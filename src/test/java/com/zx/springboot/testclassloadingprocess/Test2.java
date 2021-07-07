package com.zx.springboot.testclassloadingprocess;

/**
 * @description: 对象的创建过程 加extends 继承重写
 * 执行结果为0   1、创建B2对象，先执行int i = 0 分配内存 并设置默认值   调用子类B2 的f() 方法打印i默认值0；
 * @date 2021/7/7
 * @author zhangxuan
 */
public class Test2 {
    public static void main(String[] args) {
        // new B2();
        A2 a = new A2();
        System.out.println(a.i);
    }
}

class A2 {
    int i = f();
     int f(){
         return 5;
     }
}

class B2 extends A2 {
    int f() {
        System.out.println(i);
    return 6;
    }
}