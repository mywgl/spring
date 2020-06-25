package com.book.service;

import com.book.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/8 21:36
 * @Version 1.0
 */

public class BaseService<T> {
    @Autowired
    BaseDao<T> baseDao;
    public void save(){
        System.out.println("正在调用"+baseDao+"的Dao");
        baseDao.save();
    }
}
