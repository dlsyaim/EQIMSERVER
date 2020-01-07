package com.gisinfo.sand.FastTrigger.bean;
//快速触发插入数据实体类
public class FastTriggerBean {
    //地震信息表主键
    private String featId;
    //地震来源
    private String dataSource;
    //地震震级
    private String earthquakeLevel;
    //地震事件
    private String earthquakeTime;
    //纬度
    private Double latitude;
    //经度
    private Double longitude;
    //地震位置
    private String earthquakeLocation;

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getEarthquakeLevel() {
        return earthquakeLevel;
    }

    public void setEarthquakeLevel(String earthquakeLevel) {
        this.earthquakeLevel = earthquakeLevel;
    }

    public String getEarthquakeTime() {
        return earthquakeTime;
    }

    public void setEarthquakeTime(String earthquakeTime) {
        this.earthquakeTime = earthquakeTime;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getEarthquakeLocation() {
        return earthquakeLocation;
    }

    public void setEarthquakeLocation(String earthquakeLocation) {
        this.earthquakeLocation = earthquakeLocation;
    }

    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }
}
