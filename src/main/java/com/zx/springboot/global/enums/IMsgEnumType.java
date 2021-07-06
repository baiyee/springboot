/**
 * Copyright(c) KuGou-Inc.All Rights Reserved. 
 */
package com.zx.springboot.global.enums;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 程序的中文名称。
 * </pre>
 * 
 * @author andrewyang yangjianjun@kugou.net
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:     修改内容:
 * </pre>
 */
public interface IMsgEnumType {
	Logger logger = LoggerFactory.getLogger(IMsgEnumType.class);
	/**
	 * 获取消息代码
	 * @return
	 */
    int getCode();
	/**
	 * 获取消息描述
	 * @return
	 */
    String getMsg();
	

}
