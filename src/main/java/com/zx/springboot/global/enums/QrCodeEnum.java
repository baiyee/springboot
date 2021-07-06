package com.zx.springboot.global.enums;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public enum QrCodeEnum {
    INVITATION(1,"邀请码"),
    ACTIVATION(2,"激活兑换码"),
    ;


    private int id;
    private String value;

    private  static Map<Integer, QrCodeEnum> typeMap = new HashMap<>();
    static {
        for(QrCodeEnum msgType : values()) {
            typeMap.put(msgType.id, msgType);
        }
    }

    QrCodeEnum(int id , String value){
        this.id = id;
        this.value = value;
    }
    public static QrCodeEnum getEnum(int index){
        return typeMap.get(index);
    }

    public int index() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
