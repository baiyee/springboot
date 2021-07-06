package com.zx.springboot.global.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName StatusEnum
 * @Author suven.wang
 * @Description //TODO ${END}$
 * @CreateDate 2018-12-19  20:10
 * @WeeK 星期三
 * @Version v2.0
 **/
public enum StatusEnum {
    FAIL(0,"失败"), //下载
    SUCCESS(1,"成功"), //上载


    ;


    private int id;
    private String value;

    private  static Map<Integer, StatusEnum> typeMap = new HashMap<>();
    static {
        for(StatusEnum msgType : values()) {
            typeMap.put(msgType.id, msgType);
        }
    }

    StatusEnum(int id , String value){
        this.id = id;
        this.value = value;
    }
    public static StatusEnum getEnum(int index){
        return typeMap.get(index);
    }

    public int index() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
