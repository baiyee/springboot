package com.zx.springboot.global.enums;

public enum OrderStatusEnum {
    NO_PAYMENT(0, "等待付款"), PAYMENT(1, "付款完成"), ABOLISH(2, "订单取消"),
    ASSIGN_YES(3, "购买分配成功"), ASSIGN_NO(4, "购买分配失败"), HANDLE_YES(5, "充值处理成功"),
    HANDLE_NO(6, "充值处理失败"), HANDLE_FAILED(7, "支付成功处理失败"), REFUNDS(8, "已退款"),
    EXPIRED(9, "已失效"), WALLET_RECHARGE_SUCCESS(10, "钱包充值成功"), UPGRADE_SUCCESS(11, "设备升级成功"),
    WALLET_RECHARGE_FAIL(12, "钱包充值失败");

    private int index;
    private String name;

    OrderStatusEnum(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getIndexStr() {
        return String.valueOf(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
