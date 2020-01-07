package com.gisinfo.sand.queryGeographyInfo.geographyData.provider;

import com.gisinfo.sand.queryGeographyInfo.geographyData.condition.TEarthquakeProductsPsCondition;

//地震触发列表构建sql类
public class TEarthquakeProductsPsProvider {

    //查询总记录数
    public String getTEarthquakeProductsPsDOXCount(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition){
        StringBuilder builder =null;
        if(tEarthquakeProductsPsCondition.getRelId()!=null&&!"".equals(tEarthquakeProductsPsCondition.getRelId())){
            builder =new StringBuilder("select count(1) count from T_EARTHQUAKE_PRODUCTS_PS t INNER JOIN T_EARTHQUAKE_INFO i on i.FEATID = t.REL_ID  where 1=1 and t.FILE_TYPE not like concat(concat('%','docx'),'%') and t.REL_ID = #{relId}");
        }else {
            builder =new StringBuilder("select count(1) count from T_EARTHQUAKE_PRODUCTS_PS t INNER JOIN (SELECT * FROM T_EARTHQUAKE_INFO a WHERE ROWNUM <= 1 ORDER BY EARTHQUAKE_TIME DESC) i on i.FEATID = t.REL_ID  where 1=1 and t.FILE_TYPE like concat(concat('%','docx'),'%') ");
        }
        return builder.toString();
    }

    //查询总记录数
    public String getTEarthquakeProductsPsJPGCount(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition){
        StringBuilder builder =null;
        if(tEarthquakeProductsPsCondition.getRelId()!=null&&!"".equals(tEarthquakeProductsPsCondition.getRelId())){
            builder =new StringBuilder("select count(1) count from T_EARTHQUAKE_PRODUCTS_PS t INNER JOIN T_EARTHQUAKE_INFO i on i.FEATID = t.REL_ID  where 1=1 and t.FILE_TYPE like concat(concat('%','jpg'),'%') and t.REL_ID = #{relId}");
        } else {
            builder =new StringBuilder("select count(1) count from T_EARTHQUAKE_PRODUCTS_PS t INNER JOIN (SELECT * FROM T_EARTHQUAKE_INFO a WHERE ROWNUM <= 1 ORDER BY EARTHQUAKE_TIME DESC) i on i.FEATID = t.REL_ID  where 1=1 and t.FILE_TYPE like concat(concat('%','jpg'),'%') ");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getTEarthquakeProductsPsDOXList(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition){
        StringBuilder builder = null;
        if(tEarthquakeProductsPsCondition.getRelId()!=null&&!"".equals(tEarthquakeProductsPsCondition.getRelId())){
            builder =new StringBuilder("select * from T_EARTHQUAKE_PRODUCTS_PS t INNER JOIN T_EARTHQUAKE_INFO i on i.FEATID = t.REL_ID  where 1=1 and t.FILE_TYPE not like concat(concat('%','docx'),'%') and t.REL_ID = #{relId}");
        } else {
            builder =new StringBuilder("select * from T_EARTHQUAKE_PRODUCTS_PS t INNER JOIN (SELECT * FROM T_EARTHQUAKE_INFO a  ORDER BY EARTHQUAKE_TIME DESC) i on i.FEATID = t.REL_ID  where 1=1 and t.FILE_TYPE like concat(concat('%','docx'),'%') ");
        }
        return builder.toString();
    }

    //查询数据列表
    public String getTEarthquakeProductsPsJPGList(TEarthquakeProductsPsCondition tEarthquakeProductsPsCondition){
        StringBuilder builder = null;
        if(tEarthquakeProductsPsCondition.getRelId()!=null&&!"".equals(tEarthquakeProductsPsCondition.getRelId())){
            builder =new StringBuilder("select * from T_EARTHQUAKE_PRODUCTS_PS t INNER JOIN T_EARTHQUAKE_INFO i on i.FEATID = t.REL_ID  where 1=1 and t.FILE_TYPE like concat(concat('%','jpg'),'%') and t.REL_ID = #{relId}");
        }else {
            builder =new StringBuilder("select * from T_EARTHQUAKE_PRODUCTS_PS t INNER JOIN (SELECT * FROM T_EARTHQUAKE_INFO a   ORDER BY EARTHQUAKE_TIME DESC) i on i.FEATID = t.REL_ID  where 1=1 and t.FILE_TYPE like concat(concat('%','jpg'),'%') ");
        }
        return builder.toString();
    }
}
