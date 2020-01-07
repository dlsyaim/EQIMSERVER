package com.gisinfo.sand.commonData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("town_population")
public class EqTownPopulation {//乡镇级人口统计
    @Id
    @TableField("OBJECTID_1")
    private Integer objectid;      //	N	INTEGER	N

    private String id;             //	N	NVARCHAR2(14)	Y
    private String name;           //	N	NVARCHAR2(40)	Y
    private Integer floating;      //	N	INTEGER	Y

    private Integer total;         //	N	INTEGER	Y
    private Integer totalMin;
    private Integer totalMax;

    private Integer family;        //	N	INTEGER	Y
    private Integer over65;        //	N	INTEGER	Y
    private Integer under14;       //	N	INTEGER	Y
    private Integer resident;      //	N	INTEGER	Y

    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;

    public Integer getTotalMin() {
        return totalMin;
    }

    public void setTotalMin(Integer totalMin) {
        this.totalMin = totalMin;
    }

    public Integer getTotalMax() {
        return totalMax;
    }

    public void setTotalMax(Integer totalMax) {
        this.totalMax = totalMax;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getBottom() {
        return bottom;
    }

    public void setBottom(Integer bottom) {
        this.bottom = bottom;
    }

    public Integer getTop() {
        return top;
    }

    public void setTop(Integer top) {
        this.top = top;
    }

    public Integer getObjectid() {
        return objectid;
    }

    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
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

    public Integer getFloating() {
        return floating;
    }

    public void setFloating(Integer floating) {
        this.floating = floating;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getFamily() {
        return family;
    }

    public void setFamily(Integer family) {
        this.family = family;
    }

    public Integer getOver65() {
        return over65;
    }

    public void setOver65(Integer over65) {
        this.over65 = over65;
    }

    public Integer getUnder14() {
        return under14;
    }

    public void setUnder14(Integer under14) {
        this.under14 = under14;
    }

    public Integer getResident() {
        return resident;
    }

    public void setResident(Integer resident) {
        this.resident = resident;
    }

}
