package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@TableName("T_EARTHQUAKE_INFO")
public class TEarthquakeInfo {

    @Id
    @TableField("FEATID")
    private String featid;

    @TableField("DATA_SOURCE")
    private String dataSource;

    @TableField("EARTHQUAKE_NAME")
    private String earthquakeName;

    @TableField("EARTHQUAKE_TIME")
    private Date earthquakeTime;

    @TableField("EARTHQUAKE_LEVEL")
    private Double earthquakeLevel;

    @TableField("EARTHQUAKE_LOCATION")
    private String earthquakeLocation;

    @TableField("LONGITUDE")
    private Double longitude;

    @TableField("LATITUDE")
    private Double latitude;

    @TableField("FOCAL_DEPTH")
    private Double focalDepth;

    @TableField("FAULT_NAME")
    private String faultName;

    @TableField("REPTURE_DIRECTION")
    private String reptureDirection;

    @TableField("ANALYSIS_DATA")
    private String analysisData;

    @TableField("ANALYSIS_DATA")
    private String modelId;

    @TableField("BATCH_NUMBER")
    private Double batchNumber;

    @TableField("PROVINCE")
    private String province;

    @TableField("CITY")
    private String city;

    @TableField("COUNTY")
    private String county;

    @TableField("TOWN")
    private String town;

    public String getFeatid() {
        return featid;
    }

    public void setFeatid(String featid) {
        this.featid = featid;
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

    public String getEarthquakeLocation() {
        return earthquakeLocation;
    }

    public void setEarthquakeLocation(String earthquakeLocation) {
        this.earthquakeLocation = earthquakeLocation;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getFocalDepth() {
        return focalDepth;
    }

    public void setFocalDepth(Double focalDepth) {
        this.focalDepth = focalDepth;
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

    public Double getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(Double batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
