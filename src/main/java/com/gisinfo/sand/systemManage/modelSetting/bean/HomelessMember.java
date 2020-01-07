package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_MODEL_HOMELESS")
public class HomelessMember {
    //主键featId
    @Id
    @TableField("FEATID")
    private String featId;
    //烈度
    @TableField("I")
    private String i;
    //低比例
    @TableField("PROPORTION_LOW")
    private Double proportionLow;
    //中比例
    @TableField("PROPORTION_MEDIUM")
    private Double proportionMedium;
    //高比例
    @TableField("PROPORTION_HIGH")
    private Double proportionHigh;


    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public Double getProportionLow() {
        return proportionLow;
    }

    public void setProportionLow(Double proportionLow) {
        this.proportionLow = proportionLow;
    }

    public Double getProportionMedium() {
        return proportionMedium;
    }

    public void setProportionMedium(Double proportionMedium) {
        this.proportionMedium = proportionMedium;
    }

    public Double getProportionHigh() {
        return proportionHigh;
    }

    public void setProportionHigh(Double proportionHigh) {
        this.proportionHigh = proportionHigh;
    }
}
