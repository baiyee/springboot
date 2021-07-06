package com.zx.springboot.global.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: GoodsTypeEnum
 * @Description: TODO
 * @Author suven.wang
 * @Date 2018/6/26 19:57
 * @Copyright: (c) 2018 gc by https://www.gc.com.cn/
 * @Version : 1.0.0
 */
public enum GoodsTypeEnum {
    GOODS_COMMON(1, 1000,"普通"),
    GOODS_VIP(2,2000,"VIP套餐"),
    GOODS_GVIP(3,5000,"GVIP套餐"),
    GOODS_SVIP(4,10000, "超级VIP套餐");



    private int id;
    private int goldCoin;
    private String name;

    GoodsTypeEnum(int id, int goldCoin, String name) {
        this.id = id;
        this.goldCoin = goldCoin;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public int getGoldCoin() {
        return goldCoin;
    }
    public String getName() {
        return name;
    }

    private static Map<Integer, GoodsTypeEnum> typeMap = new HashMap<>();
    static {

        for(GoodsTypeEnum type : values()) {
            typeMap.put(type.id, type);
        }
    }
    public static GoodsTypeEnum getGoodsTypeEnum(int id){
        GoodsTypeEnum enums =  typeMap.get(id);
        enums =  enums == null ? GoodsTypeEnum.GOODS_COMMON : enums;
        return enums;
    }

}
