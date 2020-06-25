package com.book.dao;

import com.book.bean.Book;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/7 20:21
 * @Version 1.0
 */
// 改id
// @Repository("book")
@Repository
// 改成多实例 默认单实例
// @Scope(value = "prototype")

public class BookDao extends BaseDao<Book> {
    public  void saveBook(){
        System.out.println("正在保存图书.....");
    }

    @Override
   public void save() {
        System.out.println("BookDao 保存Book...");
    }
}
