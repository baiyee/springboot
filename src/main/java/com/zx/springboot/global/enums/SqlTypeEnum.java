package com.zx.springboot.global.enums;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


/**   
 * @Title: EnumsType.java 
 * @author Joven.wang   
 * @date   2016年2月17日
 * @version V1.0  
 * @Description: TODO(说明)  
 */

public enum SqlTypeEnum {

	STRING,	
	BYTE,
	SHORT,
	INT,
	INTEGER,
	LONG,
	FLOAT,
	DOUBLE,
	DATE,
	BOOLEAN,
	ENUM,//增加泛型
	;		
	
	private static Map<String, SqlTypeEnum> sqlTypeMap = new HashMap<String, SqlTypeEnum>();
	static {
		
		for(SqlTypeEnum type : values()) {
			sqlTypeMap.put(type.name(), type);
		}
	}

	/**
	 * 验证是否包括这类型的属性类型
	 * @param type
	 * @return
	 */
	public static boolean isContains(String type){
		type = type.toUpperCase();
		return sqlTypeMap.keySet().contains(type);
	}

	/**
	 * 如果是泛型类型使用整型代码
	 * @param rs
	 * @param className
	 * @return
	 * @throws SQLException
	 */
	public static String getEnumKey(ResultSet rs, String className) throws SQLException {
		Integer i = rs.getInt(className);
		i = i==null ? 0 : i;
		return i+"";
	}
	
	/**
	 * 实现类型转换
	 * @param rs
	 * @param classType
	 * @param className
	 * @return
	 * @throws SQLException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getKey(ResultSet rs, Class<T> classType, String className) throws SQLException {
		if(null == rs ||  null == classType || className  == null ){
			throw new RuntimeException("ResultSet rs is {"+ rs +"} or Class<?> classType is {"+classType+"} or String className is {"+className+"}");
		}
		String clazzType = (classType.getSimpleName()).toUpperCase();
		SqlTypeEnum name = sqlTypeMap.get(clazzType);
		if(null == name){
			throw new RuntimeException("RedisSetEnum sqlTypeMap get key result is null or Class<?> classType is {"+classType+"} or String className is {"+className+"}");
		}
		Object o = null;
		switch (name) {
		case STRING:
			 o = rs.getString(className);
			 break;
		case BYTE:
		case BOOLEAN:
			 o =rs.getByte(className);
			 break;
		case SHORT:
			 o =rs.getShort(className);
			break;
		case INT:
		case INTEGER:
			 o =rs.getInt(className);
			break;
		case LONG:
			 o =rs.getLong(className);
			break;
		case FLOAT:
			 o =rs.getFloat(className);
			break;
		case DATE:
			 o =rs.getTimestamp(className);
			break;
		default:
			 o = rs.getString(className);
			break;
		}
		return (T)o;
		
	}
}
