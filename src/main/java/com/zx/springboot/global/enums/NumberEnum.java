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
public enum NumberEnum {
    MINUS_ONE(-1),
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10);



    private int id;

    private  static Map<Integer, NumberEnum> typeMap = new HashMap<>();
    static {
        for(NumberEnum msgType : values()) {
            typeMap.put(msgType.id, msgType);
        }
    }

    NumberEnum(int id){
        this.id = id;
    }
    public static NumberEnum getEnum(int index){
        return typeMap.get(index);
    }

    public int id() {
        return id;
    }

}
