package com.zx.springboot.global.enums;

/**
 * @Auther: xiexiaodong
 * @Date: 2018/8/29 11:57
 * @Description:
 */
public enum OsTypeEnum {
    ANDROID(1,"android"),IOS(2,"ios"),PC(3,"pc");
    private int key;
    private String value;

    OsTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String platformToOs(int platform){
        switch (platform) {
            case 1:
                return ANDROID.getValue();
            case 2:
                return IOS.getValue();
            case 3:
                return PC.getValue();
        }
        return null;
    }
}
