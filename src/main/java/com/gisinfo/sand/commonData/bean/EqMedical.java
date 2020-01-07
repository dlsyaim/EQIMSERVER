package com.gisinfo.sand.commonData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("medical")
public class EqMedical {//医疗力量
    @Id
    private Integer objectid;        //	N	NUMBER N
    private String id;              //	N	VARCHAR2(14)	Y			区域名称
    private String name;            //	N	VARCHAR2(40)	Y			病床数量
    private Integer bed;             //	N	NUMBER	Y			医生数
    private Integer doctor;          //	N	NUMBER	Y			外科医生数
    @TableField("SURGERY_DCT")
    private Integer surgeryDct;     //	N	NUMBER	Y			骨科医生数
    private Integer orthopedist;     //	N	NUMBER	Y			麻醉科医生数
    private Integer anesthetist;     //	N	NUMBER	Y			护理人员数
    private Integer nurse;           //	N	NUMBER	Y			行政区编码

    private Integer hospital;        //	N	NUMBER	Y			医院数量
    private Integer hospitalMin;
    private Integer hospitalMax;

    private Integer ambulance;       //	N	NUMBER	Y			急救车辆数量
    private Integer plasma;          //	N	NUMBER	Y			库存血浆量

    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;

    public Integer getHospitalMin() {
        return hospitalMin;
    }

    public void setHospitalMin(Integer hospitalMin) {
        this.hospitalMin = hospitalMin;
    }

    public Integer getHospitalMax() {
        return hospitalMax;
    }

    public void setHospitalMax(Integer hospitalMax) {
        this.hospitalMax = hospitalMax;
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

    public Integer getBed() {
        return bed;
    }

    public void setBed(Integer bed) {
        this.bed = bed;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    public Integer getSurgeryDct() {
        return surgeryDct;
    }

    public void setSurgeryDct(Integer surgeryDct) {
        this.surgeryDct = surgeryDct;
    }

    public Integer getOrthopedist() {
        return orthopedist;
    }

    public void setOrthopedist(Integer orthopedist) {
        this.orthopedist = orthopedist;
    }

    public Integer getAnesthetist() {
        return anesthetist;
    }

    public void setAnesthetist(Integer anesthetist) {
        this.anesthetist = anesthetist;
    }

    public Integer getNurse() {
        return nurse;
    }

    public void setNurse(Integer nurse) {
        this.nurse = nurse;
    }

    public Integer getHospital() {
        return hospital;
    }

    public void setHospital(Integer hospital) {
        this.hospital = hospital;
    }

    public Integer getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(Integer ambulance) {
        this.ambulance = ambulance;
    }

    public Integer getPlasma() {
        return plasma;
    }

    public void setPlasma(Integer plasma) {
        this.plasma = plasma;
    }
}
