package com.test;

import com.bean.Car;
import com.bean.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/4 17:43
 * @Version 1.0
 */
public class IOCTest {
    //ApplicationContext ioc容器
    //ClassPathXmlApplicationContext 当前应用的xml配置文件的在classpath下
    private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
    /**
     * @Description
     * 从容器中拿到这个组件
     * @Date  2020/6/4 17:48
     * @param 
     * @return 
     **/
    @Test
    public void test(){
        //获取 bean 实例 方式一
        // Person bean = (Person) ioc.getBean("person01");
        // 方式二
        Person bean = ioc.getBean("person01", Person.class);
        System.out.println(bean);

        Person bean1 = ioc.getBean("person02", Person.class);
        System.out.println(bean1);

        Car car = (Car) ioc.getBean("Car01");
        System.out.println("我自已的"+car);
        car.setName("ha ha");
        Person person03 = ioc.getBean("person03", Person.class);
        System.out.println("person中的"+person03.getCarl());

    }
}
