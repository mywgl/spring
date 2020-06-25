package com.book.service;

import com.book.bean.Book;
import com.book.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/7 20:21
 * @Version 1.0
 */
@Service
public class BookService extends BaseService<Book> {
    @Autowired
    private BookDao bookDao;
    public  void saveBook(){
        System.out.println("正在调用saveBook方法.....");
        bookDao.saveBook();
    }
    /*
    public void save(){
        bookDao.save();
    }
    */
}
