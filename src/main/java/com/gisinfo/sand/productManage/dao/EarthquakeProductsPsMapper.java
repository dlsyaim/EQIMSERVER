package com.gisinfo.sand.productManage.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.productManage.bean.EarthquakeProductsPs;
import com.gisinfo.sand.productManage.provider.ProductPsProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

@Mapper
public interface EarthquakeProductsPsMapper extends BaseMapper<EarthquakeProductsPs> {

    @SelectProvider(type = ProductPsProvider.class, method = "getDocPageByQuery")
    List<EarthquakeProductsPs> queryDocPageList(@Param("earthquakeProductsPs") EarthquakeProductsPs queryConditions);

    //获取总条数
    @SelectProvider(type = ProductPsProvider.class, method = "getDocCountQuery")
    Integer getDocTotalCount(@Param("productsPsCount") EarthquakeProductsPs queryConditions);

    @SelectProvider(type = ProductPsProvider.class, method = "getJpgPageByQuery")
    List<EarthquakeProductsPs> queryJpgPageList(@Param("earthquakeProductsPs") EarthquakeProductsPs queryConditions);

    //获取总条数
    @SelectProvider(type = ProductPsProvider.class, method = "getJpgCountQuery")
    Integer getJpgTotalCount(@Param("productsPsCount") EarthquakeProductsPs queryConditions);

    //根据feadId查询地震表
    @Select("select * from T_EARTHQUAKE_PRODUCTS_PS T WHERE FEATID =#{featId}")
    EarthquakeProductsPs getProductPsById(@Param("featId") String featId);

    @Select("select count(1) count from T_EARTHQUAKE_PRODUCTS_PS")
    String getFileCount();

}
