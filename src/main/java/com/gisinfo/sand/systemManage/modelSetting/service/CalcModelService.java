package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.systemManage.modelSetting.bean.*;
import com.gisinfo.sand.systemManage.modelSetting.dao.*;
import com.gisinfo.sand.util.NumberUtil;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EmbeddedId;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CalcModelService extends ServiceImpl<CalcModelMapper,ConstructionPHB> {

    @Autowired(required = false)
    private CalcModelMapper calcModelMapper;

    @Autowired(required = false)
    private TModelSettingMapper tModelSettingMapper;

    @Autowired(required = false)
    private DeathPersonModelMapper deathPersonModelMapper;

    @Autowired(required = false)
    private DeathPersonModelService deathPersonModelService;

    @Autowired(required = false)
    private InjuredMemberMapper injuredMemberMapper;

    @Autowired(required = false)
    private TEarthquakeDetailMapper tEarthquakeDetailMapper;

    @Autowired(required = false)
    private HomelessMemberMapper homelessMemberMapper;

    @Autowired(required = false)
    private EconomicLossesMapper economicLossesMapper;

    @Autowired(required = false)
    private ConstructionMatrixMapper constructionMatrixMapper;

    //救援队伍模型Mapper
    @Autowired(required = false)
    private TModelRescueMapper tModelRescueMapper;

    //救援队伍模型service
    @Autowired(required = false)
    private TModelRescueService tModelRescueService;

    //救援力量模型Mapper
    @Autowired(required = false)
    private RescueForceMapper rescueForceMapper;

    //救援力量模型service
    @Autowired(required = false)
    private RescueForceService rescueForceService;

    //救援物资模型service
    @Autowired(required = false)
    private TModelReliefGoodsService tModelReliefGoodsService;

    @Autowired(required = false)
    private TModelEconomicLossesMapper tModelEconomicLossesMapper;

    //获取建筑模型当前版本数
    public String getBuildingVersion(){
        return this.calcModelMapper.getCurrentBuildingModelVersion().get("modelVersion").toString();
    }

    //开始模型计算
    /**
     * @param earthquakeId 地震id
     * @param batchNumber 批次号
     */
    public void startCalcModel(String earthquakeId,Integer batchNumber){
        //获取叠加分析数据类型
        String dataType = this.getDataType(earthquakeId);
        //获取叠加分析数据
        Map<String,Object> params = new HashedMap();
        params.put("dataType",dataType);
        params.put("batchNumber",batchNumber);
        List<Map<String,Object>> dataOfjz = this.getAnalysisData(params);
        System.out.println("*******开始计算建筑损坏面积模型******");
        for(Map item : dataOfjz){
            //街道名称
            String townName = item.get("townName").toString();
            //受灾面积
            Double affectedArea = Double.parseDouble(item.get("affectedArea").toString());
            //建筑类型
            String buildingType = "高层建筑";
            //地震烈度
            Integer ld = Integer.parseInt(item.get("intensity").toString());
            //判断地震烈度是否小于等于6
            ld =(ld <= 6) ? 6:ld;
            //调用建筑破坏比模型
            this.calcJZPHB(earthquakeId,affectedArea,townName,buildingType,ld);
            System.out.println(item);

        }
        System.out.println("*******建筑损坏面积模型计算完成******");
        System.out.println("*******开始计算受伤人员、死亡人员、无家可归人员、经济算是模型、相应等级模型******");
        //死亡模型-震害预测算法
        this.getDeathByZHYCSF(earthquakeId);
        //受伤人员模型-按烈度
        this.getInjuredByLD(earthquakeId);
        //无家可归模型
        this.getHomelessDefault(earthquakeId);
        //经济损失模型
        this.getEconomicDefault(earthquakeId);
        //相应等级模型
        this.getResponseLevelDefault(earthquakeId);
        System.out.println("*******受伤人员、死亡人员、无家可归人员、经济算是模型、相应等级模型计算完成******");
        System.out.println("*******开始计算救援队伍、医务人员、帐篷需求、临时厕所、应急饮水、粮食补助、衣服需求、棉被需求、毛毯需求、担架需求模型******");
        List<Map<String,Object>> dataOfJywz = this.calcModelMapper.getTownNameAndhomelessAndInjuredAndDeath(earthquakeId);
        for(Map item : dataOfJywz){
            String townName = item.get("townName").toString();
            Integer deathNumber = 0;
            deathNumber=(item.get("deathNumber")==null)?deathNumber:Integer.parseInt(item.get("deathNumber").toString());
            Integer injuredNumber = 0;
            injuredNumber=(item.get("injuredNumber")==null)?injuredNumber:Integer.parseInt(item.get("injuredNumber").toString());
            Integer homelessNumber = 0;
            homelessNumber=(item.get("homelessNumber")==null)?homelessNumber:Integer.parseInt(item.get("homelessNumber").toString());
            //调用救援队伍需求人数模型
            this.calcRescueModel(townName,earthquakeId,6.0,deathNumber);
            //调用医务人员需求模型
            this.calcMedicalMember(townName,earthquakeId,deathNumber);
            //调用帐篷需求模型
            this.calcTentModel(townName,earthquakeId,homelessNumber);
            //调用临时厕所需求模型
            this.calcToiletModel(townName,earthquakeId,homelessNumber);
            //调用应急饮水需求模型
            this.calcWaterModel(townName,earthquakeId,homelessNumber);
            //调用粮食补助模型
            this.calcGoodModel(townName,earthquakeId,homelessNumber);
            //调用衣服需求模型
            this.calcClothingModel(townName,earthquakeId,homelessNumber);
            //调用棉被需求模型
            this.calcQuiltModel(townName,earthquakeId,homelessNumber);
            //调用毛毯需求模型
            this.calcBlanketModel(townName,earthquakeId,homelessNumber);
            //调用担架需求模型
            this.calcStretcherModel(townName,earthquakeId,injuredNumber);
        }

        System.out.println("*******救援队伍、医务人员、帐篷需求、临时厕所、应急饮水、粮食补助、衣服需求、棉被需求、毛毯需求、担架需求模型计算完成******");

    }
    //根据地震Id获取叠加分析数据类型
    public String getDataType(String earthquakeId){
        Map<String,String> dataTypeObject = this.calcModelMapper.getDataType(earthquakeId);
        String dataType = dataTypeObject.get("analysisData");
        return dataType;
    }
    //根据叠加分析数据类型查询叠加分析结果数据
    public List<Map<String,Object>> getAnalysisData(Map<String,Object> params){
        List<Map<String,Object>> analysisData = this.calcModelMapper.getAnalysisData(params);
        return analysisData;
    }

    //建筑易损性矩阵

    /**
     *
     * @param earthquakeId 地震id
     * @param buildingArea 建筑面积
     * @param townName     街道名称
     * @param buildingType 建筑类型
     * @param ld           地震烈度
     */
    public void calcJZYSXJZ(String earthquakeId,Double buildingArea,String townName,String buildingType,Integer ld){
        String modelVersion = this.getBuildingVersion();
        Map<String,Object> jzysData=this.calcModelMapper.getJZYSdataBy(buildingType,ld,modelVersion);
        Double ysxjz_jbwh=buildingArea*(Double.parseDouble(jzysData.get("jbwh").toString())/100);
        Double ysxjz_qdph=buildingArea*(Double.parseDouble(jzysData.get("qdph").toString())/100);
        Double ysxjz_zdph=buildingArea*(Double.parseDouble(jzysData.get("zdph").toString())/100);
        Double ysxjz_yzph=buildingArea*(Double.parseDouble(jzysData.get("yzph").toString())/100);
        Double ysxjz_hh=buildingArea*(Double.parseDouble(jzysData.get("hh").toString())/100);
        System.out.println("基本完好："+ysxjz_jbwh);
        System.out.println("轻度破坏："+ysxjz_qdph);
        System.out.println("中度破坏："+ysxjz_zdph);
        System.out.println("严重破坏："+ysxjz_yzph);
        System.out.println("毁坏："+ysxjz_hh);
    }
    //计算建筑破坏比
    public Double calcJZPHB(String earthquakeId,Double buildingArea,String town,String buildingType,Integer ld){
        String modelVersion = this.getBuildingVersion();
        Map<String,Object> jzysData=this.calcModelMapper.getJZYSdataBy(buildingType,ld,modelVersion);
        Map<String,Object> jzphbData=this.calcModelMapper.getJZPHBdataBy(buildingType,modelVersion);
        //建筑破坏比模型数据
        Double phb_jbwh=buildingArea*(Double.parseDouble(jzysData.get("jbwh").toString())/100)*(Double.parseDouble(jzphbData.get("jbwh").toString())/100);
        Double phb_qdph=buildingArea*(Double.parseDouble(jzysData.get("qdph").toString())/100)*(Double.parseDouble(jzphbData.get("qdph").toString())/100);
        Double phb_zdph=buildingArea*(Double.parseDouble(jzysData.get("zdph").toString())/100)*(Double.parseDouble(jzphbData.get("zdph").toString())/100);
        Double phb_yzph=buildingArea*(Double.parseDouble(jzysData.get("yzph").toString())/100)*(Double.parseDouble(jzphbData.get("yzph").toString())/100);
        Double phb_hh=buildingArea*(Double.parseDouble(jzysData.get("hh").toString())/100)*(Double.parseDouble(jzphbData.get("hh").toString())/100);

        //添加建筑破坏比数据
        Map<String,Object> data=new HashMap();
        data.put("featId",IdUtil.simpleUUID());
        data.put("earthquakeFeatId",earthquakeId);
        data.put("townName",town);
        data.put("jbwh",phb_jbwh);
        data.put("qdph",phb_qdph);
        data.put("zdph",phb_zdph);
        data.put("yzph",phb_yzph);
        data.put("hh",phb_hh);
        this.addJZPHBdata(data);

        return (phb_jbwh+phb_qdph+phb_zdph+phb_yzph+phb_hh)/1000;

    }

    //添加建筑破坏比结果数据
    public void addJZPHBdata(Map<String,Object> data){
        this.calcModelMapper.addJZPHBdata(data);
    }
    //计算建筑经济损失比

    public Double calcJZJJSSB(Double buildingArea,String town,String buildingType,Integer ld,Double zj,String modelVersion){
        Map<String,Object> jzysData=this.calcModelMapper.getJZYSdataBy(buildingType,ld,modelVersion);
        Map<String,Object> jzphbData=this.calcModelMapper.getJZPHBdataBy(buildingType,modelVersion);
        Map<String,Object> jzjjssbData=this.calcModelMapper.getJZJJSSB(modelVersion);
        //建筑破坏比模型数据
        Double phb_jbwh=buildingArea*(Double.parseDouble(jzysData.get("jbwh").toString())/100)*(Double.parseDouble(jzphbData.get("jbwh").toString())/100);
        Double phb_qdph=buildingArea*(Double.parseDouble(jzysData.get("qdph").toString())/100)*(Double.parseDouble(jzphbData.get("qdph").toString())/100);
        Double phb_zdph=buildingArea*(Double.parseDouble(jzysData.get("zdph").toString())/100)*(Double.parseDouble(jzphbData.get("zdph").toString())/100);
        Double phb_yzph=buildingArea*(Double.parseDouble(jzysData.get("yzph").toString())/100)*(Double.parseDouble(jzphbData.get("yzph").toString())/100);
        Double phb_hh=buildingArea*(Double.parseDouble(jzysData.get("hh").toString())/100)*(Double.parseDouble(jzphbData.get("hh").toString())/100);
        //建筑经济损失比模型数据
        Double jjssb_jbwh=phb_jbwh*(Double.parseDouble(jzjjssbData.get("jbwh").toString())/100)*zj;
        Double jjssb_qdph=phb_qdph*(Double.parseDouble(jzjjssbData.get("qdph").toString())/100)*zj;
        Double jjssb_zdph=phb_zdph*(Double.parseDouble(jzjjssbData.get("zdph").toString())/100)*zj;
        Double jjssb_yzph=phb_yzph*(Double.parseDouble(jzjjssbData.get("yzph").toString())/100)*zj;
        Double jjssb_hh=phb_hh*(Double.parseDouble(jzjjssbData.get("hh").toString())/100)*zj;

        System.out.println("基本完好面积===》"+jjssb_jbwh);
        System.out.println("轻度破坏面积===》"+jjssb_qdph);
        System.out.println("中度破坏面积===》"+jjssb_zdph);
        System.out.println("严重破坏面积===》"+jjssb_yzph);
        System.out.println("毁坏面积===》"+jjssb_hh);
        return (phb_jbwh+jjssb_qdph+phb_zdph+phb_yzph+phb_hh);
    }
    //计算死亡人员中的震害预测算法
    public Double calcFWHHB(String modelVersion){
        Map<String,Object> zhyc=this.calcModelMapper.getZHYC(modelVersion);
        Double zhycValue=Double.parseDouble(zhyc.get("zhyc").toString());
        return zhycValue;
    }

    //----计算受伤人员模型
    //获取受伤人员模型当前版本数
    public Integer getInjuredVersion(){
        return Integer.parseInt(this.calcModelMapper.getCurrentInjuredModelVersion().get("modelVersion").toString());
    }
    //按地震震级计算
    public void calcSSRYAZJ(Integer dzzj,Double dieNumber,Integer modelVersion){
        Map<String,Object> l0=this.calcModelMapper.getL0(modelVersion);
        Double L0=Double.parseDouble(l0.get("l0").toString()) ;
        Double adzzjParam=Double.parseDouble(this.calcModelMapper.getSSRYAZJ(dzzj,modelVersion).get("percentInjured").toString()) ;
        Double ssryAZJresult=dieNumber*L0*(adzzjParam/100);
        System.out.println("按地震震级计算的结果为====》"+ssryAZJresult);
    }
    //按地震烈度计算
    public void calcSSRYALD(String dzld,Double dieNumber,Integer modelVersion){
        Map<String,Object> l0=this.calcModelMapper.getL0(modelVersion);
        Double L0=Double.parseDouble(l0.get("l0").toString()) ;
        Double adzldParam=Double.parseDouble(this.calcModelMapper.getSSRYALD(dzld,modelVersion).get("percentInjured").toString()) ;
        Double ssryALDresult=dieNumber*L0*(adzldParam/100);
        System.out.println("按地震烈度计算的结果为====》"+ssryALDresult);
    }

    //--------计算压埋人员模型
    //计算压埋人员
    public void calcYMRY(){
        //倒塌率
        Double dtl=10.0;
        //破坏率
        Double phl=10.0;
        Double tdcsYmry=(dtl+(10/100)*phl)/3500;
        Double dcsYmry=(dtl+(10/100)*phl)/2500;
        Double ybcsYmry=(dtl+(10/100)*phl)/1500;
        Double xcYmry=(dtl+(10/100)*phl)/1000;
        Double ncYmry=(dtl+(10/100)*phl)/500;

        System.out.println("特大城市压埋人数==》"+tdcsYmry);
        System.out.println("大城市压埋人数==》"+dcsYmry);
        System.out.println("一般城市压埋人数==》"+ybcsYmry);
        System.out.println("县城压埋人数==》"+xcYmry);
        System.out.println("农村压埋人数==》"+ncYmry);
    }

    //-------计算无家可归人员模型

    //获取无家可归人员当前参数版本号
    public String getCurrentHomelessModelVersion(){
        Map<String,Object> version=this.calcModelMapper.getCurrentHomelessModelVersion();
        String modelVersion=version.get("modelVersion").toString();
        return modelVersion;
    }
    //计算无家可归人员数量
    public Double calcHomelessNum(){
        Double totalPopulation=10000.0;
        String[] dzldRange={"Ⅵ","Ⅶ","Ⅷ","Ⅸ","Ⅹ"};
        Double homelessNum=0.0;
        String modelVersion=this.getCurrentHomelessModelVersion();
        for(int i=0;i<dzldRange.length;i++){
            Map<String,Object> param=this.calcModelMapper.getProportionLow(dzldRange[i],modelVersion);
            Double proportionLow=Double.parseDouble(param.get("proportionLow").toString());
            homelessNum+=proportionLow*totalPopulation;
        }

        //计算无家可归人口数为
        System.out.println("无家可归人员数====》"+homelessNum);

        return homelessNum;
    }

    //----------计算经济损失模型
    //获取经济损失模型参数当前版本数
    public String getCurrentEconomicLossesModelVersion(){
        Map<String,Object> version=this.calcModelMapper.getCurrentEconomicLossesModelVersion();
        String modelVersion=version.get("modelVersion").toString();
        return modelVersion;
    }
    //计算经济损失模型数据
    public void calcEconomicLossesData(){
        String[] dzldRange={"6度区","7度区","8度区","9度区及以上"};
        String modelVersion=this.getCurrentEconomicLossesModelVersion();
        //区域总人口数
        Double totalPopulation=10000.00;
        //6度区经济损失
        Double sixDQ=0.0;
        //7度区经济损失
        Double sevenDQ=0.0;
        //8度区经济损失
        Double eightDQ=0.0;
        //9度区及以上经济损失
        Double nineDQ=0.0;
        for(int i=0;i<dzldRange.length;i++){
            Map<String,Object> params=this.calcModelMapper.getEconomicLosses(dzldRange[i],modelVersion);
            Double jjssParam=Double.parseDouble(params.get("economicLosses").toString());
            String dzld=params.get("i").toString();
            if("6度区".equals(dzld)){
                sixDQ=jjssParam*totalPopulation;
            }else if("7度区".equals(dzld)){
                sevenDQ=jjssParam*totalPopulation;
            }else if("8度区".equals(dzld)){
                eightDQ=jjssParam*totalPopulation;
            }if("9度区及以上".equals(dzld)){
                nineDQ=jjssParam*totalPopulation;
            }
        }

        //不同列度下的经济损失
        System.out.println("6度区经济损失===》"+sixDQ);
        System.out.println("7度区经济损失===》"+sevenDQ);
        System.out.println("8度区经济损失===》"+eightDQ);
        System.out.println("9度区经济损失===》"+nineDQ);

    }


    /**
     * 死亡人员模型
     * @param earthquakeFaetId
     * @return
     */
    public List<TEarthquakeDetail> getDeathCount(String earthquakeFaetId,Map<String,Map<Integer,Double>> scale,String method) {

        // 1.查出参数
        DeathPersonModel deathPersonModel = deathPersonModelMapper.selectMaxVersionModel();

        List<TEarthquakeDetail> tEarthquakeDetails = tEarthquakeDetailMapper.selectEqDetailByFeatid(earthquakeFaetId);

        // 2.各个街镇的房屋损害比
        deathPersonModelService.getAMethod(method, tEarthquakeDetails,scale);

        //4.调用计算模型，查出死亡人数
        deathPersonModelService.getDeathNum(deathPersonModel, tEarthquakeDetails);
        //5.将死亡人数存表
        for (TEarthquakeDetail deathNum : tEarthquakeDetails) {
            if (deathNum.getDeathNumber() != null) {
                deathPersonModelMapper.updateDeathNum(deathNum.getDeathNumber(), deathNum.getEarthquakeFeatid(), deathNum.getTownName());
            }
        }
        return tEarthquakeDetails;
    }


    /**
     * 死亡模型-易损矩阵算法
     * @param earthquakeFaetId
     */
    public void getDeathByYSJZSF(String earthquakeFaetId) {
        Map<String, Map<Integer, Double>> scale = getTownEffectedArea(earthquakeFaetId);
        getDeathCount(earthquakeFaetId,scale,"method01");
    }

    /**
     * 死亡模型-震害预测算法
     * @param earthquakeFaetId
     */
    public void getDeathByZHYCSF(String earthquakeFaetId) {
        Map<String, Map<Integer, Double>> scale = getTownEffectedArea(earthquakeFaetId);
        getDeathCount(earthquakeFaetId,scale,"method02");
    }

    /**
     * 受伤人员模型
     * @param earthquakeDetails
     * @param scale 各街镇的烈度和对应的面积，数据格式为<街镇名，<烈度，面积>>
     * @param
     */
    public void getInjuredCount(List<TEarthquakeDetail> earthquakeDetails,Map<String,Map<Integer,Double>> scale,String eqFeatid,String formula) {
        TEarthquakeInfo earthquakeInfo = calcModelMapper.getTEarthquakeInfoByFeatid(eqFeatid);
        double zhenJi = earthquakeInfo.getEarthquakeLevel();
        double percentInjured = 0;
        List<Map<String, Object>> scaleInjured = injuredMemberMapper.selectInjuredModelMaxVersion(formula);
        Map<Object, Object> tModelInjuredMap = scaleInjured.stream().collect(Collectors.toMap(map -> map.get("scale"), map -> map.get("percentInjured")));
        if ("按震级".equals(formula)) {
            int zhenJiInt = (int) zhenJi;
            String zhenJiIntString = zhenJiInt + "";
            BigDecimal param1 = (BigDecimal) tModelInjuredMap.get(zhenJiIntString);
            BigDecimal param2 = (BigDecimal) tModelInjuredMap.get((zhenJiInt + 1) + "");
            double param1Value = param1.doubleValue();
            double param2Value = param2.doubleValue();
            double v = zhenJi % 1;
            percentInjured = (param2Value - param1Value) * v + param1Value;
        } else if ("按参数".equals(formula)) {
            Map<String, Object> map = scaleInjured.get(0);
            BigDecimal percentInjuredBigDecimal = (BigDecimal) map.get("percentInjured");
            percentInjured = percentInjuredBigDecimal.doubleValue();
        }
        for (TEarthquakeDetail earthquakeDetail : earthquakeDetails) {
            String townName = earthquakeDetail.getTownName();
            Map<Integer, Double> scaleMap = scale.get(townName);
            Double townTotalArea = earthquakeDetail.getTownTotalArea();
            Integer deathNumber = earthquakeDetail.getDeathNumber();
            if (deathNumber != null) {
                double number = 0;
                if ("按烈度".equals(formula)) {
                    if (MapUtils.isNotEmpty(scaleMap)) {
                        for (Map.Entry<Integer, Double> entry : scaleMap.entrySet()) {
                            percentInjured = 0;
                            Integer key = entry.getKey();
                            if (key < 6) {
                                key = 6;
                            }
                            String scaleKey = NumberUtil.toLuMaNumber(key);
                            Double area = entry.getValue();
                            BigDecimal percentinjuredDecimal = (BigDecimal) tModelInjuredMap.get(scaleKey);
                            percentInjured = percentinjuredDecimal.doubleValue();
                            double v = deathNumber * percentInjured * area / townTotalArea;
                            number += v;
                        }
                    }
                    int injuredNum = (int) Math.round(number);
                    earthquakeDetail.setInjuredNumber(injuredNum);
                    injuredMemberMapper.updateInjuredNum(earthquakeDetail);
                } else {
                    number = deathNumber * percentInjured;
                    int injuredNum = (int) Math.round(number);
                    earthquakeDetail.setInjuredNumber(injuredNum);
                    injuredMemberMapper.updateInjuredNum(earthquakeDetail);
                }
            }
        }
    }


    /**
     * 受伤人员模型-按震级
     * @param eqFeatid
     */
    public void getInjuredByZJ(String eqFeatid) {
        List<TEarthquakeDetail> tEarthquakeDetails = tEarthquakeDetailMapper.selectEqDetailByFeatid(eqFeatid);
        Map<String, Map<Integer, Double>> scale = getTownEffectedArea(eqFeatid);
        getInjuredCount(tEarthquakeDetails, scale, eqFeatid, "按震级");
    }

    /**
     * 受伤人员模型-按烈度
     * @param eqFeatid
     */
    public void getInjuredByLD(String eqFeatid) {
        List<TEarthquakeDetail> tEarthquakeDetails = tEarthquakeDetailMapper.selectEqDetailByFeatid(eqFeatid);
        Map<String, Map<Integer, Double>> scale = getTownEffectedArea(eqFeatid);
        getInjuredCount(tEarthquakeDetails, scale, eqFeatid, "按烈度");
    }

    /**
     * 受伤人员模型-按参数
     * @param eqFeatid
     */
    public void getInjuredByCS(String eqFeatid) {
        List<TEarthquakeDetail> tEarthquakeDetails = tEarthquakeDetailMapper.selectEqDetailByFeatid(eqFeatid);
        Map<String, Map<Integer, Double>> scale = getTownEffectedArea(eqFeatid);
        getInjuredCount(tEarthquakeDetails, scale, eqFeatid, "按参数");
    }
    /**
     * todo 计算一公里格网内存在压埋人员的格网，将格网连成片，未做
     * 压埋人员模型
     * @param earthquakeDetails
     */
    public void getBuriedNum(List<TEarthquakeDetail> earthquakeDetails) {
        for (TEarthquakeDetail earthquakeDetail : earthquakeDetails) {
            //破坏面积
            Double structureD = earthquakeDetail.getStructureD();
            //严重破坏面积
            Double structureY = earthquakeDetail.getStructureY();
            Double townTotalArea = earthquakeDetail.getTownTotalArea();
            double Dd = structureD / townTotalArea;
            double Dp = structureY / townTotalArea;
        }
    }


    /**
     * 无家可归模型
     * @param earthquakeDetails
     * @param scale
     */
    public void getHomeLessNum(List<TEarthquakeDetail> earthquakeDetails,Map<String,Map<Integer,Double>> scale) {
        List<TModelHomeless> tModelHomelesses = homelessMemberMapper.selectMaxVersionModel();
        Map<String, Double> homelessModelMap = tModelHomelesses.stream().collect(Collectors.toMap(TModelHomeless::getI, TModelHomeless::getProportionLow));
        for (TEarthquakeDetail earthquakeDetail : earthquakeDetails) {
            String townName = earthquakeDetail.getTownName();
            Map<Integer, Double> scaleMap = scale.get(townName);
            Integer townPopulation = earthquakeDetail.getTownPopulation();
            Double townTotalArea = earthquakeDetail.getTownTotalArea();
            if (townPopulation != null && townTotalArea != null) {
                double homeLess = 0;
                if (MapUtils.isNotEmpty(scaleMap)) {
                    for (Map.Entry<Integer, Double> entry : scaleMap.entrySet()) {
                        Integer key = entry.getKey();
                        if (key < 6) {
                            key = 6;
                        }
                        String scaleKey = NumberUtil.toLuMaNumber(key);
                        Double area = entry.getValue();
                        double v = homelessModelMap.get(scaleKey);
                        double v1 = townPopulation * v * area /townTotalArea;
                        homeLess += v1;
                    }
                }
                int homeLessPopulation = (int) Math.round(homeLess);
                earthquakeDetail.setHomelessNum(homeLessPopulation);
                earthquakeDetail.setEmergencyRehousingNumber(homeLessPopulation);
                tEarthquakeDetailMapper.updateEmergencyRehousingNumber(earthquakeDetail);
            }
        }
    }

    /**
     * 根据eqFeatid查询无家可归人数
     * @param eqFeatid
     */
    public void getHomelessDefault(String eqFeatid) {
        List<TEarthquakeDetail> tEarthquakeDetails = tEarthquakeDetailMapper.selectEqDetailByFeatid(eqFeatid);
        Map<String, Map<Integer, Double>> scale = getTownEffectedArea(eqFeatid);
        getHomeLessNum(tEarthquakeDetails, scale);
    }

    /**
     * 经济损失模型
     * @param earthquakeDetails
     * @param scale
     */
    public void getEconomicLosses(List<TEarthquakeDetail> earthquakeDetails,Map<String,Map<Integer,Double>> scale) {
        List<TModelEconomicLosses> tModelEconomicLosses = tModelEconomicLossesMapper.selectMaxVersionModel();
        Map<String, Double> economicModleMap = tModelEconomicLosses.stream().collect(Collectors.toMap(TModelEconomicLosses::getI, TModelEconomicLosses::getEconomicLosses));
        for (TEarthquakeDetail earthquakeDetail : earthquakeDetails) {
            String townName = earthquakeDetail.getTownName();
            Map<Integer, Double> scaleMap = scale.get(townName);
            Integer townPopulation = earthquakeDetail.getTownPopulation();
            Double townTotalArea = earthquakeDetail.getTownTotalArea();
            if (townPopulation != null &&townTotalArea != null) {
                double economicLosses = 0;
                if (MapUtils.isNotEmpty(scaleMap)) {
                    for (Map.Entry<Integer, Double> entry : scaleMap.entrySet()) {
                        Integer key = entry.getKey();
                        if (key < 6) {
                            key = 6;
                        }
                        String s = NumberUtil.toELParam(key);
                        if (!s.equals("")) {
                            Double area = entry.getValue();
                            Double param = economicModleMap.get(s);
                            double eLoss = param * townPopulation * area / townTotalArea;
                            economicLosses += eLoss;
                        }
                    }
                }
                earthquakeDetail.setEconomicLosses(economicLosses);
                economicLossesMapper.updateEconomicLoss(earthquakeDetail);
            }
        }
    }

    /**
     * 根据eqFeatid计算经济损失并存表
     */
    public void getEconomicDefault(String eqFeatid) {
        List<TEarthquakeDetail> tEarthquakeDetails = tEarthquakeDetailMapper.selectEqDetailByFeatid(eqFeatid);
        Map<String, Map<Integer, Double>> scale = getTownEffectedArea(eqFeatid);
        getEconomicLosses(tEarthquakeDetails,scale);
    }
    /**
     * 应急响应模型
     * @return
     */
    public void getResponseLevel(List<TEarthquakeDetail> earthquakeDetails,String earthquakeFeatid,Map<String,Map<Integer,Double>> scale) {
        TEarthquakeInfo earthquakeInfo = calcModelMapper.getTEarthquakeInfoByFeatid(earthquakeFeatid);
        Double zj = earthquakeInfo.getEarthquakeLevel();
        String earthquakeLocation = earthquakeInfo.getEarthquakeLocation();
        String site = "QT";
        if (earthquakeLocation.startsWith("上海")) {
            site = "SH";
        } else if (
                earthquakeLocation.startsWith("江苏") ||
                earthquakeLocation.startsWith("浙江") ||
                earthquakeLocation.startsWith("安徽") ||
                earthquakeLocation.startsWith("江西") ||
                earthquakeLocation.startsWith("福建")
        ) {
            site = "HD";
        }

        HashMap<Integer, Integer> scaleTowns = new HashMap<>();
        for (Map.Entry<String, Map<Integer, Double>> entry : scale.entrySet()) {
            String town = entry.getKey();
            Map<Integer, Double> scaleMap = entry.getValue();
            Set<Integer> scaleSet = scaleMap.keySet();
            Iterator<Integer> iterator = scaleSet.iterator();
            while (iterator.hasNext()) {
                Integer scaleValue = iterator.next();
                Integer townCounts = scaleTowns.get(scaleValue);
                if (townCounts == null) {
                    scaleTowns.put(scaleValue, 1);
                } else {
                    townCounts++;
                    scaleTowns.put(scaleValue, townCounts);
                }
            }
        }

        Object[] objects = scaleTowns.keySet().toArray();
        Integer[] scaleArrs = new Integer[objects.length];
        for (int i = 0; i < objects.length; i++) {
            scaleArrs[i] = (Integer) objects[i];
        }
        Arrays.sort(scaleArrs, ( o1, o2) -> o2 - o1);
        //查出普遍烈度
        int generalScale = -1;
        for (Integer scaleArr : scaleArrs) {
            Integer count = scaleTowns.get(scaleArr);
            if (count>1) {
                generalScale = scaleArr;
                break;
            }
        }
        //判断应急响应级别
        String emergencyLevel = "/";
        if (scaleArrs != null && scaleArrs.length > 0) {
            if (
                    ("SH".equals(site) && (zj>=5.5))
                            || ("HD".equals(site) && (zj>=7))
                            || (scaleArrs[0] >= 7)
            ) {
                emergencyLevel =  "Ⅰ";
            } else if (
                    ("SH".equals(site) && (zj >= 4 && zj < 5.5))
                            || ("HD".equals(site) && (zj >= 6 && zj < 7))
                            || (scaleArrs[0] >= 5 && scaleArrs[0] < 7)
            ) {
                emergencyLevel = "Ⅱ";
            } else if (
                    ("SH".equals(site) && (zj >= 3 && zj < 4))
                            || ("HD".equals(site) && (zj >= 5 && zj < 6))
                            || (generalScale >= 4 && generalScale < 5)
            ) {
                emergencyLevel = "Ⅲ";
            } else if (
                    ("SH".equals(site) && (zj >= 2.5 && zj < 3))
                            || ("HD".equals(site) && (zj >= 4 && zj < 5))
                            || (scaleArrs[0] >= 3 && scaleArrs[0] < 4)
            ) {
                emergencyLevel = "Ⅳ";
            }
        }
        for (TEarthquakeDetail earthquakeDetail : earthquakeDetails) {
            earthquakeDetail.setEmergencyLevel(emergencyLevel);
            tEarthquakeDetailMapper.updateEmergencyLevel(earthquakeDetail);
        }
    }

    /**
     * 根据eqFeatid计算响应等级并存表
     */
    public void getResponseLevelDefault(String eqFeatid) {
        List<TEarthquakeDetail> tEarthquakeDetails = tEarthquakeDetailMapper.selectEqDetailByFeatid(eqFeatid);
        Map<String, Map<Integer, Double>> scale = getTownEffectedArea(eqFeatid);
        getResponseLevel(tEarthquakeDetails, eqFeatid,scale);
    }

    /**
     * 根据earthquakeFeatid查询各街镇受影响强度
     * @param eqFeatid
     * @return
     */
    public Map<String, Map<Integer, Double>> getTownEffectedArea(String eqFeatid) {
        List<Map<String, Object>> townEffectedArea = calcModelMapper.getTownEffectedArea(eqFeatid);
        Map<String, Map<Integer, Double>> townStrenthArea = new HashedMap(214);
        for (Map<String, Object> map : townEffectedArea) {
            String townName = (String) map.get("townName");
            BigDecimal intensityDecimal = (BigDecimal) map.get("intensity");
            int intensity = intensityDecimal.intValue();
            BigDecimal affectedAreaDecimal = (BigDecimal) map.get("affectedArea");
            double affectedArea = affectedAreaDecimal.doubleValue();
            Map<Integer, Double> strenthArea = townStrenthArea.get(townName);
            if (strenthArea == null) {
                strenthArea = new HashedMap();
                townStrenthArea.put(townName, strenthArea);
            }
            strenthArea.put(intensity, affectedArea);
        }
        return townStrenthArea;
    }


//    /**
//     * 方法模型3-8计算混合
//     * @param eqFeatid
//     * @return Map:eqDetails-各街镇地震详情
//     *            responseLevel-应急响应等级
//     */
//    public List<TEarthquakeDetail> methodSummary(String eqFeatid) {
//
//        try {
//            Map<String, Map<Integer, Double>> scale = getTownEffectedArea(eqFeatid);
//            List<TEarthquakeDetail> eqDetails = getDeathCount(eqFeatid, scale);
//            getInjuredCount(eqDetails, scale, eqFeatid);
//            getHomeLessNum(eqDetails, scale);
//            getEconomicLosses(eqDetails, scale);
//            getResponseLevel(eqDetails,eqFeatid, scale);
//            return eqDetails;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }



    public void test() {
        CalcModelService calcModelService = new CalcModelService();
        HashMap<String, Map<Integer, Double>> scaleMap = new HashMap<>();
        HashMap<Integer, Double> scaleMapMap = new HashMap<>();
        scaleMapMap.put(6, 4000000.0);
        scaleMapMap.put(5, 4000000.0);
        scaleMapMap.put(4, 4000000.0);
        scaleMap.put("南翔镇",scaleMapMap);
    }

    ////////////////////////////////////////////////////////////////////
    //计算救援队伍模型
    /**
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param M 震级
     * @param Di 受灾人数
     * @return
     */
    public void calcRescueModel(String townName,String earthquakeFeatId,Double M,Integer Di){
        Map<String,Object> modelParams = this.tModelRescueService.getRescueParams();
        Double l0 = Double.parseDouble(modelParams.get("l0").toString());
        Double l1 = Double.parseDouble(modelParams.get("l1").toString());
        Double l2 = Double.parseDouble(modelParams.get("l2").toString());
        String Re = "";
        Map<String,Object> data = new HashMap<>();
        if(M<5){
            Re = "灾情当地驻军和武警消防为主";
        }else if(M>=5 && M<6){
            Double tempRe = M*Di*l0;
            if(tempRe >= 150000){
                Re = "15万 - 20万";
            }else{
                Re = tempRe+"";
            }
        }else if(M>=6 && M<7){
            Double tempRe = M*Di*l1;
            if(tempRe >= 150000){
                Re = "15万 - 20万";
            }else{
                Re = tempRe+"";
            }
        }else if(M>=7 && M<8){
            Double tempRe = M*Di*l2;
            if(tempRe >= 150000){
                Re = "15万 - 20万";
            }else{
                Re = tempRe+"";
            }
        }
        data.put("featId",IdUtil.simpleUUID());
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("townName",townName);
        data.put("rescueStaff",Re);
        this.tModelRescueMapper.addRescueNumber(data);
        data.clear();
        modelParams.clear();
    }

    ////////////////////////////////////////////////////////////////////
    //计算救援力量模型
    //救援力量模型-按震级
    /**
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param De 死亡人数
     * @return
     */
    public void calcRescueForceModel(String townName,String earthquakeFeatId,Integer De){
        Map<String,Object> params = this.rescueForceService.getRescueForceParams();
        Double l0= Double.parseDouble(params.get("force0").toString());
        Double l1= Double.parseDouble(params.get("force1").toString());
        Double l2= Double.parseDouble(params.get("force2").toString());
        Double l3= Double.parseDouble(params.get("force3").toString());
        Double l4= Double.parseDouble(params.get("force4").toString());
        Double l5= Double.parseDouble(params.get("force5").toString());
        Double l6= Double.parseDouble(params.get("force6").toString());
        Double Re=0.0;
        if(De == 0){
            Re = l0;
        }else if(De>0 && De<100){
            Re = De*l1+l2;
        }else if(De>100 && De<1000){
            Re = l3*Math.pow(De,l4);
        }else if(De>10000){
            Re = l5*Math.pow(De,l6);
        }
        params.clear();

    }

    //医务人员模型
    /**
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param De 死亡人数
     * @return
     */
    public void calcMedicalMember(String townName,String earthquakeFeatId,Integer De){
        Map<String,Object> params = this.rescueForceService.getRescueForceParams();
        Double l0 = Double.parseDouble(params.get("medicalStaff0").toString());
        Double l1 = Double.parseDouble(params.get("medicalStaff1").toString());
        Double l2 = Double.parseDouble(params.get("medicalStaff2").toString());
        Double l3 = Double.parseDouble(params.get("medicalStaff3").toString());
        Map<String,Object> data = new HashMap<>();
        Double EpiPer = 0.0;
        if(De>0 && De<=200){
            EpiPer = De*l0+l1;
        }else if(De>200 && De<1000){
            EpiPer = De*l2;
        }else if(De>1000){
            EpiPer = De*l3;
        }
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("medicalStaff",EpiPer);
        this.rescueForceService.addMedicalStaffDemand(data);
        data.clear();
        params.clear();
    }

    //防疫人员模型
    /**
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param De 死亡人数
     * @return
     */
    public void calcPreventionMember(String townName,String earthquakeFeatId,Integer De){
        Map<String,Object> params = this.rescueForceService.getRescueForceParams();
        Double l0 = Double.parseDouble(params.get("epidemicPrevention0").toString());
        Double l1 = Double.parseDouble(params.get("epidemicPrevention1").toString());
        Double l2 = Double.parseDouble(params.get("epidemicPrevention2").toString());
        Double l3 = Double.parseDouble(params.get("epidemicPrevention3").toString());
        Double EpiPer = 0.0;
        if(De>0 && De<=200){
            EpiPer = De*l0+l1;
        }else if(De>200 && De<1000){
            EpiPer = De*l2;
        }else if(De>1000){
            EpiPer = De*l3;
        }
        params.clear();
    }


    ////////////////////////////////////////////////////////////////////
    //计算物资物资模型
    //计算帐篷模型
    /**
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param Ho 无家可归人数
     * @return
     */
    public void calcTentModel(String townName,String earthquakeFeatId,Integer Ho){
        String modelType = "帐篷";
        String season = "";
        Calendar calendar = Calendar.getInstance();
        Integer month = calendar.get(Calendar.MONTH)+1;
        Double Tent = 0.0;
        Map<String,Object> params = this.tModelReliefGoodsService.getModelParamsByType(modelType);
        Double l0 = Double.parseDouble(params.get("l0").toString());
        Double l1 = Double.parseDouble(params.get("l1").toString());
        Double l2 = Double.parseDouble(params.get("l2").toString());
        Double l3 = Double.parseDouble(params.get("l3").toString());
        Map<String,Object> data = new HashMap<>();
        if(month>=6 && month<=8){
            season = "夏季";
            Tent = Ho*l0*l1;
        }else if(month==1 || month==2 || month==12){
            season = "冬季";
            Tent = Ho*l2*l3;
        }
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("tentDemand",Tent);
        this.tModelReliefGoodsService.addTentDemand(data);
        data.clear();
        params.clear();
    }

    //计算粮食补助模型

    /**
     *
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param Ho 无家可归人员数
     */
    public void calcGoodModel(String townName,String earthquakeFeatId,Integer Ho){
        String modelType = "灾后粮食补助";
        String season = "";
        Calendar calendar = Calendar.getInstance();
        Integer month = calendar.get(Calendar.MONTH)+1;
        Double Fo = 0.0;
        Map<String,Object> params = this.tModelReliefGoodsService.getModelParamsByType(modelType);
        Double l0 = Double.parseDouble(params.get("l0").toString());
        Double l1 = Double.parseDouble(params.get("l1").toString());
        Double l2 = Double.parseDouble(params.get("l2").toString());
        Double l3 = Double.parseDouble(params.get("l3").toString());
        Double l4 = Double.parseDouble(params.get("l4").toString());
        Double l5 = Double.parseDouble(params.get("l5").toString());
        Map<String,Object> data = new HashMap<>();
        if(month>=4 && month<=6){
            season = "夏季";
            Fo = (Ho*l0)/1000*l1;
        }else if(month>=10 && month<=12){
            season = "冬季";
            Fo = (Ho*l2)/1000*l3;
        }else{
            Fo = (Ho*l4)/1000*l5;
        }
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("foodSubsidy",Fo);
        this.tModelReliefGoodsService.addFoodSubsidy(data);
        params.clear();
        data.clear();
    }
    //计算棉被模型

    /**
     *
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param Ho 无家可归人数
     */
    public void calcQuiltModel(String townName,String earthquakeFeatId,Integer Ho){
        String modelType = "棉被";
        String season = "";
        Calendar calendar = Calendar.getInstance();
        Integer month = calendar.get(Calendar.MONTH)+1;
        Double Quilt = 0.0;
        Map<String,Object> params = this.tModelReliefGoodsService.getModelParamsByType(modelType);
        Double l0 = Double.parseDouble(params.get("l0").toString());
        Double l1 = Double.parseDouble(params.get("l1").toString());
        Double l2 = Double.parseDouble(params.get("l2").toString());
        Map<String,Object> data = new HashMap<>();
        if(month>=4 && month<=6){
            season = "夏季";
            Quilt = Ho*l0;
        }else if(month>=10 && month<=12){
            season = "冬季";
            Quilt = Ho*l1;
        }else{
            Quilt = Ho*l2;
        }
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("quiltDemand",Quilt);
        this.tModelReliefGoodsService.addQuiltDemand(data);
        params.clear();
        data.clear();
    }

    //计算应急清洁饮水模型
    /**
     *
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param Ho 无家可归人数
     */
    public void calcWaterModel(String townName,String earthquakeFeatId,Integer Ho){
        String modelType = "应急清洁饮水";
        Map<String,Object> params = this.tModelReliefGoodsService.getModelParamsByType(modelType);
        Double l0 = Double.parseDouble(params.get("l0").toString());
        Double l1 = Double.parseDouble(params.get("l1").toString());
        Map<String,Object> data = new HashMap<>();
        Double Water = (Ho*l0)/1000*l1;
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("emergencyWater",Water);
        this.tModelReliefGoodsService.addWaterDemand(data);
        params.clear();
        data.clear();
    }
    //计算衣服模型
    /**
     *
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param Ho 无家可归人数
     */
    public void calcClothingModel(String townName,String earthquakeFeatId,Integer Ho){
        String modelType = "衣服";
        Map<String,Object> params = this.tModelReliefGoodsService.getModelParamsByType(modelType);
        Double l0 = Double.parseDouble(params.get("l0").toString());
        Map<String,Object> data = new HashMap<>();
        Double Clothing = (Ho*l0)/1000*l0;
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("clothingDemand",Clothing);
        this.tModelReliefGoodsService.addClothingDemand(data);
        params.clear();
        data.clear();
    }

    //计算毛毯模型

    /**
     *
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param Ho 无家可归人数
     */
    public void calcBlanketModel(String townName,String earthquakeFeatId,Integer Ho){
        String modelType = "毛毯";
        String season = "";
        Calendar calendar = Calendar.getInstance();
        Integer month = calendar.get(Calendar.MONTH)+1;
        Double Blanket = 0.0;
        Map<String,Object> params = this.tModelReliefGoodsService.getModelParamsByType(modelType);
        Double l0 = Double.parseDouble(params.get("l0").toString());
        Double l1 = Double.parseDouble(params.get("l1").toString());
        Double l2 = Double.parseDouble(params.get("l2").toString());
        Map<String,Object> data = new HashMap<>();
        if(month>=4 && month<=6){
            season = "夏季";
            Blanket = Ho*l0;
        }else if(month>=10 && month<=12){
            season = "冬季";
            Blanket = Ho*l1;
        }else{
            Blanket = Ho*l2;
        }
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("blanketDemand",Blanket);
        this.tModelReliefGoodsService.addBlanketDemand(data);
        params.clear();
        data.clear();
    }
    //计算担架模型
    /**
     *
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param ln 受伤人数
     */
    public void calcStretcherModel(String townName,String earthquakeFeatId,Integer ln){
        String modelType = "担架";
        Map<String,Object> params = this.tModelReliefGoodsService.getModelParamsByType(modelType);
        Double l0 = Double.parseDouble(params.get("l0").toString());
        Map<String,Object> data = new HashMap<>();
        Double Lit = ln*l0;
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("stretcherDemand",Lit);
        this.tModelReliefGoodsService.addstretcherDemand(data);
        params.clear();
        data.clear();
    }

    //计算病床模型
    /**
     *
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param ln 受伤人数
     */
    public void calcWardModel(String townName,String earthquakeFeatId,Integer ln){
        String modelType = "病床";
        Map<String,Object> params = this.tModelReliefGoodsService.getModelParamsByType(modelType);
        Double l0 = Double.parseDouble(params.get("l0").toString());
        Map<String,Object> data = new HashMap<>();
        Double Ward = ln*l0;
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("wardDemand",Ward);
        params.clear();
        data.clear();
    }
    //计算应急救灾款模型
    /**
     *
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param RePop 受灾人数
     */
    public void calcYJJZKModel(String townName,String earthquakeFeatId,Integer RePop){
        String modelType = "应急救灾款";
        Map<String,Object> params = this.tModelReliefGoodsService.getModelParamsByType(modelType);
        Double l0 = Double.parseDouble(params.get("l0").toString());
        Double l1 = Double.parseDouble(params.get("l1").toString());
        Map<String,Object> data = new HashMap<>();
        Double ReMo = RePop*l0+l1;
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("wardDemand",ReMo);
        params.clear();
        data.clear();
    }
    //计算临时厕所模型
    /**
     *
     * @param townName 乡镇名称
     * @param earthquakeFeatId 地震id
     * @param Ho 无家可归人数
     */
    public void calcToiletModel(String townName,String earthquakeFeatId,Integer Ho){
        String modelType = "临时厕所";
        Map<String,Object> params = this.tModelReliefGoodsService.getModelParamsByType(modelType);
        Double l0 = Double.parseDouble(params.get("l0").toString());
        Map<String,Object> data = new HashMap<>();
        Double Toilet =Ho*l0;
        data.put("townName",townName);
        data.put("earthquakeFeatId",earthquakeFeatId);
        data.put("temporaryToilet",Toilet);
        this.tModelReliefGoodsService.addTemporaryToiletDemand(data);
        params.clear();
        data.clear();
    }
    public static void main(String[] args) {
        double result = Math.pow(2,4);
        Calendar calendar = Calendar.getInstance();
        Integer month = calendar.get(Calendar.MONTH)+1;
        System.out.println(month);
    }
}
