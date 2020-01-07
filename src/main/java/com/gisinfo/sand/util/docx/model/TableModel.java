package com.gisinfo.sand.util.docx.model;

import com.gisinfo.sand.util.docx.command.tableStyle.ITableStyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by luyj on 2016/5/12.
 * --------------------------------
 * editor: majun
 * date: 2018-03-14
 * content: 扩展表格功能，添加了表格合并单元格和表格样式
 */
public class TableModel extends HashMap {

    //内容
    private List<Map<String, Object>> tableContent = new ArrayList<Map<String, Object>>();
    //合并单元格
    private List<TableMergeBean> tableMerge = new ArrayList<TableMergeBean>();
    //表格样式
    private List<ITableStyle> tableStyle = new ArrayList<ITableStyle>();

    public List<Map<String, Object>> getTableContent() {
        return tableContent;
    }

    public List<TableMergeBean> getTableMerge() {
        return tableMerge;
    }

    public List<ITableStyle> getTableStyle() {
        return tableStyle;
    }

    public void setTableContent(List<Map<String, Object>> tableContent) {
        this.tableContent = tableContent;
    }

    public void setTableMerge(List<Map<String, Object>> tableMerge) {
        this.tableContent = tableMerge;
    }

    public void setTableStyle(List<Map<String, Object>> tableStyle) {
        this.tableContent = tableStyle;
    }

    public void addRow(Map<String, Object> map) {
        if (null == this.tableContent) {
            this.tableContent = new ArrayList<Map<String, Object>>();
        }
        this.tableContent.add(map);
    }

    public void addRow(int index, Map<String, Object> map) {
        if (null == this.tableContent) {
            this.tableContent = new ArrayList<Map<String, Object>>();
        }
        this.tableContent.add(index, map);
    }

    public void addMergeRow(TableMergeBean bean) {
        if (null == this.tableMerge) {
            this.tableMerge = new ArrayList<TableMergeBean>();
        }
        this.tableMerge.add(bean);
    }

    public void addMergeRow(int index, TableMergeBean bean) {
        if (null == this.tableMerge) {
            this.tableMerge = new ArrayList<TableMergeBean>();
        }
        this.tableMerge.add(index, bean);
    }

    public void addStyleRow(ITableStyle tableStyleImpl) {
        if (null == this.tableStyle) {
            this.tableStyle = new ArrayList<ITableStyle>();
        }
        this.tableStyle.add(tableStyleImpl);
    }

    public void addStyleRow(int index, ITableStyle tableStyleImpl) {
        if (null == this.tableStyle) {
            this.tableStyle = new ArrayList<ITableStyle>();
        }
        this.tableStyle.add(index, tableStyleImpl);
    }
}
