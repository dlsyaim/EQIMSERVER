package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;
//查询断裂条件对象
public class FaultCondition {
    //断裂属性
    private String faultAttr;
    //断裂名称
    private String faultName;
    //当前页
    private Integer pageNo;
    //每页显示条数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer top;

    public String getFaultAttr() {
        return faultAttr;
    }

    public void setFaultAttr(String faultAttr) {
        this.faultAttr = faultAttr;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
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
