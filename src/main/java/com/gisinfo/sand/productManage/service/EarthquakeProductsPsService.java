package com.gisinfo.sand.productManage.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gisinfo.sand.productManage.bean.EarthquakeProductsPs;
import com.gisinfo.sand.productManage.dao.EarthquakeProductsPsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EarthquakeProductsPsService extends ServiceImpl<EarthquakeProductsPsMapper, EarthquakeProductsPs> {

    @Autowired(required = false)
    private EarthquakeProductsPsMapper productsPsMapper;


    public List<EarthquakeProductsPs> getDocListPage(EarthquakeProductsPs queryConditions) {
        List<EarthquakeProductsPs> list = productsPsMapper.queryDocPageList(queryConditions);
        return list;
    }

    public Integer getDocCount(EarthquakeProductsPs queryConditions) {
        return this.productsPsMapper.getDocTotalCount(queryConditions);
    }

    public List<EarthquakeProductsPs> getJpgListPage(EarthquakeProductsPs queryConditions) {
        List<EarthquakeProductsPs> list = productsPsMapper.queryJpgPageList(queryConditions);
        return list;
    }

    public Integer getJpgCount(EarthquakeProductsPs queryConditions) {
        return this.productsPsMapper.getJpgTotalCount(queryConditions);
    }

    public EarthquakeProductsPs getProductId(String featId) {
        return this.productsPsMapper.getProductPsById(featId);
    }

    public String getFileCount(){
        return this.productsPsMapper.getFileCount();
    }
}
