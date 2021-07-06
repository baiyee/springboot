package com.zx.springboot.uitl.core.json;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multimap;
import com.zx.springboot.global.enums.SysMsgEnumType;
import com.zx.springboot.global.exception.SystemRuntimeException;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by zhangxuan on 2021年07月06日
 */
public class JsonParse { 

	private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

//	private Set<String> properties = Sets.newHashSet();
	private static Multimap<Class<?>, String> fieldMap = HashMultimap.create();
	private static ImmutableSet<? extends Class<? >> primitiveSet
			= ImmutableSet.of();




	private final static char CONSTANTS_CHAR_KEY = 7;// Constants.CHARKEY;
    private final static String CONSTANTS_KEY =  String.valueOf(CONSTANTS_CHAR_KEY);

	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}



	public static <T> T parseFrom(Map<String, Object> map, Class<T> clazz)
			throws Exception {
		T instance= clazz.newInstance();
		List<Field> fields = FieldUtils.getAllFieldsList(clazz);
		for (Field field : fields) {
			String fieldName = field.getName();
			synchronized (clazz) {
				if (!fieldMap.containsEntry(clazz, fieldName)) {
					fieldMap.put(clazz, fieldName);
				}
			}
			String[] rawValues = (String[]) map.get(fieldName);
			if (rawValues == null || rawValues.length <= 0)
				continue;
			String values = rawValues[0];

			Class<?> fieldType = field.getType();
			if (fieldType != String.class && null == values) {
				continue;
			}

			field.setAccessible(true);

			Object value = null;
			if (isSimpleType(fieldType)) {//基本类型
				value = signPrimitive(fieldType, values);
			}else if (isIterable(fieldType)) {//聚合类型
//				values = values.replace(',', CONSTANTS_CHAR_KEY);
				value = signIterable(field, values.split(CONSTANTS_KEY));
			}else if(isByte(fieldType)){
				value = Base64.getDecoder().decode(values);
			} else{
				logger.warn("{} {}此类型不能自动转换 ",fieldName,fieldType);
				throw new SystemRuntimeException(SysMsgEnumType.SYS_INVALID_REQUEST);
			}
			setValue(field, instance, value);
		}
		return instance;
	}

	private static void setValue(Field field, final Object instance,
                                 Object value) throws IllegalAccessException {
		field.set(instance, value);
//		JsonParse json = (JsonParse) instance;
//		json.properties.add(field.getName());
	}

	private static boolean isSimpleType(Class<?> fieldType) {
		return ClassUtils.isPrimitiveOrWrapper(fieldType)
				|| fieldType == String.class || fieldType == Date.class;
	}

	private static Object signPrimitive(Class<?> fieldType, String rawValue)
			throws Exception {
		Object value = null;
		if (StringUtils.isBlank(rawValue)) {
			return null;
		}
		if (ClassUtils.isPrimitiveOrWrapper(fieldType)) {
			Class<?> wrapperClazz = ClassUtils.primitiveToWrapper(fieldType);
			try {
				value = MethodUtils.invokeStaticMethod(wrapperClazz, "valueOf", rawValue);
			} catch (Exception ex) {
				logger.warn("数组内容类型不对,转换失败! fieldType={},requestValue={}",fieldType.getSimpleName(),rawValue);
				throw new SystemRuntimeException(SysMsgEnumType.SYS_INVALID_REQUEST);
			}
		} else if (fieldType == Date.class) {
            try {
                if (rawValue.matches("\\d+")) {
                    long time = Long.valueOf(rawValue);
                    value = new Date(time);
                } else {
                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    value = format.parse(rawValue);
                }
            } catch (Exception ex) {
				logger.warn("数组内容类型不对,转换失败! fieldType={},requestValue={}",fieldType.getSimpleName(),rawValue);
            }
		} else {
			value = rawValue;
		}
		return value;
	}

	private static Object signIterable(Field field, String[] strings)
			throws Exception {
		Class<?> fieldType = field.getType();
		if (fieldType.isArray()) {
			Class<?> cpnType = fieldType.getComponentType();
			Object array = Array.newInstance(cpnType, strings.length);
			for (int i = 0; i < strings.length; i++) {
				Object primitive = signPrimitive(cpnType, strings[i]);
				if (null != primitive) {
					Array.set(array, i, primitive);
				}
			}
			return array;
		}
		Collection c = newCollection(fieldType);
		if (!(field.getGenericType() instanceof ParameterizedType)) {
			logger.warn("{} 泛型必须写上泛型的类型", field.getName());
			throw new SystemRuntimeException(SysMsgEnumType.SYS_INVALID_REQUEST);
		}
		ParameterizedType ptType = (ParameterizedType) field.getGenericType();
		Type genericType = ptType.getActualTypeArguments()[0];
		for (String string : strings) {
			c.add(signPrimitive((Class) genericType, string.trim()));
		}
		return c;
	}

	private static Object signIterable(Field field, byte[] strings) {
		Class<?> fieldType = field.getType();
		if (fieldType.isArray()) {
			Class<?> cpnType = fieldType.getComponentType();
			Object array = Array.newInstance(cpnType, strings.length);
			array = strings;
			return array;
		}
		return null;
	}

	private static <T> Collection<T> newCollection(Class<T> clazz) {
		if (clazz == List.class) {
			return new ArrayList<>();
		} else if (clazz == Set.class) {
			return new HashSet<>();
		} else {
			logger.warn("{} 此类型尚未实现自动转换", clazz.getSimpleName());
			throw new SystemRuntimeException(SysMsgEnumType.SYS_INVALID_REQUEST);
		}
	}

	private static boolean isIterable(Class<?> clazz) {
		return (clazz.isArray() || Collection.class.isAssignableFrom(clazz))
				&& !byte[].class.isAssignableFrom(clazz);
	}

	private static boolean isByte(Class<?> clazz) {
		return (clazz.isArray() || Collection.class.isAssignableFrom(clazz))
				&& byte[].class.isAssignableFrom(clazz);
	}

	public static <T> T parseFrom(String obj, Class<T> clazz) {
		return JSON.parseObject(obj, clazz);
	}

	public static <T> T parseFrom(byte[] obj, Class<T> clazz) {
		return JSON.parseObject(obj, clazz);
	}





}