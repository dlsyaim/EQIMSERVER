package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//燃气管网实体类
@Entity
@TableName("GAS_PIPE")
public class GasPipe {

    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectId;
    //管段
    @TableField("NAME")
    private String gaspipeName;
    //类型
    @TableField("CLASS")
    private String gaspipeClass;
    //道路
    @TableField("ROAD")
    private String gaspipeRoad;

    private Double depth;//	N	NUMBER(38,8)	Y
    @TableField("MATERIAL")
    private String gaspipematerial;//	N	NVARCHAR2(4)	Y
    private String pressure;//	N	NVARCHAR2(31)	Y
    private String id;//	N	NVARCHAR2(100)	Y
    @TableField("SHAPE_LENG")
    private Double shapeLeng;//	N	NUMBER(38,8)	Y
    private String startid;	//N	NVARCHAR2(20)	Y
    private String endid;	//N	NVARCHAR2(20)	Y
    private Double longitude;	//N	NUMBER(38,8)	Y
    private Double latitude;	//N	NUMBER(38,8)	Y
    private Integer length;	//N	INTEGER	Y
    @TableField("MATERIAL_TYPE")
    private String materialType;//	N	NVARCHAR2(10)	Y
    @TableField("ELASTICITY_MODULUS")
    private String elasticityModulus;//	N	NVARCHAR2(10)	Y
    @TableField("YIELD_LIMIT_STRESS")
    private String yieldLimitStress;//	N	NVARCHAR2(10)	Y
    @TableField("STRENGTH_LIMIT_STRESS")
    private String strengthLimitStress;//	N	NVARCHAR2(10)	Y
    @TableField("PERMISSIBLE_STRAIN")
    private String permissibleStrain;//	N	NVARCHAR2(10)	Y
    private String diameter;	//N	NVARCHAR2(10)	Y
    private String thickness;	//N	NVARCHAR2(10)	Y
    private String joint;	//N	NVARCHAR2(10)	Y
    @TableField("PERMISSIBLE_ELONGATION")
    private String permissibleElongation;	//N	NVARCHAR2(10)	Y
    private String site;	//N	NVARCHAR2(10)	Y
    private String liquefaction6;	//N	NVARCHAR2(10)	Y
    private String liquefaction7;	//N	NVARCHAR2(10)	Y
    private String liquefaction8;	//N	NVARCHAR2(10)	Y
    private String liquefaction9;	//N	NVARCHAR2(10)	Y
    @TableField("SEISMIC_SUBSIDENCE6")
    private String seismicSubsidence6;	//N	NVARCHAR2(10)	Y
    @TableField("SEISMIC_SUBSIDENCE7")
    private String seismicSubsidence7;	//N	NVARCHAR2(10)	Y
    @TableField("SEISMIC_SUBSIDENCE8")
    private String seismicSubsidence8;	//N	NVARCHAR2(10)	Y
    @TableField("SEISMIC_SUBSIDENCE9")
    private String seismicSubsidence9;	//N	NVARCHAR2(10)	Y
    @TableField("YEAR_")
    private String year;	//N	NVARCHAR2(10)	Y
    private String intensity;	//N	NVARCHAR2(10)	Y

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public String getGaspipeName() {
        return gaspipeName;
    }

    public void setGaspipeName(String gaspipeName) {
        this.gaspipeName = gaspipeName;
    }

    public String getGaspipeClass() {
        return gaspipeClass;
    }

    public void setGaspipeClass(String gaspipeClass) {
        this.gaspipeClass = gaspipeClass;
    }

    public String getGaspipeRoad() {
        return gaspipeRoad;
    }

    public void setGaspipeRoad(String gaspipeRoad) {
        this.gaspipeRoad = gaspipeRoad;
    }


    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getGaspipematerial() {
        return gaspipematerial;
    }

    public void setGaspipematerial(String gaspipematerial) {
        this.gaspipematerial = gaspipematerial;
    }

    public Double getDepth() {
        return depth;
    }

    public void setDepth(Double depth) {
        this.depth = depth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getShapeLeng() {
        return shapeLeng;
    }

    public void setShapeLeng(Double shapeLeng) {
        this.shapeLeng = shapeLeng;
    }

    public String getStartid() {
        return startid;
    }

    public void setStartid(String startid) {
        this.startid = startid;
    }

    public String getEndid() {
        return endid;
    }

    public void setEndid(String endid) {
        this.endid = endid;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getElasticityModulus() {
        return elasticityModulus;
    }

    public void setElasticityModulus(String elasticityModulus) {
        this.elasticityModulus = elasticityModulus;
    }

    public String getYieldLimitStress() {
        return yieldLimitStress;
    }

    public void setYieldLimitStress(String yieldLimitStress) {
        this.yieldLimitStress = yieldLimitStress;
    }

    public String getStrengthLimitStress() {
        return strengthLimitStress;
    }

    public void setStrengthLimitStress(String strengthLimitStress) {
        this.strengthLimitStress = strengthLimitStress;
    }

    public String getPermissibleStrain() {
        return permissibleStrain;
    }

    public void setPermissibleStrain(String permissibleStrain) {
        this.permissibleStrain = permissibleStrain;
    }

    public String getDiameter() {
        return diameter;
    }

    public void setDiameter(String diameter) {
        this.diameter = diameter;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness;
    }

    public String getJoint() {
        return joint;
    }

    public void setJoint(String joint) {
        this.joint = joint;
    }

    public String getPermissibleElongation() {
        return permissibleElongation;
    }

    public void setPermissibleElongation(String permissibleElongation) {
        this.permissibleElongation = permissibleElongation;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLiquefaction6() {
        return liquefaction6;
    }

    public void setLiquefaction6(String liquefaction6) {
        this.liquefaction6 = liquefaction6;
    }

    public String getLiquefaction7() {
        return liquefaction7;
    }

    public void setLiquefaction7(String liquefaction7) {
        this.liquefaction7 = liquefaction7;
    }

    public String getLiquefaction8() {
        return liquefaction8;
    }

    public void setLiquefaction8(String liquefaction8) {
        this.liquefaction8 = liquefaction8;
    }

    public String getLiquefaction9() {
        return liquefaction9;
    }

    public void setLiquefaction9(String liquefaction9) {
        this.liquefaction9 = liquefaction9;
    }

    public String getSeismicSubsidence6() {
        return seismicSubsidence6;
    }

    public void setSeismicSubsidence6(String seismicSubsidence6) {
        this.seismicSubsidence6 = seismicSubsidence6;
    }

    public String getSeismicSubsidence7() {
        return seismicSubsidence7;
    }

    public void setSeismicSubsidence7(String seismicSubsidence7) {
        this.seismicSubsidence7 = seismicSubsidence7;
    }

    public String getSeismicSubsidence8() {
        return seismicSubsidence8;
    }

    public void setSeismicSubsidence8(String seismicSubsidence8) {
        this.seismicSubsidence8 = seismicSubsidence8;
    }

    public String getSeismicSubsidence9() {
        return seismicSubsidence9;
    }

    public void setSeismicSubsidence9(String seismicSubsidence9) {
        this.seismicSubsidence9 = seismicSubsidence9;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

}
