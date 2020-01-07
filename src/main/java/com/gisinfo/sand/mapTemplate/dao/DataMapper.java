package com.gisinfo.sand.mapTemplate.dao;

import com.gisinfo.sand.commonData.bean.EqEconomy;
import com.gisinfo.sand.mapTemplate.bean.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface DataMapper {//extends BaseMapper<TestBean>

    //添加地震事件
    @Insert("insert into T_EARTHQUAKE_INFO(FEATID,DATA_SOURCE,EARTHQUAKE_NAME,EARTHQUAKE_TIME,EARTHQUAKE_LEVEL,LONGITUDE,LATITUDE,FOCAL_DEPTH) \n" +
            "values(#{value1},#{value2},#{value3},to_date(#{value4},'yyyy-MM-dd HH24:mi:ss'),#{value5},#{value6},#{value7},#{value8})")
    Integer getAddDzsj(@Param("value1") String value1, @Param("value2") String value2, @Param("value3") String value3,
                       @Param("value4") String value4, @Param("value5") Double value5, @Param("value6") String value6,
                       @Param("value7") String value7, @Param("value8") String value8);

    //添加地震事件-附件
    @Insert("insert into T_EARTHQUAKE_PRODUCTS_PS(FEATID,REL_TABLE,REL_ID,OBJECT_TYPE,\n" +
            "ORIGINAL_NAME,NAME,FILE_TYPE,PATH,UPLOAD_DATE,DESCRIPTION,PRODUCT_TYPE,PCH) " +
            "values(#{FEATID},#{REL_TABLE},#{REL_ID},#{OBJECT_TYPE},#{ORIGINAL_NAME},#{NAME},#{FILE_TYPE}," +
            "#{PATH},to_date(#{UPLOAD_DATE},'yyyy-MM-dd HH24:mi:ss'),#{DESCRIPTION},#{PRODUCT_TYPE},#{PCH})")
    Integer getAddDzsjFile(@Param("FEATID") String FEATID, @Param("REL_TABLE") String REL_TABLE, @Param("REL_ID") String REL_ID,
                           @Param("OBJECT_TYPE") String OBJECT_TYPE,@Param("ORIGINAL_NAME") String ORIGINAL_NAME,@Param("NAME") String NAME,
                           @Param("FILE_TYPE") String FILE_TYPE, @Param("PATH") String PATH, @Param("UPLOAD_DATE") String UPLOAD_DATE,
                           @Param("DESCRIPTION") String DESCRIPTION,@Param("PRODUCT_TYPE") String PRODUCT_TYPE,@Param("PCH") String PCH);

    //查询地震事件
    @Select("select * from T_EARTHQUAKE_INFO where featid=#{featid}")
    List<DzsjBean> getQueryDzsj(@Param("featid") String rel_id);

    //查询地震事件-附件(根据featid查询)
    @Select("select * from T_EARTHQUAKE_PRODUCTS_PS where featid=#{featid}")
    List<DzsjFileBean> getQueryDzsjFile(@Param("featid") String featid);

    //查询地震事件-附件(根据rel_id查询)
    @Select("select * from T_EARTHQUAKE_PRODUCTS_PS where rel_id=#{rel_id} and original_name=#{originalName} " +
            " and pch=#{pch}")
    List<DzsjFileBean> getQueryDzsjFile_rel_id(@Param("rel_id") String rel_id, @Param("originalName") String originalName,
             @Param("pch") String pch);

    //查询叠加分析
    @Select("select count(DISTINCT COUNTYNAME) as cnames, sum( DISTINCT c.TOTAL_AREA)/10000 as zmj,round((sum( DISTINCT c.BRICK_STRUCTURE) / sum( DISTINCT c.TOTAL_AREA)) * 100, 3) as dcpt,round((sum( DISTINCT c.HIGH_RISE) / sum( DISTINCT c.TOTAL_AREA)) * 100, 3)as gcjz, round((sum( DISTINCT c.RCFRAME) / sum( DISTINCT c.TOTAL_AREA)) * 100, 3) as dczh, round((sum( DISTINCT c.SINGLE_AREA) / sum( DISTINCT c.TOTAL_AREA)) * 100, 3)     as dcmz  FROM ( SELECT * FROM T_ANALYSIS_TOWN a RIGHT JOIN T_EARTHQUAKE_INFO i on a.EARTHQUAKE_FEATID = i.FEATID WHERE i.FEATID = #{featid} AND INTENSITY = '6') r inner join TOWN_BUILDING t on r.TOWN_NAME = t.NAME  INNER JOIN COUNTY_BUILDING c  on c.name = t.COUNTYNAME ")
    List<Map> getQueryAnalysisTown(@Param("featid") String featid);

    //查询县区建筑
    @Select("SELECT name as cnames,TOTAL_AREA,round((t.BRICK_STRUCTURE / t.TOTAL_AREA) * 100, 3) as dcpt,round((t.HIGH_RISE / t.TOTAL_AREA) * 100, 3)as gcjz, round((t.RCFRAME / t.TOTAL_AREA) * 100, 3) as dczh, round((t.SINGLE_AREA / t.TOTAL_AREA) * 100, 3) as dcmz FROM county_building t INNER JOIN T_EARTHQUAKE_INFO e on e.county = t.name WHERE e.FEATID = #{featid}")
    List<Map> getQueryCountyBuild(@Param("featid") String featid);

    //查询城镇建筑
    @Select("SELECT name as cnames,TOTAL_AREA/10000 as zmj,round((t.BRICK_STRUCTURE / t.TOTAL_AREA) * 100, 3) as dcpt,round((t.HIGH_RISE / t.TOTAL_AREA) * 100, 3)as gcjz, round((t.RCFRAME / t.TOTAL_AREA) * 100, 3) as dczh,round((t.SINGLE_AREA / t.TOTAL_AREA) * 100, 3)     as dcmz FROM TOWN_BUILDING t RIGHT JOIN T_EARTHQUAKE_INFO i on t.NAME = i.town WHERE i.FEATID = #{featid}")
    List<Map> getQueryTownBuild(@Param("featid") String featid);

    //查询表格数据分析
    @Select("select DISTINCT c.NAME as cnames,c.TOTAL_AREA/10000 as zmj, c.BRICK_STRUCTURE as dcpt,c.HIGH_RISE as gcjz,c.RCFRAME  dczh,c.SINGLE_AREA  as dcmz FROM ( SELECT * FROM T_ANALYSIS_TOWN a RIGHT JOIN T_EARTHQUAKE_INFO i on a.EARTHQUAKE_FEATID = i.FEATID WHERE i.FEATID = #{featid}  AND INTENSITY = '6') r inner join TOWN_BUILDING t on r.TOWN_NAME = t.NAME  INNER JOIN COUNTY_BUILDING c  on c.name = t.COUNTYNAME")
    List<Map> getQueryCountyBuildId(@Param("featid") String featid);

//震区背景信息
    //查询活动断裂
    @Select("SELECT FEATURE,NAME,case when DIP_DIR = 'N' then '南' when DIP_DIR = 'S' then '北' when DIP_DIR = 'W' then '西' when DIP_DIR = 'E' then '东' when DIP_DIR = 'NW' then '西南' when DIP_DIR = 'NE' then '东南'when DIP_DIR = 'SW' then '西北'when DIP_DIR = 'SE' then '东北'end DIP_DIR FROM ACTIVEFAULT WHERE OBJECTID='18'")
    List<ActivefaultBean> getQueryActivefaultId(@Param("featid") String featid);


//人口信息

    //上海市人口分析
    @Select("select count(DISTINCT c.NAME) as cnames, sum( DISTINCT c.TOTAL) as zmj  FROM ( SELECT * FROM T_ANALYSIS_TOWN a RIGHT JOIN T_EARTHQUAKE_INFO i on a.EARTHQUAKE_FEATID = i.FEATID WHERE i.FEATID = #{featid} AND INTENSITY = '6') r inner join TOWN_BUILDING t on r.TOWN_NAME = t.NAME  INNER JOIN COUNTY_POPULATION c  on c.name = t.COUNTYNAME")
    List<Map> getQueryPopulationSHS(@Param("featid") String featid);

    //区县人口分析
    @Select("select t.NAME as names,t.total as totals FROM T_EARTHQUAKE_INFO i INNER JOIN COUNTY_POPULATION t on i.COUNTY = t.NAME WHERE i.FEATID = #{featid}")
    List<Map> getQueryPopulationQx(@Param("featid") String featid);
    //街镇人口分析
    @Select("select t.NAME as names,t.total as totals FROM T_EARTHQUAKE_INFO i INNER JOIN town_population t on i.TOWN = t.NAME WHERE i.FEATID = #{featid}")
    List<Map> getQueryPopulationJz(@Param("featid") String featid);

    //表格人口分析
    @Select("select name,total,UNDER14,RESIDENT from town_population WHERE OBJECTID_1<10")
    List<TownPopulationBean> getQueryPopulationTable(@Param("featid") String featid);

//震区经济信息
    //中心经济
    @Select("SELECT t.name as names, t.GDP as gdp,round(t.GDP/c.total,4) as meanGDP FROM T_EARTHQUAKE_INFO i INNER JOIN ECONOMY t on i.COUNTY = t.NAME INNER JOIN COUNTY_POPULATION c on i.COUNTY = c.NAME WHERE i.FEATID = #{featid}")
    List<Map> getQueryCentreEconomic(@Param("featid") String featid);
    //上海经济
    @Select("SELECT round(sum(t.GDP)/sum(c.TOTAL),4) as meanGDP FROM T_EARTHQUAKE_INFO i INNER JOIN ECONOMY t on i.COUNTY = t.NAME INNER JOIN COUNTY_POPULATION c on i.COUNTY = c.NAME")
    List<Map> getQueryshanghaiEconomic(@Param("featid") String featid);
    //表格经济
    @Select("SELECT name, GDP,INDUSTRY_VALUE,AGRI_VALUE,SERVICE_VALUE FROM ECONOMY")
    List<EqEconomy> getQueryTableEconomic(@Param("featid") String featid);

}
