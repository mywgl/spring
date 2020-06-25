package com.test;

import com.bean.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/11 21:53
 * @Version 1.0
 */

public class DatasourceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext4.xml");
    JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);
    @Test
    public void test(){
        DataSource bean = ioc.getBean(DataSource.class);
        try {
            Connection connection = bean.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Test
    public void test2(){
        String sql = "select id sid, name,age from test ";
        List<Student> st = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));
        System.out.println(st);

    }
}
