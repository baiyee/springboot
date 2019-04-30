package com.example.springboot.lambda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 构造方法引用
 * 如果函数式接口恰好可以通过调用一个类的构造方法来实现，那么就可以使用构造方法引用
 */
public class Example5 {

    public static void main(String[] args) {
        Supplier<Person> p1 = () -> new Person();
        Supplier<Person> p2 = Person::new;
        p1.get();
        p2.get();

        Supplier<List> l1 = () -> new ArrayList();
        Supplier<List> l2 = ArrayList::new;
        Supplier<Set> s1 = HashSet::new;
        Supplier<Set<String>> s2 = () -> new HashSet<String>();
        Supplier<Set<Integer>> s3 = HashSet::new;

        Consumer<Integer> c = (age) -> new Account(age);
        Consumer<Integer> c2 = Account::new;
        c2.accept(123);

        Function<String, Integer> f1 = (str) -> Integer.valueOf(str);
        Function<String, Integer> f2 = Integer::valueOf;
        System.out.println(f2.apply("10000"));
    }
}

class Person {

    public Person() {
    }
}

class Account {

    public Account() {
        System.out.println("Account");
    }

    public Account(int age) {
        System.out.println("Account(age)");
    }
}