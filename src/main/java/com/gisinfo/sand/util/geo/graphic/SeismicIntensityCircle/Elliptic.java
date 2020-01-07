package com.gisinfo.sand.util.geo.graphic.SeismicIntensityCircle;

import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.SpatialReference;
import com.esri.core.geometry.Transformation2D;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.gisinfo.raster.support.EsriFactory;
import com.gisinfo.raster.support.EsriFeatureProxy;
import com.gisinfo.sa.geojson.EsriGeoJsonFactory;
import com.gisinfo.sa.geojson.GeoJsonFeature;
import com.gisinfo.sa.project.SphericalMercator;
import com.gisinfo.sand.util.geo.shape.geotool.GeoConvertUtil;
import com.gisinfo.sand.util.geo.shape.geotool.GeoFeatureUtil;
import org.opengis.feature.Feature;
import org.opengis.feature.simple.SimpleFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @author: majun
 * @create: 2020-01-02 11:59
 * @description: 生成地震椭圆面
 **/
public class Elliptic {

    /**
     * Ia = C1 + C2 * M + C4 * lg(R + Ra)
     * Ib = D1 + D2 * M + D4 * lg(R + Rb)
     *
     *
     * 公式 I = L1 + L2 * M + L4 * lg(R + dR)
     *      (I - L1 - L2 * M ) / L4 = lg(R + dR)
     *      R = pow( 10 ,   (L1 + L2 * M - I) / L3) - L4
     *
     * @param {number} I - 地震烈度
     */
    public static double getAxis(double M, double I, double L1, double L2, double L3, double L4) {
        double val = Math.pow(Math.E, (L1 + L2 * M - I) / L3) - L4;
        return val * 1000;
    }

    /**
     * 获取长轴
     *
     * Ia = 3.5751 + 1.2972 * M + (-3.0988) * lg(R + 15)
     *
     * @param {*} M
     * @param {*} I
     * @param {*} L1
     * @param {*} L2
     * @param {*} L3
     * @param {*} L4
     */
    public static double getLongAxis (double M, double I, double L1, double L2, double L3, double L4) {
        if (L1 < 0) {
            L1 = 3.5751;
        }

        if (L2 < 0) {
            L2 = 1.2972;
        }

        if (L3 < 0) {
            L3 = 1.346;
        }

        if (L4 < 0) {
            L4 = 15;
        }
        return getAxis(M, I, L1, L2, L3, L4);
    }


    /**
     *
     * Ib = 2.2339 + 1.2972 * M + (-2.7254) * lg(R + 7)
     *
     * @param {number} I - 地震烈度
     */
    public static double getShortAxis (double M, double I, double L1, double L2, double L3, double L4) {
        if (L1 < 0) {
            L1 = 2.2339;
        }

        if (L2 < 0) {
            L2 = 1.2972;
        }

        if (L3  < 0) {
            L3 = 1.184;
        }

        if (L4  < 0) {
            L4 = 7;
        }
        return getAxis(M, I, L1, L2, L3, L4);
    }

    /**
     * 获取圆半径  (M * L) / V
     * @param M
     * @param L
     * @param V
     */
    public static double getCircleRadius (double M, double L, double V) {
        if (L < 0) {
            L = 25;
        }
        if (V < 0) {
            V = 4.5;
        }
        double val = (M * L) / V;
        return val * 1000;
    }

    public static Polygon createElliptic(double centerX, double centerY, double longAxis, double shortAxis, int numOfPoints) {
        double cosVal,sinVal;
        int index;
        double[][] points = new double[numOfPoints + 1][2];
        double delta = 2 * Math.PI / numOfPoints;
        for (index = 0; index < numOfPoints; index++) {
            cosVal = Math.cos(index * delta);
            sinVal = Math.sin(index * delta);
            double[] point = {longAxis * cosVal + centerX, shortAxis * sinVal + centerY};
            points[index] = point;
        }
        points[numOfPoints] = points[0];
        return EsriFactory.createPolygon(points);
    }

    /**
     * 构建椭圆面
     *
     * @param {number} x - 中心坐标X值
     * @param {number} y - 中心坐标Y值
     * @param {number} a - 长半轴
     * @param {number} b - 短半轴
     * @param {number} angle - 偏转角度（角度）
     */
    public static Polygon getEllipticGeometry(double x, double y, double a, double b, double angle) {
        if (a <= 0 || b <= 0) {
            return null;
        }
        Polygon geo = createElliptic(x, y, a, b, 100);
        if (a == b || 0 == angle) {
            return geo;
        }
        Transformation2D transformation = new Transformation2D();
        transformation.setRotate(angle);
        geo.applyTransformation(transformation);
        return geo;
    }

    public static Polygon getCircleGeometry(double x, double y, double r) {
        if (r <= 0) {
            return null;
        }
        return getEllipticGeometry(x, y, r, r, 0);
    }

