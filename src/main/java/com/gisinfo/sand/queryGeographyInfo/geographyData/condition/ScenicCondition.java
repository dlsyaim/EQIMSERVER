package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;

//旅游景区
public class ScenicCondition {

    //景区或自然保护区
    private String scenicName;
    //性质
    private String scenicType;

    //当前页数
    private Integer pageNo;
    //每页记录条数
    private Integer pageSize;
    //分页下限
    private Integer bottom;
    //分页上限
    private Integer Top;

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName;
    }

    public String getScenicType() {
        return scenicType;
    }

    public void setScenicType(String scenicType) {
        this.scenicType = scenicType;
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
