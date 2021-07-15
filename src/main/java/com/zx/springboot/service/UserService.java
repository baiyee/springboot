package com.zx.springboot.service;

import com.baomidou.mybatisplus.service.IService;
import com.zx.springboot.entity.User;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhangxuan
 * @since 2018-09-04
 */
public interface UserService extends IService<User> {

    /**
     * 查询用户列表所有用户信息
     * @return
     */
    List<User> selectAllList();
}
