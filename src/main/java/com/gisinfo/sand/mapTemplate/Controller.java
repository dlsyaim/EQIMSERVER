package com.gisinfo.sand.mapTemplate;

import cn.hutool.core.util.IdUtil;
import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.core.web.SandContext;
import com.gisinfo.sand.mapTemplate.bean.PrintParamBean;
import com.gisinfo.sand.mapTemplate.bean.DzsjFileBean;
import com.gisinfo.sand.mapTemplate.printService.PrintService;
import com.gisinfo.sand.mapTemplate.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;


@RestController
//@PropertySource("classpath:mapTemplate.properties")
public class Controller {

//    @Value("${mapTemplate.downloadImgPath}")
//    private String downloadImgPath = "F:\\gisinfoNewProject\\EQIM_Bis\\src\\main\\resources\\mapTemplate\\download\\img\\test\\";//地图模板图片下载路径

    private static String dzsjTableName = "T_EARTHQUAKE_INFO";//地震事件表
    private String dzsjId = "";//地震事件id
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
    private WordService WordService;

    @Autowired
    private DataService DataService;

    @Autowired
    private ControllerUitl ControllerUitl;


    //地图模板请求
    @EncryptDisable
    @RequestMapping(value = "/getMapPrintController", method = RequestMethod.GET)
    public String getMapPrintController(@RequestParam Map param) {
        String result = "失败";
        //添加地震事件
//        String dzsjId = IdUtil.simpleUUID();//地震事件主键
//        String dzmc = "上海测试数据111";//地震名称
//        Double dzdj = 7.5;//地震震级
//        String x = "121.44000000";//x
//        String y = "31.20000000";//y
//        String zysd = "10";//震源深度
//        Integer addDzsjInt = this.DataService.getAddDzsj(dzsjId, "测试数据1", dzmc, dzdj, x, y, zysd);

        dzsjId = (String) param.get("featid");//地震事件id
        String pch = (String) param.get("pch");//批次号
        if (dzsjId == null) {
            return result = "featid不能为null";
        }
        if (pch == null) {
            return result = "pch不能为null";
        }
        if (dzsjId.length() > 0) {
            result = PrintService.getMapPrintService(dzsjId, pch);//地图模板请求
            result = PrintService.getMapDownloadWordService(dzsjId, pch);//地图模板生成word

//            List<DzsjBean> dzsjList = this.DataService.getQueryDzsj(dzsjId);//查询地震事件
//            if (dzsjList.size() > 0) {
//                List<Map> list = PrintService.printController(dzsjList);//打印服务
//                if (list.size() > 0) {
//                    result = mapTemplateController(list, dzsjId); //地图模板生成word
//                }
//            }
        }
        return result;
    }


