package com.gisinfo.sand.dataManage.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_EARTHQUAKE_AID_DECISION")
public class EarthquakeAidDecision {
    @Id
    @TableField("FEATID")
    private String featId;
    @TableField("EARTHQUAKE_FEATID")
    private String earthquakeFeatId;
    @TableField("TOWN_NAME")
    private String townName;
    @TableField("RESCUE_STAFF_DEMAND")
    private String rescueStaffDemand;
    @TableField("MEDICAL_STAFF_DEMAND")
    private String medicalStaffDemand;
    @TableField("TENT_DEMAND")
    private String tentDemand;
    @TableField("TEMPORARY_TOILET_DEMAND")
    private String temporaryToiletDemand;
    @TableField("EMERGENCY_WATER_DEMAND")
    private String emergencyWaterDemand;
    @TableField("FOOD_SUBSIDY")
    private String foodSubsidy;
    @TableField("CLOTHING_DEMAND")
    private String clothingDemand;
    @TableField("QUILT_DEMAND")
    private String quiltDemand;
    @TableField("BLANKET_DEMAND")
    private String blanketDemand;
    @TableField("STRETCHER_DEMAND")
    private String stretcherDemand;

    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getEarthquakeFeatId() {
        return earthquakeFeatId;
    }

    public void setEarthquakeFeatId(String earthquakeFeatId) {
        this.earthquakeFeatId = earthquakeFeatId;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public String getRescueStaffDemand() {
        return rescueStaffDemand;
    }

    public void setRescueStaffDemand(String rescueStaffDemand) {
        this.rescueStaffDemand = rescueStaffDemand;
    }

    public String getMedicalStaffDemand() {
        return medicalStaffDemand;
    }

    public void setMedicalStaffDemand(String medicalStaffDemand) {
        this.medicalStaffDemand = medicalStaffDemand;
    }

    public String getTentDemand() {
        return tentDemand;
    }

    public void setTentDemand(String tentDemand) {
        this.tentDemand = tentDemand;
    }

    public String getTemporaryToiletDemand() {
        return temporaryToiletDemand;
    }

    public void setTemporaryToiletDemand(String temporaryToiletDemand) {
        this.temporaryToiletDemand = temporaryToiletDemand;
    }

    public String getEmergencyWaterDemand() {
        return emergencyWaterDemand;
    }

    public void setEmergencyWaterDemand(String emergencyWaterDemand) {
        this.emergencyWaterDemand = emergencyWaterDemand;
    }

    public String getFoodSubsidy() {
        return foodSubsidy;
    }

    public void setFoodSubsidy(String foodSubsidy) {
        this.foodSubsidy = foodSubsidy;
    }

    public String getClothingDemand() {
        return clothingDemand;
    }

    public void setClothingDemand(String clothingDemand) {
        this.clothingDemand = clothingDemand;
    }

    public String getQuiltDemand() {
        return quiltDemand;
    }

    public void setQuiltDemand(String quiltDemand) {
        this.quiltDemand = quiltDemand;
    }

    public String getBlanketDemand() {
        return blanketDemand;
    }

    public void setBlanketDemand(String blanketDemand) {
        this.blanketDemand = blanketDemand;
    }

    public String getStretcherDemand() {
        return stretcherDemand;
    }

    public void setStretcherDemand(String stretcherDemand) {
        this.stretcherDemand = stretcherDemand;
    }
}
