package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 受伤人员模型参数表
 * </p>
 *
 * @since 2020-01-03
 */
@Entity
@TableName("T_MODEL_INJURED")
public class TModelInjured implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @TableField("FEATID")
    private String featid;

    /**
     * 参数名称
     */
    @TableField("PARAM_NAME")
    private String paramName;

    /**
     * 参数0
     */
    @TableField("L0")
    private BigDecimal l0;

    /**
     * 级别（震级/烈度）
     */
    @TableField("SCALE")
    private String scale;

    /**
     * 受伤人员所占比例
     */
    @TableField("PERCENT_INJURED")
    private BigDecimal percentInjured;

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
    private LocalDateTime createTime;

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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public BigDecimal getL0() {
        return l0;
    }

    public void setL0(BigDecimal l0) {
        this.l0 = l0;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public BigDecimal getPercentInjured() {
        return percentInjured;
    }

    public void setPercentInjured(BigDecimal percentInjured) {
        this.percentInjured = percentInjured;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
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
