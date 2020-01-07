package com.gisinfo.sand.queryGeographyInfo.geographyData.condition;
//历史强震的条件查询对象
public class HistoricalEQcondition {
    //地名
    private String placeName;
    //最小震级
    private Double minMangitude;
    //最大震级
    private Double maxMangitude;
    //分页查询上限
    private Integer top;
    //分页查询下线
    private Integer bottom;

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

    public Double getMinMangitude() {
        return minMangitude;
    }

    public void setMinMangitude(Double minMangitude) {
        this.minMangitude = minMangitude;
    }

    public Double getMaxMangitude() {
        return maxMangitude;
    }

    public void setMaxMangitude(Double maxMangitude) {
        this.maxMangitude = maxMangitude;
    }
}
