package com.zx.springboot.testinterface;

/**
 * 接口概念：
 * 1. 接口是一个极端的抽象类
 * 2. 用interface 代替 class 用 implements 代替 extends
 * 3. 接口中只能定义：
 *     • 公开的抽象方法
 *     • 公开的常量
 *     • 公开的内部类、内部接口
 * 4. 接口中不能定义构造方法
 * 5. 接口的常量定义中包含缺省值(public static final)
 */
public interface Weapon {
    /**public static final 加上 static 的原因是 在方法区只保存一次 节省内存
     * 常量的定义 一般使用 static final 来定义  final 保证 值不可变*/
     int TYPE_COLD = 7365;
     int TYPE_HOT = 625;
     int TYPE_NUCLEAR = 10245;

    /**public abstract 都是缺省的，一般不写*/
     void kill();
     String getName();
     int getType();
}
