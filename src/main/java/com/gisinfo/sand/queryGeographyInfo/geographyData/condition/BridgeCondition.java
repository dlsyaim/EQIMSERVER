package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;
//桥梁条件类
public class BridgeCondition {
    //桥梁名称
    private String bridgeName;
    //桥梁类别
    private String bridgeClass;
    //桥梁等级
    private String bridgeGrade;
    //桥梁设防烈度
    private Double bridgeIntensity;
    //当前页数
    private Integer pageNo;
    //每页记录条数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer Top;


    public String getBridgeName() {
        return bridgeName;
    }

    public void setBridgeName(String bridgeName) {
        this.bridgeName = bridgeName;
    }

    public String getBridgeClass() {
        return bridgeClass;
    }

    public void setBridgeClass(String bridgeClass) {
        this.bridgeClass = bridgeClass;
    }

    public String getBridgeGrade() {
        return bridgeGrade;
    }

    public void setBridgeGrade(String bridgeGrade) {
        this.bridgeGrade = bridgeGrade;
    }

    public Double getBridgeIntensity() {
        return bridgeIntensity;
    }

    public void setBridgeIntensity(Double bridgeIntensity) {
        this.bridgeIntensity = bridgeIntensity;
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
