package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//活跃断层实体类
@Entity
@TableName("ACTIVEFAULT")
public class ActiveFault {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //断层名称
    @TableField("NAME")
    private String faultName;
    //断层走向
    @TableField("STRIKE")
    private String faultStrike;
    //断层倾向
    @TableField("DIP_DIR")
    private String dipDir;
    //断层倾角
    @TableField("DIP_ANGLE")
    private String dipAngle;
    //断层长度
    @TableField("LENGTH")
    private String faultLength;
    //断层平均宽度
    @TableField("WIDTH")
    private String faultWidth;
    //断层性质
    @TableField("FEATURE")
    private String feature;
    //活动时代
    @TableField("ACTIVE_PERIOD")
    private String activePeriod;
    //备注
    @TableField("COMMENT_")
    private String comment;


    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getFaultStrike() {
        return faultStrike;
    }

    public void setFaultStrike(String faultStrike) {
        this.faultStrike = faultStrike;
    }

    public String getDipDir() {
        return dipDir;
    }

    public void setDipDir(String dipDir) {
        this.dipDir = dipDir;
    }

    public String getDipAngle() {
        return dipAngle;
    }

    public void setDipAngle(String dipAngle) {
        this.dipAngle = dipAngle;
    }

    public String getFaultLength() {
        return faultLength;
    }

    public void setFaultLength(String faultLength) {
        this.faultLength = faultLength;
    }

    public String getFaultWidth() {
        return faultWidth;
    }

    public void setFaultWidth(String faultWidth) {
        this.faultWidth = faultWidth;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getActivePeriod() {
        return activePeriod;
    }

    public void setActivePeriod(String activePeriod) {
        this.activePeriod = activePeriod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
