package com.gisinfo.sand.main;

import com.gisinfo.sand.core.security.EncryptDisable;
import com.gisinfo.sand.util.WindowsInfoUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SystemInfoController {


    @EncryptDisable
    @RequestMapping(value = "/getSystemInfo", method = RequestMethod.GET)
    public Map<String,Object> getFocalDepthList(){
        Map<String,Object> map=new HashMap<>();
        final List<Object> memory = WindowsInfoUtil.getMemery();
        final List<Object> cpuRatioForWindows = WindowsInfoUtil.getCpuRatioForWindows();
        final List<Object> disk = WindowsInfoUtil.getDisk();
        map.put("memory",memory);
        map.put("cpu",cpuRatioForWindows);
        map.put("disk",disk);
        return map;
    }
}
