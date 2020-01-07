package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import org.apache.ibatis.annotations.Mapper;

import javax.persistence.Id;

//查询岩体相关数据实体类
@Mapper
@TableName("ROCK")
public class Rock {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //岩体名称
    @TableField("UNITNAME")
    private String unitName;
    //岩体符号
    @TableField("SYMBOL")
    private String symbol;
    //岩体描述
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
