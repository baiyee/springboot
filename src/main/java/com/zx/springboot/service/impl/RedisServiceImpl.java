package com.zx.springboot.service.impl;

import com.zx.springboot.model.RedisModel;
import com.zx.springboot.service.IRedisService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author ZhangXuan
 * @since 2018/8/30 16:41
 */
@Service
public class RedisServiceImpl extends IRedisService<RedisModel> {
    private static  final String REDIS_KEY = "TEST_REDIS_KEY";

    @Override
    protected String getRedisKey() {
        return this.REDIS_KEY;
    }
}
