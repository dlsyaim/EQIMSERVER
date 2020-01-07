package com.gisinfo.sand.mapTemplate;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.FileResourceLoader;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Service
public class ControllerUitl {

    public HttpServletResponse download(String path, HttpServletResponse response) {
        try {
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return response;
    }

    //下载地图模板图片
    public void downloadImg(String urlString, String filename, String savePath) throws Exception {
        // 构造URL
        URL url = new URL(urlString);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(5 * 10000);
        // 输入流
        InputStream is = con.getInputStream();

        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        File sf = new File(savePath);
        if (!sf.exists()) {
            sf.mkdirs();
        }
        // 获取图片的扩展名
        String extensionName = filename.substring(filename.lastIndexOf(".") + 1);
        // 新的图片文件名 = 编号 +"."图片扩展名
        OutputStream os = new FileOutputStream(sf.getPath() + "\\" + filename);
        // 开始读取
        while ((len = is.read(bs)) != -1) {
            os.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        os.close();
        is.close();
    }

    //生成文件夹
    public void createFile(String path) {
        //File file = new File("F:\\gisinfoNewProject\\EQIM_Bis\\src\\main\\resources\\mapTemplate\\download\\img\\test");
        File file = new File(path);
        //获取父目录
//        File fileParent = file.getParentFile();
//        //判断是否存在
//        if (!fileParent.exists()) {
//            //创建父目录文件
//            fileParent.mkdirs();
//        }
        try {
            file.mkdirs();//创建文件夹
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获取需要打印的图片模板
    public List getPrintModelList(String modelPath, Class beanClass) {

        if (!StringUtils.isBlank(modelPath) && !StringUtils.isBlank(modelPath)) {
            String json = getModelString(modelPath);//获取模板里面字符
            return JSONObject.parseArray(json, beanClass);//返回的数据
        } else {
            System.out.println("获取需要打印的图片模板：模板地址或内容不能为空！");
            return null;
        }
    }

    //获取模板里面字符
    public String getModelString(String modelPath) {
        //模板引擎
        //String[] modelPath = "F:\\gisinfoNewProject\\代码备份\\beeltTest.js".split("\\\\");
        String[] textArr = modelPath.split("//");
        String file = textArr[textArr.length - 1];//文件
        String filePath = "";//文件目录
        for (int i = 0; i < textArr.length - 1; i++) {
            filePath = filePath + textArr[i] + "//";//文件目录
        }
        FileResourceLoader resourceLoader = new FileResourceLoader(filePath, "utf-8");
        Configuration cfg = null;
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);
        Template t = gt.getTemplate(file);//文本内容
        String text = t.render().replaceAll("\r|\n|\t", "");//文本内容过滤
        System.out.println("获取模板里面字符：" + text);
        return text;
    }
}
