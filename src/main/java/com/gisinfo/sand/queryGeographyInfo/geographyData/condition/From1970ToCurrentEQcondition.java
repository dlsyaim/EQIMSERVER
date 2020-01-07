package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;
//查询1970以来小震数据的条件对象
public class From1970ToCurrentEQcondition {
    //地名
    private String placeName;
    //最小震级
    private Double minMagnitude;
    //最大震级
    private Double maxMagnitude;
    //当前页数
    private Integer pageNo;
    //每页记录数
    private Integer pageSize;
    //分页上限
    private Integer top;
    //分页下限
    private Integer bottom;


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

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public Double getMinMagnitude() {
        return minMagnitude;
    }

    public void setMinMagnitude(Double minMagnitude) {
        this.minMagnitude = minMagnitude;
    }

    public Double getMaxMagnitude() {
        return maxMagnitude;
    }

    public void setMaxMagnitude(Double maxMagnitude) {
        this.maxMagnitude = maxMagnitude;
    }
}
