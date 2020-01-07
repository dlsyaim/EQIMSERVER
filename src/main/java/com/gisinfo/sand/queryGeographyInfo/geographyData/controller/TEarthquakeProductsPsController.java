package com.gisinfo.sand.queryGeographyInfo.geographyData.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.queryGeographyInfo.geographyData.bean.TEarthquakeProductsPs;
import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TEarthquakeProductsPsCondition;
import com.gisinfo.sand.queryGeographyInfo.geographyData.service.TEarthquakeProductsPsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//地震触发列表控制类
@RestController
public class TEarthquakeProductsPsController {

    @Autowired
    private TEarthquakeProductsPsService tEarthquakeProductsPsService;

    //查询总记录数、数据列表
    @EncryptDisable
    @RequestMapping(value="/getTEarthquakeProductsPsDOXCountAndDOXListAndJPGCountAndJPGList",method = RequestMethod.POST)
    public Map<String,Object> getTEarthquakeProductsPsCountAndList(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition){
        Map<String,Object> result=null;
        //查询总记录数
        Integer DOXcount=this.tEarthquakeProductsPsService.getTEarthquakeProductsPsDOXCount(tEarthquakeProductsPsCondition);
        //查询记录列表
        List<TEarthquakeProductsPs> DOXlist=this.tEarthquakeProductsPsService.getTEarthquakeProductsPsDOXList(tEarthquakeProductsPsCondition);
        //查询总记录数
        Integer JPGcount=this.tEarthquakeProductsPsService.getTEarthquakeProductsPsJPGCount(tEarthquakeProductsPsCondition);
        //查询记录列表
        List<TEarthquakeProductsPs> JPGlist=this.tEarthquakeProductsPsService.getTEarthquakeProductsPsJPGList(tEarthquakeProductsPsCondition);
        result=new HashMap<>();
        result.put("DOXcount",DOXcount);
        result.put("DOXlist",DOXlist);
        result.put("JPGcount",JPGcount);
        result.put("JPGlist",JPGlist);
        return result;
    }

    //首页点击下载
    //文件下载
    @EncryptDisable
    @RequestMapping(value = "/getTEarthquakeProductsPsDOXCount/fileDownload", method = RequestMethod.GET)
    public String fileDownload(HttpServletRequest request, HttpServletResponse response) {
        // 文件名称
        String fileName = request.getParameter("fileName");
        String filePath = request.getParameter("filePath");

        if (fileName != null) {
            File file = new File(filePath);
            // 如果文件存在，则进行下载
            if (file.exists()) {
                // 配置文件下载
                response.setHeader("content-type", "application/octet-stream");
                response.setContentType("application/octet-stream");
                // 下载文件能正常显示中文
                try {
                    response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                // 实现文件下载
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("Download  successfully!");
                    return "successfully";

                } catch (Exception e) {
                    System.out.println("Download  failed!");
                    return "failed";

                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return "";
    }

}
