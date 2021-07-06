package com.zx.springboot.lambda;

import java.util.function.Function;

public class Example {
    public static void main(String[] args) {
        /**
         * 输入一个字符串，返回输入字符串的大写
         * aaa -> AAA
         */
        Function<String,String> fn = (str) -> str.toUpperCase();
        System.out.println(fn.apply("admin"));
        System.out.println("test coding");
    }
}
