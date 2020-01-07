package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//危险源实体类
@Entity
@TableName("DANGEROUS_SOURCE")
public class DangerSource {

    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //所属单位名称
    @TableField("NAME")
    private String dangerName;
    //邮政编码
    @TableField("POSTCODE")
    private String postcode;
    //所在位置
    @TableField("LOCATION")
    private String location;
    //危险品类别名称
    @TableField("FEATURE")
    private String feature;
    //危险源储量
    @TableField("STORAGE")
    private String storage;
    //主要设备抗震能力
    @TableField("CAPACITY")
    private String capacity;
    //危险品仓库的抗震能力
    @TableField("INTENSITY")
    private String intensity;
    //消防能力
    @TableField("FIRE")
    private String fire;
    //周围1000米内有无人口密集场所
    @TableField("CROWD")
    private String crowd;
    //简介
    @TableField("NOTE_")
    private String note;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getDangerName() {
        return dangerName;
    }

    public void setDangerName(String dangerName) {
        this.dangerName = dangerName;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getFire() {
        return fire;
    }

    public void setFire(String fire) {
        this.fire = fire;
    }

    public String getCrowd() {
        return crowd;
    }

    public void setCrowd(String crowd) {
        this.crowd = crowd;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
