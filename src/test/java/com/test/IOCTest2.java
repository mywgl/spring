package com.test;

import com.book.service.BookService;
import com.book.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * 泛型依赖注入测试
 * @Author WGL
 * @Date 2020/6/8 21:32
 * @Version 1.0
 */
public class IOCTest2 {
   ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext2.xml");
    @Test
    public void test(){
        BookService book = ioc.getBean(BookService.class);
        UserService user = ioc.getBean(UserService.class);
        book.save();
        user.save();
        //带泛型的父类类型com.book.service.BaseService<com.book.bean.Book>
        System.out.println(book.getClass().getGenericSuperclass());
    }

}
