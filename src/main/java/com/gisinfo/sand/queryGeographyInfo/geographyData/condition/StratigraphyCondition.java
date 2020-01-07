package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;
//查询地层数据条件对象
public class StratigraphyCondition {
    //地层名称
    private String unitName;
    //地层描述
    private String character;
    //当前页数
    private Integer pageNo;
    //每页显示条数
    private Integer pageSize;
    //分页上限
    private Integer top;
    //分页下限
    private Integer bottom;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }
}
