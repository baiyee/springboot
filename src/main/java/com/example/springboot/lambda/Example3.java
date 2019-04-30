package com.example.springboot.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 实例方法引用
 * 如果函数式接口恰好是调用一个实例的实例方法来实现，那么就可以使用实例方法引用
 */
public class Example3 extends Base{

    public String put() {
        return "hello instance method function";
    }

    public void con(Integer size) {
        return;
    }

    public String toUpperCase(String str) {
        return str.toUpperCase();
    }

    public String toUpper(String str) {
        System.out.println("current to upper");
        return str.toUpperCase();
    }

    public void test() {
        Function<String, String> f5 = super::toUpper;
        System.out.println(f5.apply("supper method"));

        Function<String, String> f4 = this::toUpper;
        System.out.println(f4.apply("this method"));

    }

    public static void main(String[] args) {
        Supplier<String> s = () -> new Example3().put();
        Supplier<String> s1 = () -> {
            return new Example3().put();
        };

        Supplier<String> s2 = new Example3()::put;
        System.out.println(s2.get());

        Example3 example = new Example3();
        example.test();

        Consumer<Integer> c1 = (size) -> new Example3().con(size);
        Consumer<Integer> c2 = new Example3()::con;
        Consumer<Integer> c3 = example::con;
        c2.accept(1996);
        c3.accept(0322);

        Function<String, String> ss1 = (str) -> new Example3().toUpperCase(str);
        Function<String, String> ss2 = str -> example.toUpperCase(str);
        Function<String, String> s3 = str -> new Example3().toUpperCase(str);
        Function<String, String> s4 = new Example3()::toUpperCase;
        Function<String, String> s5 = example::toUpperCase;

        System.out.println(s4.apply("baiye"));
    }
}
