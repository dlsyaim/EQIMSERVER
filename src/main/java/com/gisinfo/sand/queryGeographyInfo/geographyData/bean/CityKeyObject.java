package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//城市主要目标实体类
@Entity
@TableName("CITY_KEYOBJECT")
public class CityKeyObject {


    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;

    private String ID;

    //城市主要目标名称
    @TableField("NAME")
    private String citykeyName;
    //邮编
    @TableField("POSTCODE")
    private String citykeyPostcode;
    //备注
    @TableField("NOTE_")
    private String citykeyNote_;
    //性质
    @TableField("CLASS")
    private String citykeyClass;

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

    public String getCitykeyName() {
        return citykeyName;
    }

    public void setCitykeyName(String citykeyName) {
        this.citykeyName = citykeyName;
    }

    public String getCitykeyPostcode() {
        return citykeyPostcode;
    }

    public void setCitykeyPostcode(String citykeyPostcode) {
        this.citykeyPostcode = citykeyPostcode;
    }

    public String getCitykeyNote_() {
        return citykeyNote_;
    }

    public void setCitykeyNote_(String citykeyNote_) {
        this.citykeyNote_ = citykeyNote_;
    }

    public String getCitykeyClass() {
        return citykeyClass;
    }

    public void setCitykeyClass(String citykeyClass) {
        this.citykeyClass = citykeyClass;
    }

}
