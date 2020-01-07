package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_MODEL_EARTHQUAKE_SETTING")
public class TModelEarthquake {

    @Id
    private String featid;          //	N	VARCHAR2(32)	N			ID
    @TableField("PARAM_NAME")
    private String paramName;       //	N	VARCHAR2(100)	Y			参数名
    @TableField("MODEL_NAME")
    private String modelName;//	N	VARCHAR2(100)	Y			模型名称
    @TableField("FORMULA_FROM")
    private String formulaFrom;//	N	VARCHAR2(100)	Y			公式来源
    private Double l1;              //	N	NUMBER(10,6)	Y			参数L1
    private Double l2;              //	N	NUMBER(10,6)	Y			参数L2
    private Double l3;              //	N	NUMBER(10,6)	Y			参数L3
    private Double l4;              //	N	NUMBER(10,6)	Y			参数L4
    private Double s1;              //	N	NUMBER(10,6)	Y			参数S1
    private Double s2;              //	N	NUMBER(10,6)	Y			参数S2
    private Double s3;              //	N	NUMBER(10,6)	Y			参数S3
    private Double s4;              //	N	NUMBER(10,6)	Y			参数S4
    private Double l;               //	N	NUMBER(10,6)	Y			经验性常量
    private Double v;               //	N	NUMBER(10,6)	Y			协调系数
    @TableField("MAX_INTENSITY_CIRCULAR")
    private String maxIntensityCircular;//	N	VARCHAR2(30)	Y			启用圆模型的最大烈度
    @TableField("MIN_INTENSITY_EFFECT")
    private String minIntensityEffect;//	N	VARCHAR2(30)	Y			影响场最小烈度圈
    @TableField("IF_LINE_SOURCE_FIELDS")
    private String ifLineSourceFields;//	N	VARCHAR2(30)	Y			是否生成线源影响场，1为是，0为否
    @TableField("IF_OFFSET")
    private String ifOffset;//	N	VARCHAR2(30)	Y			是否生成上移、下移宏观影响场，1为是，0为否
    @TableField("CREATE_TIME")
    private String createTime;       //	N	DATE Y			创建时间
    @TableField("CREATED_BY")
    private String createdBy;       //	N	VARCHAR2(30)	Y			创建人
    @TableField("UPDATE_TIME")
    private String updateTime;       //	N	DATE	Y			最后修改时间
    @TableField("UPDATED_BY")
    private String updatedBy;       //	N	VARCHAR2(30)	Y			最后修改人
    @TableField("DEFAULT_STATUS")
    private Integer defaultStatus; //	N	NUMBER(10,4)	N			默认状态1默认0为不默认

    @TableField("MODEL_VERSION")
    private String modelVersion;       //	N	VARCHAR2(30)	Y			最后修改人

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

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getFormulaFrom() {
        return formulaFrom;
    }

    public void setFormulaFrom(String formulaFrom) {
        this.formulaFrom = formulaFrom;
    }

    public Double getL1() {
        return l1;
    }

    public void setL1(Double l1) {
        this.l1 = l1;
    }

    public Double getL2() {
        return l2;
    }

    public void setL2(Double l2) {
        this.l2 = l2;
    }

    public Double getL3() {
        return l3;
    }

    public void setL3(Double l3) {
        this.l3 = l3;
    }

    public Double getL4() {
        return l4;
    }

    public void setL4(Double l4) {
        this.l4 = l4;
    }

    public Double getS1() {
        return s1;
    }

    public void setS1(Double s1) {
        this.s1 = s1;
    }

    public Double getS2() {
        return s2;
    }

    public void setS2(Double s2) {
        this.s2 = s2;
    }

    public Double getS3() {
        return s3;
    }

    public void setS3(Double s3) {
        this.s3 = s3;
    }

    public Double getS4() {
        return s4;
    }

    public void setS4(Double s4) {
        this.s4 = s4;
    }

    public Double getL() {
        return l;
    }

    public void setL(Double l) {
        this.l = l;
    }

    public Double getV() {
        return v;
    }

    public void setV(Double v) {
        this.v = v;
    }

    public String getMaxIntensityCircular() {
        return maxIntensityCircular;
    }

    public void setMaxIntensityCircular(String maxIntensityCircular) {
        this.maxIntensityCircular = maxIntensityCircular;
    }

    public String getMinIntensityEffect() {
        return minIntensityEffect;
    }

    public void setMinIntensityEffect(String minIntensityEffect) {
        this.minIntensityEffect = minIntensityEffect;
    }

    public String getIfLineSourceFields() {
        return ifLineSourceFields;
    }

    public void setIfLineSourceFields(String ifLineSourceFields) {
        this.ifLineSourceFields = ifLineSourceFields;
    }

    public String getIfOffset() {
        return ifOffset;
    }

    public void setIfOffset(String ifOffset) {
        this.ifOffset = ifOffset;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
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

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }
}
