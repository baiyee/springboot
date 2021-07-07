package com.zx.springboot.testclassloadingprocess;

/**
 * @description: 公共类类名必须与文件名一致，所以只能有一个public 修饰的类
 * 新建B的实例 new B()
 * 第一次使用A、B类
 * 1. 加载父类，为父类静态变量分配内存
 * 2. 加载子类，为子类静态变量分配内存
 * 3. 父类的静态变量赋值运算，和静态初始化块
 * 4. 子类的静态变量赋值运算，和静态初始化块
 * 再次使用A、B类
 * 5. 创建父类对象，为父类的“实例变量”分配内存
 * 6. 创建子类对象，为子类的“实例变量”分配内存
 * 7. 父类“实例变量”的赋值运算
 * 8. 父类的构造方法
 * 9. 子类“实例变量”的赋值运算
 * 10. 子类的构造方法
 * @date 2021/7/7
 * @author zhangxuan
 */
public class Test1 {
    public static void main(String[] args) {
        new B();
        System.out.println("---------");
        new B();
    }
}

class A {
    int v1 = 1; //5.v1分配内存 7.赋值
    static int v2 =2;//1.v2分配内存 3.v2 赋值
    static {
        System.out.println("A静态块"); //3.父类静态块
    };
    public A() {
        System.out.println("A构造方法");//8.父类构造方法
    };
}

class B extends  A {
    int v3 = 3; //6.v3分配内存 9.赋值
    static int v4 =4;//2.v4分配内存 4.v4赋值
    static {
        System.out.println("B静态块");//4.子类静态块
    };
    public B() {
        System.out.println("B构造方法");//10. 子类构造方法
    };
}
