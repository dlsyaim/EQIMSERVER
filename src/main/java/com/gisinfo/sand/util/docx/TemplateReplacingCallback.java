package com.gisinfo.sand.util.docx;

import com.aspose.words.*;
import com.gisinfo.sand.util.docx.command.*;

import java.util.Map;

/**
 * Created by luyj on 2016/5/12.
 */
public class TemplateReplacingCallback implements IReplacingCallback {

    private Map<String,Object> model = null;

    public TemplateReplacingCallback(Map<String,Object> model) {
        this.model = model;
    }

    @Override
    public int replacing(ReplacingArgs replacingArgs) throws Exception {
        Node matchNode = replacingArgs.getMatchNode();
        Node matchParentNode = matchNode.getParentNode();

        if(!handleNode(matchNode)){
            handleNode(matchParentNode);
        }

        return ReplaceAction.SKIP;
    }

    private boolean handleNode(Node node) throws Exception {
        if(null == node){
            return false;
        }

        if(node.getNodeType() == NodeType.PARAGRAPH){
            handleParagraph((Paragraph)node);
        }else if(node.getNodeType() == NodeType.TABLE){
            handleTable((Table) node);
        }else if(node.getNodeType() == NodeType.ROW){
            handleRow((Row)node);
        }else if(node.getNodeType() == NodeType.CELL){
            handleCell((Cell)node);
        }else{
            return false;
        }

        return true;
    }

    private void handleParagraph(Paragraph paragraph) throws Exception {
        String text = paragraph.getText();

        ICommand command = null;
        if(CommandPattern.IMAGE.matcher(text).find()){
            command = new ImageCommand();
        }else if(CommandPattern.TABLE.matcher(text).find()){
            command = new TableCommand();
        }else if(CommandPattern.SET.matcher(text).find()){
            command = new SetCommand();
        }

        if(null != command){
            command.setModel(model);
            command.handle(paragraph);
        }
    }

    private void handleTable(Table table) throws Exception {
        RowCollection rows = table.getRows();
        for(Row row : rows){
            handleRow(row);
        }

    }

    private void handleRow(Row row) throws Exception {
        CellCollection cells = row.getCells();
        for(Cell cell : cells){
            handleCell(cell);
        }
    }

    private void handleCell(Cell cell) throws Exception {
        ParagraphCollection paragraphs = cell.getParagraphs();
        for(Paragraph paragraph : paragraphs){
            handleParagraph(paragraph);
        }
    }
}
