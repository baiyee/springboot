package com.zx.springboot.dto.response;


import com.zx.springboot.contants.ConstantEnum;

/**
 * 返回的消息类
 */
public class ReturnMessage {
	public static int SUCCESS = 0;
	public static int ERROR = 1;
	public static ReturnMessage succ = new ReturnMessage(SUCCESS, ConstantEnum.SUCCESS.getCode(), ConstantEnum.SUCCESS.getCnDetail(),null);
	public static ReturnMessage fail = new ReturnMessage(ERROR, ConstantEnum.ERROR.getCode(), ConstantEnum.ERROR.getCnDetail(),null);

	//处理状态
	private int status;
	//结果码
	private String code;
	//结果描述
	private String msg;
	//结果集
	private Object retData;

	public ReturnMessage(int status, String code, String msg, Object retData) {
		this.status = status;
		this.code = code;
		this.msg = msg;
		this.retData = retData;
	}

	/**
	 * 简化版构造方法
	 * */
	public ReturnMessage(int statusType, String msg) {
		if(statusType==SUCCESS) {
			this.status = SUCCESS;
			this.code = ConstantEnum.SUCCESS.getCode();
		}else {
			this.status = ERROR;
			this.code = ConstantEnum.ERROR.getCode();
		}
		this.msg = msg;

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getRetData() {
		return retData;
	}

	public void setRetData(Object retData) {
		this.retData = retData;
	}

}
