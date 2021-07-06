package com.zx.springboot.global.enums;

/**
 *
 *
 */
public enum VideoUserPlayEnum {
    DEFAULT(0, "默认情况"),
    HAS_VIEW(1, "当天已观看超过6分钟，消耗一次观看次数");

    private int value;
    private String name;

    VideoUserPlayEnum(int value, String name) {
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
