package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//隧道实体类
@Entity
@TableName("TUNNEL")
public class Tunnel {
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //隧道名称
    @TableField("NAME")
    private String tunnelName;
    //隧道类别
    @TableField("CLASS")
    private String tunnelClass;
    //所在位置
    @TableField("LOCATION")
    private String location;
    //隧道等级
    @TableField("GRADE")
    private String tunnelGrade;
    //隧道长度
    @TableField("LENGTH")
    private Double tunnelLength;
    //隧道宽度
    @TableField("WIDTH")
    private Double tunnelWidth;
    //最大允许通过高度
    @TableField("HEIGHT")
    private Double tunnelHeight;
    //是否复线隧道
    @TableField("number_line")
    private String numberLine;
    //抗震设防烈度
    @TableField("INTENSITY")
    private Double tunnelIntensity;
    //建设年代
    @TableField("BUILT_ERA")
    private String builtEra;
    //隧道简介
    @TableField("NOTE")
    private String tunnelNote;


    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getTunnelName() {
        return tunnelName;
    }

    public void setTunnelName(String tunnelName) {
        this.tunnelName = tunnelName;
    }

    public String getTunnelClass() {
        return tunnelClass;
    }

    public void setTunnelClass(String tunnelClass) {
        this.tunnelClass = tunnelClass;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTunnelGrade() {
        return tunnelGrade;
    }

    public void setTunnelGrade(String tunnelGrade) {
        this.tunnelGrade = tunnelGrade;
    }

    public Double getTunnelLength() {
        return tunnelLength;
    }

    public void setTunnelLength(Double tunnelLength) {
        this.tunnelLength = tunnelLength;
    }

    public Double getTunnelWidth() {
        return tunnelWidth;
    }

    public void setTunnelWidth(Double tunnelWidth) {
        this.tunnelWidth = tunnelWidth;
    }

    public Double getTunnelHeight() {
        return tunnelHeight;
    }

    public void setTunnelHeight(Double tunnelHeight) {
        this.tunnelHeight = tunnelHeight;
    }

    public String getNumberLine() {
        return numberLine;
    }

    public void setNumberLine(String numberLine) {
        this.numberLine = numberLine;
    }

    public String getBuiltEra() {
        return builtEra;
    }

    public void setBuiltEra(String builtEra) {
        this.builtEra = builtEra;
    }

    public String getTunnelNote() {
        return tunnelNote;
    }

    public void setTunnelNote(String tunnelNote) {
        this.tunnelNote = tunnelNote;
    }

    public Double getTunnelIntensity() {
        return tunnelIntensity;
    }

    public void setTunnelIntensity(Double tunnelIntensity) {
        this.tunnelIntensity = tunnelIntensity;
    }
}
