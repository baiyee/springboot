package com.zx.springboot.global.enums;

import java.util.HashMap;
import java.util.Map;

public enum  TbStatusEnum {
    DISABLE(0,"下载"), //下载
    ENABLE(1,"上载"), //上载


    ;


    private int id;
    private String value;

    private  static Map<Integer, TbStatusEnum> typeMap = new HashMap<>();
    static {
        for(TbStatusEnum msgType : values()) {
            typeMap.put(msgType.id, msgType);
        }
    }

    TbStatusEnum(int id , String value){
        this.id = id;
        this.value = value;
    }
    public static TbStatusEnum getEnum(int index){
        return typeMap.get(index);
    }

    public int index() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
