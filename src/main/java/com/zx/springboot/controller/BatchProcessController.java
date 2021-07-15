package com.zx.springboot.controller;

import com.zx.springboot.entity.User;
import com.zx.springboot.service.UserService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @description: 批量处理新增、删除、修改 通过list.remove()
 * @date 2021/7/15
 * @author zhangxuan
 */
@RestController
public class BatchProcessController {

    UserService userService;
    //@Autowired 改为构造器注入，防止注入依赖为空
    public BatchProcessController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/batchAddUpdateDeleteTogether",method = RequestMethod.POST)
    @Transactional
    public String batchAddUpdateDeleteTogether(@RequestBody List<User> newUsers){
        /**
         * 需求：
         * 查询年龄为25的用户对象列表，并和传入用户对象列表进行比较，
         * 旧列表id与新列表id相同，进行编辑操作。
         * 旧列表id未在新列表中找到，进行新增操作。
         * 旧列表即未新增也未修改的数据，进行删除操作。
         * 解决方案：使用map.remove来解决
         */
        List<User> oldUsers = userService.selectAllList();
        if (CollectionUtils.isEmpty(oldUsers) && CollectionUtils.isEmpty(newUsers) ) {
            return "";
        }
        //将查询出来的用户信息转成map
        Map<Long,User> oldUserMap = oldUsers.stream().collect(Collectors.toMap(User::getId,User->User));
        List<User> addUserList = new ArrayList<>();
        List<User> updateUserList = new ArrayList<>();
        List<Long> deleteUserList = new ArrayList<>();
        newUsers.forEach(newUser ->{
            User user = oldUserMap.remove(newUser.getId());
            if (user == null) {
                //新增对象集合
                addUserList.add(newUser);
            }else {
                //编辑对象集合
                updateUserList.add(user);
            }
        });
        //删除对象集合
        for (User user :oldUserMap.values()) {
            if (user!=null) {
                deleteUserList.add(user.getId());
            }
        }
        //批量新增
        if (!CollectionUtils.isEmpty(addUserList)){
            userService.insertBatch(addUserList);
        }
        //批量编辑
        if (!CollectionUtils.isEmpty(updateUserList)){
            userService.insertOrUpdateBatch(updateUserList);
        }
        //批量删除
        if (!CollectionUtils.isEmpty(deleteUserList)){
            userService.deleteBatchIds(deleteUserList);
        }

        return "success";
    }
}
