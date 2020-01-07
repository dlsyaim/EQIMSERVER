package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//水道实体类
@Entity
@TableName("WATERWAY")
public class WaterWay {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //水道名称
    @TableField("NAME")
    private String waterwayName;
    //水道类别
    @TableField("CLASS")
    private String waterwayClass;
    //水道区间
    @TableField("COVER_AREA")
    private String coverArea;
    //水道长度
    @TableField("LENGTH")
    private Double waterwayLength;
    //水道简介
    @TableField("NOTE")
    private String waterwayNote;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getWaterwayName() {
        return waterwayName;
    }

    public void setWaterwayName(String waterwayName) {
        this.waterwayName = waterwayName;
    }

    public String getWaterwayClass() {
        return waterwayClass;
    }

    public void setWaterwayClass(String waterwayClass) {
        this.waterwayClass = waterwayClass;
    }

    public String getCoverArea() {
        return coverArea;
    }

    public void setCoverArea(String coverArea) {
        this.coverArea = coverArea;
    }

    public Double getWaterwayLength() {
        return waterwayLength;
    }

    public void setWaterwayLength(Double waterwayLength) {
        this.waterwayLength = waterwayLength;
    }

    public String getWaterwayNote() {
        return waterwayNote;
    }

    public void setWaterwayNote(String waterwayNote) {
        this.waterwayNote = waterwayNote;
    }
}
