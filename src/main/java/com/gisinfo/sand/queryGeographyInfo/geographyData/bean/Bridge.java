package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//桥梁实体类
@Entity
@TableName("BRIDGE")
public class Bridge {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //桥梁名称
    @TableField("NAME")
    private String bridgeName;
    //桥梁类型
    @TableField("CLASS")
    private String bridgeClass;
    //桥梁所在位置
    @TableField("LOCATION")
    private String location;
    //桥梁等级
    @TableField("GRADE")
    private String bridgeGrade;
    //桥梁长度
    @TableField("LENGTH")
    private Double bridgeLength;
    //桥梁宽度
    @TableField("WIDTH")
    private Double bridgeWidth;
    //桥梁最大载重量
    @TableField("MAX_LOAD")
    private Double maxLoad;
    //桥梁抗震设防烈度
    @TableField("INTENSITY")
    private Double bridgeIntensity;
    //桥梁结构
    @TableField("STRUCTURE")
    private String bridgeStructure;
    //桥梁建造年代
    @TableField("BUILT_ERA")
    private String builtEra;
    //桥梁简介
    @TableField("NOTE")
    private String bridgeNote;


    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getBridgeName() {
        return bridgeName;
    }

    public void setBridgeName(String bridgeName) {
        this.bridgeName = bridgeName;
    }

    public String getBridgeClass() {
        return bridgeClass;
    }

    public void setBridgeClass(String bridgeClass) {
        this.bridgeClass = bridgeClass;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBridgeGrade() {
        return bridgeGrade;
    }

    public void setBridgeGrade(String bridgeGrade) {
        this.bridgeGrade = bridgeGrade;
    }

    public Double getBridgeLength() {
        return bridgeLength;
    }

    public void setBridgeLength(Double bridgeLength) {
        this.bridgeLength = bridgeLength;
    }

    public Double getBridgeWidth() {
        return bridgeWidth;
    }

    public void setBridgeWidth(Double bridgeWidth) {
        this.bridgeWidth = bridgeWidth;
    }

    public Double getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(Double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public Double getBridgeIntensity() {
        return bridgeIntensity;
    }

    public void setBridgeIntensity(Double bridgeIntensity) {
        this.bridgeIntensity = bridgeIntensity;
    }

    public String getBridgeStructure() {
        return bridgeStructure;
    }

    public void setBridgeStructure(String bridgeStructure) {
        this.bridgeStructure = bridgeStructure;
    }

    public String getBuiltEra() {
        return builtEra;
    }

    public void setBuiltEra(String builtEra) {
        this.builtEra = builtEra;
    }

    public String getBridgeNote() {
        return bridgeNote;
    }

    public void setBridgeNote(String bridgeNote) {
        this.bridgeNote = bridgeNote;
    }
}
