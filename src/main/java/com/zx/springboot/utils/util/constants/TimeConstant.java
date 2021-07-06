package com.zx.springboot.utils.util.constants;

/**
 * 时间单位静态定义
 */
public interface TimeConstant {

	/** 
	 * 一秒钟的毫秒数
	 */
	int ONE_SECOND_MILLISECOND = 1000;
	
	/** 
	 * 一分钟的毫秒数
	 */
	int ONE_MINUTE_MILLISECOND = 60 * ONE_SECOND_MILLISECOND;
	
	/** 
	 * 一小时的毫秒数
	 */
	int ONE_HOUR_MILLISECOND = 60 * ONE_MINUTE_MILLISECOND;
	
	/** 
	 * 一天的毫秒数
	 */
	int ONE_DAY_MILLISECOND = 24 * ONE_HOUR_MILLISECOND;
	
	/** 
	 * 一分钟的秒数
	 */
	int ONE_MINUTE_SECOND = ONE_MINUTE_MILLISECOND / ONE_SECOND_MILLISECOND;
	
	/** 
	 * 1小时的秒数
	 */
	int ONE_HOUR_SECOND = ONE_HOUR_MILLISECOND / ONE_SECOND_MILLISECOND;
	
	/** 
	 * 1天的秒数
	 */
	int ONE_DAY_SECOND = ONE_DAY_MILLISECOND / ONE_SECOND_MILLISECOND;
	
	/** 
	 * 7天的秒数
	 */
	int SEVEN_DAY_SECOND = 7 * ONE_DAY_SECOND;
}
