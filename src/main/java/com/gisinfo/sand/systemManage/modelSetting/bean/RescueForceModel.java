package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_MODEL_RESCUE_FORCE")
public class RescueForceModel {

    @Id
    @TableField("FEATID")
    private String featId;                  //id
    //    @TableField("MODEL_SETTING_FEATID")
//    private String modelSettingFeatid;    //评估模型设置表ID
    @TableField("PARAM_NAME")
    private String paramName;              //参数名称
    @TableField("FORCE0")
    private Double force0;                      //参数0
    @TableField("FORCE1")
    private Double force1;                      //参数1
    @TableField("FORCE2")
    private Double force2;                      //参数2
    @TableField("FORMULA")
    private String formula;                 //采用的计算方法名称
    @TableField("MODEL_VERSION")
    private String modelVersion;           //版本
    @TableField("CREATE_TIME")
    private String createTime;               //创建时间
    @TableField("CREATED_BY")
    private String createdBy;              //创建人
    @TableField("UPDATE_TIME")
    private String updateTime;               //最后修改时间
    @TableField("UPDATED_BY")
    private String updatedBy;              //最后修改人
    @TableField("DEFAULT_STATUS")
    private String defaultStatus;

    @TableField("FORCE3")
    private Double force3;                      //参数3
    @TableField("FORCE4")
    private Double force4;                      //参数4
    @TableField("FORCE5")
    private Double force5;                      //参数5
    @TableField("FORCE6")
    private Double force6;                      //参数6

    @TableField("MEDICAL_STAFF0")
    private Double medicalStaff0;                      //医务人员参数0
    @TableField("MEDICAL_STAFF1")
    private Double medicalStaff1;                      //医务人员参数1
    @TableField("MEDICAL_STAFF2")
    private Double medicalStaff2;                      //医务人员参数2
    @TableField("MEDICAL_STAFF3")
    private Double medicalStaff3;                      //医务人员参数3

    @TableField("EPIDEMIC_PREVENTION0")
    private Double epidemicPrevention0;                      //防疫人员参数0
    @TableField("EPIDEMIC_PREVENTION1")
    private Double epidemicPrevention1;                      //防疫人员参数1
    @TableField("EPIDEMIC_PREVENTION2")
    private Double epidemicPrevention2;                      //防疫人员参数2
    @TableField("EPIDEMIC_PREVENTION3")
    private Double epidemicPrevention3;                      //防疫人员参数3


    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;

    public String getFeatId() {
        return featId;
    }

    public void setFeatId(String featId) {
        this.featId = featId;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public Double getForce0() {
        return force0;
    }

    public void setForce0(Double force0) {
        this.force0 = force0;
    }

    public Double getForce1() {
        return force1;
    }

    public void setForce1(Double force1) {
        this.force1 = force1;
    }

    public Double getForce2() {
        return force2;
    }

    public void setForce2(Double force2) {
        this.force2 = force2;
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

    public String getDefaultStatus() {
        return defaultStatus;
    }

    public void setDefaultStatus(String defaultStatus) {
        this.defaultStatus = defaultStatus;
    }

    public Double getForce3() {
        return force3;
    }

    public void setForce3(Double force3) {
        this.force3 = force3;
    }

    public Double getForce4() {
        return force4;
    }

    public void setForce4(Double force4) {
        this.force4 = force4;
    }

    public Double getForce5() {
        return force5;
    }

    public void setForce5(Double force5) {
        this.force5 = force5;
    }

    public Double getForce6() {
        return force6;
    }

    public void setForce6(Double force6) {
        this.force6 = force6;
    }

    public Double getMedicalStaff0() {
        return medicalStaff0;
    }

    public void setMedicalStaff0(Double medicalStaff0) {
        this.medicalStaff0 = medicalStaff0;
    }

    public Double getMedicalStaff1() {
        return medicalStaff1;
    }

    public void setMedicalStaff1(Double medicalStaff1) {
        this.medicalStaff1 = medicalStaff1;
    }

    public Double getMedicalStaff2() {
        return medicalStaff2;
    }

    public void setMedicalStaff2(Double medicalStaff2) {
        this.medicalStaff2 = medicalStaff2;
    }

    public Double getMedicalStaff3() {
        return medicalStaff3;
    }

    public void setMedicalStaff3(Double medicalStaff3) {
        this.medicalStaff3 = medicalStaff3;
    }

    public Double getEpidemicPrevention0() {
        return epidemicPrevention0;
    }

    public void setEpidemicPrevention0(Double epidemicPrevention0) {
        this.epidemicPrevention0 = epidemicPrevention0;
    }

    public Double getEpidemicPrevention1() {
        return epidemicPrevention1;
    }

    public void setEpidemicPrevention1(Double epidemicPrevention1) {
        this.epidemicPrevention1 = epidemicPrevention1;
    }

    public Double getEpidemicPrevention2() {
        return epidemicPrevention2;
    }

    public void setEpidemicPrevention2(Double epidemicPrevention2) {
        this.epidemicPrevention2 = epidemicPrevention2;
    }

    public Double getEpidemicPrevention3() {
        return epidemicPrevention3;
    }

    public void setEpidemicPrevention3(Double epidemicPrevention3) {
        this.epidemicPrevention3 = epidemicPrevention3;
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
}
