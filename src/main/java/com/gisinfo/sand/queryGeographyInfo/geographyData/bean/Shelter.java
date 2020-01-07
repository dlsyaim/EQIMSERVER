package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//避难所实体类
@Entity
@TableName("CITY_SITE")
public class Shelter {

    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;

    private String ID;

    //城市主要目标名称
    @TableField("NAME")
    private String shelterName;
    //面积
    @TableField("AREA_")
    private Integer shelterArfa;
    //用途
    @TableField("USEAGE")
    private String shelterUseage;
    //类别
    @TableField("CLASS")
    private String shelterClass;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public Integer getShelterArfa() {
        return shelterArfa;
    }

    public void setShelterArfa(Integer shelterArfa) {
        this.shelterArfa = shelterArfa;
    }

    public String getShelterUseage() {
        return shelterUseage;
    }

    public void setShelterUseage(String shelterUseage) {
        this.shelterUseage = shelterUseage;
    }

    public String getShelterClass() {
        return shelterClass;
    }

    public void setShelterClass(String shelterClass) {
        this.shelterClass = shelterClass;
    }
}

