package com.zx.springboot.lambda.refactor;

import net.sf.ezmorph.test.ArrayAssertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

/**
 * @description: 对流的操作以及解释说明
 * 题目1：将 字符串集合中的小写数组转换成大写 eg: List<String> strList = ("a","b","c")
 * 题目2：找出一组字符串中以数字开头的字符串，eg:"1abc"和"abc" 其中"1abc"是符合条件的字符串.
 * @date 2021/7/15
 * @author zhangxuan
 */
public class StreamTest1 {
    public static void main(String[] args) {
        //生成一个Stream,进行Stream上的操作，继而是collect 操作，由Stream 生成列表
        List<String> collected = Stream.of("a","b","c").collect(toList());
        //使用断言判断结果和预期一致
        assertEquals(Arrays.asList("a","b","c"), collected);
        //普通for循环转换大写
        forStringToUpperCase();
        //使用map操作将字符串转换成大写形式
        mapToUpperCaseString();
        //使用for循环找出字符串集合中满足第一个字符为数字的条件的字符串集合
        forFoundNumberPrefixString();
        //使用Stream函数式风格找出字符串集合中满足第一个字符为数字的条件的字符串集合
        streamFoundNumberPrefixString();
    }

    /**
     * 题目1
     * for循环将String字符串转换成大写
     */
    public static void forStringToUpperCase() {
        List<String> stringList = new ArrayList<>();
        for (String str:Arrays.asList ("a","b","hello")){
            String uppercaseString = str.toUpperCase();
            stringList.add(uppercaseString);
        }
        //使用断言判断结果和预期一致
        assertEquals(Arrays.asList("A","B","HELLO"),stringList);
    }

    /**
     * 题目1
     * 使用map操作将String字符串转换成大写
     */
    public static void mapToUpperCaseString() {
        List<String> collected = Stream.of("a","b","hello")
                //传给map的Lambda表达式只接受一个String。参数和返回值不必属于同一种类型，
                //但是Lambda 表达式必须是Function接口（只包含一个参数的普通函数接口）的一个实例
                .map(string -> string.toUpperCase())
                .collect(toList());
        //使用断言判断结果和预期一致 Arrays.asList 生成一个新list<String>列表
        assertEquals(Arrays.asList("A","B","HELLO"),collected);
    }

    /**
     * 题目2 找出一组字符串中第一个字符是否是数字？
     * for循环遍历，使用条件语句判断
     */
    public static void forFoundNumberPrefixString() {
        //创建一个list集合 用于添加结果字符串
        List<String> beginningWithNumbers = new ArrayList<>();
        for (String value : Arrays.asList("a","1abc","abc1")) {
            //Character.isDigit() 用于检测字符是否是数字 value.charAt(0) 获得字符串中开头第一个字符
            if (Character.isDigit(value.charAt(0))){
                //添加满足条件的字符串到新集合中
                beginningWithNumbers.add(value);
            }
        }
        //断言判断 是否与预期结果一致 无报错表示与预期结果一致， 报错表示与预期结果不一致
        ArrayAssertions.assertEquals(Arrays.asList("1abc"),beginningWithNumbers);
    }

    /**
     * 题目2 找出一组字符串中第一个字符是否是数字？
     * 函数式风格
     */
    public static void streamFoundNumberPrefixString() {
        //Stream.of() 参数：表示接收强制参数值，这些参数值都是新流的元素. 返回：T(...values)的流返回其元素为指定值的顺序有序流
        List<String> beginningWithNumbers = Stream.of("a","1abc","abc1")
                                            //.filter对上面这个数组("a","1abc","abc1")做一些过滤操作. 表达式中的结果true就过滤，false不过滤.
                                            //value是数组的每项元素，可理解为for循环遍历数组的得到的每个项.
                                            //Character.isDigit() 用于检测字符是否是数字 结果是隐藏的，也就是不出现在代码中的
                                            //value.charAt(0) 获得字符串中开头第一个字符
                                            .filter(value -> Character.isDigit(value.charAt(0)))
                                            //.collect 将结果转换, 可转list,map等 toList()表示生成一个新list列表
                                            .collect(toList());
        //断言判断 是否与预期结果一致 无报错表示与预期结果一致， 报错表示与预期结果不一致
        ArrayAssertions.assertEquals(Arrays.asList("1abc"),beginningWithNumbers);
    }


}
