package com.zx.springboot.lambda.stream;

import net.sf.ezmorph.test.ArrayAssertions;

import java.util.Arrays;
import java.util.List;
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
    }
}
