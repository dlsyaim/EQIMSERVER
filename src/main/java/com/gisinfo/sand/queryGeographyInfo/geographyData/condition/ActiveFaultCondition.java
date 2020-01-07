package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;
//活跃断层条件类
public class ActiveFaultCondition {
    //断层名称
    private String faultName;
    //断层性质
    private String feature;
    //当前页数
    private Integer pageNo;
    //每页记录条数
    private Integer pageSize;
    //分页上限
    private Integer top;
    //分页下限
    private Integer bottom;

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
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
