package com.gisinfo.sand.commonData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@TableName("town_building")
public class EqTownBuilding {//乡镇房屋统计
//    @Id
//    private Integer objectid;            //	N	INTEGER	N
//    @TableField("TOTAL_AREA")
//    private Double totalArea;          //	N	NUMBER(38,8)	Y
//    private Double totalAreaMin;
//    private Double totalAreaMax;
//
//    @TableField("BRICK_PRICE")
//    private Double brickPrice;          //	N	NUMBER(38,8)	Y
//    @TableField("BRICK_PROPERTY")
//    private Double brickProperty;       //	N	NUMBER(38,8)	Y
//    @TableField("BRICK_STRUCTURE")
//    private Double brickStructure;      //	N	NUMBER(38,8)	Y
//    @TableField("HIGH_RISE")
//    private Double highRise;            //	N	NUMBER(38,8)	Y
//    @TableField("HIGH_RISE_PRICE")
//    private Double highRisePrice;      //	N	NUMBER(38,8)	Y
//    @TableField("HIGH_RISE_PROPERTY")
//    private Double highRiseProperty;   //	N	NUMBER(38,8)	Y
//
//    private Double intensity;            //N	INTEGER	Y
//    @TableField("OTHER_PRICE")
//    private Double otherPrice;          //	N	NUMBER(38,8)	Y
//    @TableField("OTHER_PROPERTY")
//    private Double otherProperty;       //	N	NUMBER(38,8)	Y
//    @TableField("OTHER_STRUCTURE")
//    private Double otherStructure;      //	N	NUMBER(38,8)	Y
//    private Double rcframe;              //	N	NUMBER(38,8)	Y
//    @TableField("RCFRAME_PRICE")
//    private Double rcframePrice;        //	N	NUMBER(38,8)	Y
//    @TableField("RCFRAME_PROPERTY")
//    private Double rcframeProperty;     //	N	NUMBER(38,8)	Y
//    @TableField("SINGLE_AREA")
//    private Double singleArea;          //	N	NUMBER(38,8)	Y
//    @TableField("SINGLE_PRICE")
//    private Double singlePrice;         //	N	NUMBER(38,8)	Y
//    @TableField("SINGLE_PROPERTY")
//    private Double singleProperty;      //	N	NUMBER(38,8)	Y
//
//    private Double average;              //	N	NUMBER(38,8)	Y
//    private Double averageMin;
//    private Double averageMax;
//    //    BRICK_STRUCTURE_PIC	N	BLOB Y
//    //    HIGH_RISE_PIC	N	BLOB	Y
//    //    OTHER_STRUCTURE_PIC	N	BLOB	Y
//    //    RCFRAME_PIC	N	BLOB	Y
//    //    SINGLE_BUILDING_PIC	N	BLOB	Y
//    private String id;                   //	N	NVARCHAR2(14)	Y
//    private String cityname;             //	N	NVARCHAR2(40)	Y
//    private String name;                 //	N	NVARCHAR2(40)	Y
//    private String gas;                  //	N	NVARCHAR2(20)	Y
//    @TableField("ID_1")
//    private String id1;                 //	N	NVARCHAR2(14)	Yprivate Double

    @Id
    private Double objectid;	            //N	NUMBER(38,8)	Y
    private String cityname;	            //N	NVARCHAR2(255)	Y
    private String countyname;	            //N	NVARCHAR2(255)	Y
    private String name;	                //N	NVARCHAR2(255)	Y
    private Double id;	                    //N	NUMBER(38,8)	Y

    @TableField("TOTAL_AREA")
    private Double totalArea;	            //N	NUMBER(38,8)	Y
    private Double totalAreaMin;
    private Double totalAreaMax;

    private String average;	                //N	NVARCHAR2(255)	Y
    private String averageMin;
    private String averageMax;

    @TableField("HIGH_RISE")
    private Double highRise;	            //N	NUMBER(38,8)	Y

    @TableField("HIGH_RISE_PRICE")
    private String highRisePrice;	        //N	NVARCHAR2(255)	Y
    @TableField("HIGH_RISE_PROPERTY")
    private String highRiseProperty;	    //N	NVARCHAR2(255)	Y

    private Double rcframe;	                //N	NUMBER(38,8)	Y
    @TableField("RCFRAME_PRICE")
    private String rcframePrice;	        //N	NVARCHAR2(255)	Y
    @TableField("RCFRAME_PROPERTY")
    private String rcframeProperty;        //	N	NVARCHAR2(255)	Y
    @TableField("BRICK_STRUCTURE")
    private Double brickStructure;	        //N	NUMBER(38,8)	Y
    @TableField("BRICK_PRICE")
    private String brickPrice;	            //N	NVARCHAR2(255)	Y
    @TableField("BRICK_PROPERTY")
    private String brickProperty;	        //N	NVARCHAR2(255)	Y
    @TableField("SINGLE_AREA")
    private Double singleArea;	            //N	NUMBER(38,8)	Y
    @TableField("SINGLE_PRICE")
    private Double singlePrice;	        //N	NUMBER(38,8)	Y
    @TableField("SINGLE_PROPERTY")
    private String singleProperty;	        //N	NVARCHAR2(255)	Y
    @TableField("OTHER_STRUCTURE")
    private Double otherStructure;	        //N	NUMBER(38,8)	Y
    @TableField("OTHER_PRICE")
    private String otherPrice;	            //N	NVARCHAR2(255)	Y
    @TableField("OTHER_PROPERTY")
    private String otherProperty;	        //N	NVARCHAR2(255)	Y

