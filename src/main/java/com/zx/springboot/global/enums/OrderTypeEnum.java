package com.zx.springboot.global.enums;

public enum OrderTypeEnum {

    NORMAL("0", "正常订单"), REFUND("1", "退款订单");

    private String value;
    private String name;

    OrderTypeEnum(String value, String name) {
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
