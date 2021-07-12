package com.zx.springboot.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @description:  字符编码流
 * @date 2021/7/12
 * @author zhangxuan
 */
public class MyCodeStreamTest2 {
    public static void main(String[] args) throws IOException {
        /**
         * 输出所有中文字符
         * '\u4e00'到'\u9fa5'
         * f7文件保存GBK
         * f8文件保存UTF-8
         *
         */
        f("/Users/zhangyuxuan/Desktop/test-word/f7.txt","GBK");
        f("/Users/zhangyuxuan/Desktop/test-word/f8.txt","UTF-8");

    }

    private static void f(String path, String encoding) throws IOException {
        OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(path),encoding);

        //'\u4e00'到'\u9fa5'
        //计数，没30个，加换行
        for (int i = 1, c =0x4e00;c<=0x9fa5; i++,c++ ) {
            out.write(c);
            if (i%10 == 0) {
                out.write("\n");
            }
        }
        out.close();
    }
}
