package com.zx.springboot.lambda;

import java.io.Closeable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 对象方法引用
 * 抽象方法的第一个参数类型刚好是实例方法的类型，
 * 抽象方法剩余的参数恰好可以当做实例方法的参数，
 * 如果函数式接口的实现能由上面说的实例方法调用来实现的话，
 * 那么就可以使用对象方法引用
 *
 * 语法
 * 类名::instMethod
 */
public class Example4 {

    /**
     * 抽象方法没有输入参数，不能使用对象方法引用
     */
    public void not() {
        Runnable r = () -> {};
        Closeable c = () -> {};
        Supplier<String> s = () -> "";
    }

    public static void main(String[] args) {
        Consumer<Too> c1 = (Too too) -> {new Too().foo();};
        Consumer<Too> c2 = Too::foo;
        c1.accept(new Too());
        c2.accept(new Too());

        BiConsumer<Too2, String> c5 = ((too2, s) -> new Too2().fo(s))  ;
        BiConsumer<Too2, String> c6 = Too2::fo;

        BiFunction<Prod,String,Integer> bf1 = (p,s) -> new Prod().fun(s);
        BiFunction<Prod,String,Integer> bf2 = Prod::fun;
        BiFunction<Prod,String,Integer> bf3 = (p,s) -> new Too().fun(s);

        Execute ex = (p,name ,size) -> new Prod().run(name,size);
        Execute ex2 = Prod::run;
    }
}

@FunctionalInterface
interface Execute {
    public void run(Prod p,String name, String size);
}

class Prod {

    public void run(String name ,String size) {

    }

    public Integer fun(String s) {
        return 1;
    }
}

class Too {

    public void  foo() {
        System.out.println("invoke");
    }

    public Integer fun(String s) {
        return 1;
    }

}

class Too2 {
    public void fo0() {
        System.out.println("invoke");
    }

    public void fo(String str) {

    }
}
