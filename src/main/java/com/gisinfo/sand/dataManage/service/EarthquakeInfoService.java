package com.gisinfo.sand.dataManage.service;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.esri.core.geometry.SpatialReference;
import com.gisinfo.raster.support.EsriFactory;
import com.gisinfo.raster.support.EsriFeatureProxy;
import com.gisinfo.sa.project.SphericalMercator;
import com.gisinfo.sand.dataManage.bean.*;
import com.gisinfo.sand.dataManage.condition.SelectQueryCondition;
import com.gisinfo.sand.dataManage.dao.EarthquakeGeoMapper;
import com.gisinfo.sand.dataManage.dao.EarthquakeInfoMapper;
import com.gisinfo.sand.schedule.service.PlanService;
import com.gisinfo.sand.util.ConstantsUtil;
import com.gisinfo.sand.util.EarthquakeUtil;
import com.gisinfo.sand.util.geo.graphic.SeismicIntensityCircle.Elliptic;
import com.gisinfo.sand.util.geo.shape.geotool.GeoConvertUtil;
import com.gisinfo.sand.util.geo.shape.geotool.GeoFeatureUtil;
import org.apache.commons.lang3.StringUtils;
import org.opengis.feature.Feature;
import org.opengis.feature.simple.SimpleFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service("fghsdf")
public class EarthquakeInfoService extends ServiceImpl<EarthquakeInfoMapper,EarthquakeInfo>{

    @Autowired(required = false)
    private EarthquakeInfoMapper earthquakeInfoMapper;

    @Autowired(required = false)
    private EarthquakeGeoMapper earthquakeGeoMapper;

    @Autowired
    private PlanService planService;

    public List<EarthquakeInfo> findListPage(EarthquakeInfo queryConditions) {
        List<EarthquakeInfo> list=earthquakeInfoMapper.queryPageList(queryConditions);

        return list;
    }

    public List<SelectQueryCondition> getEarthquakeLevelList(){
        return this.earthquakeInfoMapper.getEarthquakeLevelList();
    }


    public Map<String,Object> getCount(EarthquakeInfo queryConditions){
        return this.earthquakeInfoMapper.getTotalCount(queryConditions);
    }

    public List<SelectQueryCondition> getFocalDepthList(){
        return this.earthquakeInfoMapper.getFocalDepthList();
    }

    public List<SelectQueryCondition> getFaultNameList(){
        return this.earthquakeInfoMapper.getFaultNameList();
    }

    public List<SelectQueryCondition> getDataSourceList(){
        return this.earthquakeInfoMapper.getDataSourceList();
    }

    public EarthquakeInfo getEarthquakeInfoById(String featId){
        return this.earthquakeInfoMapper.getEarthquakeInfoById(featId);
    }

    public List<EarthquakeDetail> getDetailByEqInfoId(String earthquakeFeatId, Integer bottom, Integer top){
        return this.earthquakeInfoMapper.getDetailByEqInfoId(earthquakeFeatId,bottom,top);
    }

    public Map<String,Object> getDetailCountByEqId(String earthquakeFeatId){
        return this.earthquakeInfoMapper.selectDetailCountByEqId(earthquakeFeatId);
    }

    public Map<String,Object> getAidDecisionCountByEqId(String earthquakeFeatId){
        return this.earthquakeInfoMapper.getAidDecisionCountByEqId(earthquakeFeatId);
    }

    public List<EarthquakeAidDecision> getAidDecisionByEqId(String earthquakeFeatId, Integer bottom, Integer top){
        return this.earthquakeInfoMapper.getAidDecisionByEqId(earthquakeFeatId,bottom,top);
    }

    public EarthquakeAidDecision getAidDec(String earthquakeFeatId){
        return this.earthquakeInfoMapper.getAidDetail(earthquakeFeatId);
    }

    public List<FocusTarget> getFocusTargetList(String earthquakeFeatId,Integer bottom,Integer top){
        return this.earthquakeInfoMapper.getFocusTargetByEqId(earthquakeFeatId,bottom,top);
    }

    public Map<String,Object> getFocusTargetCount(String earthquakeFeatId){
        return this.earthquakeInfoMapper.getFocusTargetCountByEqId(earthquakeFeatId);
    }

    /**
     * 新增地震信息
     * @param earthquakeInfo
     * @return
     */
    @Transactional
    public Integer addEqData(EarthquakeInfo earthquakeInfo){
        earthquakeInfo.setFeatid(IdUtil.simpleUUID());
        earthquakeInfo.setBatchNumber(1);
        earthquakeInfo.setEarthquakeName(EarthquakeUtil.createEarthquakeName(earthquakeInfo));
        String[] graphics = earthquakeInfo.getGraphics();
        for (int i = 0; i < graphics.length; i++) {
            Feature feature = GeoConvertUtil.geoJsonToFeature(graphics[i]);
            addEarthquakeGeo(feature, earthquakeInfo, graphics[i]);
        }
        if (null == earthquakeInfo.getFocalDepth()) {
            earthquakeInfo.setFocalDepth(0.0);
        }
        int success = earthquakeInfoMapper.addEqInfo(earthquakeInfo);
        if (success > 0) {
//            planService.createTask(earthquakeInfo.getFeatid(), earthquakeInfo.getBatchNumber());
            planService.fastOneStep(earthquakeInfo.getFeatid(), earthquakeInfo.getBatchNumber());
        }
        return success;
    }

