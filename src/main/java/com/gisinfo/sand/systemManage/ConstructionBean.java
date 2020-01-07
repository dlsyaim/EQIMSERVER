package com.gisinfo.sand.systemManage;


import cn.hutool.core.util.IdUtil;

public class ConstructionBean {
    public static void main(String[] args) {
        int i=10000;
        for(int j=0;j<i;j++){
                System.out.println("地"+j+"个==》"+ IdUtil.simpleUUID());
        }
        
    }
}
