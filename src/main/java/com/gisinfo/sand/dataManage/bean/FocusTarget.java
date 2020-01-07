package com.gisinfo.sand.dataManage.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_EARTHQUAKE_FOCUS_SCHOOL")
public class FocusTarget {
    @Id
    @TableField("FEATID")
    private String featId;
    @TableField("EARTHQUAKE_FEATID")
    private String earthquakeFeatId;
    @TableField("DISTRICT_NAME")
    private String districtName;
    @TableField("SCHOOL_NAME")
    private String schoolName;
    @TableField("POSTCODE")
    private String postCode;
    @TableField("SCHOOL_NATURE")
    private String schoolNature;
    @TableField("SCHOOL_SCALE")
    private Integer schoolScale;
    @TableField("TEACHER_NUMBER")
    private Integer teacherNumber;
    @TableField("STUDENT_NUMBER")
    private Integer studentNumber;
    @TableField("SCHOOL_LOCATION")
    private String schoolLocation;

    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getEarthquakeFeatId() {
        return earthquakeFeatId;
    }

    public void setEarthquakeFeatId(String earthquakeFeatId) {
        this.earthquakeFeatId = earthquakeFeatId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getSchoolNature() {
        return schoolNature;
    }

    public void setSchoolNature(String schoolNature) {
        this.schoolNature = schoolNature;
    }

    public Integer getSchoolScale() {
        return schoolScale;
    }

    public void setSchoolScale(Integer schoolScale) {
        this.schoolScale = schoolScale;
    }

    public Integer getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(Integer teacherNumber) {
        this.teacherNumber = teacherNumber;
    }

    public Integer getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getSchoolLocation() {
        return schoolLocation;
    }

    public void setSchoolLocation(String schoolLocation) {
        this.schoolLocation = schoolLocation;
    }
}
