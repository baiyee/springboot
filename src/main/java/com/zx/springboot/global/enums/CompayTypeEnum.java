package com.zx.springboot.global.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GoodsTypeEnum
 * @Description: TODO
 * @Author xiexiaodong
 * @Date 2018/6/26 19:57
 * @Copyright: (c) 2018 gc by https://www.gc.com.cn/
 * @Version : 1.0.0
 */
public enum CompayTypeEnum {
    COMPAY_TOP(1,"诗多多");



    private int id;
    private String name;

    CompayTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    private static Map<Integer, CompayTypeEnum> typeMap = new HashMap<>();
    static {

        for(CompayTypeEnum type : values()) {
            typeMap.put(type.id, type);
        }
    }
    public static CompayTypeEnum getGoodsTypeEnum(int id){
        return typeMap.get(id);
    }

}
