package com.gisinfo.sand.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ReadXmlData {
    /**
     * dom4j解析Xml
     * @param xml
     */
    public  String[] getXmlRoute(String xml){
        Document doc = null;
        String[] route=null;
        try {
            // 将字符串转为XML
            doc = DocumentHelper.parseText(xml);
            // 获取根节点
            Element rootElt = doc.getRootElement();
            Element routelatlon=rootElt.element("routelatlon");
            String result=routelatlon.getText();
            route=result.split(";");
            return route;
        } catch (DocumentException e) {
            e.printStackTrace();
        }finally {
            return route;
        }
    }

    public static void main(String[] args) {
        ReadXmlData data=new ReadXmlData();
        String xml=HttpRequest.sendPost("http://api.tianditu.gov.cn/drive?postStr={%22orig%22:%22116.35506,39.92277%22,%22dest%22:%22116.39751,39.90854%22,%22style%22:%223%22}&type=search&tk=730f0599954d8bd42e72b9f13edddf6e","");

        String[] result=data.getXmlRoute(xml);

        for(int i=0;i<result.length;i++){
            System.out.println("第"+(i+1)+"个坐标==>"+result[i]);
        }
    }
}
