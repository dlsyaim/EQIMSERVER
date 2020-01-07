package com.gisinfo.sand.util.docx.command;

import com.aspose.words.*;
import com.gisinfo.sand.util.ConstantsUtil;
import com.gisinfo.sand.util.docx.TemplateReplacingCallback;
import com.gisinfo.sand.util.docx.WordTemplateGen;
import com.gisinfo.sand.util.docx.WordUtil;
import com.gisinfo.sand.util.docx.command.tableStyle.ITableStyle;
import com.gisinfo.sand.util.docx.model.TableMergeBean;
import com.gisinfo.sand.util.docx.model.TableModel;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.List;

/**
 * Created by luyj on 2016/5/12.
 * --------------------------------
 * editor: majun
 * date: 2018-03-14
 * content: 扩展表格功能，添加了表格合并单元格和表格样式
 */
public class  TableCommand implements ICommand<Map<String, Object>> {

    private Map<String, Object> model = null;

    @Override
    public void setModel(Map<String, Object> model) {
        this.model = model;
    }

    @Override
    public void handle(Paragraph paragraph) throws Exception {
//        todo  测试文本
        String text = paragraph.getText();
        Matcher matcher = CommandPattern.TABLE.matcher(text);

        String file = ConstantsUtil.EMPTY_VALUE;
        String field = ConstantsUtil.EMPTY_VALUE;
        if (matcher.find()) {
            file = matcher.group(1);
            field = matcher.group(2);

            String tempPath = getTableTemplatePath(file);
            List<Object> tables = convert2List(field);
            TableModel tableModel = null;
            Document subDoc = null;
            if (null == tables) {
                tableModel = convert2TableModel(field);
                tableModel.put(WordUtil.TEMPLATE_PATH, tempPath);
                subDoc = getDocument(tempPath, tableModel);
            } else {
                for (Object obj : tables) {
                    tableModel = getTableModel(obj);
                    tableModel.put(WordUtil.TEMPLATE_PATH, tempPath);
                    subDoc = getDocument(tempPath, tableModel);
                }

            }

            new MergerDoc().insertAfter(paragraph, subDoc);
        }

        paragraph.remove();
    }


    List<Object> convert2List(String field) {
        Object obj = model.get(field);
        if (obj instanceof List) {
            return (List<Object>) obj;
        }

        return null;
    }

    private TableModel convert2TableModel(String field) throws Exception {
        Object obj = model.get(field);
        return getTableModel(obj);
    }

    private TableModel getTableModel(Object obj) throws Exception {
        if (obj instanceof TableModel) {
            return (TableModel) obj;
        }
        throw new Exception("can not convert to " + TableModel.class.getName());
    }

    private String getTableTemplatePath(String file) throws Exception {
        if (StringUtils.isEmpty(file)) {
            throw new Exception("doc:table file is null or empty");
        }

        String mainTemplatePath = ObjectUtils.toString(model.get(WordUtil.TEMPLATE_PATH));
        String path = ConstantsUtil.EMPTY_VALUE;
        if (file.startsWith(".")) {
            path = mainTemplatePath.substring(0, mainTemplatePath.lastIndexOf(File.separator)) + File.separator + file;
        } else {
            path = file;
        }

        return path;
    }

    public Document getDocument(String path, TableModel tableModel) throws Exception {
        if (!WordTemplateGen.getLicense()) {
            return null;
        }

        Document document = new Document(path);
        Table table = null;
        for (Section section : document.getSections()) {
            if (table != null) {
                break;
            }

            for (Node node : (Iterable<Node>) section.getBody()) {
                if (node.getNodeType() == NodeType.TABLE) {
                    table = (Table) node;
                    break;
                } else {
                    continue;
                }
            }
        }


        Row lastRow = table.getLastRow();
        Node newNode = null;
        for (Map map : tableModel.getTableContent()) {
            newNode = lastRow.deepClone(true);
            map.putAll(tableModel);

            newNode.getRange().replace(
                    Pattern.compile("."),
                    new TemplateReplacingCallback(map), false);

            table.appendChild(newNode);
        }

        lastRow.remove();

        document.getRange().replace(
                Pattern.compile("."),
                new TemplateReplacingCallback(tableModel),
                false
        );

        if (null != tableModel.getTableMerge() && !tableModel.getTableMerge().isEmpty()) {
            for (TableMergeBean bean : tableModel.getTableMerge()) {
                Cell cellStartRange = table.getRows().get(bean.getStartRow()).getCells().get(bean.getStartCell());
                Cell cellEndRange = table.getRows().get(bean.getEndRow()).getCells().get(bean.getEndCell());
                mergeCells(cellStartRange, cellEndRange);
            }
        }

        if (null != tableModel.getTableStyle() && !tableModel.getTableStyle().isEmpty()) {
            for (ITableStyle style : tableModel.getTableStyle()) {
                style.applyTableStyle(table);
            }
        }

        return document;
    }

    /**
     * 合并单元格
     *
     * @param startCell
     * @param endCell
     */
    public void mergeCells(Cell startCell, Cell endCell) {
        Table parentTable = startCell.getParentRow().getParentTable();

        // Find the row and cell indices for the start and end cell.
        Point startCellPos = new Point(startCell.getParentRow().indexOf(startCell), parentTable.indexOf(startCell.getParentRow()));
        Point endCellPos = new Point(endCell.getParentRow().indexOf(endCell), parentTable.indexOf(endCell.getParentRow()));
        // Create the range of cells to be merged based off these indices. Inverse each index if the end cell if before the start cell.
        Rectangle mergeRange = new Rectangle(Math.min(startCellPos.x, endCellPos.x), Math.min(startCellPos.y, endCellPos.y), Math.abs(endCellPos.x - startCellPos.x) + 1,
                Math.abs(endCellPos.y - startCellPos.y) + 1);

        for (Row row : parentTable.getRows()) {
            for (Cell cell : row.getCells()) {
                Point currentPos = new Point(row.indexOf(cell), parentTable.indexOf(row));

                // Check if the current cell is inside our merge range then merge it.
                if (mergeRange.contains(currentPos)) {
                    if (currentPos.x == mergeRange.x)
                        cell.getCellFormat().setHorizontalMerge(CellMerge.FIRST);
                    else {
                        cell.getCellFormat().setHorizontalMerge(CellMerge.PREVIOUS);
                    }

                    if (currentPos.y == mergeRange.y) {
                        cell.getCellFormat().setVerticalMerge(CellMerge.FIRST);
                    } else {
                        cell.getCellFormat().setVerticalMerge(CellMerge.PREVIOUS);
                    }
                }
            }
        }
    }

}


