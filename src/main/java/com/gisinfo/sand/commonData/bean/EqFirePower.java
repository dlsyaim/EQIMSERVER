package com.gisinfo.sand.commonData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("fire_power")
public class EqFirePower {//消防力量
    @Id
    private Integer objectid;      //	N	INTEGER	N
    @TableField("FIRE_TRUCK")
    private Double fireTruck;    //	N	NUMBER(38,8)	Y
    private Double staff;         //	N	NUMBER(38,8)	Y
    private String id;            //	N	NVARCHAR2(14)	Y
    private String name;     //	N	NVARCHAR2(40)	Y
    private String postcode;      //	N	NVARCHAR2(6)	Y

    private String location;      //	N	NVARCHAR2(50)	Y
    private String tel;           //	N	NVARCHAR2(20)	Y

    @TableField("NOTE_")
    private String note;          //	N	NVARCHAR2(80)	Y

    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;

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

    public Double getFireTruck() {
        return fireTruck;
    }

    public void setFireTruck(Double fireTruck) {
        this.fireTruck = fireTruck;
    }

    public Double getStaff() {
        return staff;
    }

    public void setStaff(Double staff) {
        this.staff = staff;
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
