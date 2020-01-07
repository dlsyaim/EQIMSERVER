package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_MODEL_ECONOMIC_LOSSES")
public class EconomicLosses {
    //主键featId
    @Id
    @TableField("FEATID")
    private String featId;
    //地震烈度
    @TableField("I")
    private String i;
    //经济损失
    @TableField("ECONOMIC_LOSSES")
    private Double economicLosses;


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

    public Double getEconomicLosses() {
        return economicLosses;
    }

    public void setEconomicLosses(Double economicLosses) {
        this.economicLosses = economicLosses;
    }
}
