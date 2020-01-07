package com.gisinfo.sand.dataManage.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.dataManage.bean.*;
import com.gisinfo.sand.dataManage.dao.AnalysisTownMapper;
import com.gisinfo.sand.util.SettingUtil;
import com.gisinfo.sand.util.geo.shape.bean.TownModel;
import com.gisinfo.sand.util.geo.shape.geotool.GeoConvertUtil;
import com.gisinfo.sand.util.geo.shape.geotool.GeoFeatureUtil;
import com.gisinfo.sand.util.geo.shape.geotool.GeoShapeReaderUtil;
import org.locationtech.jts.geom.Geometry;
import org.opengis.feature.Feature;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @version 1.0
 * @author: majun
 * @create: 2019-12-25 17:25
 * @description: 街镇空间分析service
 **/
@Service
public class TownSpatialAnalysisService extends ServiceImpl<AnalysisTownMapper, AnalysisTown>{

    /**
     * 街镇空间分析
     * @param geoList
     * @return
     */
    public boolean analysis(List<EarthquakeGeo> geoList) {
        String path = SettingUtil.getShapeBasePath() + SettingUtil.getTownShape();
        ArrayList<TownModel> townModels = GeoShapeReaderUtil.getTownModel(path);
        if (null != townModels && !townModels.isEmpty()) {
            for (EarthquakeGeo earthquakeGeo : geoList) {
                if (null != earthquakeGeo) {
                    Feature f = GeoConvertUtil.geoJsonToFeature(earthquakeGeo.getGeo());
                    if (null != f) {
                        Geometry geometry = GeoFeatureUtil.getGeometry(f);
                        if (!geometry.isValid()) {
                            geometry = geometry.buffer(0);
                        }
                        List<AnalysisTown> list = new ArrayList<>(270);
                        for (TownModel townModel : townModels) {
                            Geometry g = geometry.intersection(townModel.getGeometry());
                            if (!g.isEmpty()) {
                                list.add(createAnalysisTown(earthquakeGeo, townModel, g));
                            }
                        }
                        if (!list.isEmpty()) {
                            saveBatch(list);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 创建街镇分析结果bean
     * @param earthquakeGeo
     * @param townModel
     * @param g
     * @return
     */
    private AnalysisTown createAnalysisTown(EarthquakeGeo earthquakeGeo, TownModel townModel, Geometry g) {
        AnalysisTown bean = new AnalysisTown();
        bean.setFeatid(IdUtil.simpleUUID());
        bean.setEarthquakeFeatid(earthquakeGeo.getEarthquakeFeatid());
        bean.setBatchNumber(earthquakeGeo.getBatchNumber());
        bean.setArea(NumberUtil.round(townModel.getArea(), 1).doubleValue());
        bean.setIntensity(earthquakeGeo.getIntensity());
        bean.setAffectedArea(NumberUtil.round(g.getArea(), 1).doubleValue());
        bean.setCode(townModel.getCode());
        bean.setTownName(townModel.getName());
        bean.setOffsetType(earthquakeGeo.getOffsetType());
        return bean;
    }
}
