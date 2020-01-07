package com.gisinfo.sand.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gisinfo.sand.FastTrigger.service.FastTriggerService;

public class GetNewestData {
    public static JSONObject filterData(){
        HttpRequest req= new HttpRequest();
        String result=req.sendPost("http://www.ceic.ac.cn/ajax/speedsearch?num=1&&page=1","");
        String jsonStr=result.substring(1,result.length()-1);
        JSONObject json= JSON.parseObject(jsonStr);
        JSONArray list=JSONArray.parseArray(json.get("shuju").toString());
        System.out.println(list.size());
        int maxId=0;
        double eastRange=135.0;
        double westRange=73.0;
        double northRange=53.31;
        double southRange=4.50;
        JSONObject newestData=null;
        for (int i=0;i<list.size();i++){
            JSONObject data=(JSONObject) list.get(i);
            if(maxId<Integer.parseInt(data.get("id").toString())){
                maxId=Integer.parseInt(data.get("id").toString());
                newestData=data;
            }
            System.out.println(data.get("id"));
        }
        //筛选中国范围内的
        if(newestData != null){
            double latitude=Double.parseDouble(newestData.get("EPI_LAT").toString());
            double logitude=Double.parseDouble(newestData.get("EPI_LON").toString());
            if(latitude>southRange&&latitude<northRange&&logitude>westRange&&logitude<eastRange){
                return newestData;
            }
        }
        System.out.println(newestData);
        return null;
    }

    public static void main(String[] args) {
//        FastTriggerService fts=new FastTriggerService();
//        fts.addEQinfoData();
        GetNewestData.filterData();
    }
}
