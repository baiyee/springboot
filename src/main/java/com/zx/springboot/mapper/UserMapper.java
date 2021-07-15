package com.zx.springboot.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zx.springboot.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhangxuan
 * @since 2018-09-04
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from tb_user")
    List<User> selectAllList();
}
