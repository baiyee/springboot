package com.zx.springboot.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zx.springboot.mapper.UserMapper;
import com.zx.springboot.model.User;
import com.zx.springboot.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangxuan
 * @since 2018-09-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
