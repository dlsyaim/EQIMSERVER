package com.gisinfo.sand.queryGeographyInfo.geographyData.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.persistence.Entity;
import javax.persistence.Id;

//地铁站实体类
@Entity
@TableName("RAIL_STATION")
public class MetroStation {

//    private Integer objectid_1;
    //主键
    @Id
    @TableField("OBJECTID")
    private Integer objectid;
    //地铁站名称
    @TableField("NAME")
    private String metroStationname;
    //地铁线路名称
    @TableField("LINEBELONG")
    private String linebelong;
    //
    @TableField("MAP_X")
    private Integer map_x;
    //
    @TableField("MAP_Y")
    private Integer map_y;
    //站点简称
    @TableField("SIMPLENAME")
    private String simplename;
//    //id
//    @TableField("ID")
//    private String id;
    //换乘线路名称
    @TableField("CHANGENAME")
    private String changename;
    //换乘站点标识
    @TableField("CHANGETYPE")
    private String changetype;
    //上行首班车时间
    @TableField("SXSTARTTIM")
    private String sxstarttime;
    //上行末班车时间
    @TableField("SXENDTIME")
    private String sxendtime;
    //下行首班车时间
    @TableField("XXSTARTTIM")
    private String xxstarttime;
    //下行末班车时间
    @TableField("XXENDTIME")
    private String xxendtime;
    //是否换乘及条数
    @TableField("VARIETY")
    private String variety;
//    //地铁线路名称
//    @TableField("SXTONEXTST")
//    private String sxtonextst;
//    //地铁线路名称
//    @TableField("XXTONEXTST")
//    private String xxtonextst;
//    private String 状态;
//    private String shape;


    public Integer getObjectid() {
        return objectid;
    }

    public void setObjectid(Integer objectid) {
        this.objectid = objectid;
    }

    public String getMetroStationname() {
        return metroStationname;
    }

    public void setMetroStationname(String metroStationname) {
        this.metroStationname = metroStationname;
    }

    public String getLinebelong() {
        return linebelong;
    }

    public void setLinebelong(String linebelong) {
        this.linebelong = linebelong;
    }

    public Integer getMap_x() {
        return map_x;
    }

    public void setMap_x(Integer map_x) {
        this.map_x = map_x;
    }

    public Integer getMap_y() {
        return map_y;
    }

    public void setMap_y(Integer map_y) {
        this.map_y = map_y;
    }

    public String getSimplename() {
        return simplename;
    }

    public void setSimplename(String simplename) {
        this.simplename = simplename;
    }

    public String getChangename() {
        return changename;
    }

    public void setChangename(String changename) {
        this.changename = changename;
    }

    public String getChangetype() {
        return changetype;
    }

    public void setChangetype(String changetype) {
        this.changetype = changetype;
    }

    public String getSxstarttime() {
        return sxstarttime;
    }

    public void setSxstarttime(String sxstarttime) {
        this.sxstarttime = sxstarttime;
    }

    public String getSxendtime() {
        return sxendtime;
    }

    public void setSxendtime(String sxendtime) {
        this.sxendtime = sxendtime;
    }

    public String getXxstarttime() {
        return xxstarttime;
    }

    public void setXxstarttime(String xxstarttime) {
        this.xxstarttime = xxstarttime;
    }

    public String getXxendtime() {
        return xxendtime;
    }

    public void setXxendtime(String xxendtime) {
        this.xxendtime = xxendtime;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }
}
