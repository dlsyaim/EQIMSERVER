package com.gisinfo.sand.util.geo.shape.bean;

import org.locationtech.jts.geom.MultiPolygon;

public class CommunityModel {

    private String code;

    private String name;

    private String county;

    private double area;

    private MultiPolygon geometry;

    public String getCode() {
        return code;
    }

    public CommunityModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public CommunityModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCounty() {
        return county;
    }

    public CommunityModel setCounty(String county) {
        this.county = county;
        return this;
    }

    public double getArea() {
        return area;
    }

    public CommunityModel setArea(double area) {
        this.area = area;
        return this;
    }

    public MultiPolygon getGeometry() {
        return geometry;
    }

    public CommunityModel setGeometry(MultiPolygon geometry) {
        this.geometry = geometry;
        return this;
    }

    @Override
    public String toString() {
        return "CommunityModel{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", county='" + county + '\'' +
                ", area=" + area +
                ", geometry=" + geometry.getGeometryType() +
                '}';
    }
}
