package com.gisinfo.sand.mapTemplate.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_EARTHQUAKE_PRODUCTS_PS")
public class DzsjFileBean {
    @Id
    @TableField("FEATID")
    private String featId;

    @TableField("REL_ID")
    private String relId;

    @TableField("ORIGINAL_NAME")
    private String originalName;

    @TableField("NAME")
    private String name;

    @TableField("FILE_TYPE")
    private String fileType;

    @TableField("PATH")
    private String path;

    @TableField("PCH")
    private String pch;

    public String getPch() {
        return pch;
    }

    public void setPch(String pch) {
        this.pch = pch;
    }

    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }

    public String getName() {
        return name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
