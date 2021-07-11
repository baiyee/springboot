package com.zx.springboot.testinterface;

/**
 * @description:  implements 关键字其实和extends 没有啥区别 是用来区分接口集成和类集成
 * @date 2021/7/7
 * @author zhangxuan
 */
public class Sword implements Weapon{

    @Override
    public void kill() {
        System.out.println("千刃追月~~~");
    }

    @Override
    public String getName() {
        return "魔刀千刃";
    }

    @Override
    public int getType() {
        return TYPE_COLD;
    }
}
