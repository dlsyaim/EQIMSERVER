package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//大型油气管线实体类
@Entity
@TableName("PETROLINE")
public class LargeOilgasPipeline {

    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //注释
    @TableField("NOTE_")
    private String note;
    //注释
    @TableField("ID")
    private String id;
    //油气管线名称
    @TableField("NAME")
    private String pipelineName;
    //油气管线名称
    @TableField("LOCATION")
    private String location;
    //特征
    @TableField("FEATURE")
    private String feature;
    //建设年代
    @TableField("BUILT_ERA")
    private String builtEra;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPipelineName() {
        return pipelineName;
    }

    public void setPipelineName(String pipelineName) {
        this.pipelineName = pipelineName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getBuiltEra() {
        return builtEra;
    }

    public void setBuiltEra(String builtEra) {
        this.builtEra = builtEra;
    }
}
