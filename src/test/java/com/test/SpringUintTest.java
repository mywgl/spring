package com.test;

import com.book.servlet.BookServlet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description
 * 使用Spring的单元测试
 * 导包：Spring单元测试包 spring-test-版本号.jar
 * @ContextConfigurcation(locations="")使用它指定Spring的配置文件位置
 * @RunWint指定的用哪种驱动程序进行单元测试默认是junit
 *     @RunWith(SpringJUnit4ClassRunner.class)
 *     使用Spring的单元测试模块来执行了 @Test 注解的测试方法
 *     以前 @Test 注解只是由junit执行
 * 好处：
 *  不用使用 ioc.getBean() 获取组件 使用 @Autowired 自动装配
 * @Author WGL
 * @Date 2020/6/8 19:47
 * @Version 1.0
 */
@ContextConfiguration(locations = "classpath:applicationContext2.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringUintTest {
    @Autowired
    BookServlet bookServlet;
    @Test
    public void test(){
        System.out.println(bookServlet);
    }

}
