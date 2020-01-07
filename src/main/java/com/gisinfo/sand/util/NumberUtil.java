package com.gisinfo.sand.util;


public class NumberUtil {

    public static String toLuMaNumber(int i) {
        switch (i) {
            case 1:
                return "Ⅰ";
            case 2:
                return "Ⅱ";
            case 3:
                return "Ⅲ";
            case 4:
                return "Ⅳ";
            case 5:
                return "Ⅴ";
            case 6:
                return "Ⅵ";
            case 7:
                return "Ⅶ";
            case 8:
                return "Ⅷ";
            case 9:
                return "Ⅸ";
            case 10:
                return "Ⅹ";
            case 11:
                return "ⅩⅠ";
            case 12:
                return "ⅩⅡ";
            case 13:
                return "ⅩⅢ";
            case 14:
                return "ⅩⅣ";
            case 15:
                return "ⅩⅤ";
            case 16:
                return "ⅩⅥ";
            default:
                return "";
        }
    }

    /**
     * 将地震烈度转换为经济损失模型需要的参数
     * @param i
     * @return
     */
    public static String toELParam(int i) {
        if (i < 6) {
            return "";
        } else if (i == 6) {
            return "6度区";
        }else if (i == 7) {
            return "7度区";
        } else if (i == 8) {
            return "8度区";
        } else {
            return "9度区及以上";
        }

    }
}
