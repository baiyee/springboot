package com.zx.springboot.lambda.stream;

import net.sf.ezmorph.test.ArrayAssertions;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

/**
 * @description: Stream reduce 操作
 * reduce 操作可实现从一组值中生成一个值，StreamTest3中例子用到的count,min和max方法,
 *        因为常用而被纳入标准库中。事实上，这些方法都是reduce操作。
 * 题目：使用reduce 操作实现累加，Lambda表达式就是reducer，它执行求和操作，有两个参数：传入Stream中的当前元素和acc。
 *      将两数相加，acc是累加器，identity保存着当前累加结果。
 * @date 2021/7/16
 * @author zhangxuan
 */
public class StreamTest4 {
    public static void main(String[] args) {
        //count 计算结果值   Stream.of(1,2,3) 生成一个 包含 这三个数字的流，流可以转成任意集合，list、map、都行.
        int count = Stream.of(1,2,3)
                // 第一个参数identity 代表根据运算式里面结果运算后，再进行运算。运算符号是表达式里运算符号。
                // 第二个参数accumulator 表示组合两个值的函数，也就说 两个函数进行累加 值赋给第一个参数.
                // acc 表示lambda表达式返回最新的值，
                // 比如第一次计算 acc=0; element=1; acc=0+1; identity=10;
                // 第二次计算 acc=1; element=2;  acc=1+2;  identity=10; 如此类推...
                // 第三次计算 acc=3; element=3;  acc=3+3;  identity=10;
                // 第四次计算 acc=6; identity=10; count=acc+identity; count=16;
                .reduce(10,(acc,element) -> acc + element);
        ArrayAssertions.assertEquals(16,count);

        //展开reduce操作
        BinaryOperator<Integer> accumulator = (acc, element) -> acc + element;
        int count2 = accumulator.apply(
                accumulator.apply(
                        accumulator.apply(0,1),
                2),
        3);

        //使用命令式编程方式求和
        //在命令式编程方式下，每一次循环将集合中的元素和累加器累加，用相加后的结果更新累加器。
        // 对于集合来说，循环在外部，需要且手动更新变量。
        int acc = 0;
        for (Integer element: Arrays.asList(1,2,3)) {
            acc += element;
        }
        ArrayAssertions.assertEquals(6,acc);
    }


}
