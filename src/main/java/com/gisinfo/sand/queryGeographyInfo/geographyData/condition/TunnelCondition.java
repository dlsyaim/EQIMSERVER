package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;
//隧道条件类
public class TunnelCondition {
    //隧道名称
    private String tunnelName;
    //隧道类别
    private String tunnelClass;
    //隧道等级
    private String tunnelGrade;
    //抗震设防烈度
    private Double tunnelIntensity;
    //当前页数
    private Integer pageNo;
    //每页记录条数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer top;


    public String getTunnelName() {
        return tunnelName;
    }

    public void setTunnelName(String tunnelName) {
        this.tunnelName = tunnelName;
    }

    public String getTunnelClass() {
        return tunnelClass;
    }

    public void setTunnelClass(String tunnelClass) {
        this.tunnelClass = tunnelClass;
    }

    public String getTunnelGrade() {
        return tunnelGrade;
    }

    public void setTunnelGrade(String tunnelGrade) {
        this.tunnelGrade = tunnelGrade;
    }

    public Double getTunnelIntensity() {
        return tunnelIntensity;
    }

    public void setTunnelIntensity(Double tunnelIntensity) {
        this.tunnelIntensity = tunnelIntensity;
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
