package com.gisinfo.sand.util;

import cn.hutool.core.date.DateUtil;
import com.gisinfo.sand.dataManage.bean.EarthquakeInfo;

/**
 * 地震属性，参数业务工具类
 */
public final class EarthquakeUtil {

    //偏移类型-正常
    public static final String OFFSET_TYPE_M = "M";

    //偏移类型-上移
    public static final String OFFSET_TYPE_T = "T";

    //偏移类型-下移
    public static final String OFFSET_TYPE_B = "B";

    //图形类型-圆形
    public static final String GEOMETRY_TYPE_C = "C";

    //图形类型-椭圆
    public static final String GEOMETRY_TYPE_E = "E";

    //图形类型-线状
    public static final String GEOMETRY_TYPE_L = "L";

    /**
     * 判断烈度圈 geo 图形类型
     * @param intensity
     * @param modelId
     * @return
     */
    public static final String getIntensityGeometryType(int intensity, String modelId) {
        if (intensity <= 5) {
            return GEOMETRY_TYPE_C;
        } else {
            return GEOMETRY_TYPE_E;
        }
    }

    /**
     * 生成地震名称
     * @param bean
     * @return
     */
    public static final String createEarthquakeName(EarthquakeInfo bean) {
        if (null != bean) {
            return GisInfoDateUtil.getCHNDate(bean.getEarthquakeTime()) + bean.getProvince() + bean.getCounty() + bean.getEarthquakeLevel() + "级地震";
        }
        return ConstantsUtil.EMPTY_VALUE;
    }

}
