package com.zx.springboot.global.enums;

/**
 *
 *
 */
public enum BannerInfoEnum {
    INDEX_TOP(1, "首页顶部轮播"),
    INDEX_MIDDLE(2, "首页中部轮播"),
    CHANNEL(3, "频道页广告轮播"),
    VIDEO(4, "视频"),
    ME(5, "我的广告页广告轮播"),
    INDEX_BOTTOM(6, "首页底部广告轮播"),
    SEARCH(7, "搜索页广告轮播"),
    START(8, "开屏广告"),
    VIDEO_PLAY(9,"视频播放前"),
    LEFT_TOP(10,"左侧顶部"),
    USER_CENTER(11,"个人中心页"),
    VIDEO_PLAY_PAGE(12,"视频播放页");


    private int value;
    private String name;

    BannerInfoEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
