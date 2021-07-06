package com.zx.springboot.global.enums;

public enum SmsSendTypeEnum {
    FIVE_C("5c","美联软通"),ALIDAYU("alidayu","阿里大于"),MOVEK("movek","movek"),WEILAIWUXIAN("weilaiwuxian","未来无线");
    private String value;
    private String name;

    SmsSendTypeEnum(String value, String name) {
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
