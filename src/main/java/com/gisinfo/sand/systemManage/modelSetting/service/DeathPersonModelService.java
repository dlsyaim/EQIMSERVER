package com.gisinfo.sand.systemManage.modelSetting.service;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.commonData.bean.EqTownBuilding;
import com.gisinfo.sand.systemManage.modelSetting.bean.DeathPersonModel;
import com.gisinfo.sand.systemManage.modelSetting.bean.TEarthquakeDetail;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelBuilding;
import com.gisinfo.sand.systemManage.modelSetting.dao.CalcModelMapper;
import com.gisinfo.sand.systemManage.modelSetting.dao.ConstructionMatrixMapper;
import com.gisinfo.sand.systemManage.modelSetting.dao.DeathPersonModelMapper;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.crypto.hash.Hash;
import org.aspectj.weaver.ast.Var;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DeathPersonModelService extends ServiceImpl<DeathPersonModelMapper, DeathPersonModel> {

    @Autowired(required = false)
    private DeathPersonModelMapper deathPersonMapper;

    @Autowired
    private CalcModelMapper calcModelMapper;

    @Autowired
    private ConstructionMatrixMapper constructionMatrixMapper;

    private static final double A = 0.05; //评估区域房屋毁坏比
    private static final int M = 15000;  //评估区域总人口数


    public List<DeathPersonModel> listDeath(DeathPersonModel deathPersonModel) {
        return this.deathPersonMapper.getListDeathModel(deathPersonModel);
    }

    public Map<String,Object> getListCount(){
        return this.deathPersonMapper.getCount();
    }

    public DeathPersonModel getById(String featId) {
        return this.deathPersonMapper.getDeathFeatId(featId);
    }

    @Transactional
    public Integer addDeathData(DeathPersonModel deathPersonModel) {
        Date day = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTimes = df.format(System.currentTimeMillis());
        if (deathPersonModel.getFeatId() == null || deathPersonModel.getFeatId() == "") {
            deathPersonModel.setFeatId(IdUtil.simpleUUID());
            deathPersonModel.setFormula("死亡人员");
            deathPersonModel.setModelVersion("1.0");
            deathPersonModel.setUpdatedBy("admin");
            deathPersonModel.setCreatedBy("admin");
            deathPersonModel.setUpdateTime(createTimes);
            deathPersonModel.setCreateTime(createTimes);

        }
        System.out.println(deathPersonModel.getCreateTime());
        System.out.println(deathPersonModel.getParamName());
        return this.deathPersonMapper.addDeath(deathPersonModel);
    }

    @Transactional
    public void deleteById(String featId) {
        this.deathPersonMapper.deleteDeath(featId);
    }

    public static void main(String[] args) {
        DeathPersonModelService service = new DeathPersonModelService();
//        final Integer rescueWorker = service.getRescueWorker();
//        System.out.println(rescueWorker);
//        final Double food = service.getFood();
//        System.out.println(food);
//        System.out.println(Math.pow(10,3));
//        System.out.println(Math.log10(7.05));
//        System.out.println(Math.pow(10,2));
    }


    public Integer getResultByFeatId(String featId) {//死亡人员公式计算方法
        Double Nd = 0.0;
        DeathPersonModel personModel = this.getById(featId);
       // String featId1 = personModel.getFeatId();
        Double l0 = personModel.getL0();
        Double l1 = personModel.getL1();
        Double l2 = personModel.getL2();
        Double logRd = 0.0;
        Double Rd = 0.0;
        Double pow = Math.pow(A, l1);
        logRd = l0 * pow + l2;
        Rd = Math.pow(10, logRd);
        //double log10 = Math.log10(logRd);
        //System.out.println(log10);
        Nd = Rd * M;
        Integer Nds = Math.toIntExact(Math.round(Nd));
        if (Nds < 0) {
            Nds = 0;
        }
        //System.out.println(featId1+"||||||||||||||||"+l0+"////////"+l1+"???????????"+l2);
        return Nds;
    }


    public Integer getRescueWorker() {//救援人员
        Double Re = 0.0;
        Integer Di = 15000;
        Double l0 = 0.09;
        Double l1 = 0.0075;
        Double l2 = 0.04;
        Double Ms = 6.3;
        if (5 <= Ms || Ms < 6) {
            Re = Di * l0;
        } else if (6 <= Ms || Ms < 7) {
            Re = Di * l1;
        } else if (6 <= Ms || Ms < 7) {
            Re = Di * l2;
        }
        Integer Res = Math.toIntExact(Math.round(Re));
        return Res;
    }


    public Integer getDeathRescueWorker() {//死亡救援人员
        String featId = "a36b0e4402924b208ba5ea6201708da7";
        Integer De = getResultByFeatId(featId);
        Double l0 = 3.44;
        Double l1 = 4.57;
        Double l2 = 500.0;
        Double l3 = 311.73;
        Double l4 = 0.5414;
        Double l5 = 261.72;
        Double l6 = 0.4943;
        Double Re = 0.0;
        if (0 < De || De < 100) {
            Re = l1 * De + l2;
        } else if (100 <= De || De < 1000) {
            Double p = Math.pow(De, l4);
            Re = l3 * p;
        } else if (1000 <= De) {
            Double f = Math.pow(De, l6);
            Re = l5 * f;
        }
        System.out.println(De);
        Integer Rep = Math.toIntExact(Math.round(Re));
        return Rep;
    }

    public Integer getDoctor(){//获取医务人员
        Double dr=0.0;
        Double l0=0.08;
        Double l1=0.55;
        Double l2=0.0;
        Integer In=80;
        Integer de=3;
        Integer re=1;

        dr=l0*re;
        if(de <=10000){
            dr=l0*In;
        }else if (de > 10000){
            Double d = Math.pow(de, l2);
            dr=l1*d;
        }
        Integer drs = Math.toIntExact(Math.round(dr));
        return drs;
    }

    public Integer getEpWorker() {//防疫人员
        String featId = "a36b0e4402924b208ba5ea6201708da7";
        Integer De = getResultByFeatId(featId);
        Double l0 = 0.1;
        Double l1 = 10.0;
        Double l2 = 0.1;
        Double l3 = 0.06;
        Double EpiPer = 0.0;
        if (1 < De || De <= 200) {
            EpiPer = De * l0 + l1;
        } else if (200 <= De || De < 1000) {
            EpiPer = De * l2;
        } else if (1000 <= De) {
            EpiPer = De * l3;
        }
        System.out.println(EpiPer);
        Integer Epi = Math.toIntExact(Math.round(EpiPer));
        return Epi;
    }

    public Integer getTent() {//获取帐篷数量
        Integer Ho = 1000;
        Double tent = 0.0;
        Double l0 = 0.1;
        Double l1 = 1.0;
        Double l2 = 0.1;
        Double l3 = 2.0;
        Integer season = 2;

        if (season == 2) {
            tent = Ho * l0 * l1;
        } else if (season == 4) {
            tent = Ho * l2 * l3;
        }
        Integer tents = Math.toIntExact(Math.round(tent));

        return tents;
    }

    public Double getFood() {//粮食
        Integer Ho = 1000;
        Double food = 0.0;
        Double l0 = 0.5;
        Double l1 = 10.0;
        Double l2 = 1.0;
        Double l3 = 10.0;
        Double l4 = 0.7;
        Double l5 = 10.0;
        Integer season = 2;

        if (season == 2) {
            food = (Ho * l0) / 1000 * l1;
        } else if (season == 4) {
            food = (Ho * l2) / 1000 * l3;
        } else if (season == 3) {
            food = (Ho * l4) / 1000 * l5;
        }
        return food;
    }

    public Integer getQuilt() {//棉被
        Integer Ho = 1000;
        Double quilt = 0.0;
        Double l0 = 0.1;
        Double l1 = 1.0;
        Double l2 = 0.5;
        Integer season = 2;
        if (season == 2) {
            quilt = Ho * l0;
        } else if (season == 4) {
            quilt = Ho * l2;
        } else if (season == 3) {
            quilt = Ho * l1;
        }
        Integer quilts = Math.toIntExact(Math.round(quilt));
        return quilts;
    }


    public Double getWater() {//饮用水
        Integer Ho = 1000;
        Double quilt = 0.0;
        Double l0 = 5.0;
        Double l1 = 1.0;
        quilt = (Ho * l0) / 1000 * l1;
        return quilt;
    }

    public Integer getCloth() {//衣服
        Integer Ho = 1000;
        Double clothing = 0.0;
        Double l0 = 2.0;
        clothing = Ho * l0;
        Integer cloths = Math.toIntExact(Math.round(clothing));
        return cloths;
    }


    public Integer getBlanket() {//毛毯
        Integer Ho = 1000;
        Double blanket = 0.0;
        Double l0 = 2.0;
        Double l1 = 1.1;
        Double l2 = 0.6;
        Integer season = 2;
        if (season == 2) {
            blanket = Ho * l0;
        } else if (season == 4) {
            blanket = Ho * l2;
        } else if (season == 3) {
            blanket = Ho * l1;
        }
        Integer blankets = Math.toIntExact(Math.round(blanket));
        return blankets;
    }

    public Integer getLit() {//担架
        Double In = 5.0;
        Double lit = 0.0;
        Double l0 = 0.5;
        lit = In * l0;
        Integer stretcher = Math.toIntExact(Math.round(lit));
        return stretcher;
    }

    public Integer getWard() {//病床
        Double In = 5.0;
        Double ward = 0.0;
        Double l0 = 0.5;
        ward = In * l0;
        Integer wards = Math.toIntExact(Math.round(ward));
        return wards;
    }

    public Double getDeMo() {//救灾款
        Integer RePop = 1500;
        Double l0 = 10.0;
        Double l1 = 5.0;
        Double DeMo = 0.0;
        DeMo = l0 * RePop + l1;
        return DeMo;
    }

    public Integer getToilet() {//临时厕所
        Integer Ho = 1000;
        Double l0 = 250.0;
        Double toilet = 0.0;
        toilet = Ho / l0;
        Integer toilets = Math.toIntExact(Math.round(toilet));
        return toilets;
    }

    /**
     * 算出A,存到earthquakeDetail中
     * @param methodName
     * @param
     * @param tEarthquakeDetailList
     */
    public void getAMethod(String methodName,List<TEarthquakeDetail> tEarthquakeDetailList,Map<String,Map<Integer,Double>> scale) {

        if (methodName.equals("method01")) {
            for (TEarthquakeDetail tEarthquakeDetail : tEarthquakeDetailList) {
                if (tEarthquakeDetail.getTownTotalArea() != null) {
                    String townName = tEarthquakeDetail.getTownName();
                    Double damageArea = tEarthquakeDetail.getStructureD();
                    double A = 0;
                    try {
                        A = damageArea / tEarthquakeDetail.getTownTotalArea();
                    } catch (Exception e) {
//                        e.printStackTrace();
                    }
                    tEarthquakeDetail.setA(A);
                }
            }
        } else {
            //按方法二进行进行计算
//            ∑(易损性矩阵 * 建筑破坏比 * 某一建筑类型面积 * 某一烈度面积)/(街镇总面积 * 街镇总面积)
            List<EqTownBuilding> eqTownBuildings = constructionMatrixMapper.selectTownBuilding();
            //各街镇各建筑类型面积
            HashMap<String, EqTownBuilding> townAffectArea = new HashMap<>();
            for (EqTownBuilding eqTownBuilding : eqTownBuildings) {
                String name = eqTownBuilding.getName();
                townAffectArea.put(name, eqTownBuilding);
            }
            for (TEarthquakeDetail tEarthquakeDetail : tEarthquakeDetailList) {
                if (tEarthquakeDetail.getTownTotalArea() != null) {
                    String townName = tEarthquakeDetail.getTownName();
                    //各烈度各建筑类型易损性值
                    //地震烈度，建筑类型，易损性值
                    HashMap<Integer, Map<String, Double>> ysxjz = dealDamagedYSXJZ();
                    //建筑类型，破坏比值
                    HashMap<String, Double> jzphb = dealDamagedJZPHB();
                    Map<Integer, Double> scaleMap = scale.get(townName);
                    Double townTotalArea = tEarthquakeDetail.getTownTotalArea();
                    EqTownBuilding eqTownBuilding = townAffectArea.get(townName);
                    double AResult = 0;
                    if (MapUtils.isNotEmpty(scaleMap)) {
                        for (Map.Entry<Integer, Double> entry : scaleMap.entrySet()) {
                            Integer scaleValue = entry.getKey();
                            scaleValue = scaleValue <= 6 ? 6 : scaleValue;
                            Double scaleArea = entry.getValue();
                            //建筑类型，易损性矩阵
                            Map<String, Double> buildTypeYSXJZ = ysxjz.get(scaleValue);
                            //1,计算多层砌体
                            Double DCQRResult = 0.0;
                            try {
                                Double DCQTArea = eqTownBuilding.getBrickStructure();
                                Double DCQTJzphb = jzphb.get("多层砌体");
                                Double DCQTYsxjz = buildTypeYSXJZ.get("多层砌体");
                                DCQRResult = DCQTArea * DCQTJzphb *DCQTYsxjz;
                            } catch (Exception e) {
//                                e.printStackTrace();
                            }
//                        2.高层建筑
                            double GCJZResult = 0;
                            try {
                                Double GCJZArea = eqTownBuilding.getHighRise();
                                Double GCJZJzphb = jzphb.get("高层建筑");
                                Double GCJZYsxjz = buildTypeYSXJZ.get("高层建筑");
                                GCJZResult = GCJZArea * GCJZJzphb * GCJZYsxjz;
                            } catch (Exception e) {
//                                e.printStackTrace();
                            }
//                      3.单层厂房
                            double DCCFResult = 0;
                            try {
                                Double DCCFArea = eqTownBuilding.getSingleArea();
                                Double DCCFJzphb = jzphb.get("单层厂房");
                                Double DCCFYsxjz = buildTypeYSXJZ.get("单层厂房");
                                DCCFResult = DCCFArea * DCCFJzphb * DCCFYsxjz;
                            } catch (Exception e) {
//                                e.printStackTrace();
                            }
//                        4.钢筋混凝
                            double GJHNResult = 0;
                            try {
                                Double GJHNArea = eqTownBuilding.getRcframe();
                                Double GJHNJzphb = jzphb.get("钢筋混凝");
                                Double GJHNYsxjz = buildTypeYSXJZ.get("钢筋混凝");
                                GJHNResult = GJHNArea * GJHNJzphb * GJHNYsxjz;
                            } catch (Exception e) {
//                                e.printStackTrace();
                            }
//                        5.老旧民房
                            double LJMFResult = 0;
                            try {
                                Double LJMFArea = eqTownBuilding.getOtherStructure();
                                Double LJMFJzphb = jzphb.get("老旧民房");
                                Double LJMFYsxjz = buildTypeYSXJZ.get("老旧民房");
                                LJMFResult = LJMFArea * LJMFJzphb * LJMFYsxjz;
                            } catch (Exception e) {
//                                e.printStackTrace();
                            }
                            try {
                                AResult += (DCQRResult + GCJZResult + DCCFResult + GJHNResult + LJMFResult) * scaleArea / townTotalArea / 100 / 100;
                            } catch (Exception e) {
//                                e.printStackTrace();
                            }
                        }
                    }
                    try {
                        AResult /= townTotalArea;
                    } catch (Exception e) {
                        AResult = 0;
//                        e.printStackTrace();
                    }
                    tEarthquakeDetail.setA(AResult);
                }
            }
        }
    }

    public void getDeathNum(DeathPersonModel personModel,List<TEarthquakeDetail> tEarthquakeDetailList) {
        for (TEarthquakeDetail tEarthquakeDetail : tEarthquakeDetailList) {
            Double A = tEarthquakeDetail.getA();
            Integer townTotalPopulation = tEarthquakeDetail.getTownPopulation();
            if (A != null && townTotalPopulation != null) {
                Double Nd = 0.0;
                Double l0 = personModel.getL0();
                Double l1 = personModel.getL1();
                Double l2 = personModel.getL2();
                Double logRd = 0.0;
                Double Rd = 0.0;
                Double pow = Math.pow(A, l1);
                logRd = l0 * pow + l2;
                Rd = Math.pow(10, logRd);
                Nd = Rd * townTotalPopulation;
                Integer Nds = 0;
                try {
                    Nds = Math.toIntExact(Math.round(Nd));
                } catch (Exception e) {
//                    e.printStackTrace();
                }
                if (Nds < 0) {
                    Nds = 0;
                }
                tEarthquakeDetail.setDeathNumber(Nds);
            }
        }
    }


    /**
     * 获取街镇受影响的面积
     *
     */
    public Map<String, Map<Integer, Double>> getTownEffectedArea(String earthquakeid) {
        List<Map<String, Object>> townEffectedArea = calcModelMapper.getTownEffectedArea(earthquakeid);
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

    /**
     * 处理建筑易损性矩阵
     * 数据格式：<地震烈度，<建筑类型，易损性值>>
     */
    public HashMap<Integer, Map<String,Double>> dealDamagedYSXJZ() {
        List<TModelBuilding> tModelBuildings = constructionMatrixMapper.selectMaxVersionYSXJZ();
        HashMap<Integer, Map<String,Double>> map = new HashMap<>();
        for (TModelBuilding tModelBuilding : tModelBuildings) {
            String buildingType = tModelBuilding.getBuildingType();
            Integer i = tModelBuilding.getI();
            Double d = tModelBuilding.getD();
            Map<String, Double> stringDoubleMap = map.get(i);
            if (stringDoubleMap == null) {
                stringDoubleMap = new HashedMap();
                map.put(i, stringDoubleMap);
            }
            stringDoubleMap.put(buildingType, d);
        }
        return map;
    }

    /**
     * 处理建筑破坏比
     * @return 返回数据格式<建筑类型，建筑破坏比毁坏值>
     */
    public HashMap<String, Double> dealDamagedJZPHB() {
        List<TModelBuilding> tModelBuildings = constructionMatrixMapper.selectMaxVersionJZPHB();
        HashMap<String, Double> jzphbMap = new HashMap<>();
        for (TModelBuilding tModelBuilding : tModelBuildings) {
            String buildingType = tModelBuilding.getBuildingType();
            Double d = tModelBuilding.getD();
            jzphbMap.put(buildingType, d);
        }
        return jzphbMap;
    }
}
