package com.zx.springboot.global.enums;

import java.util.HashMap;
import java.util.Map;

public enum TableTypeEnum {

	STRING(" VARCHAR(100)"),	//普通用户（没房间号）
	BYTE(" INT(11) "),
	SHORT(" INT(11) "),
	INT(" INT(11) "),
	INTEGER(" INT(11) "),
	LONG(" BIGINT(20) "),
	FLOAT(" FLOAT"),
	DOUBLE("DOUBLE"),
	DATE( " DATETIME"),
	DATE_NOT( " DATETIME NOT NULL"),
	BOOLEAN(" INT(11) "),
	;		
	
	private String value;
	
	
	private static Map<String, String> tbTypeMap = new HashMap<String, String>();
	static {
		
		for(TableTypeEnum type : values()) {
			tbTypeMap.put(type.name(), type.getValue());
		}
	}

	

	TableTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	public static String getKey(String name){
		return tbTypeMap.get(name);
	}
}