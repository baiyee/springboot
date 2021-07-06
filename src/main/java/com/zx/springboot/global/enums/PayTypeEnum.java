package com.zx.springboot.global.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:
 * @Description:
 * @Author liulu
 * @Date 2018/6/27 17:47
 * @Copyright: (c) 2018 gc by https://www.gc.com.cn/
 * @Version : 1.0.0
 */
public enum PayTypeEnum {

    PAY_TYPE_ALIPAY(0),PAY_TYPE_UNIONPAY_PAY(1),PAY_TYPE_TENPAY(2),PAY_TYPE_BILL(3),PAY_TYPE_RF_WALLET(4)
    ;

    private final int value;

    private static Map<String, PayTypeEnum> tbTypeMap = new HashMap<String, PayTypeEnum>();
    static {

        for (PayTypeEnum type : values()) {
            tbTypeMap.put(type.name(), type);
        }
    }

    PayTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PayTypeEnum getKey(String name) {
        return tbTypeMap.get(name);
    }

    public static String valueOfString(int value) {
        switch (value) {
            case 0:
                return "支付宝";
            case 1:
                return "银联支付";
            case 2:
                return "微信支付";
            case 3:
                return "财付通";
            case 4:
                return "电子钱包";
            default:
                return null;


        }
    }
}
