package com.zx.springboot.global.enums;

/**
 * @Auther: xiexiaodong
 * @Date: 2018/8/21 12:01
 * @Description:
 */
public enum SmsValidEnum {
    SIGN_UP(1, "注册验证码"),
    BIND_USER_PHONE(2, "绑定手机"),
    RESET(3, "重置密码"),
    UN_BIND_EMAIL(4, "解绑邮箱"),
    BIND_PAD(5, "绑定设备");
    private int value;
    private String name;

    SmsValidEnum(int value, String name) {
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
