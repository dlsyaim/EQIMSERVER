package com.gisinfo.sand.dataManage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.dataManage.bean.EarthquakeGeo;
import com.gisinfo.sand.dataManage.provider.EarthquakeGeoProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface EarthquakeGeoMapper extends BaseMapper<EarthquakeGeo> {

    @Insert("INSERT INTO T_GEO_RESULT(FEATID,EARTHQUAKE_FEATID,BATCH_NUMBER,GEO,OFFSET_TYPE,SHAPE_TYPE,INTENSITY,AREA) VALUES" +
            "(#{bean.featid,jdbcType=VARCHAR},#{bean.earthquakeFeatid,jdbcType=VARCHAR},#{bean.batchNumber,jdbcType=INTEGER}," +
            "#{bean.geo,jdbcType=CLOB},#{bean.offsetType,jdbcType=VARCHAR},#{bean.shapeType,jdbcType=VARCHAR}," +
            "#{bean.intensity,jdbcType=INTEGER},#{bean.area,jdbcType=DOUBLE})")
    Integer insertData(@Param("bean") EarthquakeGeo earthquakeGeo);

    @Results({@Result(property = "geo", column = "geo", javaType = String.class, jdbcType = JdbcType.CLOB)
    })
    @Select("select * from T_GEO_RESULT where EARTHQUAKE_FEATID = #{earthquakeId} and BATCH_NUMBER = #{batch}")
    List<EarthquakeGeo> selectGeo(@Param("earthquakeId") String earthquakeId, @Param("batch") int batch);

}
