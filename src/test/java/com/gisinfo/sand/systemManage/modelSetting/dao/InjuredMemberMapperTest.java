package com.gisinfo.sand.systemManage.modelSetting.dao;

import com.gisinfo.sand.SandApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SandApplication.class)
public class InjuredMemberMapperTest {

    @Autowired
    private InjuredMemberMapper injuredMemberMapper;

    public static void main(String[] args) {
        double d = 5.23;
        double d2 = 2;
        d /= d2;
        System.out.println(d);
    }
}
