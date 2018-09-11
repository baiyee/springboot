package com.example.springboot.entity;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @author ZhangXuan
 * @since 2018/8/30 16:33
 */
public class RedisModel implements Serializable {

    private static final long serialVersionUID = -4626029361140059227L;

    private String redisKey;//redis中的key

    private String name; //名字

    private String phone;//电话

    private String address;//地址

    public String getRedisKey() {
        return redisKey;
    }

    public void setRedisKey(String redisKey) {
        this.redisKey = redisKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
