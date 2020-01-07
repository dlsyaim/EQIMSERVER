package com.gisinfo.sand.util.docx;

import com.gisinfo.sand.util.ConstantsUtil;
import com.gisinfo.sand.util.SettingUtil;

import java.io.File;

/**
 * Created by majun on 2016/5/12.
 */
public final class WordUtil {
    public static final String TEMPLATE_PATH = "___templatePath___";
    public static String WORD_IN_PATH = ConstantsUtil.EMPTY_VALUE;
    public static String WORD_OUT_PATH = ConstantsUtil.EMPTY_VALUE;
    public static final String FILE_NAME = "word";
    public static final String SUFFIX_DOCX = ".docx";
    public static final String SUFFIX_DOC = ".doc";

    static {
        WORD_IN_PATH = SettingUtil.getWordModelPath();
        WORD_OUT_PATH = SettingUtil.getUploadPath();
        WORD_OUT_PATH += FILE_NAME + File.separator;
    }

    /**
     * 获得word模板路径
     * @return
     */
    public static String getInPath() {
        return WORD_IN_PATH;
    }

    /**
     * 获得生成word路径
     * @return
     */
    public static String getOutPath() {
        return WORD_OUT_PATH;
    }

}
