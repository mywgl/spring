package com.test;

import com.book.servlet.BookServlet;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APP2Test {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext2.xml");
    @Test
    public void test(){
        /**
         * 组件的id默认就是类名的首字母小写
         * 默认单例的
         **/

        Object bean = ioc.getBean("book");
        Object bean2 = ioc.getBean("book");
        System.out.println(bean);
        System.out.println(bean == bean2);

    }

    public void test2(){
        BookServlet bean = ioc.getBean(BookServlet.class);
        bean.doGet();
    }

}
