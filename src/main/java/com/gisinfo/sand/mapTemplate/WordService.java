package com.gisinfo.sand.mapTemplate;

import com.gisinfo.sand.mapTemplate.wordUtil.CustomXWPFDocument;
import com.gisinfo.sand.mapTemplate.wordUtil.WordUtil;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBorder;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblBorders;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STBorder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WordService {

    @Autowired
    private WordContentService WordContentService;

    @Autowired
    private WordTableService WordTableService;

    //模板生成新word
    public boolean createWord(String modelWordUrl, String createWordUrl, List<Map> imgList,String wordName,String dzsjId) {
        //读取word源文件
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(modelWordUrl);
            CustomXWPFDocument document2 = new CustomXWPFDocument(fileInputStream);//重写XWPFDocument

            createTableWord(document2, wordName,dzsjId);//生成表格数据
            createContentWord(document2, wordName,dzsjId);//生成文本内容

            //图片插入word
            if (imgList.size() > 0) {
                for (int i = 0; i < imgList.size(); i++) {
                    String imgName = (String) imgList.get(i).get("imgName");
                    String imgWidth = ((String) imgList.get(i).get("printWordImgSize")).split(";")[0];
                    String imgHeight = ((String) imgList.get(i).get("printWordImgSize")).split(";")[1];
                    String imgType = (String) imgList.get(i).get("imgType");
                    String printDownloadPath = (String) imgList.get(i).get("printDownloadPath");
                    String chartName = "${" + imgName + "}";//插入word别名
                    createChartWord(document2, printDownloadPath, imgName, chartName, imgWidth, imgHeight, imgType);//图片插入word
                }
            }

            OutputStream output = new FileOutputStream(createWordUrl);
            document2.write(output);//模板写入到导出的word中
            return true;
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }

    //生成图表插入word中
    public void createChartWord(CustomXWPFDocument document2, String chartImgUrl, String imgName, String chartName, String imgWidth, String imgHeight, String imgType) throws FileNotFoundException {
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Object> sjjc = new HashMap<String, Object>();
        sjjc.put("width", imgWidth);
        sjjc.put("height", imgHeight);
        //sjjc.put("type", "png");
        sjjc.put("type", imgType);
        sjjc.put("content", WordUtil.inputStream2ByteArray(new FileInputStream(chartImgUrl + "" + imgName +"." + imgType), true));
        param.put(chartName, sjjc);
        List<XWPFParagraph> paragraphList = document2.getParagraphs();
        WordUtil.processParagraphs(paragraphList, param, document2);//扫描段落进行变量处理
    }


    //生成表格数据
    public void createTableWord(CustomXWPFDocument document2, String wordName,String dzsjId) {
        List<XWPFTable> tableList = document2.getTables();//获取所有表格
        //WordTableService wts = new WordTableService();
        if (tableList.size() > 0) {//文档中存在表格
            for (int i = 0; i < tableList.size(); i++) {//循环word中每张表
                setBoderStyle(tableList.get(i));//设置表格边框
                WordTableService.WordTable(tableList.get(i), i, document2,wordName,dzsjId);//设置每个table数据
            }
        }
    }

    //生成文本内容
    public void createContentWord(CustomXWPFDocument document2, String wordName,String dzsjId) throws FileNotFoundException {
//        WordContentService wcs = new WordContentService();
        WordContentService.textContent(document2, wordName,dzsjId);//段落内容
//        XWPFParagraph para = document2.createParagraph();
//
//        //一个XWPFRun代表具有相同属性的一个区域。
//        XWPFRun run = para.createRun();
//        run.setBold(true); //加粗
//        run.setText("加粗的内容");
//        run.setText("红色的字。");

//        Map<String, Object> param = new HashMap<String, Object>();
//        param.put("${testContent}", "测试Content");
//        List<XWPFParagraph> paragraphList = document2.getParagraphs();
//        WordUtil.processParagraphs(paragraphList, param, document2);//扫描段落进行变量处理
    }


    //设置表格边框
    public void setBoderStyle(XWPFTable table) {
        CTTblBorders borders = table.getCTTbl().getTblPr().addNewTblBorders();
        CTBorder hBorder = borders.addNewInsideH();
        hBorder.setVal(STBorder.Enum.forString("single"));  // 线条类型
        hBorder.setSz(new BigInteger("1")); // 线条大小
        hBorder.setColor("000000"); // 设置颜色

        CTBorder vBorder = borders.addNewInsideV();
        vBorder.setVal(STBorder.Enum.forString("single"));
        vBorder.setSz(new BigInteger("1"));
        vBorder.setColor("000000");

        CTBorder lBorder = borders.addNewLeft();
        lBorder.setVal(STBorder.Enum.forString("single"));
        lBorder.setSz(new BigInteger("1"));
        lBorder.setColor("000000");

        CTBorder rBorder = borders.addNewRight();
        rBorder.setVal(STBorder.Enum.forString("single"));
        rBorder.setSz(new BigInteger("1"));
        rBorder.setColor("000000");

        CTBorder tBorder = borders.addNewTop();
        tBorder.setVal(STBorder.Enum.forString("single"));
        tBorder.setSz(new BigInteger("1"));
        tBorder.setColor("000000");

        CTBorder bBorder = borders.addNewBottom();
        bBorder.setVal(STBorder.Enum.forString("single"));
        bBorder.setSz(new BigInteger("1"));
        bBorder.setColor("000000");
    }


}
