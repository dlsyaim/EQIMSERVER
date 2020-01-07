package com.gisinfo.sand.mapTemplate;

import com.gisinfo.sand.commonData.bean.EqEconomy;
import com.gisinfo.sand.core.web.SandContext;
import com.gisinfo.sand.mapTemplate.bean.TownPopulationBean;
import com.gisinfo.sand.mapTemplate.service.DataService;
import com.gisinfo.sand.mapTemplate.wordUtil.CustomXWPFDocument;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WordTableService {//处理word表格数据

    @Autowired
    private DataService DataService;

    //震区房屋统计
    private static String zqwftjTable =
            SandContext.getValueFromGroup("MapTemplate", "get", "zqwftj");

    //地震背景信息
    private static String dzbjxxTable =
            SandContext.getValueFromGroup("MapTemplate", "get", "dzbjxx");

    //震区人口信息
    private static String zqrkxxTable =
            SandContext.getValueFromGroup("MapTemplate", "get", "zqrkxx");

    //重点目标信息
    private static String zdmbxxTable =
            SandContext.getValueFromGroup("MapTemplate", "get", "zdmbxx");

    //重点目标信息
    private static String zzkjjlfbTable =
            SandContext.getValueFromGroup("MapTemplate", "get", "zzkjjlfb");

    //重点目标信息
    private static String zqjjxxTable =
            SandContext.getValueFromGroup("MapTemplate", "get", "zqjjxx");

    public void WordTable(XWPFTable table, int i, CustomXWPFDocument document2, String wordName,String dzsjId) {
        if (wordName.equals(zqwftjTable)) {//震区房屋统计
            if (i == 0) {
                zqwftjTable1(table, document2,dzsjId);//表格1
            }
        } else if (wordName.equals(dzbjxxTable)) {//地震背景信息
            if (i == 0) {
                dzbjxxTable1(table, document2,dzsjId);//表格1
            }
            if (i == 1) {
                dzbjxxTable2(table, document2,dzsjId);//表格2
            }
        }else if (wordName.equals(zqrkxxTable)) {//震区人口信息
            if (i == 0) {
                zqrkxxTable1(table, document2,dzsjId);//表格1
            }
        }else if (wordName.equals(zdmbxxTable)) {//重点目标信息
            if (i == 0) {
                zdmbxxTable1(table, document2,dzsjId);//表格1
            }
        }else if (wordName.equals(zzkjjlfbTable)) {//震中空间距离分布
            if (i == 0) {
                zzkjjlfbTable1(table, document2,dzsjId);//表格1
            }
            if (i == 1) {
                zzkjjlfbTable2(table, document2,dzsjId);//表格2
            }
            if (i == 2) {
                zzkjjlfbTable3(table, document2,dzsjId);//表格3
            }
        }else if (wordName.equals(zqjjxxTable)) {//震区经济信息
            if (i == 0) {
                zqjjxxTable1(table, document2,dzsjId);//表格1
            }
        }
    }

    //震区房屋统计-表格1
    public void zqwftjTable1(XWPFTable table, CustomXWPFDocument document2,String dzsjId) {
        List<Map> getQueryCountyBuildId = this.DataService.getQueryCountyBuildId(dzsjId);
        for (int i = 0; i < getQueryCountyBuildId.size(); i++) {
            List li = new ArrayList();
            li.add(i+1);
            li.add(getQueryCountyBuildId.get(i).get("cnames"));//名称
//            li.add(getQueryCountyBuildId.get(i).get("zmj"));//
            li.add(getQueryCountyBuildId.get(i).get("gcjz"));//高层建筑
            li.add(getQueryCountyBuildId.get(i).get("dczh"));//多层砖混
            li.add(getQueryCountyBuildId.get(i).get("dcpt"));//多层砌体
            li.add("XXX");//老旧民房，
            li.add(getQueryCountyBuildId.get(i).get("dcmz"));//单层厂房
            XWPFTableRow rowsContent = table.createRow();//创建行
            for (int j = 0; j < li.size(); j++) {
                XWPFParagraph cellParagraphC = rowsContent.getCell(j).getParagraphs().get(0);//每个行每列单元格
                cellParagraphC.setAlignment(ParagraphAlignment.CENTER); //设置表格内容居中
                cellParagraphC.setVerticalAlignment(TextAlignment.CENTER);
                XWPFRun cellParagraphRunC = cellParagraphC.createRun();
                cellParagraphRunC.setFontSize(10); //设置表格内容字号
                //cellParagraphRunC.setBold(true);//字体加粗
                cellParagraphRunC.setText(String.valueOf("" + li.get(j) + "")); //单元格数据
            }
        }
    }

    //地震背景信息-表格1
    public void dzbjxxTable1(XWPFTable table, CustomXWPFDocument document2,String dzsjId) {
        for (int i = 0; i < 5; i++) {
            List li = new ArrayList();
            li.add("1");
            li.add("2");
            li.add("3");
            li.add("4");
            XWPFTableRow rowsContent = table.createRow();//创建行
            for (int j = 0; j < li.size(); j++) {
                XWPFParagraph cellParagraphC = rowsContent.getCell(j).getParagraphs().get(0);//每个行每列单元格
                cellParagraphC.setAlignment(ParagraphAlignment.CENTER); //设置表格内容居中
                cellParagraphC.setVerticalAlignment(TextAlignment.CENTER);
                XWPFRun cellParagraphRunC = cellParagraphC.createRun();
                cellParagraphRunC.setFontSize(10); //设置表格内容字号
                //cellParagraphRunC.setBold(true);//字体加粗
                cellParagraphRunC.setText(String.valueOf("" + li.get(j) + "")); //单元格数据
            }
        }
    }

    //地震背景信息-表格2
    public void dzbjxxTable2(XWPFTable table, CustomXWPFDocument document2,String dzsjId) {
        for (int i = 0; i < 5; i++) {
            List li = new ArrayList();
            li.add("11");
            li.add("22");
            li.add("33");
            li.add("44");
            XWPFTableRow rowsContent = table.createRow();//创建行
            for (int j = 0; j < li.size(); j++) {
                XWPFParagraph cellParagraphC = rowsContent.getCell(j).getParagraphs().get(0);//每个行每列单元格
                cellParagraphC.setAlignment(ParagraphAlignment.CENTER); //设置表格内容居中
                cellParagraphC.setVerticalAlignment(TextAlignment.CENTER);
                XWPFRun cellParagraphRunC = cellParagraphC.createRun();
                cellParagraphRunC.setFontSize(10); //设置表格内容字号
                //cellParagraphRunC.setBold(true);//字体加粗
                cellParagraphRunC.setText(String.valueOf("" + li.get(j) + "")); //单元格数据
            }
        }
    }

    //震区人口信息-表格1
    public void zqrkxxTable1(XWPFTable table, CustomXWPFDocument document2,String dzsjId) {
        List<TownPopulationBean> getQueryPopulationTable = this.DataService.getQueryPopulationTable(dzsjId);
        for (int i = 0; i < 9; i++) {
            List li = new ArrayList();
            li.add(i+1);
            li.add(getQueryPopulationTable.get(i).getName());
            li.add(getQueryPopulationTable.get(i).getTotal());
            li.add(getQueryPopulationTable.get(i).getUnder14());
            li.add(getQueryPopulationTable.get(i).getResident());
            XWPFTableRow rowsContent = table.createRow();//创建行
            for (int j = 0; j < li.size(); j++) {
                XWPFParagraph cellParagraphC = rowsContent.getCell(j).getParagraphs().get(0);//每个行每列单元格
                cellParagraphC.setAlignment(ParagraphAlignment.CENTER); //设置表格内容居中
                cellParagraphC.setVerticalAlignment(TextAlignment.CENTER);
                XWPFRun cellParagraphRunC = cellParagraphC.createRun();
                cellParagraphRunC.setFontSize(10); //设置表格内容字号
                //cellParagraphRunC.setBold(true);//字体加粗
                cellParagraphRunC.setText(String.valueOf("" + li.get(j) + "")); //单元格数据
            }
        }
    }

    //重点目标信息-表格1
    public void zdmbxxTable1(XWPFTable table, CustomXWPFDocument document2,String dzsjId) {
        List<TownPopulationBean> getQueryPopulationTable = this.DataService.getQueryPopulationTable(dzsjId);
        for (int i = 0; i < 3; i++) {
            List li = new ArrayList();
            li.add(i+1);
            li.add("11");
            li.add("22");
            li.add("33");
            li.add("44");
            li.add("55");
            li.add("66");
            li.add("77");
            li.add("88");
            XWPFTableRow rowsContent = table.createRow();//创建行
            for (int j = 0; j < li.size(); j++) {
                XWPFParagraph cellParagraphC = rowsContent.getCell(j).getParagraphs().get(0);//每个行每列单元格
                cellParagraphC.setAlignment(ParagraphAlignment.CENTER); //设置表格内容居中
                cellParagraphC.setVerticalAlignment(TextAlignment.CENTER);
                XWPFRun cellParagraphRunC = cellParagraphC.createRun();
                cellParagraphRunC.setFontSize(10); //设置表格内容字号
                //cellParagraphRunC.setBold(true);//字体加粗
                cellParagraphRunC.setText(String.valueOf("" + li.get(j) + "")); //单元格数据
            }
        }
    }

    //震中空间距离分布-表格1
    public void zzkjjlfbTable1(XWPFTable table, CustomXWPFDocument document2,String dzsjId) {
        List<TownPopulationBean> getQueryPopulationTable = this.DataService.getQueryPopulationTable(dzsjId);
        for (int i = 0; i < 6; i++) {
            List li = new ArrayList();
            li.add(i+1);
            li.add("11");
            li.add("22");
            li.add("33");
            li.add("44");
            XWPFTableRow rowsContent = table.createRow();//创建行
            for (int j = 0; j < li.size(); j++) {
                XWPFParagraph cellParagraphC = rowsContent.getCell(j).getParagraphs().get(0);//每个行每列单元格
                cellParagraphC.setAlignment(ParagraphAlignment.CENTER); //设置表格内容居中
                cellParagraphC.setVerticalAlignment(TextAlignment.CENTER);
                XWPFRun cellParagraphRunC = cellParagraphC.createRun();
                cellParagraphRunC.setFontSize(10); //设置表格内容字号
                //cellParagraphRunC.setBold(true);//字体加粗
                cellParagraphRunC.setText(String.valueOf("" + li.get(j) + "")); //单元格数据
            }
        }
    }

    //震中空间距离分布-表格2
    public void zzkjjlfbTable2(XWPFTable table, CustomXWPFDocument document2,String dzsjId) {
        List<TownPopulationBean> getQueryPopulationTable = this.DataService.getQueryPopulationTable(dzsjId);
        for (int i = 0; i < 5; i++) {
            List li = new ArrayList();
            li.add(i+1);
            li.add("11");
            li.add("22");
            XWPFTableRow rowsContent = table.createRow();//创建行
            for (int j = 0; j < li.size(); j++) {
                XWPFParagraph cellParagraphC = rowsContent.getCell(j).getParagraphs().get(0);//每个行每列单元格
                cellParagraphC.setAlignment(ParagraphAlignment.CENTER); //设置表格内容居中
                cellParagraphC.setVerticalAlignment(TextAlignment.CENTER);
                XWPFRun cellParagraphRunC = cellParagraphC.createRun();
                cellParagraphRunC.setFontSize(10); //设置表格内容字号
                //cellParagraphRunC.setBold(true);//字体加粗
                cellParagraphRunC.setText(String.valueOf("" + li.get(j) + "")); //单元格数据
            }
        }
    }

    //震中空间距离分布-表格2
    public void zzkjjlfbTable3(XWPFTable table, CustomXWPFDocument document2,String dzsjId) {
        List<TownPopulationBean> getQueryPopulationTable = this.DataService.getQueryPopulationTable(dzsjId);
        for (int i = 0; i < 5; i++) {
            List li = new ArrayList();
            li.add(i+1);
            li.add("11");
            li.add("22");
            XWPFTableRow rowsContent = table.createRow();//创建行
            for (int j = 0; j < li.size(); j++) {
                XWPFParagraph cellParagraphC = rowsContent.getCell(j).getParagraphs().get(0);//每个行每列单元格
                cellParagraphC.setAlignment(ParagraphAlignment.CENTER); //设置表格内容居中
                cellParagraphC.setVerticalAlignment(TextAlignment.CENTER);
                XWPFRun cellParagraphRunC = cellParagraphC.createRun();
                cellParagraphRunC.setFontSize(10); //设置表格内容字号
                //cellParagraphRunC.setBold(true);//字体加粗
                cellParagraphRunC.setText(String.valueOf("" + li.get(j) + "")); //单元格数据
            }
        }
    }

    //震区经济信息-表格1
    public void zqjjxxTable1(XWPFTable table, CustomXWPFDocument document2,String dzsjId) {
        List<TownPopulationBean> getQueryPopulationTable = this.DataService.getQueryPopulationTable(dzsjId);
        List<EqEconomy> getQueryTableEconomic = this.DataService.getQueryTableEconomic(dzsjId);
        for (int i = 0; i < getQueryTableEconomic.size(); i++) {
            List li = new ArrayList();
            li.add(i+1);
            li.add(getQueryTableEconomic.get(i).getName());
            li.add(getQueryTableEconomic.get(i).getGdp());
            li.add(getQueryTableEconomic.get(i).getIndustryValue());
            li.add(getQueryTableEconomic.get(i).getAgriValue());
            li.add(getQueryTableEconomic.get(i).getServiceValue());
            XWPFTableRow rowsContent = table.createRow();//创建行
            for (int j = 0; j < li.size(); j++) {
                XWPFParagraph cellParagraphC = rowsContent.getCell(j).getParagraphs().get(0);//每个行每列单元格
                cellParagraphC.setAlignment(ParagraphAlignment.CENTER); //设置表格内容居中
                cellParagraphC.setVerticalAlignment(TextAlignment.CENTER);
                XWPFRun cellParagraphRunC = cellParagraphC.createRun();
                cellParagraphRunC.setFontSize(10); //设置表格内容字号
                //cellParagraphRunC.setBold(true);//字体加粗
                cellParagraphRunC.setText(String.valueOf("" + li.get(j) + "")); //单元格数据
            }
        }
    }



    //每格背景色
    public void setCellText1(XWPFTableCell cell, String text, int width, boolean isShd, int shdValue, String shdColor) {
        CTTc cttc = cell.getCTTc();
        CTTcPr ctPr = cttc.isSetTcPr() ? cttc.getTcPr() : cttc.addNewTcPr();
        CTShd ctshd = ctPr.isSetShd() ? ctPr.getShd() : ctPr.addNewShd();
        if (isShd) {
            if (shdValue > 0 && shdValue <= 38) {
                //ctshd.setVal(STShd.Enum.forInt(shdValue));
            }
            if (shdColor != null) {
                ctshd.setFill(shdColor);
                // ctshd.setColor("auto");
                //ctshd.setColor(shdColor);
            }
        }
        ctshd.setColor(shdColor);
    }

}

