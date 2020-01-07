package com.gisinfo.sand.dataManage.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_EARTHQUAKE_DETAIL")
public class EarthquakeDetail {
    @Id
    @TableField("FEATID")
    private String featId;
    @TableField("EARTHQUAKE_FEATID")
    private String earthquakeFeatId;
    @TableField("TOWN_NAME")
    private String townName;
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
    @TableField("INJURED_NUMBER")
    private Integer injuredNumber;
    @TableField("DIRECT_ECONOMIC_LOSS")
    private Integer directEconomicLoss;
    @TableField("EMERGENCY_REHOUSING_NUMBER")
    private Integer emergencyRehousingNumber;


    public String getFeatId() {
        return featId;
    }

    public String getEarthquakeFeatId() {
        return earthquakeFeatId;
    }

    public String getTownName() {
        return townName;
    }

    public Double getStructureJ() {
        return structureJ;
    }

    public Double getStructureQ() {
        return structureQ;
    }

    public Double getStructureZ() {
        return structureZ;
    }

    public Double getStructureY() {
        return structureY;
    }

    public Double getStructureD() {
        return structureD;
    }

    public Integer getDeathNumber() {
        return deathNumber;
    }

    public Integer getInjuredNumber() {
        return injuredNumber;
    }

    public Integer getDirectEconomicLoss() {
        return directEconomicLoss;
    }

    public Integer getEmergencyRehousingNumber() {
        return emergencyRehousingNumber;
    }
}
