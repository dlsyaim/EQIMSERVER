package com.gisinfo.sand.util.geo.shape.geotool;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.gisinfo.sand.util.geo.shape.bean.CommunityModel;
import com.gisinfo.sand.util.geo.shape.bean.TownModel;
import org.geotools.data.FeatureSource;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.feature.FeatureCollection;
import org.geotools.feature.FeatureIterator;
import org.locationtech.jts.geom.Envelope;
import org.locationtech.jts.geom.MultiPolygon;
import org.opengis.feature.Property;
import org.opengis.feature.simple.SimpleFeature;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author majun
 * @date 2019-12-12
 * @version 1.0
 * 使用GEOTOOL读取shape文件
 */
public final class GeoShapeReaderUtil {

    /**
     * 获取街镇shape数据
     * @param filePath
     * @return
     */
    public static ArrayList<TownModel> getTownModel(String filePath) {
        ArrayList<TownModel> modelList = new ArrayList<>();
        File file = new File(filePath);
        if (!file.isDirectory()) {
            if (file.toString().endsWith(".shp")) {
                try {
                    modelList = getTownShapeFile(file);
                    return modelList;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("选择的文件后缀名不是.shp");
            }
        }
        return modelList;
    }

    /**
     * 获取社区shape数据
     * @param filePath
     * @return
     */
    public static ArrayList<CommunityModel> getCommunityModel(String filePath) {
        ArrayList<CommunityModel> modelList = new ArrayList<>();
        File file = new File(filePath);
        if (!file.isDirectory()) {
            if (file.toString().endsWith(".shp")) {
                try {
                    modelList = getCommunityShapeFile(file);
                    return modelList;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("选择的文件后缀名不是.shp");
            }
        }
        return modelList;
    }

    /**
     * 将shape文件数据转换为街镇
     * @param file
     * @return
     * @throws Exception
     */
    private static ArrayList<TownModel> getTownShapeFile(File file) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("url", file.toURI().toURL());
        ArrayList<TownModel> models = new ArrayList<>();
        ShapefileDataStore dataStore = buildDataStore(file);
        String typeName = dataStore.getTypeNames()[0];
        FeatureSource<SimpleFeatureType, SimpleFeature> source = dataStore.getFeatureSource(typeName);
        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures();
        FeatureIterator<SimpleFeature> features = collection.features();
        while (features.hasNext()) {
            SimpleFeature feature = features.next();
            TownModel model = new TownModel();
            Iterator<? extends Property> iterator = feature.getValue().iterator();
            while (iterator.hasNext()) {
                Property property = iterator.next();
                //property数据与实体类对应
                if (property.getName().toString().equalsIgnoreCase("the_geom")) {
//                    System.out.println(property.getValue().getClass().getName());
                    model.setGeometry((MultiPolygon) property.getValue());
                } else if (property.getName().toString().equalsIgnoreCase("extent")) {
                    String envelope = property.getValue().toString();
                    if (StringUtils.isNotEmpty(envelope)) {
                        JSONObject json = JSONObject.parseObject(envelope);
                        if (null != json && !json.isEmpty()) {
                            model.setEnvelope(new Envelope(
                                    json.getDoubleValue("xmin"),
                                    json.getDoubleValue("xmax"),
                                    json.getDoubleValue("ymin"),
                                    json.getDoubleValue("ymax")
                            ));
                        }
                    }
                } else if (property.getName().toString().equalsIgnoreCase("name")) {
                    model.setName(property.getValue().toString());
                } else if (property.getName().toString().equalsIgnoreCase("code")) {
                    model.setCode(property.getValue().toString());
                } else if (property.getName().toString().equalsIgnoreCase("shape_area")) {
                    model.setArea(Convert.toDouble(property.getValue()));
                }
            }
            models.add(model);
        }
        dataStore.dispose();
        return models;
    }

    /**
     * 将shape文件数据转换为街镇
     * @param file
     * @return
     * @throws Exception
     */
    private static ArrayList<CommunityModel> getCommunityShapeFile(File file) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("url", file.toURI().toURL());
        ArrayList<CommunityModel> models = new ArrayList<>();
        ShapefileDataStore dataStore = buildDataStore(file);
        String typeName = dataStore.getTypeNames()[0];
        FeatureSource<SimpleFeatureType, SimpleFeature> source = dataStore.getFeatureSource(typeName);
        FeatureCollection<SimpleFeatureType, SimpleFeature> collection = source.getFeatures();
        FeatureIterator<SimpleFeature> features = collection.features();
        while (features.hasNext()) {
            SimpleFeature feature = features.next();
            CommunityModel model = new CommunityModel();
            Iterator<? extends Property> iterator = feature.getValue().iterator();
            while (iterator.hasNext()) {
                Property property = iterator.next();
                //property数据与实体类对应
                if (property.getName().toString().equalsIgnoreCase("the_geom")) {
//                    System.out.println(property.getValue().getClass().getName());
                    model.setGeometry((MultiPolygon) property.getValue());
                } else if (property.getName().toString().equalsIgnoreCase("name")) {
                    model.setName(property.getValue().toString());
                } else if (property.getName().toString().equalsIgnoreCase("code")) {
                    model.setCode(property.getValue().toString());
                } else if (property.getName().toString().equalsIgnoreCase("total_area")) {
                    model.setArea(Convert.toDouble(property.getValue()));
                } else if (property.getName().toString().equalsIgnoreCase("county")) {
                    model.setCounty(property.getValue().toString());
                }
            }
            models.add(model);
        }
        dataStore.dispose();
        return models;
    }

    /**
     * 设置shape文件流为UTF-8格式
     * @param file
     * @return
     */
    private static ShapefileDataStore buildDataStore(File file) {
        ShapefileDataStoreFactory factory = new ShapefileDataStoreFactory();
        try {
            ShapefileDataStore dataStore = (ShapefileDataStore) factory
                    .createDataStore(file.toURI().toURL());
            if (dataStore != null) {
                dataStore.setCharset(Charset.forName("UTF-8"));
            }
            return dataStore;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String filePath = "D:\\temp\\gis\\jiezhenmkt\\shequmkt2.shp";
//        filePath = "D:\\temp\\gis\\街镇区划2000exp.shp";
//        ArrayList<TownModel> list = getTownModel(filePath);
        ArrayList<CommunityModel> list = getCommunityModel(filePath);
//        for (TownModel townModel : list) {
//            if (!townModel.getGeometry().isValid()) {
//                System.out.println(townModel);
//            }
//        }
        for (CommunityModel model : list) {
            if (!model.getGeometry().isValid()) {
                System.out.println(model);
            }
        }
//        System.out.println(list);
    }

}
