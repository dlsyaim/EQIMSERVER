package com.gisinfo.sand.systemManage.modelSetting.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("T_MODEL_RELIEF_GOODS")
public class TModelReliefGoods {
    @Id
    private String featid;          //	N	VARCHAR2(32)	N			ID
    @TableField("PARAM_NAME")
    private String paramName;       //	N	VARCHAR2(100)	Y			参数名称
    private Double tent0;           //	N	NUMBER(10,4)	Y			帐篷参数0
    private Double tent1;           //	N	NUMBER(10,4)	Y			帐篷参数1
    private Double tent2;           //	N	NUMBER(10,4)	Y			帐篷参数2
    private Double tent3;           //	N	NUMBER(10,4)	Y			帐篷参数3l0;
    private Double food0;           //	N	NUMBER(10,4)	Y			灾后粮食补助参数0;
    private Double food1;           //	N	NUMBER(10,4)	Y			灾后粮食补助参数1;
    private Double food2;           //	N	NUMBER(10,4)	Y			灾后粮食补助参数2;
    private Double food3;           //	N	NUMBER(10,4)	Y			灾后粮食补助参数3;
    private Double food4;           //	N	NUMBER(10,4)	Y			灾后粮食补助参数4;
    private Double food5;           //	N	NUMBER(10,4)	Y			灾后粮食补助参数5;
    private Double water0;          //	N	NUMBER(10,4)	Y			应急清洁饮水参数0;
    private Double water1;          //	N	NUMBER(10,4)	Y			应急清洁饮水参数1;
    private Double cloth0;          //	N	NUMBER(10,4)	Y			衣服参数0;
    private Double blanket0;        //	N	NUMBER(10,4)	Y			毛毯参数0;
    private Double blanket1;        //	N	NUMBER(10,4)	Y			毛毯参数1;
    private Double blanket2;        //	N	NUMBER(10,4)	Y			毛毯参数2;
    private Double lit0;            //	N	NUMBER(10,4)	Y			担架参数0;
    private Double ward0;           //	N	NUMBER(10,4)	Y			病床参数0;
    private Double remo0;           //	N	NUMBER(10,4)	Y			应急救灾款参数0;
    private Double remo1;           //	N	NUMBER(10,4)	Y			应急救灾款参数1;
    private Double toilet0;         //	N	NUMBER(10,4)	Y			临时厕所参数0;
    private Double quilt0;
    private Double quilt1;
    private Double quilt2;
    private String formula;         //	N	VARCHAR2(100)	Y			采用的计算方法名称
    @TableField("MODEL_VERSION")
    private String modelVersion;     //	N	VARCHAR2(30)	Y			版本
    @TableField("CREATE_TIME")
    private String createTime;       //	N	DATE Y			创建时间
    @TableField("CREATED_BY")
    private String createdBy;       //	N	VARCHAR2(30)	Y			创建人
    @TableField("UPDATE_TIME")
    private String updateTime;       //	N	DATE	Y			最后修改时间
    @TableField("UPDATED_BY")
    private String updatedBy;       //	N	VARCHAR2(30)	Y			最后修改人

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

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Double getTent0() {
        return tent0;
    }

    public void setTent0(Double tent0) {
        this.tent0 = tent0;
    }

    public Double getTent1() {
        return tent1;
    }

    public void setTent1(Double tent1) {
        this.tent1 = tent1;
    }

    public Double getTent2() {
        return tent2;
    }

    public void setTent2(Double tent2) {
        this.tent2 = tent2;
    }

    public Double getTent3() {
        return tent3;
    }

    public void setTent3(Double tent3) {
        this.tent3 = tent3;
    }

    public Double getFood0() {
        return food0;
    }

    public void setFood0(Double food0) {
        this.food0 = food0;
    }

    public Double getFood1() {
        return food1;
    }

    public void setFood1(Double food1) {
        this.food1 = food1;
    }

    public Double getFood2() {
        return food2;
    }

    public void setFood2(Double food2) {
        this.food2 = food2;
    }

    public Double getFood3() {
        return food3;
    }

    public void setFood3(Double food3) {
        this.food3 = food3;
    }

    public Double getFood4() {
        return food4;
    }

    public void setFood4(Double food4) {
        this.food4 = food4;
    }

    public Double getFood5() {
        return food5;
    }

    public void setFood5(Double food5) {
        this.food5 = food5;
    }

    public Double getWater0() {
        return water0;
    }

    public void setWater0(Double water0) {
        this.water0 = water0;
    }

    public Double getWater1() {
        return water1;
    }

    public void setWater1(Double water1) {
        this.water1 = water1;
    }

    public Double getCloth0() {
        return cloth0;
    }

    public void setCloth0(Double cloth0) {
        this.cloth0 = cloth0;
    }

    public Double getBlanket0() {
        return blanket0;
    }

    public void setBlanket0(Double blanket0) {
        this.blanket0 = blanket0;
    }

    public Double getBlanket1() {
        return blanket1;
    }

    public void setBlanket1(Double blanket1) {
        this.blanket1 = blanket1;
    }

    public Double getBlanket2() {
        return blanket2;
    }

    public void setBlanket2(Double blanket2) {
        this.blanket2 = blanket2;
    }

    public Double getLit0() {
        return lit0;
    }

    public void setLit0(Double lit0) {
        this.lit0 = lit0;
    }

    public Double getWard0() {
        return ward0;
    }

    public void setWard0(Double ward0) {
        this.ward0 = ward0;
    }

    public Double getRemo0() {
        return remo0;
    }

    public void setRemo0(Double remo0) {
        this.remo0 = remo0;
    }

    public Double getRemo1() {
        return remo1;
    }

    public void setRemo1(Double remo1) {
        this.remo1 = remo1;
    }

    public Double getToilet0() {
        return toilet0;
    }

    public void setToilet0(Double toilet0) {
        this.toilet0 = toilet0;
    }

    public Double getQuilt0() {
        return quilt0;
    }

    public void setQuilt0(Double quilt0) {
        this.quilt0 = quilt0;
    }

    public Double getQuilt1() {
        return quilt1;
    }

    public void setQuilt1(Double quilt1) {
        this.quilt1 = quilt1;
    }

    public Double getQuilt2() {
        return quilt2;
    }

    public void setQuilt2(Double quilt2) {
        this.quilt2 = quilt2;
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
}
