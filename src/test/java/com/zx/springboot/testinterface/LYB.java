package com.zx.springboot.testinterface;

/**
 * @description: TODO 类描述 
 * @date 2021/7/7
 * @author zhangxuan
 */
public class LYB implements Weapon{
    @Override
    public void kill() {
        System.out.println("蹦~蹦~蹦~");
    }

    @Override
    public String getName() {
        return "zhuangxuan的狼牙棒";
    }

    @Override
    public int getType() {
        return TYPE_NUCLEAR;
    }
}
