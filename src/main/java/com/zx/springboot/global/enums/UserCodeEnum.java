package com.zx.springboot.global.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserTypeEnum
 * @Author suven.wang
 * @Description //TODO ${END}$
 * @CreateDate 2018-11-19  20:47
 * @WeeK 星期一QQ
 * @Version v2.0
 **/
public enum UserCodeEnum {

    DEFAULT(0,"缺省平台"),
    PHONE(1,"手机号码"),//openid（qq），4：unionid(微信)
    EMAIL(2,"邮箱地址"),
    QQ(3,"QQ"),
    WECHAR (4,"微信"),
    WEIBO (5,"微博"),
    TODOU (6,"土豆"),
    FACEBOOK (7,"facebook"),
    TELEGRAM (8,"telegram"),

    ;


    private int id;
    private String value;

    private  static Map<Integer, UserCodeEnum> typeMap = new HashMap<>();
    static {
        for(UserCodeEnum msgType : values()) {
            typeMap.put(msgType.id, msgType);
        }
    }

    UserCodeEnum(int index , String value){
        this.id = index;
        this.value = value;
    }
    public static UserCodeEnum getType(int index){
       return typeMap.get(index);
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
