package com.gisinfo.sand.commonData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("emergcy_plan")
public class EqEmergcyPlan{//应急预案

    @Id
    private Integer objectid;    //	N	INTEGER	N
    //private String outline;     //	N	BLOB Y
    //private String member;      //	N	BLOB	Y
    private String id;          //	N	NVARCHAR2(14)	Y


    private String unitname;    //	N	NVARCHAR2(60)	Y
    private String department;  //	N	NVARCHAR2(60)	Y
    @TableField("FULL_NAME")
    private String fullName;    //	N	VARCHAR2(100)	Y

    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;

    public EqEmergcyPlan(){}

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



    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
