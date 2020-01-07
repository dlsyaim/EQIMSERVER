package com.gisinfo.sand.FastTrigger.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gisinfo.sand.FastTrigger.bean.FastTriggerBean;
import com.gisinfo.sand.FastTrigger.provider.FastTriggerProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;

//快速触发执行sql
@Mapper
public interface FastTriggerMapper extends BaseMapper<FastTriggerBean> {
    @InsertProvider(type= FastTriggerProvider.class,method = "addEQinfoData")
    void addEQinfoData(FastTriggerBean fastTriggerBean);
}
