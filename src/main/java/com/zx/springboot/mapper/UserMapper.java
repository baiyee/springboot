package com.zx.springboot.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zx.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

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

}
