package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//查询地层数据对象
@Entity
@TableName("STRATIGRAPHY")
public class Stratigraphy {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //单位名称
    @TableField("UNITNAME")
    private String unitName;
    //符号
    @TableField("SYMBOL")
    private String symbol;
    //描述
    @TableField("CHARACTER_")
    private String character;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
