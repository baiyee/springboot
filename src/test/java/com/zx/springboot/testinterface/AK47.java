package com.zx.springboot.testinterface;

/**
 * @description: TODO 类描述 
 * @date 2021/7/7
 * @author zhangxuan
 */
public class AK47 implements Weapon{
    @Override
    public void kill() {
        System.out.println("咻咻咻~~~");
    }

    @Override
    public String getName() {
        return "zhangxuan的AK47";
    }

    @Override
    public int getType() {
        return TYPE_NUCLEAR;
    }
}
