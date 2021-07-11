package com.zx.springboot.io;

import java.io.*;

/**
 * @description: 缓冲流 BufferInputStream
 * • 提供内存缓冲数组
 * • 提高单字节的读写效率
 * • 帮助做批量读写
 * @date 2021/7/12
 * @author zhangxuan
 */
public class MyBufferStreamTest {
    public static void main(String[] args) throws IOException {
        /**
         * BOS--FOS--f4
         */
        BufferedOutputStream out
                = new BufferedOutputStream(new FileOutputStream("/Users/zhangyuxuan/Desktop/test-word/f4.txt"));
        out.write(97);
        out.write(98);
        out.write(99);
        /**BufferedOutputStream将数据缓存在内存数据中，数组大小为8192字节，只有数据达到最大值才会被刷出。所以需要手动刷出*/
        out.flush();//刷出缓存数据

        /**
         * 高级流的close()
         *  1) flush()
         *  2) 关闭相接的流
         * */
        BufferedInputStream input =
                new BufferedInputStream(
                        new FileInputStream("/Users/zhangyuxuan/Desktop/test-word/f4.txt"));
        BufferedOutputStream output =
                new BufferedOutputStream(
                        new FileOutputStream("/Users/zhangyuxuan/Desktop/test-word/f5.txt"));
       //  //批量读取
       //  byte[] buff = new byte[66];
       //  int n;
       //  while ((n = input.read(buff)) != -1) {
       //      out.write(buff,0,n);
       // }
        //单字节读取
        int n;
        while ((n = input.read()) != -1) {
            System.out.println(n);
            output.write(n);
        }
        input.close();
        output.close();
    }
}
