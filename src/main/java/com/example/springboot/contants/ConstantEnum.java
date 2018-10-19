package com.example.springboot.contants;

/**
 * 常量枚举类,系统所有返回码和相关说明须在此定义
 * */
public enum ConstantEnum {
	SUCCESS("0000","success","success"),
	ERROR("1000","error","error"),
	ERROR_NOT_AUTHOR("1001","接口未授权","Missing or invalid Authorization header."),
	ERROR_NOT_PARAMER("1002","缺少必要的参数","required parameter missing");
	
	private String code;
	private String cnDetail;
	private String enDetail;
	
	 ConstantEnum(String code, String cn, String en) {
		this.code = code;
		this.cnDetail = cn;
		this.enDetail = en;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCnDetail() {
		return cnDetail;
	}

	public void setCnDetail(String cnDetail) {
		this.cnDetail = cnDetail;
	}

	public String getEnDetail() {
		return enDetail;
	}

	public void setEnDetail(String enDetail) {
		this.enDetail = enDetail;
	}
	
}
