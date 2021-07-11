package com.zx.springboot.innerclass;


/**
 * @description: 内部类
 * @date 2021/7/11
 * @author zhangxuan
 */
public class Test1 {
    public static void main(String[] args) {
        A.Inner1 inner1 = new A.Inner1();
        A a = new A();
    }
}

class A {
    static class Inner1{}
    static class Inner2{}
}