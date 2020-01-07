package com.gisinfo.sand.productManage.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@ApiModel
@TableName("T_EARTHQUAKE_PRODUCTS_PS")
public class EarthquakeProductsPs {
    @Id
    @TableField("FEATID")
    private String featId;           //		主键
    @TableField("REL_TABLE")
    private String relTable;         //		关联的业务表
    @TableField("REL_ID")
    private String relId;            //		关联的业务表中的记录
    @TableField("OBJECT_TYPE")
    private String objectType;       //	    关联的业务表中的记录的状态或者其他分类信息
    @TableField("ORIGINAL_NAME")
    private String originalName;     //		上传的原始文件名称
    @TableField("NAME")
    private String name;             //		保存的文件名
    @TableField("FILE_TYPE")
    private String fileType;         //		文件类型
    @TableField("PATH")
    private String path;             //		文件保存路径
    @TableField("UPLOAD_DATE")
    private Date uploadDate;       //		上传文件的时间
    @TableField("UPLOADER")
    private String uploader;         //		上传人
    @TableField("DESCRIPTION")
    private String description;      //		文件描述
    @TableField("PRODUCT_VERSION")
    private String productVersion;   //		产品版本
    @TableField("PRODUCT_TYPE")
    private String productType;      //		产品类型
    @TableField("DEPARTMENT")
    private String department;       //		部门

    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;
    private String earthquakeName;

    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getRelTable() {
        return relTable;
    }

    public void setRelTable(String relTable) {
        this.relTable = relTable;
    }

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public String getName() {
        return name;
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

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getEarthquakeName() {
        return earthquakeName;
    }

    public void setEarthquakeName(String earthquakeName) {
        this.earthquakeName = earthquakeName;
    }

}
