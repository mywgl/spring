package com.test;

import com.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/7 19:01
 * @Version 1.0
 */

public class AppTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test(){
        Person bean = ioc.getBean(Person.class);
        System.out.println(bean);
    }
}
