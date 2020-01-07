package com.gisinfo.sand.util.docx.command.tableStyle;

import cn.hutool.core.convert.Convert;
import com.aspose.words.Row;
import com.aspose.words.Table;

import java.util.List;
import java.util.Map;

/**
 * Created by majun on 2018/3/14.
 * 表格样式修改
 */
public class OverPlusSubDetail implements ITableStyle{
    private List<Map<String, Object>> list;

    @Override
    public void setStyleMap(Map<String, Object> map) {

    }

    @Override
    public void setStyleList(List<Map<String, Object>> list) {
        this.list = list;
    }

    @Override
    public void applyTableStyle(Table table) {
        if (null != table && null != list && !list.isEmpty()) {
            for (Map<String, Object> map : list) {
                int rowIndex = Convert.toInt(map.get("rowIndex"), 1);
                Row row = table.getRows().get(rowIndex);
                try {
                    //由于应用与row的边框宽度不起作用，改为应用于cell边框
//                    row.getRowFormat().getBorders().getTop().setLineWidth(3);
                    for (int i = 0; i < row.getCount(); i++) {
                        row.getCells().get(i).getCellFormat().getBorders().getTop().setLineWidth(2.5);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
