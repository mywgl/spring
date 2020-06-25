package com.book.servlet;

import com.book.dao.BookDao;
import com.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/7 20:19
 * @Version 1.0
 */
@Controller
public class BookServlet {
    /**
     * @Description
     * 自动装配
     * @Autowired
     * 方法上有 @Autowired 注解 在bean创建的时候自动运行
     * 在方法上色每一个参数都会自动注入值
     * required = false 当bean所要注入的值不存在就会自动注入null 值而不会报异常
     * @Qualifier("bookservice") :指定一个名做为id 让spring不要使用变量名作为id
     *
     * @Autowired、 @Resource、@Inject 都是自动装配的注解
     * @Autowired 是spring的注解
     * @Resource java的标准 扩展性更强 Autowired只能在spring中调用resource离开spring框架在其他框架能使用
     * @Inject
     *
     * @Date  2020/6/8 17:59
     * @return {@link null}
     **/
    @Qualifier("bookservice")
    @Autowired(required = false)
    private  BookService bookService;
    private BookDao bd;
    public  void doGet(){
        bookService.saveBook();
        System.out.println("保存保存图书完成！");
        System.out.println(bd);
    }


}
