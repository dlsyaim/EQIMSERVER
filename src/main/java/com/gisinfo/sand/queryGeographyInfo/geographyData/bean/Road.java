package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//道路实体类
@Entity
@TableName("ROAD")
public class Road {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //道路名称
    @TableField("NAME")
    private String roadName;
    //道路等级
    @TableField("CLASS")
    private String roadClass;
    //道路区间
    @TableField("COVER")
    private String roadCover;
    //道路长度
    @TableField("LENGTH")
    private Double roadLength;
    //道路宽度
    @TableField("WIDTH")
    private Double roadWidth;
    //道路最大装载量
    @TableField("CAPACITY")
    private String roadCapacity;
    //道路简介
    @TableField("NOTE_")
    private String roadNote;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getRoadName() {
        return roadName;
    }

    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    public String getRoadClass() {
        return roadClass;
    }

    public void setRoadClass(String roadClass) {
        this.roadClass = roadClass;
    }

    public String getRoadCover() {
        return roadCover;
    }

    public void setRoadCover(String roadCover) {
        this.roadCover = roadCover;
    }

    public Double getRoadLength() {
        return roadLength;
    }

    public void setRoadLength(Double roadLength) {
        this.roadLength = roadLength;
    }

    public Double getRoadWidth() {
        return roadWidth;
    }

    public void setRoadWidth(Double roadWidth) {
        this.roadWidth = roadWidth;
    }

    public String getRoadCapacity() {
        return roadCapacity;
    }

    public void setRoadCapacity(String roadCapacity) {
        this.roadCapacity = roadCapacity;
    }

    public String getRoadNote() {
        return roadNote;
    }

    public void setRoadNote(String roadNote) {
        this.roadNote = roadNote;
    }
}
