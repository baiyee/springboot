package com.zx.springboot.global.enums;

/**
 * @Auther: xiexiaodong
 * @Date: 2018/8/16 15:07
 * @Description:
 * 1.注册,2登陆,3.重置密码
 */
public enum SmsTypeEnum {
    REGISTER(1, "注册"),
    LOGIN_CODE(2, "登陆"),
    RESET_PASSWORD(3, "重置密码"),;

    private int value;
    private String name;

    SmsTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
