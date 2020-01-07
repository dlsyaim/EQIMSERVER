package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//医院实体类
@Entity
@TableName("HOSPITAL")
public class Hospital {

    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //医院名称
    @TableField("NAME")
    private String name;

    //邮政编码
    @TableField("POSTCODE")
    private String postcode;
    //位置
    @TableField("LOCATION")
    private String location;
    //联系电话
    @TableField("TEL")
    private String tel;
    //病床数量
    @TableField("BED")
    private String bed;
    //所属部门
    @TableField("MEMBERSHIP")
    private String membership;
    //医院类别
    @TableField("TYPE")
    private String type;
    //等级
    @TableField("GRADE")
    private String grade;
    //急救车辆数量
    @TableField("AMBULANCE")
    private String ambulance;
    //库存血浆量
    @TableField("PLASMA")
    private String plasma;
    //医生数
    @TableField("DOCTOR")
    private String doctor;
    //外科医生数
    @TableField("SURGERY_DCT")
    private String surgeryDct;
    //骨科医生数
    @TableField("ORTHOPEDIST")
    private String orthopedist;
    //麻醉科医生数
    @TableField("ANESTHETIST")
    private String anesthetist;
    //护理人员数
    @TableField("NURSE")
    private String nurse;
    //能力描述
    @TableField("NOTE_")
    private String note_;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
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

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAmbulance() {
        return ambulance;
    }

    public void setAmbulance(String ambulance) {
        this.ambulance = ambulance;
    }

    public String getPlasma() {
        return plasma;
    }

    public void setPlasma(String plasma) {
        this.plasma = plasma;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getSurgeryDct() {
        return surgeryDct;
    }

    public void setSurgeryDct(String surgeryDct) {
        this.surgeryDct = surgeryDct;
    }

    public String getOrthopedist() {
        return orthopedist;
    }

    public void setOrthopedist(String orthopedist) {
        this.orthopedist = orthopedist;
    }

    public String getAnesthetist() {
        return anesthetist;
    }

    public void setAnesthetist(String anesthetist) {
        this.anesthetist = anesthetist;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    public String getNote_() {
        return note_;
    }

    public void setNote_(String note_) {
        this.note_ = note_;
    }
}

