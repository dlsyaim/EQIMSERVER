package com.gisinfo.sand.mapTemplate.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("ACTIVEFAULT")
public class ActivefaultBean {

    @Id
    @TableField("OBJECTID")
    private Double objectid;
    @TableField("ACTIVE_PERIOD")
    private String activePeriod;
    @TableField("DIP_ANGLE")
    private String dipAngle;
    @TableField("DIP_DIR")
    private String dipDir;
    @TableField("OBJECTID")
    private String feature;
    @TableField("COMMENT_")
    private String comment_;
    @TableField("NAME")
    private String name;
    @TableField("STRIKE")
    private String strike;
    @TableField("WIDTH")
    private String width;
    @TableField("LENGTH")
    private String length;
    @TableField("COMMENT1")
    private String comment1;

    public Double getObjectid() {
        return objectid;
    }

    public void setObjectid(Double objectid) {
        this.objectid = objectid;
    }

    public String getActivePeriod() {
        return activePeriod;
    }

    public void setActivePeriod(String activePeriod) {
        this.activePeriod = activePeriod;
    }

    public String getDipAngle() {
        return dipAngle;
    }

    public void setDipAngle(String dipAngle) {
        this.dipAngle = dipAngle;
    }

    public String getDipDir() {
        return dipDir;
    }

    public void setDipDir(String dipDir) {
        this.dipDir = dipDir;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getComment_() {
        return comment_;
    }

    public void setComment_(String comment_) {
        this.comment_ = comment_;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStrike() {
        return strike;
    }

    public void setStrike(String strike) {
        this.strike = strike;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getComment1() {
        return comment1;
    }

    public void setComment1(String comment1) {
        this.comment1 = comment1;
    }
}
