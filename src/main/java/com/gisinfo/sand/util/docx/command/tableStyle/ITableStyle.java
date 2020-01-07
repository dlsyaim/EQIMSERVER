package com.gisinfo.sand.util.docx.command.tableStyle;

import com.aspose.words.Table;

import java.util.List;
import java.util.Map;

/**
 * Created by majun on 2018/3/14.
 * 由于每个表格样式调整不一致，改为接口实现调用
 */
public interface ITableStyle {

    void setStyleMap(Map<String, Object> map);
    void setStyleList(List<Map<String, Object>> list);
    void applyTableStyle(Table table);
}
