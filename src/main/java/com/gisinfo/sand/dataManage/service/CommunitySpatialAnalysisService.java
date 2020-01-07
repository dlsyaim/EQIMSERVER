package com.gisinfo.sand.dataManage.service;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.dataManage.bean.AnalysisVillage;
import com.gisinfo.sand.dataManage.bean.EarthquakeGeo;
import com.gisinfo.sand.dataManage.dao.AnalysisVillageMapper;
import com.gisinfo.sand.util.SettingUtil;
import com.gisinfo.sand.util.geo.shape.bean.CommunityModel;
import com.gisinfo.sand.util.geo.shape.geotool.GeoConvertUtil;
import com.gisinfo.sand.util.geo.shape.geotool.GeoFeatureUtil;
import com.gisinfo.sand.util.geo.shape.geotool.GeoShapeReaderUtil;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;
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
public class CommunitySpatialAnalysisService extends ServiceImpl<AnalysisVillageMapper, AnalysisVillage>{

    /**
     * 社区空间分析
     * @param geoList
     * @return
     */
    public boolean analysis(List<EarthquakeGeo> geoList) {
        String path = SettingUtil.getShapeBasePath() + SettingUtil.getTownShape();
        ArrayList<CommunityModel> communityModels = GeoShapeReaderUtil.getCommunityModel(path);
        if (null != communityModels && !communityModels.isEmpty()) {
            for (EarthquakeGeo earthquakeGeo : geoList) {
                if (null != earthquakeGeo) {
                    Feature f = GeoConvertUtil.geoJsonToFeature(earthquakeGeo.getGeo());
                    if (null != f) {
                        Polygon polygon = GeoFeatureUtil.getPolygon(f);
                        List<AnalysisVillage> list = new ArrayList<>(12400);
                        for (CommunityModel model : communityModels) {
                            Geometry g = polygon.intersection(model.getGeometry());
                            if (!g.isEmpty()) {
                                list.add(createAnalysisVillage(earthquakeGeo, model, g));
                            }
                        }
                        if (!list.isEmpty()) {
                            return saveBatch(list);
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * 创建社区分析结果bean
     * @param earthquakeGeo
     * @param townModel
     * @param g
     * @return
     */
    private AnalysisVillage createAnalysisVillage(EarthquakeGeo earthquakeGeo, CommunityModel townModel, Geometry g) {
        AnalysisVillage bean = new AnalysisVillage();
        bean.setFeatid(IdUtil.simpleUUID());
        bean.setEarthquakeFeatid(earthquakeGeo.getFeatid());
        bean.setBatchNumber(earthquakeGeo.getBatchNumber());
        bean.setArea(NumberUtil.round(townModel.getArea(), 1).doubleValue());
        bean.setIntensity(earthquakeGeo.getIntensity());
        bean.setAffectedArea(NumberUtil.round(g.getArea(), 1).doubleValue());
        bean.setCode(townModel.getCode());
        bean.setVillageName(townModel.getName());
        bean.setOffsetType(earthquakeGeo.getOffsetType());
        return bean;
    }
}
