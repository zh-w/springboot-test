package com.wz.test.SpringbootTest.bean;

/**
 * @Auther: wangzheng
 * @Date: 2019-06-29 21:30
 * @Description:
 */
public class SimpleBean {

    public String name;

    private int age ;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void init(){
        System.out.println("SimpleBean:"+name+":initing");
    }

    void destory(){
        System.out.println("SimpleBean:"+name+":destoryed");
    }
}
