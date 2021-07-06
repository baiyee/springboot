package com.zx.springboot.utils.core.json;

import com.google.common.collect.ImmutableSet;
import com.google.protobuf.GeneratedMessage;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.*;


/**
 * Java 序列化工具类, 目前使用的序列化使用的Kryo
 * why kryo:<br>
 * 1. 性能
 * 2. 生成体积小
 * Created by zhangxuan on 2014/7/18.
 */
public class SerializableUtil {

    private static Logger logger = LoggerFactory.getLogger(SerializableUtil.class);

    private static Charset charset = Charset.forName("UTF-8");
	private static ImmutableSet<? extends Class<? extends Serializable>> primitiveSet;

	static {
		// 还是直接的HashSet比较快..
		primitiveSet = ImmutableSet.of(int.class, Integer.class, long.class, Long.class,
				double.class, Double.class, float.class, Float.class, byte.class, Byte.class,
				short.class, Short.class, boolean.class, Boolean.class, String.class, Number.class);
	}

    /**
     * 对象序列化成字节
     *
     * @param object java对象
     * @return 序列化后的数组
     */
    @SuppressWarnings("unchecked")
	public static byte[] toBytes(Object object) {
    	if(primitiveSet.contains(object.getClass())){
    		return String.valueOf(object).getBytes();
    	}
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            return ProtobufIOUtil.toByteArray(object, (Schema<Object>) RuntimeSchema.getSchema(object.getClass()), buffer);
        } finally {
            buffer.clear();
        }
    }



	/**
     * 反序列化
     *
     * @param bytes 已经被序列化的数组
     * @param klass 需要反序列化成的类型
     * @param <T>   不解释
     * @return 反序列化后的实例
     */
    @SuppressWarnings("unchecked")
	public static <T> T fromBytes(byte[] bytes, Class<T> klass) {
        try {
        	//如果klass是pb对象直接使用反映实现
        	if(GeneratedMessage.class.isAssignableFrom(klass)){
        		T obj = (T) MethodUtils.invokeStaticMethod(klass, "parseFrom", bytes);
        		return obj;
        	}
        	//将pb-byte[] 转换为java object
            T object = klass.newInstance();
			Schema schema = RuntimeSchema.getSchema(klass);
            ProtobufIOUtil.mergeFrom(bytes, object, schema);
            return object;
        } catch (Exception e) {
            logger.error("byteStr:{}", new String(bytes));
            logger.error("反序列化失败:{}", e);
        }
        return null;
    }


    /**
     * 反序列化byte数组
     * @param byteList
     * @param klass
     * @return
     */
    public static <T> List<T> fromByteList(List<byte[]> byteList, Class<T> klass) {
    	List<T> list = new ArrayList<>(byteList.size());
    	for (byte[] bs : byteList) {
    		list.add(parseValue(klass, bs));
		}
        return list;
    }
    
    /**
     * 反序列化byte Map集合;
     * @param claxx
     * @param clazz
     * @param datas
     * @return
     */
    public static <K,V> Map<K, V> fromByteMap(Class<K> claxx , Class<V> clazz, Map<byte[] ,byte[]> datas) {
    	Map<K, V> map = new LinkedHashMap<>();
    	for(Map.Entry<byte[], byte[]> it: datas.entrySet()) {
    		map.put(parseValue(claxx, it.getKey()), parseValue(clazz ,it.getValue()));
    	}
    	return map;
    }
    
    
    /**
	 * 将数据类型转换成相对应的对像,或字符类型;
	 * @param str 要转换成byte[] 数据组;
	 * @param clazzType 被转成的数据类型;
	 * @return
	 */
	public static <T> T parseValue(Class<T> clazzType, String str) { //boolean.class, pojo.class ,String.class
		Object value = null;
		if (clazzType == null ) {
			return null;
		}
		if(str == null || "".equals(str)){
			str = "0";
		} 
	    if (short.class == clazzType || Short.class == clazzType) {
			value = Short.parseShort(str);
		} else if (int.class == clazzType || Integer.class == clazzType) {
			value = Integer.parseInt(str);
		} else if (long.class == clazzType || Long.class == clazzType) {
			value = Long.parseLong(str);
		} else if (float.class == clazzType || Float.class == clazzType) {
			value = Float.parseFloat(str);
		} else if (double.class == clazzType || Double.class == clazzType
				|| Number.class == clazzType) {
			value = Double.parseDouble(str);
		}
		return (T)value;
	}

	
	/**
	 * 将数据类型转换成相对应的对像,或字符类型;
	 * @param data 要转换成byte[] 数据组;
	 * @param clazzType 被转成的数据类型;
	 * @return
	 */
	public static <T> T parseValue(Class<T> clazzType, byte[] data) { //boolean.class, pojo.class ,String.class

		boolean wasNullCheck = false;
		Object value = null;
		if (clazzType == null) {
			return null;
		}
		if (byte[].class.equals(clazzType)) {
			return (T) data;
		}else if(!primitiveSet.contains(clazzType)){
			return SerializableUtil.fromBytes(data, clazzType);
		} else if (byte.class == clazzType || Byte.class == clazzType) {
			value = data[0];
			wasNullCheck = true;
		} else if (boolean.class == clazzType || Boolean.class == clazzType) {
			value = data[0] == 1;
			wasNullCheck = true;
		}else if (String.class == clazzType) {
			value = new String(data,charset);
			wasNullCheck = true;
		}else{
			String str = new String(data,charset);
			value = parseValue(clazzType, str);
			wasNullCheck = true;
		}
		if (wasNullCheck && value != null) {
			return (T) value;
		}
		return null;
	}
	/**
	 * 将list转化为数组
	 * @param set
	 * @return
	 */
	public static <V> byte[][] tranformStrTobyte(String prefix, Collection<V> set){
		byte[][] arr = new byte[set.size()][];
		int i = 0 ;
		for (V v : set) {
			arr[i]=(prefix + v).getBytes();
			i++;
		}
		return arr;
	}
	
//	/**
//	 * java类改换包路径会有性能问题,不建议使用
//	 * @param object
//	 * @return
//	 */
//	@Deprecated
//	public static byte[] serialize(Object object) {
//		ObjectOutputStream oos = null;
//		ByteArrayOutputStream baos = null;
//		try {
//			baos = new ByteArrayOutputStream();
//			oos = new ObjectOutputStream(baos);
//			oos.writeObject(object);
//			return baos.toByteArray();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//				try {
//					if (oos != null)
//						oos.close();
//					if (baos != null)
//						baos.close();
//				} catch (IOException e) {
//				}
//		}
//		return null;
//	}
//
//	/**
//	 * java类改换包路径会有性能问题,不建议使用
//	 * @param object
//	 * @return
//	 */
//	@Deprecated
//	public static Object unserialize(byte[] bytes) {
//		ByteArrayInputStream bais = null;
//		try {
//			bais = new ByteArrayInputStream(bytes);
//			ObjectInputStream ois = new ObjectInputStream(bais);
//			Object obj = ois.readObject();
//			ois.close();
//			return obj;
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (bais != null)
//				try {
//					bais.close();
//				} catch (IOException e) {
//				}
//		}
//		return null;
//	}
	public static void main(String[] args) {
		byte[] by = SerializableUtil.toBytes(39089073);
		System.out.println(by);
		System.out.println( new String(by));
	}
}
