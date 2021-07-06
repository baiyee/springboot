package com.zx.springboot.global.enums;


import java.util.HashMap;
import java.util.Map;

/**
 * 	 * 激活码兑换
 * 	 *
 * 	 * 0：系统不存在激活码
 * 	 * 1：兑换成功
 * 	 * 2：已经兑换过了
 */
public enum ActivateCodeEnum {

    ACTIVATE_CODE_NOT(0,"无效的兑换码，兑换失败"),
    ACTIVATE_CODE_SUCCESS(1,"兑换成功"),
    ACTIVATE_CODE_USED(2,"您已领取过本此福利了"),
    ACTIVATE_CODE_NONE(3,"此兑换码已被抢完了"),
    ACTIVATE_CODE_EXPIRED(4,"您输入的兑换码已过期"),
    ;


    private int id;
    private String value;

    private  static Map<Integer, ActivateCodeEnum> typeMap = new HashMap<>();
    static {
        for(ActivateCodeEnum enumType : values()) {
            typeMap.put(enumType.id, enumType);
        }
    }

    ActivateCodeEnum(int id , String value){
        this.id = id;
        this.value = value;
    }
    public static ActivateCodeEnum getEnum(int index){
        return typeMap.get(index);
    }

    public int index() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
