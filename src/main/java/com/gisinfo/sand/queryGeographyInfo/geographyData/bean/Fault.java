package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//查询断裂相关数据实体类
@Entity
@TableName("FAULT")
public class Fault {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //断裂属性
    @TableField("ATTR")
    private String faultAttr;
    //断裂名称
    @TableField("NAME")
    private String faultName;
    //断裂描述
    @TableField("CHARACTER_")
    private String character;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getFaultAttr() {
        return faultAttr;
    }

    public void setFaultAttr(String faultAttr) {
        this.faultAttr = faultAttr;
    }

    public String getFaultName() {
        return faultName;
    }

    public void setFaultName(String faultName) {
        this.faultName = faultName;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
