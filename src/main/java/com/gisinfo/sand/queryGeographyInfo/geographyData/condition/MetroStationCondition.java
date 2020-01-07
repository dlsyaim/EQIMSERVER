package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;

//地铁站条件类
public class MetroStationCondition {
    //地铁站名称
    private String metroStationName;

    //当前页数
    private Integer pageNo;
    //每页记录条数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer Top;

    public String getMetroStationName() {
        return metroStationName;
    }

    public void setMetroStationName(String metroStationName) {
        this.metroStationName = metroStationName;
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
