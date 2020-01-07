package com.gisinfo.sand.dataManage.condition;

public class SelectQueryCondition {
    private String dataSource ;
    private String faultName;
    private Double earthquakeLevel;
    private String  focalDepth;
    private Integer count;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public Double getEarthquakeLevel() {
        return earthquakeLevel;
    }

    public void setEarthquakeLevel(Double earthquakeLevel) {
        this.earthquakeLevel = earthquakeLevel;
    }

    public String getFocalDepth() {
        return focalDepth;
    }

    public void setFocalDepth(String focalDepth) {
        this.focalDepth = focalDepth;
    }
}
