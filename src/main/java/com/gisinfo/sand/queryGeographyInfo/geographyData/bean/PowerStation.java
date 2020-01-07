package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//重要发电厂房信息实体类
@Entity
@TableName("power_plant_information")
public class PowerStation {

    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //名称
    @TableField("NAME")
    private String name;
    //地址
    @TableField("POSITION_")
    private String position;
    //装机容量
    @TableField("INSTALLED_CAPACITY")
    private String installedCapacity;
    //时间
    @TableField("YEAR_")
    private String year;
    //发电方式
    @TableField("GENERATING_TYPE")
    private String generatingType;
    private String id;//	N	NVARCHAR2(20)	Y
    private String longitude;//	N	NVARCHAR2(40)	Y
    private String latitude;//	N	NVARCHAR2(40)	Y
    @TableField("FORTIFICATION_INTENSITY")
    private String fortificationIntensity;//	N	NVARCHAR2(10)	Y
    @TableField("TOTAL_COST_OF_POWER_PLANT")
    private String totalCostOfPowerPlant;//	N	NVARCHAR2(40)	Y
    @TableField("COST_OF_SUBSTATION_EQUIPMENT")
    private String costOfSubstationEquipment;//	N	NVARCHAR2(10)	Y
    @TableField("COST_OF_GENERATING_EQUIPMENT")
    private String costOfGeneratingEquipment;//	N	NVARCHAR2(10)	Y
    @TableField("AREA_OF_STRUCTURES")
    private String areaOfStructures;//	N	NVARCHAR2(10)	Y
    @TableField("UNIT_COST_OF_STEEL_STRUCTURE")
    private String unitCostOfSteelStructure;//	N	NVARCHAR2(10)	Y
    @TableField("AREA_OF_CONSTRUCTION")
    private String areaOfConstruction;//	N	NVARCHAR2(10)	Y
    @TableField("COST_OF_CONSTRUCTION")
    private String costOfConstruction;//	N	NVARCHAR2(10)	Y
    @TableField("AREA_OF_BUILDING")
    private String areaOfBuilding;//	N	NVARCHAR2(10)	Y
    @TableField("COST_OF_BUILDING")
    private String costOfBuilding;//	N	NVARCHAR2(10)	Y


    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getInstalledCapacity() {
        return installedCapacity;
    }

    public void setInstalledCapacity(String installedCapacity) {
        this.installedCapacity = installedCapacity;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGeneratingType() {
        return generatingType;
    }

    public void setGeneratingType(String generatingType) {
        this.generatingType = generatingType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getFortificationIntensity() {
        return fortificationIntensity;
    }

    public void setFortificationIntensity(String fortificationIntensity) {
        this.fortificationIntensity = fortificationIntensity;
    }

    public String getTotalCostOfPowerPlant() {
        return totalCostOfPowerPlant;
    }

    public void setTotalCostOfPowerPlant(String totalCostOfPowerPlant) {
        this.totalCostOfPowerPlant = totalCostOfPowerPlant;
    }

    public String getCostOfSubstationEquipment() {
        return costOfSubstationEquipment;
    }

    public void setCostOfSubstationEquipment(String costOfSubstationEquipment) {
        this.costOfSubstationEquipment = costOfSubstationEquipment;
    }

    public String getCostOfGeneratingEquipment() {
        return costOfGeneratingEquipment;
    }

    public void setCostOfGeneratingEquipment(String costOfGeneratingEquipment) {
        this.costOfGeneratingEquipment = costOfGeneratingEquipment;
    }

    public String getAreaOfStructures() {
        return areaOfStructures;
    }

    public void setAreaOfStructures(String areaOfStructures) {
        this.areaOfStructures = areaOfStructures;
    }

    public String getUnitCostOfSteelStructure() {
        return unitCostOfSteelStructure;
    }

    public void setUnitCostOfSteelStructure(String unitCostOfSteelStructure) {
        this.unitCostOfSteelStructure = unitCostOfSteelStructure;
    }

    public String getAreaOfConstruction() {
        return areaOfConstruction;
    }

    public void setAreaOfConstruction(String areaOfConstruction) {
        this.areaOfConstruction = areaOfConstruction;
    }

    public String getCostOfConstruction() {
        return costOfConstruction;
    }

    public void setCostOfConstruction(String costOfConstruction) {
        this.costOfConstruction = costOfConstruction;
    }

    public String getAreaOfBuilding() {
        return areaOfBuilding;
    }

    public void setAreaOfBuilding(String areaOfBuilding) {
        this.areaOfBuilding = areaOfBuilding;
    }

    public String getCostOfBuilding() {
        return costOfBuilding;
    }

    public void setCostOfBuilding(String costOfBuilding) {
        this.costOfBuilding = costOfBuilding;
    }
}
