package com.zx.springboot.global.enums;

/**
 *
 * 分页
 *
 */
public enum AccountEnum {

    ALLOW(0, "可以"),
    BANNED(1, "禁言"),
    STATUS(1, "封禁");

    private int value;
    private String name;

    AccountEnum(int value, String name) {
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
