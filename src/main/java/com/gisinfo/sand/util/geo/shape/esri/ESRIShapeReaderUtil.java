//package com.gisinfo.sand.util.geo.shape.esri;
//
//import com.esri.core.geometry.Geometry;
//import com.esri.core.geometry.Polygon;
//import org.apache.commons.lang3.StringUtils;
//
//import java.io.File;
//import java.io.IOException;
//
//public final class ESRIShapeReaderUtil {
//
//    /**
//     * esri读取shape文件
//     * @param filePath
//     */
//    public static void getTownModelByESRI(String filePath) {
//        if (StringUtils.isNotEmpty(filePath)) {
//            File file = new File(filePath);
//            if (!file.isDirectory()) {
//                if (file.toString().endsWith(".shp")) {
//                    try {
//                        ShapefileGeometryCursor geometryCursor = new ShapefileGeometryCursor(file);
//                        Geometry geom;
//                        int i = 0;
//                        while ((geom = geometryCursor.next()) != null) {
//                            Polygon polygon = (Polygon) geom;
//                            i++;
//                        }
//                        Geometry.Type geometryType = geometryCursor.getGeometryType();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//    }
//
//
//}
