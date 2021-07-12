package com.zx.springboot.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @description:  字符编码流
 * @date 2021/7/12
 * @author zhangxuan
 */
public class MyCodeStreamTest1 {
    public static void main(String[] args) throws IOException {
        /**
         * abc中文喆镕
         * f5 保存GBK编码
         * f6 保存UTF-8编码
         *
         * OSW--FOS--f5
         * OSW--FOS--F6
         */
        f("abc中文喆镕","/Users/zhangyuxuan/Desktop/test-word/f5.txt","GBK");
        f("abc中文喆镕","/Users/zhangyuxuan/Desktop/test-word/f5.txt","UTF-8");

    }

    private static void f(String s, String path, String encoding) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path),encoding);
        out.write(s);
        out.close();
    }
}
