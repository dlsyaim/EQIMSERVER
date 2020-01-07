package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//地铁线路实体类
@Entity
@TableName("TRACK_LINE")
public class MetroLine {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;

    @TableField("OBJECTID_1")
    private String objectId1;
    @TableField("TRACK_NAME")
    private String trackName;
    @TableField("TAG_NAME")
    private String tagName;
    @TableField("STATUS_QUO")
    private String statusQuo;
    @TableField("SHAPE_LENG")
    private Double shapeLeng;

    public String getObjectId1() {
        return objectId1;
    }

    public void setObjectId1(String objectId1) {
        this.objectId1 = objectId1;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getStatusQuo() {
        return statusQuo;
    }

    public void setStatusQuo(String statusQuo) {
        this.statusQuo = statusQuo;
    }

    public Double getShapeLeng() {
        return shapeLeng;
    }

    public void setShapeLeng(Double shapeLeng) {
        this.shapeLeng = shapeLeng;
    }

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

}
