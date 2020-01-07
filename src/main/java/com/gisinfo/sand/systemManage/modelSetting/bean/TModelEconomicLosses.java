package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 经济损失模型参数表
 * </p>
 * @since 2020-01-03
 */
@Entity
@TableName("T_MODEL_ECONOMIC_LOSSES")
public class TModelEconomicLosses implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableId("FEATID")
    private String featid;

    /**
     * 参数名称
     */
    @TableField("PARAM_NAME")
    private String paramName;

    /**
     * 地震烈度
     */
    @TableField("I")
    private String i;

    /**
     * 经济损失比
     */
    @TableField("ECONOMIC_LOSSES")
    private Double economicLosses;

    /**
     * 采用的计算方法名称
     */
    @TableField("FORMULA")
    private String formula;

    /**
     * 版本
     */
    @TableField("MODEL_VERSION")
    private String modelVersion;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME")
    private Date createTime;

    /**
     * 创建人
     */
    @TableField("CREATED_BY")
    private String createdBy;

    /**
     * 最后修改时间
     */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /**
     * 最后修改人
     */
    @TableField("UPDATED_BY")
    private String updatedBy;

    /**
     * 默认状态1默认0为不默认
     */
    @TableField("DEFAULT_STATUS")
    private Integer defaultStatus;

    public String getFeatid() {
        return featid;
    }

    public void setFeatid(String featid) {
        this.featid = featid;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public Double getEconomicLosses() {
        return economicLosses;
    }

    public void setEconomicLosses(Double economicLosses) {
        this.economicLosses = economicLosses;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Integer getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(Integer defaultStatus) {
        this.defaultStatus = defaultStatus;
    }
}
