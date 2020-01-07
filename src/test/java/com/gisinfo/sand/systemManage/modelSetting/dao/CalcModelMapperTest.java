package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.gisinfo.sand.SandApplication;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SandApplication.class)
public class CalcModelMapperTest {

    @Autowired
    private CalcModelMapper calcModelMapper;

    /**
     * 获取街镇受影响的面积
     */
    @Test
    public void getTownEffectedArea() {
        List<Map<String, Object>> townEffectedArea = calcModelMapper.getTownEffectedArea("1d610ba8593142859738093b2b8b0888");
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
    }

    @Test
    public void test01() {
        double d = 4.2;
        double v = d / 2;
        System.out.println(v);
        int d1 = (int) d;
        System.out.println(d1);
        double v1 = d % 1;
        System.out.println(v1);
    }
}
