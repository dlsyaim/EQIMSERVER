package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;
//水道条件类
public class WaterwayCondition {
    //水道名称、
    private String waterwayName;
    //水道类别
    private String waterwayClass;
    //当前页数
    private Integer pageNo;
    //每页显示条数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer top;


    public String getWaterwayName() {
        return waterwayName;
    }

    public void setWaterwayName(String waterwayName) {
        this.waterwayName = waterwayName;
    }

    public String getWaterwayClass() {
        return waterwayClass;
    }

    public void setWaterwayClass(String waterwayClass) {
        this.waterwayClass = waterwayClass;
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
