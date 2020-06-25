package com.bean;

import java.util.List;

/**
 * @Description
 * @Author WGL
 * @Date 2020/6/4 17:35
 * @Version 1.0
 */

public class Person {
    private String lastName;
    private Integer age;
    private String email;
    private Car carl;
    private List<Integer> list;

    public Person() {
    }

    public Person(String lastName, Integer age, String email, Car carl, List<Integer> list) {
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.carl = carl;
        this.list = list;
    }

    public Car getCarl() {
        return carl;
    }

    public void setCarl(Car carl) {
        this.carl = carl;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                 carl +
                '}';
    }
}
