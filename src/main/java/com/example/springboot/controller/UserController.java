package com.example.springboot.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhangxuan
 * @since 2018-09-04
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @RequestMapping("/test")
    public void testMD() {
        List<User> users = userMapper.selectList(new EntityWrapper<User>());
        System.out.println(users);
    }

    @RequestMapping("/testService")
    public void testService() {
      List<User> users = userService.selectList(new EntityWrapper<User>());
        System.out.println(users);
        User user = userService.selectById("1");
        System.out.println(user);
    }
}

