package com.zx.springboot.io;

import java.util.Arrays;

/**
 * @description: 字符编码转换 Unicode 转其他编码
 * @date 2021/7/12
 * @author zhangxuan
 */
public class MyUnicodeParseTransformTest1 {
    public static void main(String[] args) throws Exception{
        String s = "abc中文喆镕";
        f(s,null);
        f(s,"GBK");
        f(s,"GB2312");
        f(s,"UTF-8");
    }

    private static void f(String s, String encoding) throws Exception {
        //Unicode 转其他编码
        byte[] a;
        if(encoding == null) {
            a = s.getBytes();//转成系统默认编码
        } else {
            a = s.getBytes(encoding);
        }
        System.out.println(encoding + "/t" + Arrays.toString(a));
    }


}
