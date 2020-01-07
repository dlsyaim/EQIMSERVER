package com.gisinfo.sand.commonData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("economy")
public class EqEconomy {//国民经济统计
    @Id
    private Integer objectid;           //	N	INTEGER	N
    private String id;                  //	N	NVARCHAR2(14)	N
    private String name;                //	N	NVARCHAR2(40)	Y
    private Integer gdp;                //	N	INTEGER	Y
    private Integer gdpMin;
    private Integer gdpMax;

    @TableField("INDUSTRY_VALUE")
    private Integer industryValue;     //	N	INTEGER	Y
    @TableField("AGRI_VALUE")
    private Integer agriValue;         //	N	INTEGER	Y
    @TableField("SERVICE_VALUE")
    private Integer serviceValue;      //	N	INTEGER	Y
    private Integer income;             //	N	INTEGER	Y
    private Integer outcome;            //	N	INTEGER	Y
    private Integer investment;         //	N	INTEGER	Y

    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;

    public Integer getGdpMin() {
        return gdpMin;
    }

    public void setGdpMin(Integer gdpMin) {
        this.gdpMin = gdpMin;
    }

    public Integer getGdpMax() {
        return gdpMax;
    }

    public void setGdpMax(Integer gdpMax) {
        this.gdpMax = gdpMax;
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

    @TableField("IMP_EXP")
    private Integer impExp;            //	N	INTEGER	Y

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

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    public Integer getIndustryValue() {
        return industryValue;
    }

    public void setIndustryValue(Integer industryValue) {
        this.industryValue = industryValue;
    }

    public Integer getAgriValue() {
        return agriValue;
    }

    public void setAgriValue(Integer agriValue) {
        this.agriValue = agriValue;
    }

    public Integer getServiceValue() {
        return serviceValue;
    }

    public void setServiceValue(Integer serviceValue) {
        this.serviceValue = serviceValue;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public Integer getOutcome() {
        return outcome;
    }

    public void setOutcome(Integer outcome) {
        this.outcome = outcome;
    }

    public Integer getInvestment() {
        return investment;
    }

    public void setInvestment(Integer investment) {
        this.investment = investment;
    }

    public Integer getImpExp() {
        return impExp;
    }

    public void setImpExp(Integer impExp) {
        this.impExp = impExp;
    }
}
