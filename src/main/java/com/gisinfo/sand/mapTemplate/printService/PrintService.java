package com.gisinfo.sand.mapTemplate.printService;

import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSON;
import com.gisinfo.sand.core.config.Group;
import com.gisinfo.sand.core.web.SandContext;
import com.gisinfo.sand.mapTemplate.Controller;
import com.gisinfo.sand.mapTemplate.ControllerUitl;
import com.gisinfo.sand.mapTemplate.WordService;
import com.gisinfo.sand.mapTemplate.bean.DzsjBean;
import com.gisinfo.sand.mapTemplate.bean.DzsjFileBean;
import com.gisinfo.sand.mapTemplate.bean.PrintParamBean;
import com.gisinfo.sand.mapTemplate.service.DataService;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PrintService {
    private static String dzsjTableName = "T_EARTHQUAKE_INFO";//地震事件表
    private String dzsjFeatid = "";//地震事件id
    private static String modelWordPath =
            SandContext.getValueFromGroup("MapTemplate", "get", "modelWordPath");//模板word路径
    private static String createWordPath =
            SandContext.getValueFromGroup("MapTemplate", "get", "createWordPath");//创建word路径
    private static String downloadImgPath =
            SandContext.getValueFromGroup("MapTemplate", "get", "downloadImgPath");//下载图片路径
    private static String imgType =
            SandContext.getValueFromGroup("MapTemplate", "get", "imgType");//图片类型配置
    private static String wordType =
            SandContext.getValueFromGroup("MapTemplate", "get", "wordType");//word类型配置

    @Autowired
    private PrintService PrintService;

    @Autowired
    private com.gisinfo.sand.mapTemplate.WordService WordService;

    @Autowired
    private com.gisinfo.sand.mapTemplate.service.DataService DataService;

    @Autowired
    private com.gisinfo.sand.mapTemplate.ControllerUitl ControllerUitl;


    //打印服务
    public List<Map> printController(List<DzsjBean> dzsjList) {
        List<Map> list = new ArrayList<Map>();
        String result = "失败";
        String printService = SandContext.getValueFromGroup("MapTemplate", "get", "getPrintService");//打印服务
        //ConcurrentHashMap<String, Group> imgGroups = SandContext.getModule("MapPrintRequest").getGroups();//打印图片服务配置
        String printModel = SandContext.getValueFromGroup("MapTemplate", "get", "printModel");//打印图片服务配置
        List<PrintParamBean> imgGroups = ControllerUitl.getPrintModelList(printModel + "printParam.js", PrintParamBean.class);
        if (imgGroups.size() > 0) {
            //String printType = "";//生成类型
            String printWord = "";//对应word
            String printName = "";//模板名称
            String printLayers = "";//显示图层
            String printTemplate = "";//模板
            String printUrl = "";//模板地址
            String printWordImgSize = "";//插入word图片大小
            String printDownloadPath = "";//下载图片位置
            String x = dzsjList.get(0).getLongitude();//"13484026.537737189";
            String y = dzsjList.get(0).getLatitude();//"3670888.12594343";
            for (int i = 0; i < imgGroups.size(); i++) {
                Map map = new HashMap();
                //printType = (String) (imgGroups.get("get" + i).getConfigValue()).get("printType");//生成类型
                printWord = imgGroups.get(i).getPrintWord();//对应word
                printName = imgGroups.get(i).getPrintName();//模板名称
                printLayers = imgGroups.get(i).getPrintLayers();//显示图层
                printTemplate =imgGroups.get(i).getPrintTemplate();//模板
                printUrl =imgGroups.get(i).getPrintUrl();//模板地址
                printWordImgSize =imgGroups.get(i).getPrintWordImgSize();//插入word图片大小
                printDownloadPath =imgGroups.get(i).getPrintDownloadPath();//下载图片位置
                String param = getPrintModel(printName, printLayers, printTemplate, printUrl, x, y);//打印模板参数（模板引擎）
                String resJson = Request.sendPost(printService, param);//请求打印服务
                List<Map> listMap = ((List<Map>) JSON.parseObject(resJson).get("results"));//返回结果
                String imgUrl = "";
                if (listMap.size() > 0) {
                    imgUrl = (String) JSON.parseObject(listMap.get(0).get("value").toString()).get("url");//图片地址
                    map.put("imgUrl", imgUrl);//图片地址
                    map.put("x", x);
                    map.put("y", y);
                    //map.put("printType", printType);//生成类型
                    map.put("printWord", printWord);//对应word
                    map.put("printName", printName);//模板名称
                    map.put("printWordImgSize", printWordImgSize);//插入word图片大小
                    map.put("printDownloadPath", printDownloadPath);//下载图片位置
                    list.add(map);
                }
            }
        }
        return list;
    }

    //打印模板参数（模板引擎）
    public String getPrintModel(String printName, String printLayers, String printTemplate, String printUrl, String x, String y) {
        String printString = "";
        String printModel = SandContext.getValueFromGroup("MapTemplate", "get", "printModel");//打印服务
        FileResourceLoader resourceLoader = new FileResourceLoader(printModel, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate("//point.txt");
        t.binding("url", printUrl);
        t.binding("title", printName);
        t.binding("visibleLayers", printLayers);
        t.binding("x", x);
        t.binding("y", y);
        t.binding("template", printTemplate);
        printString = t.render();
        System.out.println("模板服务请求参数："+printString);
        return printString;
    }


    //地图模板请求
    public String getMapPrintService(String dzsjId, String pch) {//featid 地震id，pch 批次号
        String result = "失败";
        if (dzsjId.length() == 0) {
            return result = "featid不能为null";
        }
        if (pch.length() == 0) {
            return result = "pch不能为null";
        }
        if (dzsjId.length() > 0) {
            List<DzsjBean> dzsjList = this.DataService.getQueryDzsj(dzsjId);//查询地震事件
            if (dzsjList.size() > 0) {
                List<Map> list = PrintService.printController(dzsjList);//打印服务
                if (list.size() > 0) {
                    //mapTemplateController(list, dzsjId); //地图模板生成word
                    //下载图片
                    for (int i = 0; i < list.size(); i++) {
                        String imgUrl = String.valueOf(list.get(i).get("imgUrl"));//图片路径
                        String printName = String.valueOf(list.get(i).get("printName"));//模板名称
                        String printWord = String.valueOf(list.get(i).get("printWord"));//关联word

                        String dzsjFileId = IdUtil.simpleUUID();//主键
                        String printDownloadPath = String.valueOf(list.get(i).get("printDownloadPath"));//版本路径
                        String cplx = printDownloadPath;//.replace("//", "");//产品类型
                        //添加地震事件-附件
                        addDzsjFile(dzsjFileId, dzsjId,"img", downloadImgPath + dzsjId + "_" + pch + "//" + printDownloadPath + "//", printWord, printName, imgType, cplx, pch);

                        //下载地图模板图片
                        if (imgUrl.length() > 0) {
                            //下载地图模板图片
                            try {
                                ControllerUitl.downloadImg(imgUrl, printName + "." + imgType, downloadImgPath + dzsjId + "_" + pch + "//" + printDownloadPath + "//");
                                result = "成功";
                            } catch (Exception e) {
                                result = "失败";
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    //地图模板生成word
    public String getMapDownloadWordService(String dzsjId, String pch) {//featid 地震id，pch 批次号
        String result = "失败";
        if (dzsjId.length() == 0) {
            return result = "featid不能为null";
        }
        if (pch.length() == 0) {
            return result = "pch不能为null";
        }
        List<DzsjFileBean> list = null;
        if (dzsjId.length() > 0) {
            //list = DataService.getQueryDzsjFile_rel_id(dzsjId);//查询地震事件-附件(根据rel_id查询)
        } else {
            return result;
        }

        if (dzsjId.length() > 0) {
            dzsjFeatid = dzsjId;//地震事件id
            //生成word;
           // ConcurrentHashMap<String, Group> imgModelGroups = SandContext.getModule("MapPrintRequest").getGroups();//打印图片服务配置
            String printModel = SandContext.getValueFromGroup("MapTemplate", "get", "printModel");//打印图片服务配置
            List<PrintParamBean> imgModelGroups = ControllerUitl.getPrintModelList(printModel + "printParam.js", PrintParamBean.class);
            ConcurrentHashMap<String, Group> wordGroups = SandContext.getModule("MapWordRequest").getGroups();//生成word配置
            for (int i = 0; i < wordGroups.size(); i++) {
                String wordName = (String) (wordGroups.get("get" + i).getConfigValue()).get("wordName");//word名称
                List<Map> imgList = new ArrayList<Map>();//图片集合
                for (int iMInt = 0; iMInt < imgModelGroups.size(); iMInt++) {//图片模板配置信息
                    String printWord =imgModelGroups.get(iMInt).getPrintWord();//对应word
                    String printName =imgModelGroups.get(iMInt).getPrintName();//模板名称
                    String printWordImgSize =imgModelGroups.get(iMInt).getPrintWordImgSize();//插入word图片大小
                    String printDownloadPath =imgModelGroups.get(iMInt).getPrintDownloadPath();//下载图片位置
                    if (wordName.equals(printWord) && printDownloadPath.equals("图件-上海局")) {//需要插入的图片
                        //List<DzsjFileBean> fileImgList = DataService.getQueryDzsjFile_rel_id(dzsjId, printWord, pch);//查询地震事件-附件(根据rel_id查询)
//                        String imgNameId = "";//图片名称
//                        for (int f = 0; f < fileImgList.size(); f++) {
//                            String name = fileImgList.get(f).getName();
//                            if(name.split("_")[0].equals(printName)){
//                                imgNameId = name.split("_")[1];
//                            }
//                        }
                        Map map = new HashMap();
                        //map.put("imgNameId", imgNameId);
                        map.put("printWord", printWord);
                        map.put("imgName", printName);
                        map.put("printWordImgSize", printWordImgSize);
                        map.put("imgType", imgType);
                        map.put("printDownloadPath", downloadImgPath + dzsjId + "_" + pch + "//" + printDownloadPath + "//");
                        imgList.add(map);
                    }
                }
                //生成word
                String wordPath = (String) (wordGroups.get("get" + i).getConfigValue()).get("wordPath");//word配置路径
                String mdWordPath = modelWordPath + "" + wordPath;//模板word路径
                String crWordPath = createWordPath + dzsjId + "_" + pch + "//" + wordPath;//生成的word路径

                ControllerUitl.createFile(crWordPath);//创建文件夹

                String dzsjFileId = IdUtil.simpleUUID();//主键
                boolean staWord = WordService.createWord(mdWordPath + wordName + "." + wordType, crWordPath + "" + wordName + "." + wordType, imgList, wordName, dzsjId);
                if (staWord) {
                    //添加地震事件-word附件
                    addDzsjFile(dzsjFileId, dzsjId,"word", crWordPath, wordName, wordName, wordType, wordPath, pch);
                }
            }
            result = "成功";
        }
        return result;
    }

    //添加地震事件-附件
    public void addDzsjFile(String dzsjFileId, String dzsjId,String objectType, String path, String wordName, String name, String type, String cplx, String pch) {
        String filePath = path + name + "." + type;//文件路径
        this.DataService.getAddDzsjFile(dzsjFileId, dzsjTableName,
                dzsjId,objectType, wordName, name, type, filePath, "测试数据1", cplx, pch);
    }

}



