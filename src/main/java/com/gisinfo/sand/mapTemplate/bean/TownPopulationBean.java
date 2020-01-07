package com.gisinfo.sand.mapTemplate.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("TOWN_POPULATION")
public class TownPopulationBean {
    @Id
    @TableField("OBJECTID_1")
    private Double objectid_1;
    @TableField("ID")
    private String id;
    @TableField("NAME")
    private String    name;
    @TableField("FLOATING")
    private Double floating;
    @TableField("TOTAL")
    private Double total;
    @TableField("FAMILY")
    private Double family;
    @TableField("OVER65")
    private Double over65;
    @TableField("UNDER14")
    private Double under14;
    @TableField("RESIDENT")
    private Double resident;


    public Double getObjectid_1() {
        return objectid_1;
    }

    public void setObjectid_1(Double objectid_1) {
        this.objectid_1 = objectid_1;
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

    public Double getFloating() {
        return floating;
    }

    public void setFloating(Double floating) {
        this.floating = floating;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getFamily() {
        return family;
    }

    public void setFamily(Double family) {
        this.family = family;
    }

    public Double getOver65() {
        return over65;
    }

    public void setOver65(Double over65) {
        this.over65 = over65;
    }

    public Double getUnder14() {
        return under14;
    }

    public void setUnder14(Double under14) {
        this.under14 = under14;
    }

    public Double getResident() {
        return resident;
    }

    public void setResident(Double resident) {
        this.resident = resident;
    }
}
