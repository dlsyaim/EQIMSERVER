package com.gisinfo.sand.systemManage.modelSetting.bean;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_EARTHQUAKE_DETAIL")
public class TEarthquakeDetail {

    @Id
    @TableField("FEATID")
    private String featId;

    @TableField("EARTHQUAKE_FEATID")
    private String earthquakeFeatid;

    @TableField("STRUCTURE_J")
    private Double structureJ;

    @TableField("STRUCTURE_Q")
    private Double structureQ;

    @TableField("STRUCTURE_Z")
    private Double structureZ;

    @TableField("STRUCTURE_Y")
    private Double structureY;

    @TableField("STRUCTURE_D")
    private Double structureD;

    @TableField("DEATH_NUMBER")
    private Integer deathNumber;

    @TableField("TOWN_NAME")
    private String townName;

    @TableField("DIRECT_ECONOMIC_LOSS")
    private Double directEconomicLoss;

    @TableField("INJURED_NUMBER")
    private Integer injuredNumber;

    @TableField("EMERGENCY_REHOUSING_NUMBER")
    private Integer emergencyRehousingNumber;

    @TableField("EMERGENCY_LEVEL")
    private String emergencyLevel;

    @TableField("TOWN_POPULATION")
    private Integer townPopulation;

    @TableField("TOWN_TOTAL_AREA")
    private Double townTotalArea;

    //压埋人员总数
    private Integer buriedNum;

    private boolean buried;

    private Integer homelessNum;

    private Double economicLosses;

    //倒塌率
    private Double dtl;

    //破坏率
    private Double phl;

    private Double A;


    public Double getEconomicLosses() {
        return economicLosses;
    }

    public void setEconomicLosses(Double economicLosses) {
        this.economicLosses = economicLosses;
    }

    public Integer getHomelessNum() {
        return homelessNum;
    }

    public void setHomelessNum(Integer homelessNum) {
        this.homelessNum = homelessNum;
    }

    public Double getA() {
        return A;
    }

    public void setA(Double a) {
        A = a;
    }

    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getEarthquakeFeatid() {
        return earthquakeFeatid;
    }

    public void setEarthquakeFeatid(String earthquakeFeatid) {
        this.earthquakeFeatid = earthquakeFeatid;
    }

    public Double getStructureJ() {
        return structureJ;
    }

    public void setStructureJ(Double structureJ) {
        this.structureJ = structureJ;
    }

    public Double getStructureQ() {
        return structureQ;
    }

    public void setStructureQ(Double structureQ) {
        this.structureQ = structureQ;
    }

    public Double getStructureZ() {
        return structureZ;
    }

    public void setStructureZ(Double structureZ) {
        this.structureZ = structureZ;
    }

    public Double getStructureY() {
        return structureY;
    }

    public void setStructureY(Double structureY) {
        this.structureY = structureY;
    }

    public Double getStructureD() {
        return structureD;
    }

    public void setStructureD(Double structureD) {
        this.structureD = structureD;
    }

    public Integer getDeathNumber() {
        return deathNumber;
    }

    public void setDeathNumber(Integer deathNumber) {
        this.deathNumber = deathNumber;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Integer getInjuredNumber() {
        return injuredNumber;
    }

    public void setInjuredNumber(Integer injuredNumber) {
        this.injuredNumber = injuredNumber;
    }

    public Integer getTownPopulation() {
        return townPopulation;
    }

    public void setTownPopulation(Integer townPopulation) {
        this.townPopulation = townPopulation;
    }

    public Double getTownTotalArea() {
        return townTotalArea;
    }

    public void setTownTotalArea(Double townTotalArea) {
        this.townTotalArea = townTotalArea;
    }

    public Integer getBuriedNum() {
        return buriedNum;
    }

    public void setBuriedNum(Integer buriedNum) {
        this.buriedNum = buriedNum;
    }

    public Double getDtl() {
        return dtl;
    }

    public void setDtl(Double dtl) {
        this.dtl = dtl;
    }

    public Double getPhl() {
        return phl;
    }

    public void setPhl(Double phl) {
        this.phl = phl;
    }

    public boolean isBuried() {
        return buried;
    }

    public void setBuried(boolean buried) {
        this.buried = buried;
    }

    public Double getDirectEconomicLoss() {
        return directEconomicLoss;
    }

    public void setDirectEconomicLoss(Double directEconomicLoss) {
        this.directEconomicLoss = directEconomicLoss;
    }

    public Integer getEmergencyRehousingNumber() {
        return emergencyRehousingNumber;
    }

    public void setEmergencyRehousingNumber(Integer emergencyRehousingNumber) {
        this.emergencyRehousingNumber = emergencyRehousingNumber;
    }

    public String getEmergencyLevel() {
        return emergencyLevel;
    }

    public void setEmergencyLevel(String emergencyLevel) {
        this.emergencyLevel = emergencyLevel;
    }
}
