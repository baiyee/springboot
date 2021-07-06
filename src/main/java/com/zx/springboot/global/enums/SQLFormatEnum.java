package com.zx.springboot.global.enums;
public enum SQLFormatEnum {

	INSERT_INTO(" INSERT INTO %s ( %s ) VALUES (%s) ;"),	//插入数据语句
	REPLACE_INTO(" REPLACE INTO  %s ( %s ) VALUES (%s) ; "),//插入或修改数据语句
	CREATE_TABLE(" CREATE TABLE IF NOT EXISTS %s \n ( %s  )  ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ; "),//验证并创建表是否存在语句;
	CREATE_TABLE_ID(" CREATE TABLE IF NOT EXISTS %s ( \n\t  %s  \n\t PRIMARY KEY (id) \n )  ENGINE=InnoDB DEFAULT CHARSET=utf8 ;"),
	SERLECT_LIST(" SELECT %s FROM %s WHERE 1=1 limit 0, 100;"),
	SERLECT_OBJECT(" SELECT %s FROM %s WHERE 1=1 limit 0, 1;")
	;		//
	
	private String value;

	SQLFormatEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}