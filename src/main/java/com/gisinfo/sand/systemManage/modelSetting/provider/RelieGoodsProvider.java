package com.gisinfo.sand.systemManage.modelSetting.provider;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

//救援物资模型构建sql类
public class RelieGoodsProvider {
    //构建添加参数sql
    public String addRelieGoodParams(Map<String,Object> data){
        String wzlx = data.get("wzlx").toString();
        StringBuilder builder = new StringBuilder("insert into T_MODEL_FOOD t");
        if("帐篷".equals(wzlx)){
            builder.append("(t.featid,t.param_name,t.l0,t.l1,t.l2,t.l3,t.formula,t.model_version," +
                    "t.create_time,t.update_time,t.created_by,t.updated_by) " +
                    "values(#{featId},#{paramName},#{tent0},#{tent1},#{tent2},#{tent3}," +
                    "'帐篷',#{modelVersion},to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')," +
                    "to_date(#{updateTime},'yyyy-mm-dd hh24:mi:ss'),#{createdBy},#{updatedBy})");
                }else if("灾后粮食补助".equals(wzlx)){
                    builder.append("(t.featid,t.param_name,t.l0,t.l1,t.l2,t.l3,t.l4,t.l5,t.formula,t.model_version," +
                            "t.create_time,t.update_time,t.created_by,t.updated_by) " +
                            "values(#{featId},#{paramName},#{food0},#{food1},#{food2},#{food3},#{food4},#{food5}," +
                            "'灾后粮食补助',#{modelVersion},to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')," +
                            "to_date(#{updateTime},'yyyy-mm-dd hh24:mi:ss'),#{createdBy},#{updatedBy})");
                }else if("棉被".equals(wzlx)){
                    builder.append("(t.featid,t.param_name,t.l0,t.l1,t.l2,t.formula,t.model_version," +
                            "t.create_time,t.update_time,t.created_by,t.updated_by) " +
                            "values(#{featId},#{paramName},#{quilt0},#{quilt1},#{quilt2}," +
                            "'棉被',#{modelVersion},to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')," +
                            "to_date(#{updateTime},'yyyy-mm-dd hh24:mi:ss'),#{createdBy},#{updatedBy})");
                }else if("应急清洁饮水".equals(wzlx)){
                    builder.append("(t.featid,t.param_name,t.l0,t.l1,t.formula,t.model_version," +
                            "t.create_time,t.update_time,t.created_by,t.updated_by) " +
                            "values(#{featId},#{paramName},#{water0},#{water1}," +
                            "'应急清洁饮水',#{modelVersion},to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')," +
                            "to_date(#{updateTime},'yyyy-mm-dd hh24:mi:ss'),#{createdBy},#{updatedBy})");
                }else if("衣服".equals(wzlx)){
                    builder.append("(t.featid,t.param_name,t.l0,t.formula,t.model_version," +
                            "t.create_time,t.update_time,t.created_by,t.updated_by) " +
                            "values(#{featId},#{paramName},#{cloth0}," +
                            "'衣服',#{modelVersion},to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')," +
                            "to_date(#{updateTime},'yyyy-mm-dd hh24:mi:ss'),#{createdBy},#{updatedBy})");
                }else if("毛毯".equals(wzlx)){
                    builder.append("(t.featid,t.param_name,t.l0,t.l1,t.l2,t.formula,t.model_version," +
                            "t.create_time,t.update_time,t.created_by,t.updated_by) " +
                            "values(#{featId},#{paramName},#{blanket0},#{blanket1},#{blanket2}," +
                            "'毛毯',#{modelVersion},to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')," +
                            "to_date(#{updateTime},'yyyy-mm-dd hh24:mi:ss'),#{createdBy},#{updatedBy})");
                }else if("担架".equals(wzlx)){
                    builder.append("(t.featid,t.param_name,t.l0,t.formula,t.model_version," +
                            "t.create_time,t.update_time,t.created_by,t.updated_by) " +
                            "values(#{featId},#{paramName},#{dj0}," +
                            "'担架',#{modelVersion},to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')," +
                            "to_date(#{updateTime},'yyyy-mm-dd hh24:mi:ss'),#{createdBy},#{updatedBy})");
                }else if("病床".equals(wzlx)){
                    builder.append("(t.featid,t.param_name,t.l0,t.formula,t.model_version," +
                            "t.create_time,t.update_time,t.created_by,t.updated_by) " +
                            "values(#{featId},#{paramName},#{bed0}," +
                            "'病床',#{modelVersion},to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')," +
                            "to_date(#{updateTime},'yyyy-mm-dd hh24:mi:ss'),#{createdBy},#{updatedBy})");
                }else if("应急救灾款".equals(wzlx)){
                    builder.append("(t.featid,t.param_name,t.l0,t.l1,t.formula,t.model_version," +
                            "t.create_time,t.update_time,t.created_by,t.updated_by) " +
                            "values(#{featId},#{paramName},#{yjjzk0},#{yjjzk1}," +
                            "'应急救灾款',#{modelVersion},to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')," +
                            "to_date(#{updateTime},'yyyy-mm-dd hh24:mi:ss'),#{createdBy},#{updatedBy})");
                }else if("临时厕所".equals(wzlx)){
                    builder.append("(t.featid,t.param_name,t.l0,t.formula,t.model_version," +
                            "t.create_time,t.update_time,t.created_by,t.updated_by) " +
                            "values(#{featId},#{paramName},#{toilet0}," +
                            "'临时厕所',#{modelVersion},to_date(#{createTime},'yyyy-mm-dd hh24:mi:ss')," +
                            "to_date(#{updateTime},'yyyy-mm-dd hh24:mi:ss'),#{createdBy},#{updatedBy})");
                }

                return builder.toString();
    }
    //计算模型使用
    //模型参数查询sql
    /**
     * @param params
     * @return
     */
    public String getModelParamsByType(Map<String,Object> params){
        String modelType = params.get("modelType").toString();
        StringBuilder builder = new StringBuilder("select * from T_MODEL_FOOD t where t.MODEL_VERSION = #{maxVersion}");
        if("帐篷".equals(modelType)){
            builder.append(" and t.FORMULA = #{modelType}");
        }else if("灾后粮食补助".equals(modelType)){
            builder.append(" and t.FORMULA = #{modelType}");
        }else if("棉被".equals(modelType)){
            builder.append(" and t.FORMULA = #{modelType}");
        }else if("应急清洁饮水".equals(modelType)){
            builder.append(" and t.FORMULA = #{modelType}");
        }else if("衣服".equals(modelType)){
            builder.append(" and t.FORMULA = #{modelType}");
        }else if("毛毯".equals(modelType)){
            builder.append(" and t.FORMULA = #{modelType}");
        }else if("担架".equals(modelType)){
            builder.append(" and t.FORMULA = #{modelType}");
        }else if("病床".equals(modelType)){
            builder.append(" and t.FORMULA = #{modelType}");
        }else if("应急救灾款".equals(modelType)){
            builder.append(" and t.FORMULA = #{modelType}");
        }else if("临时厕所".equals(modelType)){
            builder.append(" and t.FORMULA = #{modelType}");
        }
        return builder.toString();
    }
}
