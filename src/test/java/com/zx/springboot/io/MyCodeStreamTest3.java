package com.zx.springboot.io;

import java.io.*;

/**
 * @description:  字符编码流 一行行读取
 * @date 2021/7/12
 * @author zhangxuan
 */
public class MyCodeStreamTest3 {
    public static void main(String[] args) throws IOException {
        /**
         * 读取f8 文件 一行行读取
         *
         */
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                new FileInputStream("/Users/zhangyuxuan/Desktop/test-word/f7.txt"),"GBK"));
        String line;
        while ((line =in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
    }

}
