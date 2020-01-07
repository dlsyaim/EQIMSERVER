package com.gisinfo.sand.dataManage.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@ApiModel
@TableName("T_EARTHQUAKE_INFO")
public class EarthquakeInfo {
    @Id
    @TableField("FEATID")
    private String featid;
    @TableField("DATA_SOURCE")
    private String dataSource;
    @TableField("EARTHQUAKE_NAME")
    private String earthquakeName;
    @TableField("EARTHQUAKE_TIME")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
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
    @TableField("TRIGGER_TIME")
    private String triggerTime;
    @TableField("FINISH_TIME")
    private String finishTime;


    @TableField(exist = false)
    private String[] graphics;

    @TableField(exist = false)
    private String startTime;
    @TableField(exist = false)
    private String endTime;
    @TableField(exist = false)
    private Integer pageNo;
    @TableField(exist = false)
    private Integer pageSize;
    @TableField(exist = false)
    private Integer bottom;
    @TableField(exist = false)
    private Integer top;

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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

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

    public String[] getGraphics() {
        return graphics;
    }

    public void setGraphics(String[] graphics) {
        this.graphics = graphics;
    }

    public int getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(int batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(String triggerTime) {
        this.triggerTime = triggerTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
}
