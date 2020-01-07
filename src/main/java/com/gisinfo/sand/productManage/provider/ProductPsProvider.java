package com.gisinfo.sand.productManage.provider;

import com.gisinfo.sand.productManage.bean.EarthquakeProductsPs;
import org.apache.ibatis.annotations.Param;

public class ProductPsProvider {
    public String getDocPageByQuery(@Param("earthquakeProductsPs") EarthquakeProductsPs queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select a.featid featid,a.rel_id rel_id,a.name name,a.file_type file_type,a.path path,a.product_version product_version,\n" +
                "a.product_type product_type,b.featid fid,b.EARTHQUAKE_NAME earthquake_name  from T_EARTHQUAKE_PRODUCTS_PS a, T_EARTHQUAKE_INFO b \n" +
                "where a.rel_id = b.featid and a.file_type='docx'");
        if (queryConditions.getEarthquakeName() != null && !"".equals(queryConditions.getEarthquakeName())) {
            builder.append("and b.earthquake_name like concat(concat('%',#{earthquakeProductsPs.earthquakeName}),'%')");
        }
        builder.append(" and rownum<=#{earthquakeProductsPs.top})t) t where t.rn >#{earthquakeProductsPs.bottom}");
        return builder.toString();
    }


    public String getDocCountQuery(@Param("productsPsCount") EarthquakeProductsPs queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from (select t.*,t2.* from T_EARTHQUAKE_PRODUCTS_PS t join T_EARTHQUAKE_INFO  t2 on t.rel_id =t2.featid where 1=1 and t.file_type='docx'");
        if (queryConditions.getEarthquakeName() != null && !"".equals(queryConditions.getEarthquakeName())) {
            builder.append("and t2.earthquake_name like concat(concat('%',#{productsPsCount.earthquakeName}),'%')");
        }
        builder.append(")");
        return builder.toString();
    }

    public String getJpgPageByQuery(@Param("earthquakeProductsPs") EarthquakeProductsPs queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select a.featid featid,a.rel_id rel_id,a.name name,a.file_type file_type,a.path path,a.product_version product_version,\n" +
                "a.product_type product_type,b.featid fid,b.EARTHQUAKE_NAME earthquake_name  from T_EARTHQUAKE_PRODUCTS_PS a, T_EARTHQUAKE_INFO b \n" +
                "where a.rel_id = b.featid and a.file_type='jpg'");
        if (queryConditions.getEarthquakeName() != null && !"".equals(queryConditions.getEarthquakeName())) {
            builder.append("and b.earthquake_name like concat(concat('%',#{earthquakeProductsPs.earthquakeName}),'%')");
        }
        builder.append(" and rownum<=#{earthquakeProductsPs.top})t) t where t.rn >#{earthquakeProductsPs.bottom}");
        return builder.toString();
    }


    public String getJpgCountQuery(@Param("productsPsCount") EarthquakeProductsPs queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from (select t.*,t2.* from T_EARTHQUAKE_PRODUCTS_PS t join T_EARTHQUAKE_INFO  t2 on t.rel_id =t2.featid where 1=1 and t.file_type='jpg'");
        if (queryConditions.getEarthquakeName() != null && !"".equals(queryConditions.getEarthquakeName())) {
            builder.append("and t2.earthquake_name like concat(concat('%',#{productsPsCount.earthquakeName}),'%')");
        }
        builder.append(")");
        return builder.toString();
    }

}
