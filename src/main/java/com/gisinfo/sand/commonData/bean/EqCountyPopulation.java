package com.gisinfo.sand.commonData.bean;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("county_population")
public class EqCountyPopulation {//区县级人口统计
    @Id
    private Integer objectid; //	N	INTEGER	N

    private Double total;        //N	NUMBER(38,8)	Y

    private Double totalMin;
    private Double totalMax;

    private Double resident;  //	N	NUMBER(38,8)	Y
    private Double family;    //	N	NUMBER(38,8)	Y
    private Double over65;    //N	NUMBER(38,8)	Y
    private Double under14;    //N	NUMBER(38,8)	Y
    private String id;        //N	NVARCHAR2(14)	Y
    private String name;        //N	NVARCHAR2(40)	Y

    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;

    public Double getTotalMin() {
        return totalMin;
    }

    public void setTotalMin(Double totalMin) {
        this.totalMin = totalMin;
    }

    public Double getTotalMax() {
        return totalMax;
    }

    public void setTotalMax(Double totalMax) {
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getResident() {
        return resident;
    }

    public void setResident(Double resident) {
        this.resident = resident;
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
}
