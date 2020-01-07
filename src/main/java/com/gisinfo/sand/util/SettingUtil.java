package com.gisinfo.sand.util;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson.JSONArray;
import com.gisinfo.sand.core.web.SandContext;

/**
 * @author majun
 * @time 2019-11-24
 * @content 简化获得config.xml中的自定义配置信息
 */
public class SettingUtil {

    /**
     * word模板路径
     * @return
     */
    public static final String getWordModelPath() {
        return SandContext.getValueFromGroup("custom", "word", "inPath");
    }

    /**
     * 上传文件路径
     * @return
     */
    public static final String getUploadPath() {
        return SandContext.getValueFromGroup("Http", "FileUpload", "uploadPath");
    }

    //region 权限

    public static final String getAuthUrl() {
        return SandContext.getValueFromGroup("custom", "auth", "url");
    }

    //endregion

    //region shape

    /**
     * 获得shape文件基础路径
     * @return
     */
    public static final String getShapeBasePath() {
        return SandContext.getValueFromGroup("custom", "shape", "basePath");
    }

    /**
     * 获得街镇shape名称
     * @return
     */
    public static final String getTownShape() {
        return SandContext.getValueFromGroup("custom", "shape", "townName");
    }

    /**
     * 获得栅格shape名称
     * @return
     */
    public static final String getGridShape() {
        return SandContext.getValueFromGroup("custom", "shape", "gridName");
    }

    /**
     * 获得社区shape名称
     * @return
     */
    public static final String getCommunityShape() {
        return SandContext.getValueFromGroup("custom", "shape", "communityName");
    }

    //endregion


}
