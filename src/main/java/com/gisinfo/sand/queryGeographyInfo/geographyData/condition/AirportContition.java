package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;
//机场条件类
public class AirportContition {
    //机场名称
    private String airportName;
    //当前页数
    private Integer pageNo;
    //每页显示的条数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer top;

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
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
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }
}
