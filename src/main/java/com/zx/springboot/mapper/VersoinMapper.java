package com.zx.springboot.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zx.springboot.dto.request.VersoinRequest;
import com.zx.springboot.model.Versoin;
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
public interface VersoinMapper extends BaseMapper<Versoin> {

	Versoin searchVersoinInfoWithSystem(String system);

	void updateCoinTypeVersion();

    Integer updateVersoin(Versoin versoin);

    List<VersoinRequest> selectVersoinList(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    Integer selectTotalCount();
}