    /**
     * 获取烈度的环
     *
     * @param {number} M - 地震震级
     * @param {number} sI - 起始烈度
     * @param {number||null} eI - 结束烈度（构造内部的洞，如不存在则为实心）
     * @param {number} x - 中心点X坐标
     * @param {number} y - 中心点Y坐标
     * @param {number} angle
     * @param {number} spatialReference
     */
    public static EsriFeatureProxy getIntensityCircle(double M, int sI, int eI, double x, double y, double angle, SpatialReference spatialReference) {
        double lowerLangAxis = getLongAxis(M, sI, -1, -1, -1, -1);
        double lowerShortAxis = getShortAxis(M, sI, -1, -1, -1, -1);
        if (sI <= 5) {
            lowerShortAxis = lowerLangAxis;
        }
        double upperLangAxis = 0, upperShortAxis = 0;
        Polygon outRing = getEllipticGeometry(x, y, lowerLangAxis, lowerShortAxis, angle);
        Polygon holeRing = null;
        if (eI > 0) {
            upperLangAxis = getLongAxis(M, eI, -1, -1, -1, -1);
            upperShortAxis = getShortAxis(M, eI, -1, -1, -1, -1);
            if (sI < 5) {
                upperShortAxis = upperLangAxis;
            }
            holeRing = getEllipticGeometry(x, y, upperLangAxis, upperShortAxis, angle);
        }
        if (null == outRing) {
            return null;
        } else if (null == holeRing) {
            Map<String, Object> attributes = new HashMap<>();
            setIntensityValue(attributes, sI, eI);
            setAxisValue(attributes, lowerLangAxis, lowerShortAxis, upperLangAxis, upperShortAxis);
            setCenterPointValue(attributes, x, y, angle);
            return EsriFactory.createFeature(outRing, spatialReference, attributes);
        } else {
            Map<String, Object> attributes = new HashMap<>();
            setIntensityValue(attributes, sI, eI);
            setAxisValue(attributes, lowerLangAxis, lowerShortAxis, upperLangAxis, upperShortAxis);
            setCenterPointValue(attributes, x, y, angle);
            //翻转内圈rings
//            holeRing.reverseAllPaths();
            holeRing = createNewReversePath(holeRing);
            outRing.add(holeRing, false);
            return EsriFactory.createFeature(outRing, spatialReference, attributes);
        }
    }

    /**
     * 新增polygon，翻转坐标串
     * @param polygon
     * @return
     */
    public static Polygon createNewReversePath(Polygon polygon) {
        int index = 0;
        int size = polygon.getPathSize(index);
        double[][] points = new double[size][2];
        int j = 0;
        for (int i = size - 1; i >= 0; i--) {
            double[] point = {polygon.getPoint(i).getX(), polygon.getPoint(i).getY()};
            points[j] = point;
            j++;
        }
        return EsriFactory.createPolygon(points);
    }

    /**
     * 获取烈度的环
     *
     * @param {number} M - 地震震级
     * @param {number[]} I - 烈度
     * @param {number} x - 中心点X坐标
     * @param {number} y - 中心点Y坐标
     * @param {number} angle
     */
    public static List<EsriFeatureProxy> getIntensityCircleArr(double M, int[] I, double x, double y, double angle, SpatialReference spatialReference) {
        if (null != I) {
            List<EsriFeatureProxy> list = new ArrayList<>(I.length + 1);
            for (int i = 0; i < I.length; i++) {
                if (i == I.length - 1) {
                    EsriFeatureProxy feature = getIntensityCircle(M, I[i], -1, x, y, angle, spatialReference);
                    if (null != feature) {
                        list.add(feature);
                    }
                } else {
                    EsriFeatureProxy feature = getIntensityCircle(M, I[i], I[i + 1], x, y, angle, spatialReference);
                    if (null != feature) {
                        list.add(feature);
                    }
                }
            }
            return list;
        }
        return null;
    }

    /**
     * 烈度圈范围
     * @param attributes
     * @param lowerValue
     * @param upperValue
     * @return
     */
    private static Map<String, Object> setIntensityValue(Map<String, Object> attributes, int lowerValue, int upperValue) {
        attributes.put("lowerValue", lowerValue);
        attributes.put("upperValue", upperValue);
        return attributes;
    }

    /**
     * 烈度圈椭圆面长短轴
     * @param attributes
     * @param lowerLangAxis
     * @param lowerShortAxis
     * @param upperLangAxis
     * @param upperShortAxis
     * @return
     */
    private static Map<String, Object> setAxisValue(Map<String, Object> attributes, double lowerLangAxis, double lowerShortAxis, double upperLangAxis, double upperShortAxis) {
        attributes.put("lowerLangAxis", lowerLangAxis);
        attributes.put("lowerShortAxis", lowerShortAxis);
        attributes.put("upperLangAxis", upperLangAxis);
        attributes.put("upperShortAxis", upperShortAxis);
        return attributes;
    }

    /**
     * 烈度圈中心点及偏转角
     * @param attributes
     * @param x
     * @param y
     * @param angle
     * @return
     */
    private static Map<String, Object> setCenterPointValue(Map<String, Object> attributes, double x, double y, double angle) {
        attributes.put("x", x);
        attributes.put("y", y);
        attributes.put("angle", angle);
        return attributes;
    }

    public static void main(String[] args) {
        int[] I = {3, 4, 5, 6, 7, 8, 9, 10};
        double[] xy = SphericalMercator.project(121.76, 31.1);
        SpatialReference mercator = EsriFactory.createWebMercator();
        List<EsriFeatureProxy> list = Elliptic.getIntensityCircleArr(5.8, I, xy[0], xy[1], 0,  mercator);
        System.out.println(list);
        for (EsriFeatureProxy esriFeatureProxy : list) {
            Feature feature = GeoConvertUtil.esriFeatureToFeatureIntensityCircle(esriFeatureProxy.getProxyed());
            System.out.println(GeoConvertUtil.featureToGeoJson((SimpleFeature) feature));
        }
    }

}
