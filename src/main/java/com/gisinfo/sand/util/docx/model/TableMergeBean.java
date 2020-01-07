package com.gisinfo.sand.util.docx.model;

/**
 * Created by majun on 2018/3/14.
 */
public class TableMergeBean {

    public TableMergeBean() {

    }

    public TableMergeBean(int startRow, int startCell, int endRow, int endCell) {
        this.startRow = startRow;
        this.startCell = startCell;
        this.endRow = endRow;
        this.endCell = endCell;
    }

    private int startRow;
    private int startCell;
    private int endRow;
    private int endCell;

    public int getStartRow() {
        return startRow;
    }

    public TableMergeBean setStartRow(int startRow) {
        this.startRow = startRow;
        return this;
    }

    public int getStartCell() {
        return startCell;
    }

    public TableMergeBean setStartCell(int startCell) {
        this.startCell = startCell;
        return this;
    }

    public int getEndRow() {
        return endRow;
    }

    public TableMergeBean setEndRow(int endRow) {
        this.endRow = endRow;
        return this;
    }

    public int getEndCell() {
        return endCell;
    }

    public TableMergeBean setEndCell(int endCell) {
        this.endCell = endCell;
        return this;
    }
}
