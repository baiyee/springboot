package com.zx.springboot.service;

import com.baomidou.mybatisplus.service.IService;
import com.zx.springboot.dto.request.VersoinRequest;
import com.zx.springboot.dto.response.VersoinResponse;
import com.zx.springboot.model.Versoin;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sea123
 * @since 2018-03-23
 */
public interface VersoinService extends IService<Versoin> {
	/**
	 * 根据平台系统获取版本升级信息
	 * @param
	 * @return
	 */
	public Versoin searchVersoinInfoWithSystem(String system);
	
	public void updateCoinTypeVersion();

	/**
	 * 添加版本 记录信息
	 * @param versoinRequest
	 * @return
	 */
	Boolean addVersoin(VersoinRequest versoinRequest);

	/**
	 * 根据id 删除版本 记录信息
	 * @param id
	 * @return
	 */
	Boolean deleteAllById(Long versoinId);

	/**
	 * 根据id 修改 版本 记录信息
	 * @param versoinId
	 * @return
	 */
    Boolean updateAllById(VersoinRequest request);

	/**
	 * 根据条件 查询版本记录 列表
	 * @param request
	 * @return
	 */
	VersoinResponse selectVsrsoinList(VersoinRequest request);
}
