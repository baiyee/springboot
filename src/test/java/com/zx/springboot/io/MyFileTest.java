package com.zx.springboot.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

/**
 * @author zhangxuan
 * @description: File
 * • 封装磁盘路径字符串
 * • 文件路径
 * • 文件夹路径
 * • 不存在的路径
 * • 可获得文件或文件夹属性 length() 文件字节量 ➗1024 = xx k  ➗1024 m 再➗1024 b 对目录无效
 *  • lastModified() 最后修改时间
 *  • getAbsolutePath() 完整路径
 *
 * • 可创建或删除文件或文件夹
 *  • createNewFile() 创建文件
 *  • mkdirs() 创建多层文件夹
 *  • delete() 删除文件，或空文件夹
 *  • creatTempFile 创建临时文件
 *
 * • 获取文件夹列表
 *  ▪ list()
 *  ▪ listFiles()
 *

 * @date 2021/7/11
 */
public class MyFileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/zhangyuxuan/Desktop/test-word/多应用sql.txt");
        System.out.println(file.length());
        System.out.println(new Date(file.lastModified()));
        System.out.println(file.getAbsolutePath());


    }

}
