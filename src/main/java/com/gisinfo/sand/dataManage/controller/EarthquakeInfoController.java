package com.gisinfo.sand.dataManage.controller;
import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.dataManage.bean.EarthquakeAidDecision;
import com.gisinfo.sand.dataManage.bean.EarthquakeDetail;
import com.gisinfo.sand.dataManage.bean.EarthquakeGeo;
import com.gisinfo.sand.dataManage.bean.EarthquakeInfo;
import com.gisinfo.sand.dataManage.condition.SelectQueryCondition;
import com.gisinfo.sand.dataManage.service.EarthquakeInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EarthquakeInfoController {

    @Autowired
    private EarthquakeInfoService earthquakeInfoService;
    @EncryptDisable
    @RequestMapping(value = "/getEQdataList", method = RequestMethod.POST)
    //获取分页列表
    public Map<String,Object> getPageData(EarthquakeInfo queryConditions){
        Map<String,Object> result=null;
        if(queryConditions.getPageSize()!=null&&queryConditions.getPageNo()!=null){
            queryConditions.setBottom((queryConditions.getPageNo()-1)*queryConditions.getPageSize());
            queryConditions.setTop(queryConditions.getPageNo()*queryConditions.getPageSize());
        }
        result=new HashMap<String,Object>();
        result.put("list",this.earthquakeInfoService.findListPage(queryConditions));
        result.put("count",this.earthquakeInfoService.getCount(queryConditions));
        return result;
    }
    //获取查询条件列表
    @EncryptDisable
    @RequestMapping(value = "/getQueryList", method = RequestMethod.GET)
    public Map<String,Object> getFocalDepthList(){
        Map<String,Object> queryList=null;
        List<SelectQueryCondition> earthquakeLevelList = null;
        List<SelectQueryCondition> focalDepthList = null;
        List<SelectQueryCondition> faultNameList = null;
        List<SelectQueryCondition> dataSourceList = null;
        earthquakeLevelList =this.earthquakeInfoService.getEarthquakeLevelList();
        focalDepthList = this.earthquakeInfoService.getFocalDepthList();
        faultNameList = this.earthquakeInfoService.getFaultNameList();
        dataSourceList = this.earthquakeInfoService.getDataSourceList();
        queryList = new HashMap<String,Object>();
        queryList.put("earthquakeLevel",earthquakeLevelList);
        queryList.put("focalDepth",focalDepthList);
        queryList.put("faultName",faultNameList);
        queryList.put("dataSource",dataSourceList);
        return queryList;
    }

    //根据featId获取地震信息
    @EncryptDisable
    @RequestMapping(value = "/getInfoByFeatId", method = RequestMethod.POST)
    public EarthquakeInfo getInfoByFeatId(String featId){
            return this.earthquakeInfoService.getEarthquakeInfoById(featId);
    }

    //根据地震事件featId获取详情
    @EncryptDisable
    @RequestMapping(value = "/getDetailByEqInfoId", method = RequestMethod.POST)
    public Map<String, Object> getDetailByEqInfoIdByEqInfoId(String earthquakeInfoFeatId,Integer pageNo,Integer pageSize){
        Integer bottom = null;
        Integer top = null;
        Map<String,Object> result=null;
        List<EarthquakeDetail> detailData=null;
        Map<String,Object>  count= null;
        if(pageNo!=null&&pageSize!=null){
            bottom=(pageNo-1)*pageSize;
            top = pageNo*pageSize;
        }
        detailData=this.earthquakeInfoService.getDetailByEqInfoId(earthquakeInfoFeatId,bottom,top);
        count=this.earthquakeInfoService.getDetailCountByEqId(earthquakeInfoFeatId);
        result=new HashMap<String,Object>();
        result.put("detailData",detailData);
        result.put("count",count);
        return result;
    }

    //根据地震事件FeatId获取辅助决策信息
    @EncryptDisable
    @RequestMapping(value = "/getAidDecisionByEqId", method = RequestMethod.POST)
    Map<String, Object> getAidDecisionByEqId(String earthquakeFeatId, Integer pageNo,Integer pageSize){
        Integer bottom=null;
        Integer top = null;
        Map<String,Object> result=null;
        List<EarthquakeAidDecision> list=null;
        Map<String,Object> count=null;
        if(pageNo!=null&&pageSize!=null){
            bottom=(pageNo - 1)*pageSize;
            top=pageNo*pageSize;
        }
        result=new HashMap<String,Object>();
        list=this.earthquakeInfoService.getAidDecisionByEqId(earthquakeFeatId,bottom,top);
        count=this.earthquakeInfoService.getAidDecisionCountByEqId(earthquakeFeatId);
        result.put("list",list);
        result.put("count",count);
        return result;
    }

    //根据地震事件FeatId物资信息
    @EncryptDisable
    @RequestMapping(value = "/getGoodsMaterials", method = RequestMethod.POST)
    public EarthquakeAidDecision getGoodsMaterials(String earthquakeFeatId){
        return this.earthquakeInfoService.getAidDec(earthquakeFeatId);
    }

    //根据地震事件Id获取列表和总记录数
    @EncryptDisable
    @RequestMapping(value = "/getFocusTargetListAndCount", method = RequestMethod.POST)
    public Map<String,Object> getFocusTargetListAndCount(String earthquakeFeatId,Integer pageNo,Integer pageSize){
        Map<String,Object> result=null;
        Integer bottom=null;
        Integer top = null;
        if(pageNo!=null&&pageSize!=null){
           bottom=(pageNo - 1)*pageSize;
           top=pageNo*pageSize;
        }
        result=new HashMap<String,Object>();
        result.put("list",this.earthquakeInfoService.getFocusTargetList(earthquakeFeatId,bottom,top));
        result.put("count",this.earthquakeInfoService.getFocusTargetCount(earthquakeFeatId));
        return result;
    }

    /**
     * 新增地震信息
     * @param earthquakeInfo
     * @return
     */
    @EncryptDisable
    @RequestMapping(value = "/earthquakeInfo/addData", method = RequestMethod.POST)
    public Integer addEarthquakeInfo(EarthquakeInfo earthquakeInfo){
        if (null != earthquakeInfo
                && earthquakeInfo.getLongitude() != 0
                && earthquakeInfo.getLongitude() != 0
                && null != earthquakeInfo.getGraphics()
                && earthquakeInfo.getGraphics().length > 0) {
            return this.earthquakeInfoService.addEqData(earthquakeInfo);
        }
        return -1;
    }

    /**
     * 获得地震相关烈度圈图形
     * @param id
     * @param batch
     * @return
     */
    @EncryptDisable
    @RequestMapping(value = "/earthquakeInfo/getGeoList", method = RequestMethod.POST)
    public List<EarthquakeGeo> getGeoList(String id, int batch){
        if (StringUtils.isNotEmpty(id)) {
            return this.earthquakeInfoService.getGeoList(id, batch);
        }
        return null;
    }

}
