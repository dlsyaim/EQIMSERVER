package com.gisinfo.sand.productManage.controller;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.productManage.bean.EarthquakeProductsPs;
import com.gisinfo.sand.productManage.service.EarthquakeProductsPsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

@RestController
public class EarthquakeProductsPsController {

    @Autowired
    private EarthquakeProductsPsService productsPsService;


    @EncryptDisable
    @RequestMapping(value = "/productsPs/getListData", method = RequestMethod.POST)
    //获取分页列表
    public Map<String,Object> getDocPageData(EarthquakeProductsPs queryConditions) {
        if (queryConditions.getPageSize() != null && queryConditions.getPageNo() != null) {
            queryConditions.setBottom((queryConditions.getPageNo() - 1) * queryConditions.getPageSize());
            queryConditions.setTop(queryConditions.getPageNo() * queryConditions.getPageSize());
        }

        Map<String,Object> map = new HashMap<String,Object>();

        map.put("docList",this.productsPsService.getDocListPage(queryConditions));
        map.put("docCount",this.productsPsService.getDocCount(queryConditions));
        map.put("jpgList",this.productsPsService.getJpgListPage(queryConditions));
        map.put("jpgCount",this.productsPsService.getJpgCount(queryConditions));
        return map;
    }

//    @EncryptDisable
//    @RequestMapping(value = "/productsPs/getDocDataCount", method = RequestMethod.POST)
//    public Map<String, Object> getDocDataCount(EarthquakeProductsPs queryConditions) {
//        Map<String, Object> queryList = new HashMap<String, Object>();
//        queryList.put("count", this.productsPsService.getDocCount(queryConditions));
//        return queryList;
//    }
//
//    @EncryptDisable
//    @RequestMapping(value = "/productsPs/getJpgList", method = RequestMethod.POST)
//    //获取分页列表
//    public List<Map> getJpgPageData(EarthquakeProductsPs queryConditions) {
//        if (queryConditions.getPageSize() != null && queryConditions.getPageNo() != null) {
//            queryConditions.setBottom((queryConditions.getPageNo() - 1) * queryConditions.getPageSize());
//            queryConditions.setTop(queryConditions.getPageNo() * queryConditions.getPageSize());
//        }
//        return productsPsService.getDocListPage(queryConditions);
//    }
//
//    @EncryptDisable
//    @RequestMapping(value = "/productsPs/getJpgDataCount", method = RequestMethod.POST)
//    public Map<String, Object> getJpgDataCount(EarthquakeProductsPs queryConditions) {
//        Map<String, Object> queryList = new HashMap<String, Object>();
//        queryList.put("count", this.productsPsService.getDocCount(queryConditions));
//        return queryList;
//    }

    //根据featId获取地震附件信息
    @EncryptDisable
    @RequestMapping(value = "/getByFeatId", method = RequestMethod.POST)
    public EarthquakeProductsPs getByFeatId(String featId) {
        return this.productsPsService.getProductId(featId);
    }

    //根据featId获取地震附件信息
    @EncryptDisable
    @RequestMapping(value = "/getFileCount", method = RequestMethod.POST)
    public String getFileCount() {
        return this.productsPsService.getFileCount();
    }


    //文件下载
    @EncryptDisable
    @RequestMapping(value = "/productsPs/fileDownload", method = RequestMethod.GET)
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
