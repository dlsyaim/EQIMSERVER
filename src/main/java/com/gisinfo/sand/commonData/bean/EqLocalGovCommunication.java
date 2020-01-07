package com.gisinfo.sand.commonData.bean;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("local_gov_communication")
public class EqLocalGovCommunication {//地方政府系统联系

    @Id
    private Integer objectid;        //	N	INTEGER	N
    private String id;              //	N	NVARCHAR2(14)	Y
    private String name;            //	N	NVARCHAR2(40)	Y
    private String postcode;        //	N	NVARCHAR2(6)	Y
    private String tel1;            //	N	NVARCHAR2(20)	Y
    private String tel2;            //	N	NVARCHAR2(20)	Y
    private String linkman;         //	N	NVARCHAR2(40)	Y
    private String fax;             //	N	NVARCHAR2(20)	Y

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

    public String getTel1() {
        return tel1;
    }

    public void setTel1(String tel1) {
        this.tel1 = tel1;
    }

    public String getTel2() {
        return tel2;
    }

    public void setTel2(String tel2) {
        this.tel2 = tel2;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
}
