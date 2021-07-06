package com.zx.springboot.global.enums;

/**
 * @ClassName:
 * @Description:
 * @Author aric
 * @Date 2018/5/29 下午4:10
 * @Copyright: (c) 2018 gc by https://www.gc.com.cn/
 * @Version : 1.0.0
 * --------------------------------------------------------
 * modifyer    modifyTime                 comment
 * <p>
 * --------------------------------------------------------
 */
public enum EnableStatusEnum {

   DISABLE(0,"禁用"),ENABLE(1,"启用"),RELIEVE(2,"解绑禁用"),EXPERIENCE_RELIEVE(4,"体验设备解绑禁用");

    int index;
    String name;
    public int getIndex() {
        return index;
    }
    public String getIndexStr() {
        return String.valueOf(index);
    }
    public String getName() {
        return name;
    }

    EnableStatusEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public static EnableStatusEnum getByIndex(int index) {
        for(EnableStatusEnum typeEnum : EnableStatusEnum.values()) {
            if(typeEnum.index==index) {
                return typeEnum;
            }
        }
        throw new IllegalArgumentException("No element matches " + index);
    }
}
