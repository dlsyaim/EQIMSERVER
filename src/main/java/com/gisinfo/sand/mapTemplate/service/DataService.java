package com.gisinfo.sand.mapTemplate.service;

import com.gisinfo.sand.commonData.bean.EqEconomy;
import com.gisinfo.sand.mapTemplate.bean.*;
import com.gisinfo.sand.mapTemplate.dao.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Service
public class DataService {//extends ServiceImpl<TestMapper, TestBean>
    @Autowired(required = false)
    private DataMapper DataMapper;
    @Autowired(required = false)
    SimpleDateFormat sdf;

    //添加地震事件
    public Integer getAddDzsj(String value1, String value2, String value3, Double value5, String value6, String value7, String value8) {
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sdf.format(System.currentTimeMillis());//生成时间
        Integer data = this.DataMapper.getAddDzsj(value1, value2, value3, createTime, value5, value6, value7, value8);
        return data;
    }

    //添加地震事件-附件
    public Integer getAddDzsjFile(String FEATID, String REL_TABLE, String REL_ID,String OBJECT_TYPE, String ORIGINAL_NAME,
                                  String NAME, String FILE_TYPE, String PATH, String DESCRIPTION,String PRODUCT_TYPE,String PCH) {
        this.sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String createTime = sdf.format(System.currentTimeMillis());//生成时间
        Integer data = this.DataMapper.getAddDzsjFile(FEATID, REL_TABLE, REL_ID,OBJECT_TYPE, ORIGINAL_NAME, NAME, FILE_TYPE, PATH,
                createTime, DESCRIPTION,PRODUCT_TYPE,PCH);
        return data;
    }

    //查询地震事件
    public List<DzsjBean> getQueryDzsj(String featid) {
        List<DzsjBean> data = this.DataMapper.getQueryDzsj(featid);
        return data;
    }

    //查询地震事件-附件(根据featid查询)
    public List<DzsjFileBean> getQueryDzsjFile(String featid) {
        List<DzsjFileBean> data = this.DataMapper.getQueryDzsjFile(featid);
        return data;
    }

    //查询地震事件-附件(根据rel_id查询)
    public List<DzsjFileBean> getQueryDzsjFile_rel_id(String rel_id,String originalName,String pch) {
        List<DzsjFileBean> data = this.DataMapper.getQueryDzsjFile_rel_id(rel_id,originalName,pch);
        return data;
    }

    //查询叠加分析
    public List<Map> getQueryAnalysisTown(String featid) {
        List<Map> data = this.DataMapper.getQueryAnalysisTown(featid);
        return data;
    }

    //查询县区建筑
    public List<Map> getQueryCountyBuild(String featid) {
        List<Map> data = this.DataMapper.getQueryCountyBuild(featid);
        return data;
    }

    //查询城镇建筑
    public List<Map> getQueryTownBuild(String featid) {
        List<Map> data = this.DataMapper.getQueryTownBuild(featid);
        return data;
    }

    //查询城镇建筑
    public List<Map> getQueryCountyBuildId(String featid) {
        List<Map> data = this.DataMapper.getQueryCountyBuildId(featid);
        return data;
    }

//震区背景信息
    //查询活动断裂
    public List<ActivefaultBean> getQueryActivefaultId(String featid) {
        List<ActivefaultBean> data = this.DataMapper.getQueryActivefaultId(featid);
        return data;
    }


//人口信息
    //上海市人口分析
    public List<Map> getQueryPopulationSHS(String featid) {
        List<Map> data = this.DataMapper.getQueryPopulationSHS(featid);
        return data;
    }

    //区县人口分析
    public List<Map> getQueryPopulationQx(String featid) {
        List<Map> data = this.DataMapper.getQueryPopulationQx(featid);
        return data;
    }
    //街镇人口分析
    public List<Map> getQueryPopulationJz(String featid) {
        List<Map> data = this.DataMapper.getQueryPopulationJz(featid);
        return data;
    }



    //表格人口分析
    public List<TownPopulationBean> getQueryPopulationTable(String featid) {
        List<TownPopulationBean> data = this.DataMapper.getQueryPopulationTable(featid);
        return data;
    }

//震区经济信息
    //中心经济
    public List<Map> getQueryCentreEconomic(String featid) {
        List<Map> data = this.DataMapper.getQueryCentreEconomic(featid);
        return data;
    }
    //上海经济
    public List<Map> getQueryshanghaiEconomic(String featid) {
        List<Map> data = this.DataMapper.getQueryshanghaiEconomic(featid);
        return data;
    }
    //表格经济
    public List<EqEconomy> getQueryTableEconomic(String featid) {
        List<EqEconomy> data = this.DataMapper.getQueryTableEconomic(featid);
        return data;
    }
}
