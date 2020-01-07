package com.gisinfo.sand.dataManage.provider;

import com.gisinfo.sand.dataManage.bean.EarthquakeGeo;
import org.apache.ibatis.annotations.Param;

public class EarthquakeGeoProvider {

    public String insert(@Param("bean") EarthquakeGeo earthquakeGeo){
        StringBuilder builder = new StringBuilder("");


        return builder.toString();
    }

}
