package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@TableName("T_MODEL_BURIED")
public class BuriedACSBL {
    @Id
    @TableField("FEATID")
    private String featId;
    @TableField("CATEGORY")
    private String category;
    @TableField("PERCENT_BURIED")
    private Double percentBuried;

    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPercentBuried() {
        return percentBuried;
    }

    public void setPercentBuried(Double percentBuried) {
        this.percentBuried = percentBuried;
    }
}
