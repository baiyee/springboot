package com.zx.springboot.io;

import java.io.*;

/**
 * @description: ObjectInputStream/ObjectOutputStream
 *  • 对象序列化
 *   ▪ 对象的信息，按照固定的格式，转成一串字节序列格式进行输出
 *   ▪ 就是根据类名、类属性、类值顺序将对象通过输出流以byte数组格式输出到文件当中
 *  • 序列化的使用场景
 *   ▪ 游戏中 进度保存
 *  • ObjectInputStream
 *   ▪ writeObject(object) 把对象,序列化输出
 *
 *  • 反序列化
 *  • ObjectOutputStream
 *   ▪ readObject() 读取对象的序列化数据，反序列化恢复对象
 *  • 不序列化对象
 *   ▪ static 属于类，不随对象被序列化输出
 *   ▪ transient 临时，只在程序运行期间,在内存中存在，不会随对象，序列化持久保存
 *  • 序列化版本   static final long serialVersionUID = 42L;
 *   ▪ 旧版本的数据，不允许恢复成新版本的类型
 *   ▪ 如果自己不定义，编译器编译时，会根据类的定义信息，自动生成一个版本
 * @date 2021/7/12
 * @author zhangxuan
 */
public class MyObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /**
         * MyObject对象，序列化输出，保存文件
         * OOS--FOS--f5
         */
        MyObject myObject = new MyObject(1, "新一", "男", 25);
        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("/Users/zhangyuxuan/Desktop/test-word/f6.txt"));
        out.writeObject(myObject);
        out.close();

        /**
         * 从f5文件读取序列化对象，反序列化MyObject对象
         * OIS--FIS--f5
         */
        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream("/Users/zhangyuxuan/Desktop/test-word/f6.txt"));
        MyObject o = (MyObject) in.readObject();
        System.out.println(o.toString());
    }
}