    /**
     * 新增网络自动抓取数据
     * @param earthquakeInfo
     * @return
     */
    @Transactional
    public Integer addWebAutoGraspData(EarthquakeInfo earthquakeInfo){
        if (null == earthquakeInfo) {
            Date date = DateUtil.parseDate("2020-01-06 09:50:00");
            earthquakeInfo = new EarthquakeInfo();
            earthquakeInfo.setFeatid(IdUtil.simpleUUID());
            earthquakeInfo.setBatchNumber(1);
            earthquakeInfo.setEarthquakeName("2020年1月6日上海市徐汇区5.7级地震");
            earthquakeInfo.setEarthquakeLocation("上海市徐汇区天平路街道");
            earthquakeInfo.setLongitude(121.44);
            earthquakeInfo.setLatitude(31.2);
            earthquakeInfo.setEarthquakeLevel(5.7);
            earthquakeInfo.setFocalDepth(10.0);
            earthquakeInfo.setAnalysisData("town");
            earthquakeInfo.setModelId("1");
            earthquakeInfo.setProvince("上海市");
            earthquakeInfo.setCity("上海市");
            earthquakeInfo.setCounty("徐汇区");
            earthquakeInfo.setTown("天平路街道");
            earthquakeInfo.setEarthquakeTime(date);
            earthquakeInfo.setDataSource("地震速报");
        }
        if (StringUtils.isEmpty(earthquakeInfo.getFeatid())) {
            earthquakeInfo.setFeatid(IdUtil.simpleUUID());
            earthquakeInfo.setBatchNumber(1);
            earthquakeInfo.setEarthquakeName(EarthquakeUtil.createEarthquakeName(earthquakeInfo));
        }
        if (null == earthquakeInfo.getFocalDepth()) {
            earthquakeInfo.setFocalDepth(0.0);
        }
        List<EsriFeatureProxy> list = getEsriFeatures(earthquakeInfo);
        if (null != list) {
            for (EsriFeatureProxy esriFeatureProxy : list) {
                Feature feature = GeoConvertUtil.esriFeatureToFeatureIntensityCircle(esriFeatureProxy.getProxyed());
                addEarthquakeGeo(feature, earthquakeInfo, GeoConvertUtil.featureToGeoJson((SimpleFeature) feature));
            }
            int success = earthquakeInfoMapper.addEqInfo(earthquakeInfo);
            if (success > 0) {
//            planService.createTask(earthquakeInfo.getFeatid(), earthquakeInfo.getBatchNumber());
                planService.fastOneStep(earthquakeInfo.getFeatid(), earthquakeInfo.getBatchNumber());
            }
            return success;
        }
        return -1;
    }

    /**
     * 添加地震烈度圈图形信息
     * @param feature
     * @param earthquakeInfo
     * @param geo
     * @return
     */
    private Integer addEarthquakeGeo(Feature feature, EarthquakeInfo earthquakeInfo, String geo) {
        if (null != feature && null != earthquakeInfo && StringUtils.isNotEmpty(geo)) {
            int intensity = Convert.toInt(feature.getProperty("lowerValue").getValue());
            EarthquakeGeo earthquakeGeo = new EarthquakeGeo();
            earthquakeGeo.setFeatid(IdUtil.simpleUUID());
            earthquakeGeo.setEarthquakeFeatid(earthquakeInfo.getFeatid());
            earthquakeGeo.setShapeType(EarthquakeUtil.getIntensityGeometryType(intensity, null));
            earthquakeGeo.setArea(GeoFeatureUtil.getArea(feature));
            earthquakeGeo.setBatchNumber(earthquakeInfo.getBatchNumber());
            earthquakeGeo.setGeo(geo);
            earthquakeGeo.setIntensity(intensity);
            earthquakeGeo.setOffsetType(EarthquakeUtil.OFFSET_TYPE_M);
            return earthquakeGeoMapper.insertData(earthquakeGeo);
        }
        return -1;
    }

    /**
     * 获取esri features对象
     * @param earthquakeInfo
     * @return
     */
    private List<EsriFeatureProxy> getEsriFeatures(EarthquakeInfo earthquakeInfo) {
        int[] I = {3, 4, 5, 6, 7, 8, 9, 10};
        double[] xy = SphericalMercator.project(earthquakeInfo.getLongitude(), earthquakeInfo.getLatitude());
        SpatialReference mercator = EsriFactory.createWebMercator();
        List<EsriFeatureProxy> list = Elliptic.getIntensityCircleArr(earthquakeInfo.getEarthquakeLevel(), I, xy[0], xy[1], 0,  mercator);
        if (null == list || list.isEmpty()) {
            return null;
        }
        return list;
    }

    /**
     * 获得地震相关烈度圈图形
     * @param id
     * @param batch
     * @return
     */
    @Transactional
    public List<EarthquakeGeo> getGeoList(String id, int batch){
        if (StringUtils.isNotEmpty(id)) {
            return earthquakeGeoMapper.selectGeo(id, batch);
        }
        return null;
    }


}
