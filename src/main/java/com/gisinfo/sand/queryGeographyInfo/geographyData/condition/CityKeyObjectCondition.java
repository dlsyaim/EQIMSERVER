package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;

//城市主要目标条件类
public class CityKeyObjectCondition {

    private String citykeyName;

    private String citykeyClass;

    //当前页数
    private Integer pageNo;
    //每页记录条数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer Top;

    public String getCitykeyName() {
        return citykeyName;
    }

    public void setCitykeyName(String citykeyName) {
        this.citykeyName = citykeyName;
    }

    public String getCitykeyClass() {
        return citykeyClass;
    }

    public void setCitykeyClass(String citykeyClass) {
        this.citykeyClass = citykeyClass;
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
