package com.wz.test.SpringbootTest.mybatis.entity;

/**
 * @Auther: wangzheng
 * @Date: 2019-06-05 14:59
 * @Description:
 */

public class Account {

    private int id;

    private String name;

    private int age;

    private double account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAccount() {
        return account;
    }

    public void setAccount(double account) {
        this.account = account;
    }
}
