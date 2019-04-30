package com.example.springboot.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 静态方法引用
 * 如果函数式接口的实现恰好是通过调用一个静态方法来实现，
 * 那么就可以使用静态方法引用
 * 语法 类名::staticMethod
 */
public class Example2 {

    public static String get() {
        return "hello";
    }

    public static void con(Integer size) {
        System.out.println("size:" + size);
    }

    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public static Integer len(String str1 ,String str2) {
        return str1.length() + str2.length();
    }

    public static void main(String[] args) {
        Supplier<String> s = () -> Example2.get();
        Supplier<String> s1 = () -> Fun.ret();

        Supplier<String> s2 = Example2::get;
        Supplier<String> s3 = Fun::ret;

        System.out.println(s1.get());

        Consumer<Integer> c1 = (size) -> Example2.con(size);
        Consumer<Integer> c2 = Example2::con;
        c2.accept(10);


        Function<String, String> f1 = str -> str.toUpperCase();
        Function<String, String> f2 = str -> Example2.toUpperCase(str);
        Function<String, String> f3 = Example2::toUpperCase;
        System.out.println(f3.apply("abcde"));

        BiFunction<String,String,Integer> bf1 = (ss1,ss2) -> ss1.length() + ss2.length();
        BiFunction<String,String,Integer> bf2 = (ss3, ss4) -> Example2.len(ss3,ss4);
        BiFunction<String,String,Integer> bf3 = Example2::len;
        System.out.println(bf3.apply("zhang","xuan"));
    }
}

class Fun {
    public static String ret() {
        System.out.println("put method invoke");
        return "hello function";
    }
}
