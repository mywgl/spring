package com.book.dao;

import com.book.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/8 21:16
 * @Version 1.0
 */
@Repository
public class UserDao extends BaseDao<User> {
    @Override
    public void save() {
        System.out.println("UserDao 正在保存 用户");
    }
}
