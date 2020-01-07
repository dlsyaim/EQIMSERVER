package com.gisinfo.sand.util.geo.shape.bean;

import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.MultiPolygon;

public class TownModel {

    private String code;

    private String name;

    private double area;

    private Envelope envelope;

    private MultiPolygon geometry;

    public String getCode() {
        return code;
    }

    public TownModel setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public TownModel setName(String name) {
        this.name = name;
        return this;
    }

    public double getArea() {
        return area;
    }

    public TownModel setArea(double area) {
        this.area = area;
        return this;
    }

    public Envelope getEnvelope() {
        return envelope;
    }

    public TownModel setEnvelope(Envelope envelope) {
        this.envelope = envelope;
        return this;
    }

    public MultiPolygon getGeometry() {
        return geometry;
    }

    public TownModel setGeometry(MultiPolygon geometry) {
        this.geometry = geometry;
        return this;
    }

    @Override
    public String toString() {
        return "TownModel{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", area=" + area +
                ", envelope=" + envelope.toString() +
                ", geometry=" + geometry.getGeometryType() +
                '}';
    }
}
