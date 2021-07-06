package com.zx.springboot.global.exception;

import com.zx.springboot.global.enums.IMsgEnumType;
import java.util.Arrays;


/**
 * Created by zhangxuan on 2014/9/3
 */
public class BusinessLogicException extends Exception {
	
	private IMsgEnumType error;

	private int errorCode;

	private String errorMessage;


	public BusinessLogicException() {
		super();
	}

	public BusinessLogicException(int errorCode, String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

	}

	public BusinessLogicException(IMsgEnumType error)  {
		super(error.getMsg());
		this.error = error;
		this.errorCode =  error.getCode();
		this.errorMessage = error.getMsg();
	}

	public BusinessLogicException(IMsgEnumType error, String... errParam)  {
		super(error.getMsg());
		Object[] param = Arrays.asList(errParam).toArray();
		this.error = error;
		this.errorCode =  error.getCode();
		this.errorMessage = String.format(error.getMsg(), param);
	}


	/**
	 * @return 返回 error。
	 */
	public IMsgEnumType getError() {
		return error;
	}

	public int getErrorCode() {
		return errorCode;
	}



	public String getErrorMessage() {
		return errorMessage;
	}


}
