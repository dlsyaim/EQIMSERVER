package com.gisinfo.sand.dataManage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gisinfo.sand.dataManage.bean.EarthquakeGeo;
import com.gisinfo.sand.dataManage.bean.EarthquakeInfo;
import com.gisinfo.sand.dataManage.dao.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @author: majun
 * @create: 2019-12-25 17:25
 * @description: 空间分析service
 **/

@Service
public class SpatialAnalysisService {

    public static final String TYPE_TOWN = "town";
    public static final String TYPE_GRID = "grid";
    public static final String TYPE_COMMUNITY = "community";

    @Autowired(required = false)
    private EarthquakeInfoMapper earthquakeInfoMapper;

    @Autowired(required = false)
    private EarthquakeGeoMapper earthquakeGeoMapper;

    @Autowired(required = false)
    private AnalysisVillageMapper analysisVillageMapper;

    @Autowired
    private TownSpatialAnalysisService townService;

    @Autowired
    private CommunitySpatialAnalysisService communityService;



    /**
     * 获取地震信息
     * @param id
     * @param batch
     * @return
     */
    private EarthquakeInfo getEarthquakeInfo(String id, int batch) {
        if (StringUtils.isNotEmpty(id)) {
            QueryWrapper<EarthquakeInfo> queryWrapper = new QueryWrapper<EarthquakeInfo>()
                    .eq("FEATID", id)
                    .eq("BATCH_NUMBER", batch);
            List<EarthquakeInfo> list = earthquakeInfoMapper.selectList(queryWrapper);
            if (null != list && !list.isEmpty()) {
                return list.get(0);
            }
        }
        return null;
    }

    /**
     * 空间分析计算外部调用入口
     * @param id
     * @param batch
     * @return
     */
    public boolean start(String id, int batch) {
        EarthquakeInfo earthquakeInfo = getEarthquakeInfo(id, batch);
        if (null != earthquakeInfo) {
            List<EarthquakeGeo> geoList = earthquakeGeoMapper.selectGeo(id, batch);
            if (null != geoList && !geoList.isEmpty()) {
                return spatialAnalysis(earthquakeInfo, geoList);
            }
        }
        return false;
    }

    /**
     * 空间分析
     * @param earthquakeInfo
     * @param geoList
     * @return
     */
    private boolean spatialAnalysis(EarthquakeInfo earthquakeInfo, List<EarthquakeGeo> geoList) {
        if (TYPE_TOWN.equals(earthquakeInfo.getAnalysisData())) {
            return townService.analysis(geoList);
        } else if (TYPE_GRID.equals(earthquakeInfo.getAnalysisData())) {
            return communityService.analysis(geoList);
        } else if (TYPE_COMMUNITY.equals(earthquakeInfo.getAnalysisData())) {

        }
        return false;
    }

}
