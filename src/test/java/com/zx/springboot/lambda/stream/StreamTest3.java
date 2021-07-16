package com.zx.springboot.lambda.stream;

import com.zx.springboot.lambda.Track;
import net.sf.ezmorph.test.ArrayAssertions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: max和min  Stream上常用的操作之一是求最大值和最小值。
 * @date 2021/7/16
 * @author zhangxuan
 */
public class StreamTest3 {
    public static void main(String[] args) {
        //使用Stream查找时间最短的曲目
        foundShortestTrack();
        //使用Stream查找时间最长的曲目
        foundLongestTrack();
        //使用for循环查找时间最短的曲目
        foundTrackByFor();
    }

    /**
     * 使用Stream 查找时间最短的曲目，展示如何max和min操作.方便检查结果，代码片段罗列了专辑中曲目信息
     */
    public static void foundShortestTrack() {
        List<Track> tracks = Arrays.asList(
                new Track("断桥残雪",227),
                new Track("素颜",243),
                new Track("有何不可",241));
        //找出长度在当前专辑列表中最小的专辑
        //Comparator.comparing 比较 这里传入的是多个对象，类似于 for循环中 调用Comparator.comparing方法
        Track shortestTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength()))
                                //get() 取出Optional 对象的中的值.
                                //这里没有.collect 选项，说明.min方法已经确定了返回结果值只有唯一一个，并不会出现集合.
                                .get();
        //数组断言集合类，调用assertEquals()断言方法，比较结果
        // true 继续执行.
        // false 抛出 Exception in thread "main" junit.framework.AssertionFailedError异常.
        ArrayAssertions.assertEquals(tracks.get(0),shortestTrack);
        System.out.println(shortestTrack);
    }

    /**
     * 使用Stream 查找时间最长的曲目
     */
    public static void foundLongestTrack() {
        List<Track> tracks = Arrays.asList(
                new Track("断桥残雪",227),
                new Track("素颜",243),
                new Track("有何不可",241));
        //找出长度在当前专辑列表中最小的专辑
        //Comparator.comparing 比较 这里传入的是多个对象，类似于 for循环中 调用Comparator.comparing方法
        Track shortestTrack = tracks.stream().max(Comparator.comparing(track -> track.getLength()))
                //get() 取出Optional 对象的中的值
                //这里没有.collect 选项，说明.min方法已经确定了返回结果值只有唯一一个，并不会出现集合
                .get();
        //数组断言集合类，调用assertEquals()断言方法，比较结果
        // true 继续执行
        // false 抛出 Exception in thread "main" junit.framework.AssertionFailedError异常
        ArrayAssertions.assertEquals(tracks.get(1),shortestTrack);
        System.out.println(shortestTrack);
    }

    /**
     * 使用for循环 查找时间最短的曲目
     */
    public static void foundTrackByFor() {
        List<Track> tracks = Arrays.asList(
                new Track("庐州月",255),
                new Track("素颜",243),
                new Track("惊鸿一面",256));
        Track shortestTrack = tracks.get(0);
        for (Track track: tracks) {
            if (track.getLength() < shortestTrack.getLength()) {
                shortestTrack = track;
            }
        }
        ArrayAssertions.assertEquals(tracks.get(1),shortestTrack);
    }

}
