//package com.gisinfo.sand.systemManage.modelSetting.service;
//
//
//import com.gisinfo.sand.SandApplication;
//import com.gisinfo.sand.systemManage.modelSetting.bean.TEarthquakeDetail;
//import org.apache.commons.lang3.StringUtils;
//import org.aspectj.weaver.ast.Var;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//import java.util.Map;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = SandApplication.class)
//public class CalcModelServiceTest {
//
//    @Autowired
//    private CalcModelService calcModelService;
//
//    @Test
//    public void getDeathCount() {
//        Map<String, Map<Integer, Double>> townEffectedArea = calcModelService.getTownEffectedArea("123456");
//        List<TEarthquakeDetail> deathCount = calcModelService.getDeathCount("123456", townEffectedArea);
//
//    }
//
//    @Test
//    public void XYDJTest() {
//        Map<String, Map<Integer, Double>> townEffectedArea = calcModelService.getTownEffectedArea("1d610ba8593142859738093b2b8b0444");
//        String responseLevel = calcModelService.getResponseLevel("1d610ba8593142859738093b2b8b0444", townEffectedArea);
//        System.out.println(responseLevel);
//    }
//
//    @Test
//    public void test02() {
//        Map<String, Map<Integer, Double>> townEffectedArea = calcModelService.getTownEffectedArea("1d610ba8593142859738093b2b8b0444");
//        List<TEarthquakeDetail> deathCount = calcModelService.getDeathCount("1d610ba8593142859738093b2b8b0444", townEffectedArea);
//        calcModelService.getInjuredCount(deathCount, townEffectedArea, "1d610ba8593142859738093b2b8b0444");
//    }
//}
