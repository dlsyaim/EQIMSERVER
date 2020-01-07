package com.gisinfo.sand.commonData.bean;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("CLIMATE")
public class EqClimate {//气象统计数据
    @Id
    private Integer objectid;            //	N	INTEGER	N
    @TableField("AV_PREC")
    private Double avPrec;              //	N	NUMBER(38,8)	Y
    @TableField("AV_TEMP")
    private Double avTemp;              //	N	NUMBER(38,8)	Y
    @TableField("AV_WINDGRADE")
    private Double avWindgrade;         //	N	NUMBER(38,8)	Y
    @TableField("H_TEMP")
    private Double hTemp;               //	N	NUMBER(38,8)	Y
    @TableField("L_PREC")
    private Double lPrec;               //	N	NUMBER(38,8)	Y
    @TableField("L_TEMP")
    private Double lTemp;               //	N	NUMBER(38,8)	Y
    @TableField("MONTH_")
    private Integer month;              //	N	INTEGER	Y
    @TableField("H_PREC")
    private Double hPrec;               //	N	NUMBER(38,8)	Y
    private String id;                   //	N	NVARCHAR2(14)	Y
    private String name;                 //	N	NVARCHAR2(40)	Y
    @TableField("AV_WINDDIR")
    private String avWinddir;           //	N	NVARCHAR2(10)	Y

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

    public Double getAvPrec() {
        return avPrec;
    }

    public void setAvPrec(Double avPrec) {
        this.avPrec = avPrec;
    }

    public Double getAvTemp() {
        return avTemp;
    }

    public void setAvTemp(Double avTemp) {
        this.avTemp = avTemp;
    }

    public Double getAvWindgrade() {
        return avWindgrade;
    }

    public void setAvWindgrade(Double avWindgrade) {
        this.avWindgrade = avWindgrade;
    }

    public Double gethTemp() {
        return hTemp;
    }

    public void sethTemp(Double hTemp) {
        this.hTemp = hTemp;
    }

    public Double getlPrec() {
        return lPrec;
    }

    public void setlPrec(Double lPrec) {
        this.lPrec = lPrec;
    }

    public Double getlTemp() {
        return lTemp;
    }

    public void setlTemp(Double lTemp) {
        this.lTemp = lTemp;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double gethPrec() {
        return hPrec;
    }

    public void sethPrec(Double hPrec) {
        this.hPrec = hPrec;
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

    public String getAvWinddir() {
        return avWinddir;
    }

    public void setAvWinddir(String avWinddir) {
        this.avWinddir = avWinddir;
    }
}
