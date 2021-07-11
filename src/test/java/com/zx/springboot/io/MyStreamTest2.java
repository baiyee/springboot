package com.zx.springboot.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * @description: 读取数据
 * @date 2021/7/12
 * @author zhangxuan
 */
public class MyStreamTest2 {
    public static void main(String[] args) throws IOException{
        FileInputStream fi;
        fi = new FileInputStream("/Users/zhangyuxuan/Desktop/test-word/myStream.txt");
        //单字节读取
        int b;
        while ((b = fi.read()) != -1) {
            System.out.println(b);
        }
        fi.close();
        fi = new FileInputStream("/Users/zhangyuxuan/Desktop/test-word/myStream.txt");
        //批量读取
        byte[] buff = new byte[66];
        int n;
        while ((n = fi.read(buff)) != -1) {
            System.out.println(n + "/t" + Arrays.toString(buff));
        }
        fi.close();
    }
}
