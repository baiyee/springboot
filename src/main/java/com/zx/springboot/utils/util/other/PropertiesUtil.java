package com.zx.springboot.utils.util.other;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Properties;

/**
 * Parsing The Configuration File
 * @author ShenHuaJie
 * @version 2016年7月30日 下午11:41:53
 */
public final class PropertiesUtil extends PropertyPlaceholderConfigurer  {

    private static Map<String, String> ctxPropertiesMap  = new HashMap<String, String>();


    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
            throws BeansException {
        super.processProperties(beanFactoryToProcess, props);

        for (Object key : props.keySet()) {
            String keyStr = key.toString();
            String value = props.getProperty(keyStr);
            if(null != value){
                value = value.trim();
            }
            ctxPropertiesMap.put(keyStr, value);
        }
    }

    /**
     * Get a value based on key , if key does not exist , null is private int firstApplyStatus
     *
     * @param key
     * @return
     */
    public static String getString(String key) {
        try {
            return ctxPropertiesMap.get(key);
        } catch (MissingResourceException e) {
            return null;
        }
    }

    public static String getString(String key,String defaultValue) {
        try {
            String str = ctxPropertiesMap.get(key);
            if(str == null){
                return defaultValue;
            }return str.trim();
        } catch (MissingResourceException e) {
            return null;
        }
    }

    /**
     * 根据key获取值
     *
     * @param key
     * @return
     */
    public static int getInt(String key) {
        try {
            String value =  ctxPropertiesMap.get(key);
            if(null != value && !"".equals(value)){
                return Integer.parseInt(value);
            }
        } catch (MissingResourceException e) {
            return -1;
        }
        return 0;
    }
    /**
     * 根据key获取值
     *
     * @param key
     * @return
     */
    public static int getInt(String key,int defaultValue) {
        int count = 0;
        try {
            String value =  ctxPropertiesMap.get(key);
            if(null != value && !"".equals(value)){
                count = Integer.parseInt(value);
            }
        } catch (Exception e) {  }
        if(count > 0){
            return count;
        }
        return defaultValue;
    }

    /**
     * 根据key获取值
     *
     * @param key
     * @return
     */
    public static long getLong(String key,long defaultValue) {
        long count = 0;
        try {
            String value =  ctxPropertiesMap.get(key);
            if(null != value && !"".equals(value)){
                count = Long.parseLong(value);
            }
        } catch (Exception e) {  }
        if(count > 0){
            return count;
        }
        return defaultValue;
    }
    
    /**
     * 根据key获取boolean, 1或true 为true 否则为false;
     * @param key
     * @return
     */
    public static boolean getBoolean(String key) {
        try {
            String value =  ctxPropertiesMap.get(key);
            boolean is = false;
            if(null != value && !"".equals(value) ){
                if( "1".equals(value) || "true".equals(value)){
                    is = true;
                }
                return is;
            }
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 根据key获取boolean, 1或true 为true 否则为false;
     * @param key
     * @return
     */
    public static boolean getBoolean(String key,boolean defaultValue) {
        try {
            String value =  ctxPropertiesMap.get(key);
            if(null == value){
                return defaultValue;
            }
            boolean is = false;
            if(null != value && !"".equals(value) ){
                if( "1".equals(value) || "true".equals(value)){
                    is = true;
                }
                return is;
            }
        } catch (Exception e) {
            return defaultValue;
        }
        return false;
    }
}
