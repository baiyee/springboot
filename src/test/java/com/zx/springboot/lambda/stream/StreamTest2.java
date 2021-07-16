package com.zx.springboot.lambda.stream;

import net.sf.ezmorph.test.ArrayAssertions;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: flatMap 方法 可用Stream 流替换 用于将多个Stream 流连接成一个Stream流输出.
 * 题目1：假设有一个包含多个列表的流，现在希望得到所有数字的序列.
 * @date 2021/7/16
 * @author zhangxuan
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<Integer>  together = Stream.of(Arrays.asList(1,2),Arrays.asList(3,4))
                .flatMap(numbers -> numbers.stream())
                .collect(Collectors.toList());
        // 为什么list toString方法能直接输出 集合里面的元素呢?
        // 通过查看代码，list 实现 abstractList 接口， abstractList 集成了 abstractCollection 接口，
        // abstractCollection 接口中重写了 Object 类中的 toString 方法.
        // 所以list.toString 方法其实就是调用的abstractCollection抽象类的toString方法.
        System.out.println(together.toString());
        ArrayAssertions.assertEquals(Arrays.asList(1,2,3,4),together);
        testArrays();
    }

    /**
     * 数组连接有两种方法
     * 方法一： list.addAll() 传入一个数组 注意：参数只能传一个 不支持多个参数
     * 方法二：Stream.flatMap() 传入多个对象，支持list、map、set、object等
     */
    public static void testArrays() {
        //stream flatMap 连接多个list 对象
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        System.out.println(list1.toString());
        List<String> list2 = new ArrayList<>();
        list2.addAll(list1);
        list2.add("b");
        list2.add("c");
        list2.add("d");
        System.out.println(list2.toString());
        List<String> results = Stream.of(list1, list2).flatMap(strings -> strings.stream())
                .collect(Collectors.toList());
        System.out.println(results);

        //stream flatMap map 对象
        Map<String,String> map1 = new HashMap<>();
        map1.put("z","x");
        map1.put("h","z");
        Map<String,String> map2 = new HashMap<>();
        map1.put("z2","x2");
        map1.put("h2","z2");
        List<String> results2 = Stream.of(map1, map2).flatMap(strings -> strings.values().stream())
                .collect(Collectors.toList());
        System.out.println(results2);
    }
}
