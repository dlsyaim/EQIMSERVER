package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;

//供水主干管网条件类
public class WaterPipeCondition {

    private String waterpipeClass;

    private String waterpipemateial;

    //当前页数
    private Integer pageNo;
    //每页记录条数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer Top;

    public String getWaterpipeClass() {
        return waterpipeClass;
    }

    public void setWaterpipeClass(String waterpipeClass) {
        this.waterpipeClass = waterpipeClass;
    }

    public String getWaterpipemateial() {
        return waterpipemateial;
    }

    public void setWaterpipemateial(String waterpipemateial) {
        this.waterpipemateial = waterpipemateial;
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

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }

    public Integer getTop() {
        return Top;
    }

    public void setTop(Integer top) {
        Top = top;
    }
}
