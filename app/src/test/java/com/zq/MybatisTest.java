package com.zq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import startup.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.config.location=classpath:config/app-dev.yml", classes = Application.class)
public class MybatisTest {


    @Test
    public void test01(){

    }
}
