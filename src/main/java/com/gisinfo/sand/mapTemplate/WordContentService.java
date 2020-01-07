package com.gisinfo.sand.mapTemplate;

import com.gisinfo.sand.commonData.bean.EqEconomy;
import com.gisinfo.sand.core.web.SandContext;
import com.gisinfo.sand.mapTemplate.bean.*;
import com.gisinfo.sand.mapTemplate.service.DataService;
import com.gisinfo.sand.mapTemplate.wordUtil.CustomXWPFDocument;
import com.gisinfo.sand.mapTemplate.wordUtil.WordUtil;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WordContentService {
    //震区房屋统计
    private static String zqwftjText =
            SandContext.getValueFromGroup("MapTemplate", "get", "zqwftj");

    //地震背景信息
    private static String dzbjxxText =
            SandContext.getValueFromGroup("MapTemplate", "get", "dzbjxx");

    //震区人口信息
    private static String zqrkxxText =
            SandContext.getValueFromGroup("MapTemplate", "get", "zqrkxx");

    //重点目标信息
    private static String zdmbxxText =
                SandContext.getValueFromGroup("MapTemplate", "get", "zdmbxx");

    //震中空间距离分布
    private static String zzkjjlfbText =
                SandContext.getValueFromGroup("MapTemplate", "get", "zzkjjlfb");

    //震区经济信息
    private static String zqjjxxText =
                SandContext.getValueFromGroup("MapTemplate", "get", "zqjjxx");

    //模板文本路径
    private static String contentText =
            SandContext.getValueFromGroup("MapTemplate", "get", "contentText");

    //时间格式
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");

    @Autowired
    private DataService DataService;


    //<<<<<<<<<<<<<<<<<<<<<<<<<<text-Content<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public void textContent(CustomXWPFDocument document2, String wordName,String dzsjId) {
        if (wordName.equals(zqwftjText)) {//震区房屋统计
            zqfwtjContent(document2,dzsjId);
        } else if (wordName.equals(dzbjxxText)) {//地震背景信息
            dzbjxxContent(document2,dzsjId);
        }else if (wordName.equals(zqrkxxText)) {//震区人口信息
            zqrkxxContent(document2,dzsjId);
        }else if (wordName.equals(zdmbxxText)) {//重点目标信息
            zdmbxxContent(document2,dzsjId);
        }else if (wordName.equals(zzkjjlfbText)) {//震中空间距离分布
            zzkjjlfbContent(document2,dzsjId);
        }else if (wordName.equals(zqjjxxText)) {//震区经济信息
            zqjjxxContent(document2,dzsjId);
        }
    }

    //震区房屋统计
    public void zqfwtjContent(CustomXWPFDocument document2,String dzsjId) {
//        据中国地震台网测定，北京时间${time}，在${wz}（北纬${y}度，东经${x}度）发生${dzjb}级地震，
//        震源深度约${zysd}公里。地震烈度${ldjb}度区波及上海${yxqx}个区县，其建筑物总面积为${sumMj}万平方米，
//        其中高层结构建筑面积占${gcjgMj}%，多层砖混结构建筑面积占${zhjgMj}%，多层砌体结构建筑面积占${qtjgMj}%，
//        老旧民宅结构建筑面积占${ljmzjgMj}%；震中所在的${name_q}建筑物总面积${sumMj_q}万平方米，
//        其中高层结构建筑面积占${gcjgMj_q}%，多层砖混结构建筑面积占${zhjgMj_q}%，多层砌体结构建筑面积占${qtjgMj_q}%，
//        老旧民宅结构建筑面积占${ljmzjgMj_q}%；震中所在的${name_jd}建筑物总面积为${sumMj_jd}万平方米，
//        其中高层结构建筑面积占${gcjgMj_jd}%，多层砖混结构建筑面积占${zhjgMj_jd}%，
//        多层砌体结构建筑面积占${qtjgMj_jd}%，老旧民宅结构建筑面积占${ljmzjgMj_jd}%。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        List<DzsjBean> getQueryDzsj = this.DataService.getQueryDzsj(dzsjId);
        List<Map> getQueryAnalysisTown = this.DataService.getQueryAnalysisTown(dzsjId);
        List<Map> getQueryCountyBuild = this.DataService.getQueryCountyBuild(dzsjId);
        List<Map> getQueryTownBuild = this.DataService.getQueryTownBuild(dzsjId);
        String names = "xxx";//标题名
        String time = "xxx";//时间
        String wz = "xxx";//位置
        String x = "xxx";//x
        String y = "xxx";//y
        Double dzjb = Double.valueOf(0);//地震级别
        Double zysd = Double.valueOf(0);//震源深度
        Object yxqx = "xxx";//影响区县
        Object sumMj = "xxx";//总面积
        Object gcjgMj = "xxx";//高层结构面积
        Object zhjgMj = "xxx";//砖混结构面积
        Object qtjgMj = "xxx";//砌体结构面积
        Object ljmzjgMj = "xxx";//老旧民宅结构面积
        Object name_q = "xxx";//区名称
        Object sumMj_q = "xxx";//总面积-区
        Object gcjgMj_q = "xxx";//高层结构面积-区
        Object zhjgMj_q = "xxx";//砖混结构面积-区
        Object qtjgMj_q = "xxx";//砌体结构面积-区
        Object ljmzjgMj_q = "xxx";//老旧民宅结构面积-区
        Object name_jd = "xxx";//街道名称
        Object sumMj_jd = "xxx";//总面积-街道
        Object gcjgMj_jd = "xxx";//高层结构面积-街道
        Object zhjgMj_jd = "xxx";//砖混结构面积-街道
        Object qtjgMj_jd = "xxx";//砌体结构面积-街道
        Object ljmzjgMj_jd = "xxx";//老旧民宅结构面积-街道
        if (getQueryDzsj.get(0) != null &&getQueryDzsj.size()>0){
            names =getQueryDzsj.get(0).getEarthquakeName();//标题名
            time = sdf.format(getQueryDzsj.get(0).getEarthquakeTime());//时间
            wz = getQueryDzsj.get(0).getEarthquakeLocation();//位置
            x = getQueryDzsj.get(0).getLongitude();//x
            y = getQueryDzsj.get(0).getLatitude();//y
            dzjb = getQueryDzsj.get(0).getEarthquakeLevel();//地震级别
            zysd = getQueryDzsj.get(0).getFocalDepth();//震源深度
        }
        if (getQueryAnalysisTown.get(0) != null&&getQueryAnalysisTown.size()>0){
            yxqx = getQueryAnalysisTown.get(0).get("cnames");//影响区县
            sumMj = getQueryAnalysisTown.get(0).get("zmj");//总面积
            gcjgMj = getQueryAnalysisTown.get(0).get("gcjz");//高层结构面积
            zhjgMj = getQueryAnalysisTown.get(0).get("dczh");//砖混结构面积
            qtjgMj = getQueryAnalysisTown.get(0).get("dcpt");//砌体结构面积
            ljmzjgMj = getQueryAnalysisTown.get(0).get("dcmz");//老旧民宅结构面积
        }
        if (getQueryCountyBuild.size()>0){
            name_q = getQueryCountyBuild.get(0).get("cnames");//区名称
            sumMj_q = getQueryCountyBuild.get(0).get("zmj");//总面积-区
            gcjgMj_q = getQueryCountyBuild.get(0).get("gcjz");//高层结构面积-区
            zhjgMj_q = getQueryCountyBuild.get(0).get("dczh");//砖混结构面积-区
            qtjgMj_q = getQueryCountyBuild.get(0).get("dcpt");//砌体结构面积-区
            ljmzjgMj_q = getQueryCountyBuild.get(0).get("dcmz");//老旧民宅结构面积-区
        }
        if (getQueryTownBuild.get(0) != null){
            name_jd = getQueryTownBuild.get(0).get("cnames");//街道名称
            sumMj_jd = getQueryTownBuild.get(0).get("zmj");//总面积-街道
            gcjgMj_jd = getQueryTownBuild.get(0).get("gcjz");//高层结构面积-街道
            zhjgMj_jd = getQueryTownBuild.get(0).get("dczh");//砖混结构面积-街道
            qtjgMj_jd = getQueryTownBuild.get(0).get("dcpt");//砌体结构面积-街道
            ljmzjgMj_jd = getQueryTownBuild.get(0).get("dcmz");//老旧民宅结构面积-街道
        }
        //模板引擎
        FileResourceLoader resourceLoader = new FileResourceLoader(contentText, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("\\震区房屋统计.txt");
        t.binding("time", time);
        t.binding("wz", wz);
        t.binding("x", x);
        t.binding("y", y);
        t.binding("dzjb", dzjb);
        t.binding("zysd", zysd);
        t.binding("yxqx", yxqx);
        t.binding("sumMj", sumMj);
        t.binding("gcjgMj", gcjgMj);
        t.binding("zhjgMj", zhjgMj);
        t.binding("qtjgMj", qtjgMj);
        t.binding("ljmzjgMj", ljmzjgMj);
        t.binding("name_q", name_q);
        t.binding("sumMj_q", sumMj_q);
        t.binding("gcjgMj_q", gcjgMj_q);
        t.binding("zhjgMj_q", zhjgMj_q);
        t.binding("qtjgMj_q", qtjgMj_q);
        t.binding("ljmzjgMj_q", ljmzjgMj_q);
        t.binding("name_jd", name_jd);
        t.binding("sumMj_jd", sumMj_jd);
        t.binding("gcjgMj_jd", gcjgMj_jd);
        t.binding("zhjgMj_jd", zhjgMj_jd);
        t.binding("qtjgMj_jd", qtjgMj_jd);
        t.binding("ljmzjgMj_jd", ljmzjgMj_jd);
        String zqfwtjContentText = t.render();//文本内容
        Map<String, Object> param = new HashMap<String, Object>();//${zqfwtjContentText}
        param.put("${zqfwtjContentText}", zqfwtjContentText);
        param.put("${title}",names);//标题
        List<XWPFParagraph> paragraphList = document2.getParagraphs();
        WordUtil.processParagraphs(paragraphList, param, document2);//扫描段落进行变量处理
    }

    //震区背景信息
    public void dzbjxxContent(CustomXWPFDocument document2,String dzsjId) {
//      中国地震台网测定,北京时间${time},在${wz}(北纬${y}度,东经${x}度)发生${dzjb}级地震,震源深度约${zysd}公里。
//      震中50公里范围内发生2.5级及以上的地震共${dzcs}次,其中,震级最大地震是${zddz}级,距离最近的地震是${zjdz}级。  需要计算！！！！！！
//      地震发生在${zjwz}附近,该断裂性质是${dlxz}, 呈${cxzx}走向。
        List<DzsjBean> getQueryDzsj = this.DataService.getQueryDzsj(dzsjId);
        List<ActivefaultBean> getQueryActivefaultId = this.DataService.getQueryActivefaultId(dzsjId);
        String names = "xxx";//标题名
        String time = "xxx";//时间
        String wz = "xxx";//位置
        String x = "xxx";//x
        String y = "xxx";//y
        Double dzjb = Double.valueOf(0);//地震级别
        Double zysd = Double.valueOf(0);//震源深度
        String dzcs = "xxx";//2.5级及以上的地震
        String zddz = "xxx";//最大地震
        String zjdz = "xxx";//最近的地震
        String zjwz = "xxx";//附近
        String dlxz = "xxx";//断裂性质
        String cxzx = "xxx";//走向
        if (getQueryDzsj.get(0) != null &&getQueryDzsj.size()>0){
            names =getQueryDzsj.get(0).getEarthquakeName();//标题名
            time = sdf.format(getQueryDzsj.get(0).getEarthquakeTime());//时间
            wz = getQueryDzsj.get(0).getEarthquakeLocation();//位置
            x = getQueryDzsj.get(0).getLongitude();//x
            y = getQueryDzsj.get(0).getLatitude();//y
            dzjb = getQueryDzsj.get(0).getEarthquakeLevel();//地震级别
            zysd = getQueryDzsj.get(0).getFocalDepth();//震源深度
        }
        if (getQueryActivefaultId.get(0) != null&&getQueryActivefaultId.size()>0){
            zjwz = getQueryActivefaultId.get(0).getName();//附近
            dlxz = getQueryActivefaultId.get(0).getFeature();//断裂性质
            cxzx = getQueryActivefaultId.get(0).getDipDir();//走向
        }
//        dzcs = "7";//2.5级及以上的地震
//        zddz = "8";//最大地震
//        zjdz = "9";//最近的地震

        //模板引擎
        FileResourceLoader resourceLoader = new FileResourceLoader(contentText, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("\\震区背景信息.txt");
        t.binding("time", time);
        t.binding("wz", wz);
        t.binding("x", x);
        t.binding("y", y);
        t.binding("dzjb", dzjb);
        t.binding("zysd", zysd);
        t.binding("dzcs", dzcs);
        t.binding("zddz", zddz);
        t.binding("zjdz", zjdz);
        t.binding("zjwz", zjwz);
        t.binding("dlxz", dlxz);
        t.binding("cxzx", cxzx);
        String dzbjxxContentText = t.render();//文本内容
        Map<String, Object> param = new HashMap<String, Object>();//${dzbjxxContentText}
        param.put("${dzbjxxContentText}", dzbjxxContentText);
        param.put("${title}",names);//标题
        List<XWPFParagraph> paragraphList = document2.getParagraphs();
        WordUtil.processParagraphs(paragraphList, param, document2);//扫描段落进行变量处理
    }

    //震区人口信息
    public void zqrkxxContent(CustomXWPFDocument document2,String dzsjId) {
//      据中国地震台网测定,北京时间${time},在${wz}(北纬${y}度,东经${x}度)发生${dzjb}级地震,震源深度约${zysd}公里。
//      地震烈度Ⅵ度区波及上海${yxqx}个县区，约${yxqxnumber}万人受灾；
//      震中所在的${zzsz}总人口约${zzsznumber}万人，人口密度约${zzszmd}人/平方公里；
//      震中所在的${zzjd}总人口约${zzjdnumber}万人，人口密度约${zzjdmd}人/平方公里；
//      上海市平均人口密度约${shmd}人/平方公里。
        List<DzsjBean> getQueryDzsj = this.DataService.getQueryDzsj(dzsjId);
        List<Map> getQueryPopulationSHS = this.DataService.getQueryPopulationSHS(dzsjId);
        List<Map> getQueryPopulationQx = this.DataService.getQueryPopulationQx(dzsjId);
        List<Map> getQueryPopulationJz = this.DataService.getQueryPopulationJz(dzsjId);
        String names = "xxx";//标题名
        String time = "xxx";//时间
        String wz = "xxx";//位置
        String x = "xxx";//x
        String y = "xxx";//y
        Double dzjb = Double.valueOf(0);//地震级别
        Double zysd = Double.valueOf(0);//震源深度
        Object yxqx = "xxx";//波及区县
        Object yxqxnumber = "xxx";//受灾人口
        Object zzsz = "xxx";//区县名称
        Object zzsznumber = "xxx";//区县人口
        String zzszmd = "xxx";//区县密度
        Object zzjd = "xxx";//街镇名称
        Object zzjdnumber = "xxx";//街镇人口
        Object zzjdmd = "xxx";//街镇密度
        String shmd = "xxx";//人口密度
        if (getQueryDzsj.get(0) != null &&getQueryDzsj.size()>0){
            names =getQueryDzsj.get(0).getEarthquakeName();//标题名
            time = sdf.format(getQueryDzsj.get(0).getEarthquakeTime());//时间
            wz = getQueryDzsj.get(0).getEarthquakeLocation();//位置
            x = getQueryDzsj.get(0).getLongitude();//x
            y = getQueryDzsj.get(0).getLatitude();//y
            dzjb = getQueryDzsj.get(0).getEarthquakeLevel();//地震级别
            zysd = getQueryDzsj.get(0).getFocalDepth();//震源深度
        }
        if (getQueryPopulationSHS.get(0) != null&&getQueryPopulationSHS.size()>0){
            yxqx = getQueryPopulationSHS.get(0).get("cnames");//波及区县
            yxqxnumber = getQueryPopulationSHS.get(0).get("zmj");//受灾人口
//            shmd = "456";//人口密度
        }
        if (getQueryPopulationQx.size()>0){
            zzsz = getQueryPopulationQx.get(0).get("snames");//区县名称
            zzsznumber = getQueryPopulationQx.get(0).get("totals");//区县人口
//            zzszmd = "789";//区县密度
        }
        if (getQueryPopulationJz.size()>0){
            zzjd = getQueryPopulationJz.get(0).get("names");//街镇名称
            zzjdnumber = getQueryPopulationJz.get(0).get("totals");//街镇人口
//            zzjdmd = "123";//街镇密度
        }
        //模板引擎
        FileResourceLoader resourceLoader = new FileResourceLoader(contentText, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("\\震区人口信息.txt");
        t.binding("time", time);
        t.binding("wz", wz);
        t.binding("x", x);
        t.binding("y", y);
        t.binding("dzjb", dzjb);
        t.binding("zysd", zysd);
        t.binding("yxqx", yxqx);
        t.binding("yxqxnumber", yxqxnumber);
        t.binding("zzsz", zzsz);
        t.binding("zzsznumber", zzsznumber);
        t.binding("zzszmd", zzszmd);
        t.binding("zzjd", zzjd);
        t.binding("zzjdnumber", zzjdnumber);
        t.binding("zzjdmd", zzjdmd);
        t.binding("shmd", shmd);
        String zqrkxxContentText = t.render();//文本内容
        Map<String, Object> param = new HashMap<String, Object>();//${dzbjxxContentText}
        param.put("${zqrkxxContentText}", zqrkxxContentText);
        param.put("${title}",names);//标题
        List<XWPFParagraph> paragraphList = document2.getParagraphs();
        WordUtil.processParagraphs(paragraphList, param, document2);//扫描段落进行变量处理
    }



    //重点目标信息
    public void zdmbxxContent(CustomXWPFDocument document2,String dzsjId) {
//      据中国地震台网测定,北京时间${time},在${wz}(北纬${y}度,东经${x}度)发生${dzjb}级地震,震源深度约${zysd}公里。
//      地震烈度Ⅵ度区内共涉及${sumSchool}所学校、${sumHospital}家医院、${sumReserior}个水库、${sumdzzhd}个地震灾害点；
//      其中最高烈度范围内涉及${maxSchool}所学校、${maxHospital}家医院、${maxReserior}个水库、${maxdzzhd}个地震灾害点。
        List<DzsjBean> getQueryDzsj = this.DataService.getQueryDzsj(dzsjId);
        String names = "xxx";//标题名
        String time = "xxx";//时间
        String wz = "xxx";//位置
        String x = "xxx";//x
        String y = "xxx";//y
        Double dzjb = Double.valueOf(0);//地震级别
        Double zysd = Double.valueOf(0);//震源深度
        String sumSchool = "xxx";//总学校
        String sumHospital = "xxx";//总医院
        String sumReserior = "xxx";//总水库
        String sumdzzhd = "xxx";//总灾害点
        String maxSchool = "xxx";//最高烈度学校
        Object maxHospital = "xxx";//最高烈度医院
        Object maxReserior = "xxx";//最高烈度水库
        Object maxdzzhd = "xxx";//最高烈度灾害点
        if (getQueryDzsj.get(0) != null &&getQueryDzsj.size()>0){
            names =getQueryDzsj.get(0).getEarthquakeName();//标题名
            time = sdf.format(getQueryDzsj.get(0).getEarthquakeTime());//时间
            wz = getQueryDzsj.get(0).getEarthquakeLocation();//位置
            x = getQueryDzsj.get(0).getLongitude();//x
            y = getQueryDzsj.get(0).getLatitude();//y
            dzjb = getQueryDzsj.get(0).getEarthquakeLevel();//地震级别
            zysd = getQueryDzsj.get(0).getFocalDepth();//震源深度
        }

//        sumSchool = "7";//总学校
//        sumHospital = "8";//总医院
//        sumReserior = "9";//总水库
//        sumdzzhd = "10";//总灾害点
//        maxSchool = "11";//最高烈度学校
//        maxHospital = "12";//最高烈度医院
//        maxReserior = "13";//最高烈度水库
//        maxdzzhd = "14";//最高烈度灾害点
        //模板引擎
        FileResourceLoader resourceLoader = new FileResourceLoader(contentText, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("\\重点目标信息.txt");
        t.binding("time", time);
        t.binding("wz", wz);
        t.binding("x", x);
        t.binding("y", y);
        t.binding("dzjb", dzjb);
        t.binding("zysd", zysd);
        t.binding("sumSchool", sumSchool);
        t.binding("sumHospital", sumHospital);
        t.binding("sumReserior", sumReserior);
        t.binding("sumdzzhd", sumdzzhd);
        t.binding("sumdzzhd", sumdzzhd);
        t.binding("maxSchool", maxSchool);
        t.binding("maxHospital", maxHospital);
        t.binding("maxReserior", maxReserior);
        t.binding("maxdzzhd", maxdzzhd);
        String zdmbxxContentText = t.render();//文本内容
        Map<String, Object> param = new HashMap<String, Object>();//${dzbjxxContentText}
        param.put("${zdmbxxContentText}", zdmbxxContentText);
        param.put("${title}",names);//标题
        List<XWPFParagraph> paragraphList = document2.getParagraphs();
        WordUtil.processParagraphs(paragraphList, param, document2);//扫描段落进行变量处理
    }

    //震中空间距离分布
    public void zzkjjlfbContent(CustomXWPFDocument document2,String dzsjId) {
//      据中国地震台网测定，北京时间${time}，在${wz}（北纬${y}度，东经${x}度）发生${dzjb}级地震，震源深度约${zysd}公里。
        List<DzsjBean> getQueryDzsj = this.DataService.getQueryDzsj(dzsjId);
        String names = "xxx";//标题名
        String time = "xxx";//时间
        String wz = "xxx";//位置
        String x = "xxx";//x
        String y = "xxx";//y
        Double dzjb = Double.valueOf(0);//地震级别
        Double zysd = Double.valueOf(0);//震源深度
        if (getQueryDzsj.get(0) != null &&getQueryDzsj.size()>0){
            names =getQueryDzsj.get(0).getEarthquakeName();//标题名
            time = sdf.format(getQueryDzsj.get(0).getEarthquakeTime());//时间
            wz = getQueryDzsj.get(0).getEarthquakeLocation();//位置
            x = getQueryDzsj.get(0).getLongitude();//x
            y = getQueryDzsj.get(0).getLatitude();//y
            dzjb = getQueryDzsj.get(0).getEarthquakeLevel();//地震级别
            zysd = getQueryDzsj.get(0).getFocalDepth();//震源深度
        }
        //模板引擎
        FileResourceLoader resourceLoader = new FileResourceLoader(contentText, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("\\震中空间距离分布.txt");
        t.binding("time", time);
        t.binding("wz", wz);
        t.binding("x", x);
        t.binding("y", y);
        t.binding("dzjb", dzjb);
        t.binding("zysd", zysd);
        String zzkjjlfbContentText = t.render();//文本内容
        Map<String, Object> param = new HashMap<String, Object>();//${dzbjxxContentText}
        param.put("${SeismicDistanceSpatialDistribution}", zzkjjlfbContentText);
        param.put("${title}",names);//标题
        List<XWPFParagraph> paragraphList = document2.getParagraphs();
        WordUtil.processParagraphs(paragraphList, param, document2);//扫描段落进行变量处理
    }


    //震区经济信息
    public void zqjjxxContent(CustomXWPFDocument document2,String dzsjId) {
//      中国地震台网测定,北京时间${time},在${wz}(北纬${y}度,东经${x}度)发生${dzjb}级地震,震源深度约${zysd}公里。
//      震中所在的${qx}人均GDP是${gdp}元。2016年上海人均GDP为${pgdp}元。
        List<DzsjBean> getQueryDzsj = this.DataService.getQueryDzsj(dzsjId);
        List<Map> getQueryCentreEconomic = this.DataService.getQueryCentreEconomic(dzsjId);
        List<Map> getQueryshanghaiEconomic = this.DataService.getQueryshanghaiEconomic(dzsjId);
        String names = "xxx";//标题名
        String time = "xxx";//时间
        String wz = "xxx";//位置
        String x = "xxx";//x
        String y = "xxx";//y
        Double dzjb = Double.valueOf(0);//地震级别
        Double zysd = Double.valueOf(0);//震源深度
        Object qx = "11";//区县
        Object gdp = "22";//GDP
        Object pgdp = "33";//GDP
        if (getQueryDzsj.get(0) != null &&getQueryDzsj.size()>0){
            names =getQueryDzsj.get(0).getEarthquakeName();//标题名
            time = sdf.format(getQueryDzsj.get(0).getEarthquakeTime());//时间
            wz = getQueryDzsj.get(0).getEarthquakeLocation();//位置
            x = getQueryDzsj.get(0).getLongitude();//x
            y = getQueryDzsj.get(0).getLatitude();//y
            dzjb = getQueryDzsj.get(0).getEarthquakeLevel();//地震级别
            zysd = getQueryDzsj.get(0).getFocalDepth();//震源深度
        }
        if (getQueryCentreEconomic.size()>0){
            qx = getQueryCentreEconomic.get(0).get("names");//区县
            gdp = getQueryCentreEconomic.get(0).get("meanGDP");//GDP
        }
        if (getQueryshanghaiEconomic.size()>0){
            pgdp = getQueryshanghaiEconomic.get(0).get("meanGDP");//GDP
        }
        //模板引擎
        FileResourceLoader resourceLoader = new FileResourceLoader(contentText, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("\\震区经济信息.txt");
        t.binding("time", time);
        t.binding("wz", wz);
        t.binding("x", x);
        t.binding("y", y);
        t.binding("dzjb", dzjb);
        t.binding("zysd", zysd);
        t.binding("qx", qx);
        t.binding("gdp", gdp);
        t.binding("pgdp", pgdp);
        String zqjjxxContentText = t.render();//文本内容
        Map<String, Object> param = new HashMap<String, Object>();//${dzbjxxContentText}
        param.put("${zqjjxxContentText}", zqjjxxContentText);
        param.put("${title}",names);//标题
        List<XWPFParagraph> paragraphList = document2.getParagraphs();
        WordUtil.processParagraphs(paragraphList, param, document2);//扫描段落进行变量处理
    }

}
