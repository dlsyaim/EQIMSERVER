package com.gisinfo.sand.commonData.provider;

import com.gisinfo.sand.commonData.bean.EqStorageInventory;
import org.apache.ibatis.annotations.Param;

public class EqStorageInventoryProvider {
    public String getPageQuery(@Param("storageInventoryList") EqStorageInventory queryConditions) {
        StringBuilder builder = new StringBuilder("select * from(select t.*,rownum rn from (select * from storage_inventory a where 1=1");
        if (queryConditions.getGoodsName() != null && !"".equals(queryConditions.getGoodsName())) {
            builder.append("and a.GOODS_NAME =#{storageInventoryList.goodsName}");
        }
        builder.append(" and rownum<=#{storageInventoryList.top})t) t where t.rn >#{storageInventoryList.bottom}");
        return builder.toString();
    }


    public String getCountQuery(@Param("storageInventoryCount") EqStorageInventory queryConditions) {
        StringBuilder builder = new StringBuilder("select count(1) count from storage_inventory a where 1=1 ");
        if (queryConditions.getGoodsName() != null && !"".equals(queryConditions.getGoodsName())) {
            builder.append("and a.GOODS_NAME =#{storageInventoryCount.goodsName}");
        }

        return builder.toString();
    }
}
