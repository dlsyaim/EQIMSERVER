package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//学校所实体类
@Entity
@TableName("SCHOOL")
public class School {

    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;

    private String ID;

    //区县行政区名称
    @TableField("FULL_NAME")
    private String fullName;

    //学校名称
    @TableField("UNITNAME")
    private String unitName;
    //邮政编码
    @TableField("POSTCODE")
    private String postcode;
    //规模
//    @TableField("SCALE")
    private String scale;
    //教师人数
    @TableField("TEACHER")
    private String teacher;
    //学生人数
    @TableField("STUDENT")
    private String student;
    //主体建筑结构
    @TableField("NOTE_")
    private String note_;
    //性质
//    @TableField("CLASS")
    private String CLASS;

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getNote_() {
        return note_;
    }

    public void setNote_(String note_) {
        this.note_ = note_;
    }

    public String getCLASS() {
        return CLASS;
    }

    public void setCLASS(String CLASS) {
        this.CLASS = CLASS;
    }
}
