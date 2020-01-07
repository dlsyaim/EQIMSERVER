package com.gisinfo.sand.util.geo.shape.geotool;

import com.gisinfo.sand.util.ConstantsUtil;
import org.geotools.feature.simple.SimpleFeatureImpl;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.MultiPolygon;
import org.locationtech.jts.geom.Polygon;
import org.opengis.feature.Feature;

/**
 * geo Feature 操作工具类
 */
public final class GeoFeatureUtil {

    public static final String GEO_MULTIPOLYGON = "MultiPolygon";
    public static final String GEO_POLYGON = "Polygon";

    /**
     * 获得geometry
     * @param feature
     * @return
     */
    public static Geometry getGeometry(Feature feature) {
        if (null != feature) {
            Object object = ((SimpleFeatureImpl) feature).getDefaultGeometry();
            if (null != object) {
                return (Geometry) object;
            }
        }
        return null;
    }

    /**
     * 获得polygon geometry
     * @param feature
     * @return
     */
    public static Polygon getPolygon(Feature feature) {
        if (null != feature) {
            Object object = ((SimpleFeatureImpl) feature).getDefaultGeometry();
            if (null != object) {
                if (object.getClass().getName().equals("org.locationtech.jts.geom.Polygon")) {
                    return (Polygon) object;
                }
            }
        }
        return null;
    }

    /**
     * 获得MultiPolygon geometry
     * @param feature
     * @return
     */
    public static MultiPolygon getMultiPolygon(Feature feature) {
        if (null != feature) {
            Object object = ((SimpleFeatureImpl) feature).getDefaultGeometry();
            if (null != object) {
                if (object.getClass().getName().equals("org.locationtech.jts.geom.MultiPolygon")) {
                    return (MultiPolygon) object;
                }
            }
        }
        return null;
    }

    /**
     * 获得feature里所有图形面积
     * @param feature
     * @return
     */
    public static double getArea(Feature feature) {
        if (null != feature) {
            String type = getGeometryType(feature);
            switch (type) {
                case GEO_MULTIPOLYGON:
                    MultiPolygon multiPolygon = getMultiPolygon(feature);
                    if (null != multiPolygon) {
                        return multiPolygon.getArea();
                    }
                case GEO_POLYGON:
                    Polygon polygon = getPolygon(feature);
                    if (null != polygon) {
                        return polygon.getArea();
                    }
            }
        }
        return 0;
    }

    /**
     * 获得geometry类型
     * @param feature
     * @return
     */
    public static String getGeometryType(Feature feature) {
        if (null != feature) {
            Object object = ((SimpleFeatureImpl) feature).getDefaultGeometry();
            if (null != object) {
                if (object.getClass().getName().equals("org.locationtech.jts.geom.MultiPolygon")) {
                    return GEO_MULTIPOLYGON;
                } else if (object.getClass().getName().equals("org.locationtech.jts.geom.Polygon")) {
                    return GEO_POLYGON;
                }
            }
        }
        return ConstantsUtil.EMPTY_VALUE;
    }

}
