package com.zx.springboot.global.exception;

import com.zx.springboot.global.enums.IMsgEnumType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;


/**
 * @author vincentdeng
 *
 */
public class SystemRuntimeException extends RuntimeException {

	private static Logger logger = LoggerFactory.getLogger(SystemRuntimeException.class);

	/**
	 *
	 */
	private static final long serialVersionUID = -1349660295724046112L;

	private int errorCode;

	private String errorMessage;

	private Object response;


	private IMsgEnumType error;


	public SystemRuntimeException() {
		super();
	}


	public SystemRuntimeException(IMsgEnumType error)  {
		super(error.getMsg());
		this.errorCode =  error.getCode();
		this.errorMessage = error.getMsg();
		this.error = error;
	}

    public SystemRuntimeException(IMsgEnumType error, String... errParam)  {
		super(error.getMsg());
		this.errorCode =  error.getCode();
		if(null == errParam){
			this.errorMessage = error.getMsg();
		}else {
			Object[] param = Arrays.asList(errParam).toArray();
			this.errorMessage = String.format(error.getMsg(), param);
		}

    }
	public SystemRuntimeException setResponse(Object response) {
		this.response = response;
		return this;
	}
	public SystemRuntimeException format(Object... errParam)  {
		this.errorMessage = String.format(this.errorMessage, errParam);
		return this;

	}

	public SystemRuntimeException(String message, Throwable cause,
                                  boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SystemRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemRuntimeException(String message) {
		super(message);
	}

	public SystemRuntimeException(Throwable cause) {
		super(cause);
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Object getResponse() {
		return response;
	}



	/**
	 * @return 返回 error。
	 */

	public IMsgEnumType getError() {
		return error;
	}
}
