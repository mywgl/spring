package com.test;

import aop.impl.MyMathCalculator;
import aop.inter.Calculator;
import aop.proxy.CalculatorProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/10 10:14
 * @Version 1.0
 */

public class AopTest {
    /**
     * @Description
     * 有了动态代理，日志记录可以做的非常强大，而且与业务逻辑解耦
     * jdk的默认的动态代理，如果目标对象没有是实现任何接口，是无法为它创建代理对象的
     * @Date  2020/6/10 11:31
     * @return {@link null}
     **/
    @Test
    public void test(){
        Calculator cal = new MyMathCalculator();
        // cal.add(2, 3);
        // cal.div(4, 2);
        //获取的代理对象
        Calculator proxy = CalculatorProxy.getProxy(cal);
        //代理对象和被代理对象唯一产生的关联就是实现了同一个接口
        //interface aop.inter.Calculator
        System.out.println(Arrays.asList(proxy.getClass().getInterfaces()));
        proxy.add(2, 3);
        // proxy.div(2,0);
     }
   ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext3.xml");
    @Test
     public void test2(){
        Calculator bean = ioc.getBean(Calculator.class);
        bean.add(2, 3);
        // bean.div(2,0);
     }
}
