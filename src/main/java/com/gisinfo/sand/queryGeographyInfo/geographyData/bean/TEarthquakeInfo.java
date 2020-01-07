package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

//地震触发列表实体类
@Entity
@TableName("T_EARTHQUAKE_INFO")
public class TEarthquakeInfo {

    //主键
    @Id
    @TableField("FEATID")
    private String featid;

    //数据来源
    @TableField("DATA_SOURCE")
    private String dataSource;

    //地震名称
    @TableField("EARTHQUAKE_NAME")
    private String earthquakeName;

    //地震时间
    @TableField("EARTHQUAKE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date earthquakeTime;

    //地震等级
    @TableField("EARTHQUAKE_LEVEL")
    private Double earthquakeLevel;

    //位置
    @TableField("EARTHQUAKE_LOCATION")
    private String earthquakeLocation;

    //经度
    @TableField("LONGITUDE")
    private Double longitude;

    //纬度
    @TableField("LATITUDE")
    private Double latitude;

    //震源深度
    @TableField("FOCAL_DEPTH")
    private Double focalDepth;

    //断层名称
    @TableField("FAULT_NAME")
    private String faultName;


    //破裂方向
    @TableField("REPTURE_DIRECTION")
    private String reptureDirection;

    @TableField("ANALYSIS_DATA")
    private String analysisData;
    @TableField("MODEL_ID")
    private String modelId;
    @TableField("BATCH_NUMBER")
    private int batchNumber;
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

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
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
