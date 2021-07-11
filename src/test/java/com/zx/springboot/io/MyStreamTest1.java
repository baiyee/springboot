package com.zx.springboot.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @description: stream 流
 * 把数据的读写，抽象成数据在管道中流动
 * • 流是单向的
 *  ▪ 输入流，只能用来读取数据
 *  ▪ 输出流，只能用来输出数据
 * • 流只能一次性从头到尾读取数据
 *  ▪ 流动过的数据，不能反复流动
 *  ▪ 重复读写数据，只能重新新建流
 *
 * InputStream OutputStream
 * • 字节流的抽象父类
 * • 方法
 *  ▪ write(int b)
 *    int 的4个字节值，只输出末尾的一个字节值
 *  ▪ write(byte[] b)
 *    输出数组中，全部字节值
 *  ▪ write(byte[],start,length)
 *    输出数组中，从start位置开始的 到 length 个字节值
 *  ▪ flush() 刷出缓存数据
 *
 *  ▪ read()
 *  ▪ read(byte[] buff)
 *  ▪ available() 剩余可读取的字节数量
 *
 * FileInputStream/FileOutputStream
 *  • 创建对象
 *   ▪ new FileOutputStream(文件) 不管文件是否存在，都会新建一个新文件，若文件已经存在，也建一个空文件，把原来的文件覆盖掉
 *   ▪ new FileOutputStream(文件,true) 文件存在，向文件追加数据
 *
 * @date 2021/7/12
 * @author zhangxuan
 */
public class MyStreamTest1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileOutputStream out =
                new FileOutputStream("/Users/zhangyuxuan/Desktop/test-word/myStream.txt");
        out.write(97); // 00 00 00 61 -> 61
        out.write(98); // 00 00 00 61 -> 62
        out.write(99); // 00 00 00 61 -> 63
        out.write(356); // 00 00 00 61 -> 64

        byte[] a = {
                101,102,103,104,105,
                106,107,108,109,110
        };
        out.write(a);
        out.write(a,2,4);
        out.close();
    }
}