    private String gas;	                    //N	NVARCHAR2(255)	Y
    @TableField("HIGH_RISE_PIC")
    private String highRisePic;	        //N	NVARCHAR2(255)	Y
    @TableField("RCFRAME_PIC")
    private String rcframePic;	            //N	NVARCHAR2(255)	Y
    @TableField("BRICK_STRUCTURE_PIC")
    private String brickStructurePic;	    //N	NVARCHAR2(255)	Y
    @TableField("SINGLE_BUILDING_PIC")
    private String singleBuildingPic;	    //N	NVARCHAR2(255)	Y
    @TableField("OTHER_STRUCTURE_PIC")
    private String otherStructurePic;	    //n	nvarchar2(255)	y

    private String intensity;	            //N	NVARCHAR2(255)	Y
    //private String shape;	                //N	BLOB Y


    private Integer pageNo;
    private Integer pageSize;
    private Integer bottom;
    private Integer top;

    public Double getObjectid() {
        return objectid;
    }

    public void setObjectid(Double objectid) {
        this.objectid = objectid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCountyname() {
        return countyname;
    }

    public void setCountyname(String countyname) {
        this.countyname = countyname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getId() {
        return id;
    }

    public void setId(Double id) {
        this.id = id;
    }

    public Double getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(Double totalArea) {
        this.totalArea = totalArea;
    }

    public Double getTotalAreaMin() {
        return totalAreaMin;
    }

    public void setTotalAreaMin(Double totalAreaMin) {
        this.totalAreaMin = totalAreaMin;
    }

    public Double getTotalAreaMax() {
        return totalAreaMax;
    }

    public void setTotalAreaMax(Double totalAreaMax) {
        this.totalAreaMax = totalAreaMax;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getAverageMin() {
        return averageMin;
    }

    public void setAverageMin(String averageMin) {
        this.averageMin = averageMin;
    }

    public String getAverageMax() {
        return averageMax;
    }

    public void setAverageMax(String averageMax) {
        this.averageMax = averageMax;
    }

    public Double getHighRise() {
        return highRise;
    }

    public void setHighRise(Double highRise) {
        this.highRise = highRise;
    }

    public String getHighRisePrice() {
        return highRisePrice;
    }

    public void setHighRisePrice(String highRisePrice) {
        this.highRisePrice = highRisePrice;
    }

    public String getHighRiseProperty() {
        return highRiseProperty;
    }

    public void setHighRiseProperty(String highRiseProperty) {
        this.highRiseProperty = highRiseProperty;
    }

    public Double getRcframe() {
        return rcframe;
    }

    public void setRcframe(Double rcframe) {
        this.rcframe = rcframe;
    }

    public String getRcframePrice() {
        return rcframePrice;
    }

    public void setRcframePrice(String rcframePrice) {
        this.rcframePrice = rcframePrice;
    }

    public String getRcframeProperty() {
        return rcframeProperty;
    }

    public void setRcframeProperty(String rcframeProperty) {
        this.rcframeProperty = rcframeProperty;
    }

    public Double getBrickStructure() {
        return brickStructure;
    }

    public void setBrickStructure(Double brickStructure) {
        this.brickStructure = brickStructure;
    }

    public String getBrickPrice() {
        return brickPrice;
    }

    public void setBrickPrice(String brickPrice) {
        this.brickPrice = brickPrice;
    }

    public String getBrickProperty() {
        return brickProperty;
    }

    public void setBrickProperty(String brickProperty) {
        this.brickProperty = brickProperty;
    }

    public Double getSingleArea() {
        return singleArea;
    }

    public void setSingleArea(Double singleArea) {
        this.singleArea = singleArea;
    }

    public Double getSinglePrice() {
        return singlePrice;
    }

    public void setSinglePrice(Double singlePrice) {
        this.singlePrice = singlePrice;
    }

    public String getSingleProperty() {
        return singleProperty;
    }

    public void setSingleProperty(String singleProperty) {
        this.singleProperty = singleProperty;
    }

    public Double getOtherStructure() {
        return otherStructure;
    }

    public void setOtherStructure(Double otherStructure) {
        this.otherStructure = otherStructure;
    }

    public String getOtherPrice() {
        return otherPrice;
    }

    public void setOtherPrice(String otherPrice) {
        this.otherPrice = otherPrice;
    }

    public String getOtherProperty() {
        return otherProperty;
    }

    public void setOtherProperty(String otherProperty) {
        this.otherProperty = otherProperty;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getHighRisePic() {
        return highRisePic;
    }

    public void setHighRisePic(String highRisePic) {
        this.highRisePic = highRisePic;
    }

    public String getRcframePic() {
        return rcframePic;
    }

    public void setRcframePic(String rcframePic) {
        this.rcframePic = rcframePic;
    }

    public String getBrickStructurePic() {
        return brickStructurePic;
    }

    public void setBrickStructurePic(String brickStructurePic) {
        this.brickStructurePic = brickStructurePic;
    }

    public String getSingleBuildingPic() {
        return singleBuildingPic;
    }

    public void setSingleBuildingPic(String singleBuildingPic) {
        this.singleBuildingPic = singleBuildingPic;
    }

    public String getOtherStructurePic() {
        return otherStructurePic;
    }

    public void setOtherStructurePic(String otherStructurePic) {
        this.otherStructurePic = otherStructurePic;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
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
