package com.gisinfo.sand.FastTrigger.bean;

import com.gisinfo.sand.dataManage.service.EarthquakeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

@Component
public class StartUpBean implements CommandLineRunner {
    @Autowired
    private EarthquakeInfoService earthquakeInfoService;
    //自动触发
    public void run(String ...strings){
        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//
//            public void run() {
//                earthquakeInfoService.addWebAutoGraspData(null);
//                System.out.println("*********自动触发已完成**********");
//            }
//        }, 1000*5, 1000*60*30);
    }
}
