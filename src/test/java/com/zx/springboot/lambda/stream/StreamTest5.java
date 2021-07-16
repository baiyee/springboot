package com.zx.springboot.lambda.stream;

import com.zx.springboot.lambda.Album;
import com.zx.springboot.lambda.Artist;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * @description: Stream 整合操作
 * Stream接口的方法之多，有时让人难以选择，像闯入一个迷宫，不知道该用哪个方法更好。
 * 题目：找出某张专机上所有乐队的国籍。
 * 思考：艺术家列表中既有个人，也有乐队。利用一点领域知识，假定一般乐队名以定冠词The开头。当然这不是绝对的，但也差不多。
 * 步骤：1.找出专辑中所有表演者。2.区分哪些表演者是乐队。3.找出每个乐队的国籍。4.将找出的国籍放入一个集合。
 * 代码：1.Album类有个getMusicians方法，该方法返回一个Stream对象，包含整张专辑中所有的表演者；
 *      2.使用filter方法对表演者进行过滤，只保留乐队；
 *      3.使用map方法将乐队映射为国籍；
 *      4.使用collect((Collections.toList))方法将国籍放入一个列表。
 *      5.注意国籍不需要重复添加，这里我们使用set集合。
 * @date 2021/7/16
 * @author zhangxuan
 */
public class StreamTest5 {
    public static void main(String[] args) {
        Album album = new Album();
        album.setMusicians(Arrays.asList(new Artist("许嵩","许嵩","中国"),
                new Artist("The Linkin Park","查斯特·贝宁顿,麦克·信田,罗伯·巴登,大卫·菲尼克斯·法雷尔,布莱德·德尔森","America"),
                new Artist("The Beyond","黄家强、黄贯中、黄家驹、叶世荣","香港")));
        Set<String> origins = album.getMusicians().stream()
                                .filter(artist -> artist.getName().startsWith("The"))
                                .map(artist -> artist.getOrigin())
                                .collect(Collectors.toSet());
        System.out.println(origins);
    }
}
