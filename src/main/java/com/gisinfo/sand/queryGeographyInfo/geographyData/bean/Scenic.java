package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//旅游景区实体类
@Entity
@TableName("TOURISM_SPOT")
public class Scenic {

    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;

    private String ID;

    //景区或自然保护区
    @TableField("NAME")
    private String scenicName;
    //性质
    @TableField("TYPE")
    private String scenicType;
    //描述
    @TableField("NOTE_")
    private String scenicNote;
    //邮政编码
    @TableField("POSTCODE")
    private String scenicPostcode;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName;
    }

    public String getScenicType() {
        return scenicType;
    }

    public void setScenicType(String scenicType) {
        this.scenicType = scenicType;
    }

    public String getScenicNote() {
        return scenicNote;
    }

    public void setScenicNote(String scenicNote) {
        this.scenicNote = scenicNote;
    }

    public String getScenicPostcode() {
        return scenicPostcode;
    }

    public void setScenicPostcode(String scenicPostcode) {
        this.scenicPostcode = scenicPostcode;
    }
}
