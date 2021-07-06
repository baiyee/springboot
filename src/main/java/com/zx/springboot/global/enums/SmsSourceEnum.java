package com.zx.springboot.global.enums;

public enum SmsSourceEnum {
    NORMAL_PAD("1", "普通设备申请"),
    TASTE_PAD("2", "体验设备申请"),
    REGISTER("3", "注册"),
    UNBIND_EMAIL("4", "解绑邮箱"),
    BACK_PASSWORD("5", "找回密码"),
    MANAGER("6", "后台发送"),
    RESEND("7", "重新发送"),
    ACTIVATION_SEND("8", "激活码发送"),
    GAME_PAD("9", "游戏设备申请"),
    BIND_PHONE("10", "绑定手机");
    private String value;
    private String name;

    SmsSourceEnum(String value, String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
