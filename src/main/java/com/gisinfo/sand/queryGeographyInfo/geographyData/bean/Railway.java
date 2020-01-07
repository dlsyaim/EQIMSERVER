package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//铁路实体类
@Entity
@TableName("RAILWAY")
public class Railway{
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //铁路名称

    private String name;
    //铁路类别
    private String id;
    @TableField("CLASS")
    private String railwayClass;
    //铁路区间
    @TableField("COVER_AREA")
    private String coverArea;
    //铁路复线
    @TableField("NUMBER_LINE")
    private String numberLine;
    //铁路长度
    @TableField("LENGTH")
    private Double railwayLength;
    //铁路简介
    @TableField("NOTE_")
    private String railwayNote;


    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRailwayClass() {
        return railwayClass;
    }

    public void setRailwayClass(String railwayClass) {
        this.railwayClass = railwayClass;
    }

    public String getCoverArea() {
        return coverArea;
    }

    public void setCoverArea(String coverArea) {
        this.coverArea = coverArea;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(String numberLine) {
        this.numberLine = numberLine;
    }

    public Double getRailwayLength() {
        return railwayLength;
    }

    public void setRailwayLength(Double railwayLength) {
        this.railwayLength = railwayLength;
    }

    public String getRailwayNote() {
        return railwayNote;
    }

    public void setRailwayNote(String railwayNote) {
        this.railwayNote = railwayNote;
    }
}
