package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//独立建筑实体类
@Entity
@TableName("SINGLE_BUILDING")
public class DetachedBuilding {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //建筑名称
    @TableField("BUILDING_NAME")
    private String buildingName;

    //类别
    @TableField("USE")
    private String use;
    //建造时间
    @TableField("YEAR_")
    private String year;
    //楼层数
    @TableField("STORY_NUMBER")
    private String storyNumber;
    //建筑结构
    @TableField("BUILDING_TYPE")
    private String buildingType;
    //高度
    @TableField("HEIGHT")
    private String height;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStoryNumber() {
        return storyNumber;
    }

    public void setStoryNumber(String storyNumber) {
        this.storyNumber = storyNumber;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
