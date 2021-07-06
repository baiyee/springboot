package com.zx.springboot.uitl.core.json;


import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 接收异步线程发送的数据
 * @author zhangxuan
 */
public class JsonExchanger {

    private static Map<Long, JSONObject> exchanger = new ConcurrentHashMap<>();

    /**
     * 异步线程应该调用, 将要发送的数据发送给某个线程
     * @param threadId 发送数据给这个线程id
     * @param jsonObject 要发送的数据
     */
    public static void put(long threadId, JSONObject jsonObject) {
        exchanger.put(threadId, jsonObject);
    }


    /**
     * 当前线程获取数据, 需要注意如果调用此函数, 一般要手动调用reset()函数重置
     * @return
     */
    public static JSONObject get() {
        return exchanger.get(Thread.currentThread().getId());
    }

    /**
     * 当前线程删除数据
     */
    public static void reset() {
        exchanger.remove(Thread.currentThread().getId());
    }

    /**
     * 当前线程获取数据并且删除.
     * @return
     */
    public static JSONObject getAndReset() {
        JSONObject jsonObject = get();
        reset();
        return jsonObject;
    }
}
