package com.zx.springboot.controller;

import com.zx.springboot.model.RedisModel;
import com.zx.springboot.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 * </p>
 *
 * @author ZhangXuan
 * @since 2018/8/30 16:47
 */
@RestController
@RequestMapping(value = "redis")
public class TestRedisController {

    @Autowired
    private IRedisService redisService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void test() {
        System.out.println("start..........redis....add");
        RedisModel model = new RedisModel();
        model.setName("白夜");
        model.setPhone("13530203421");
        model.setAddress("深圳");
        model.setRedisKey("baiyeKey");
        redisService.put(model.getRedisKey(), model, -1);

        RedisModel model2 = new RedisModel();
        model2.setName("张玄");
        model2.setPhone("15879470919");
        model2.setAddress("地球");
        model2.setRedisKey("zhangxuanKey");
        redisService.put(model2.getRedisKey(), model2, -1);

        System.out.println("add success end ............");
    }

    //查询所有对象
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Object getAll() {
        return redisService.getAll();
    }

    //查询所有key
    @RequestMapping(value = "/getKeys", method = RequestMethod.GET)
    public Object getKeys() {
        return redisService.getKeys();
    }

    //根据key查询
    @RequestMapping(value = "/get")
    public Object get(@RequestBody RedisModel model) {
        System.out.println(model.toString());
        return redisService.get(model.getRedisKey());
    }

    //删除
    @RequestMapping(value = "/remove")
    public Object remove(@RequestBody RedisModel model) {
        System.out.println(model.toString());
        redisService.remove(model.getRedisKey());
        return redisService.getKeys();
    }

    //判断key是否存在
    @RequestMapping(value = "/isKeyExists")
    public Object isKeyExists(@RequestBody RedisModel model) {
        System.out.println(model.toString());
        if (model.getRedisKey() == null) {
            return "Key 不能为空";
        }
        boolean flag = redisService.isKeyExists(model.getRedisKey());
        System.out.println("zhangsanKey01 是否存在: " + flag);
        return flag == true ? "存在" : "不存在";
    }

    //查询当前缓存的数量
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public Object count() {
        return redisService.count();
    }

    //清空所有key
    @RequestMapping(value = "/empty", method = RequestMethod.GET)
    public void empty() {
        redisService.empty();
    }

}
