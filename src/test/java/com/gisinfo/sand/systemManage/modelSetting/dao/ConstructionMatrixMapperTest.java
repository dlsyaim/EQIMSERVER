package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.gisinfo.sand.SandApplication;
import com.gisinfo.sand.commonData.bean.EqTownBuilding;
import com.gisinfo.sand.systemManage.modelSetting.bean.TModelBuilding;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SandApplication.class)
public class ConstructionMatrixMapperTest {

    @Autowired
    private ConstructionMatrixMapper constructionMatrixMapper;

    @Test
    public void selectTownBuilding() {
        List<EqTownBuilding> eqTownBuildings = constructionMatrixMapper.selectTownBuilding();
    }

    @Test
    public void selectTModelBuilding() {
        List<TModelBuilding> eqTownBuildings = constructionMatrixMapper.selectTModelBuildings();
    }

    /**
     * 处理建筑易损性矩阵
     * 数据格式：<地震烈度，<建筑类型，易损性值>>
     */
    @Test
    public void test01() {
//        List<TModelBuilding> tModelBuildings = constructionMatrixMapper.selectDefaultYSXJZ();
//        HashMap<Integer, Map<String,Double>> map = new HashMap<>();
//        for (TModelBuilding tModelBuilding : tModelBuildings) {
//            String buildingType = tModelBuilding.getBuildingType();
//            Integer i = tModelBuilding.getI();
//            Double d = tModelBuilding.getD();
//            Map<String, Double> stringDoubleMap = map.get(i);
//            if (stringDoubleMap == null) {
//                stringDoubleMap = new HashedMap();
//                map.put(i, stringDoubleMap);
//            }
//            stringDoubleMap.put(buildingType, d);
//        }
    }
}
