package com.zx.springboot.io;

import java.io.Serializable;

/**
 * @description: Serializable
 * • 空接口
 * • 标识这个类可被序列化
 * @date 2021/7/12
 * @author zhangxuan
 */
public class MyObject  implements Serializable{
    static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String gender;
    private int age;

    public MyObject(int id, String name, String gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public MyObject setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MyObject setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public MyObject setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public int getAge() {
        return age;
    }

    public MyObject setAge(int age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