    //地图模板生成word
//    @EncryptDisable
//    @RequestMapping(value = "/getMapTemplateController", method = RequestMethod.POST)
//    //@PostMapping("/getMapTemplateController")@RequestBody List<Map> list
//    public String mapTemplateController(List<Map> list, String dzsjId) {
//        String result = "失败";
//        try {
//            if (list.size() > 0) {
//                //下载图片
//                for (int i = 0; i < list.size(); i++) {
//                    String imgUrl = String.valueOf(list.get(i).get("imgUrl"));//图片路径
//                    String printName = String.valueOf(list.get(i).get("printName"));//模板名称
//                    String printDownloadPath = downloadImgPath + "" + String.valueOf(list.get(i).get("printDownloadPath"));//下载图片位置
//                    //下载地图模板图片
//                    if (imgUrl.length() > 0) {
//                        //下载地图模板图片
//                        ControllerUitl.downloadImg(imgUrl, printName + "." + imgType, printDownloadPath);
//                        //添加地震事件-附件
//                        addDzsjFile(dzsjId, printDownloadPath, printName, imgType);
//                    }
//                }
//                //生成word;
//                ConcurrentHashMap<String, Group> wordGroups = SandContext.getModule("MapWordRequest").getGroups();//生成word配置
//                for (int i = 0; i < wordGroups.size(); i++) {
//                    String wordName = (String) (wordGroups.get("get" + i).getConfigValue()).get("wordName");//word名称
//                    List<Map> imgList = new ArrayList<Map>();//图片集合
//                    Integer status = 0;//是否生成word
//                    for (int j = 0; j < list.size(); j++) {
//                        Map map = new HashMap();
//                        String printWord = (String) list.get(j).get("printWord");//对应word
//                        String printName = (String) list.get(j).get("printName");//模板名称
//                        String printWordImgSize = (String) list.get(j).get("printWordImgSize");//插入word图片大小
//                        String printDownloadPath = downloadImgPath + "" + (String) list.get(j).get("printDownloadPath");//下载图片位置
//                        if (wordName.equals(printWord)) {//需要生成的word
//                            status = 1;
//                            map.put("printWord", printWord);
//                            map.put("imgName", printName);
//                            map.put("printWordImgSize", printWordImgSize);
//                            map.put("imgType", imgType);
//                            map.put("printDownloadPath", printDownloadPath);
//                            imgList.add(map);
//                        }
//                    }
//                    //生成word
//                    if (status > 0) {
//                        String wordPath = (String) (wordGroups.get("get" + i).getConfigValue()).get("wordPath");//word配置路径
//                        String mdWordPath = modelWordPath + "" + wordPath;//模板word路径
//                        String crWordPath = createWordPath + "" + wordPath;//生成的word路径
//
//                        boolean staWord = WordService.createWord(mdWordPath + wordName + "." + wordType, crWordPath + "" + wordName + "." + wordType, imgList);
//                        if (staWord) {
//                            //添加地震事件-附件
//                            addDzsjFile(dzsjId, crWordPath, wordName, wordType);
//                        }
//                    }
//                }
//                result = "成功";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }
//
//
//    //添加地震事件-附件
//    public void addDzsjFile(String dzsjId, String path, String name, String type) {
//        String dzsjFileId = IdUtil.simpleUUID();//主键
//        String filePath = path + "" + name + "." + type;//文件路径
//        this.DataService.getAddDzsjFile(dzsjFileId, dzsjTableName,
//                dzsjId, name, name, type, filePath, "测试数据1");
//    }


    //下载文件
    @EncryptDisable
    @RequestMapping(value = "/getMapTemplateDownload", method = RequestMethod.GET)//, @RequestBody Map map
    public String download(HttpServletRequest request, HttpServletResponse response, @RequestParam Map param) {
        String featid = String.valueOf(param.get("id"));//地震事件id
        if (featid.length() > 0) {
            List<DzsjFileBean> addDzsjInt = this.DataService.getQueryDzsjFile(featid);
            if (addDzsjInt.size() > 0) {
                String path = addDzsjInt.get(0).getPath();//文件路径
                String name = addDzsjInt.get(0).getName();//文件名称
                //String url = "F:\\gisinfoNewProject\\EQIM_Bis\\src\\main\\resources\\mapTemplate\\download\\word\\test\\震区房屋统计.docx";
                File fileurl = new File(path);
                //浏览器下载后的文件名称showValue,从url中截取到源文件名称以及，以及文件类型，如board.docx;
                String showValue = name + "." + path.split("\\.")[1];//"1.docx";
                //System.out.println(showValue);
                try {
                    //根据条件得到文件路径
                    // System.out.println("===========文件路径==========="+fileurl);
                    //将文件读入文件流
                    InputStream inStream = new FileInputStream(fileurl);
                    //获得浏览器代理信息
                    String finalFileName = URLEncoder.encode(showValue, "UTF8");//其他浏览器
                    //设置HTTP响应头
                    response.reset();//重置 响应头
                    //response.setContentType("application/x-download");//告知浏览器下载文件，而不是直接打开，浏览器默认为打开
                    response.addHeader("Content-Disposition", "attachment;filename=\"" + finalFileName + "\"");//下载文件的名称

                    // 循环取出流中的数据
                    byte[] b = new byte[1024];
                    int len;
                    while ((len = inStream.read(b)) > 0) {
                        response.getOutputStream().write(b, 0, len);
                    }
                    inStream.close();
                    response.getOutputStream().close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "成功";
    }

}
