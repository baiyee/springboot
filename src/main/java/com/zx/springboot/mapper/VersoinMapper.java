package com.zx.springboot.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zx.springboot.dto.request.VersoinRequest;
import com.zx.springboot.entity.Version;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sea123
 * @since 2018-05-28
 */
@Mapper
public interface VersoinMapper extends BaseMapper<Version> {

	Version searchVersoinInfoWithSystem(String system);

	void updateCoinTypeVersion();

    Integer updateVersoin(Version version);

    List<VersoinRequest> selectVersoinList(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    Integer selectTotalCount();
}
