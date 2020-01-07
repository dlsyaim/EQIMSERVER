package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//港口、码头实体类
@Entity
@TableName("HARBOR")
public class Harbor {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //港口名称
    @TableField("NAME")
    private String harborName;
    //邮政编码
    @TableField("POSTCODE")
    private String postCode;
    //所在位置
    @TableField("LOCATION")
    private String location;
    //港口年吞吐量
    @TableField("VOLUME")
    private String harborVolume;
    //抗震设防标准
    @TableField("INTENSITY")
    private String harborIntensity;
    //港口简介
    @TableField("NOTE")
    private String harborNote;


    public String getHarborNote() {
        return harborNote;
    }

    public void setHarborNote(String harborNote) {
        this.harborNote = harborNote;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getHarborName() {
        return harborName;
    }

    public void setHarborName(String harborName) {
        this.harborName = harborName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHarborVolume() {
        return harborVolume;
    }

    public void setHarborVolume(String harborVolume) {
        this.harborVolume = harborVolume;
    }

    public String getHarborIntensity() {
        return harborIntensity;
    }

    public void setHarborIntensity(String harborIntensity) {
        this.harborIntensity = harborIntensity;
    }
}
