package com.zx.springboot.io;

import java.io.RandomAccessFile;

/**
 * @description: RandomAccessFile 读写文件的工具
 * 所有的文件(不管是图片、视频、音频、文字)都是在计算机眼里都是二进制数据，只不过表示方式不同而已
 *  ▪ 有一个下标，读写下标位置的字节值
 *  ▪ 每读取一个字节值，下标会自动向后移动
 *  ▪ 下标可以任意定位
 * • 创建对象
 *  ▪ new RandomAccessFile("文件", r) r，只读
 *  ▪ new RandomAccessFile("文件",rw)rw，读写
 * • 方法
 *  ▪ write(int b)
 *    int 的4个字节值，只输出末尾的一个字节值
 *  ▪ write(byte[] b)
 *    输出数组中，全部字节值
 *  ▪ write(byte[],start,length)
 *    输出数组中，从start位置开始的 到 length 个字节值
 *
 * @date 2021/7/11
 * @author zhangxuan
 */
public class MyRandomAccessFileTest {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("/Users/zhangyuxuan/Desktop/test-word/测试文件输出.txt","rw");
        System.out.println(randomAccessFile);
        randomAccessFile.write(97);
        randomAccessFile.write(98);
        randomAccessFile.write(99);
        RandomAccessFile randomAccessFile2 =
                new RandomAccessFile("/Users/zhangyuxuan/Desktop/test-word/测试文件输出.txt","rw");
        // randomAccessFile.write(new byte[1024],1,20);
    }
}
