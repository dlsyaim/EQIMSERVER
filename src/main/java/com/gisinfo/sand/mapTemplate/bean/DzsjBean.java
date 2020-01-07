package com.gisinfo.sand.mapTemplate.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@TableName("T_EARTHQUAKE_INFO")
public class DzsjBean {
    @Id
    @TableField("FEATID")
    private String featId;//主键id

    @TableField("DATA_SOURCE")
    private String dataSource;//数据来源

    @TableField("EARTHQUAKE_NAME")
    private String earthquakeName;//地震名称

    @TableField("EARTHQUAKE_TIME")
    private Date earthquakeTime;//地震时间

    @TableField("EARTHQUAKE_LEVEL")
    private Double earthquakeLevel;//地震震级

    @TableField("LONGITUDE")
    private String longitude;//经度

    @TableField("LATITUDE")
    private String latitude;//纬度

    @TableField("FOCAL_DEPTH")
    private Double focalDepth;//震源深度



    @TableField("EARTHQUAKE_LOCATION")
    private String earthquakeLocation;

    @TableField("FAULT_NAME")
    private String faultName;

    @TableField("REPTURE_DIRECTION")
    private String reptureDirection;

    @TableField("ANALYSIS_DATA")
    private String analysisData;

    @TableField("MODEL_ID")
    private String modelId;



    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getEarthquakeName() {
        return earthquakeName;
    }

    public void setEarthquakeName(String earthquakeName) {
        this.earthquakeName = earthquakeName;
    }

    public Date getEarthquakeTime() {
        return earthquakeTime;
    }

    public void setEarthquakeTime(Date earthquakeTime) {
        this.earthquakeTime = earthquakeTime;
    }

    public Double getEarthquakeLevel() {
        return earthquakeLevel;
    }

    public void setEarthquakeLevel(Double earthquakeLevel) {
        this.earthquakeLevel = earthquakeLevel;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Double getFocalDepth() {
        return focalDepth;
    }

    public void setFocalDepth(Double focalDepth) {
        this.focalDepth = focalDepth;
    }


    public String getEarthquakeLocation() {
        return earthquakeLocation;
    }

    public void setEarthquakeLocation(String earthquakeLocation) {
        this.earthquakeLocation = earthquakeLocation;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getReptureDirection() {
        return reptureDirection;
    }

    public void setReptureDirection(String reptureDirection) {
        this.reptureDirection = reptureDirection;
    }

    public String getAnalysisData() {
        return analysisData;
    }

    public void setAnalysisData(String analysisData) {
        this.analysisData = analysisData;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }
}
