package com.bean;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/11 22:32
 * @Version 1.0
 */

public class Student {
    private Integer sid;
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(Integer sid, String name, Integer age) {
        this.sid = sid;
        this.name = name;
        this.age = age;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
