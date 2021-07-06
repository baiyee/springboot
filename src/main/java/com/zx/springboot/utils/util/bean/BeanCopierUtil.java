package com.zx.springboot.utils.util.bean;

import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * NOTE:
 * ===============================================================
 * - 基于（同名属性）的复制
 * - 属于浅复制
 * - 同名不同类型的属性，不会复制（即使存在继承关系或是装拆箱类）e.g. int->Integer
 * - 同集合类不同泛型，可以复制，后续取出元素时会报类型转换错误，如果后续只是做比如json序列化，不会影响 e.g. List<Double> -> List<BigDecimal>
 * ===============================================================
 * TODO:
 * - 添加类型转换，解决同名不同类型的属性复制的问题
 */
public abstract class BeanCopierUtil {
    private static final ConcurrentMap<String, BeanCopier> beanCopierCache = new ConcurrentHashMap<>();
    private static final String keySplitor = "->";
    private static final int threshold = 1 << 20;  //>=threshold use parallelstream
    private static final ConcurrentMap<String, Constructor> constCache = new ConcurrentHashMap<>();

    public static <S, T> void copy(S sourceObject, T targetObject) {
        if (sourceObject == null || targetObject == null) {
            throw new IllegalArgumentException("sourceObject or targetObject required not empty.");
        }
        BeanCopier bc = getBeanCopier(sourceObject.getClass(), targetObject.getClass());
        bc.copy(sourceObject, targetObject, null);
    }

    public static <S, T> T copy(S sourceObject, Class<T> targetClass) throws Exception {
        if (sourceObject == null || targetClass == null) {
            throw new IllegalArgumentException("sourceObject or targetClass required not empty.");
        }
        Class<?> sourceClass = sourceObject.getClass();
        BeanCopier beanCopier = getBeanCopier(sourceClass, targetClass);
        T target = targetClass.newInstance();
        beanCopier.copy(sourceObject, target, null);
        return target;
    }

    public static <S, T> List<T> copyList(List<S> sourceList, Class<S> sourceClass, Class<T> targetClass) throws Exception {
        List<T> targetList = new ArrayList<>();
        BeanCopier beanCopier = getBeanCopier(sourceClass, targetClass);

        for (S source : sourceList) {
            T target = targetClass.newInstance();
            targetList.add(target);
            if (source == null || target == null) {
                continue;
            }
            beanCopier.copy(source, target, null);
        }
        return targetList;
    }


    public static <S, T> void copyList(List<S> sourceList, List<T> targetList, int sourceOffset, int targetOffset, int length) {
        if (sourceList == null || targetList == null || sourceList.isEmpty() || targetList.isEmpty()) {
            throw new IllegalArgumentException("sourceList and targetList required not empty.");
        }
        if (sourceOffset < 0 || targetOffset < 0) {
            throw new IllegalArgumentException("sourceList and sourceOffset required >=0.");
        }
        if (length < 1) {
            throw new IllegalArgumentException("len required >0.");
        }
        int sourceSize = sourceList.size();
        int targetSize = targetList.size();
        if (sourceSize < sourceOffset + length || targetSize < targetOffset + length) {
            throw new IllegalArgumentException("sourceOffset+len and targetOffset+len required not out of range.");
        }
        Class<?> sourceClass = sourceList.get(sourceOffset).getClass();
        Class<?> targetClass = targetList.get(targetOffset).getClass();
        BeanCopier beanCopier = getBeanCopier(sourceClass, targetClass);

        for (int i = 0; i < length; i++) {
            beanCopier.copy(sourceList.get(sourceOffset + i), targetList.get(targetOffset + i), null);
        }
    }


    private static BeanCopier getBeanCopier(Class<?> sourceClass, Class<?> targetClass) {
        String key = generateKey(sourceClass, targetClass);
        BeanCopier beanCopier = beanCopierCache.computeIfAbsent(key, k -> {
            return BeanCopier.create(sourceClass, targetClass, false);
        });
        return beanCopier;
    }

    private static String generateKey(Class<?> sourceClass, Class<?> targetClass) {
        StringBuilder sb = new StringBuilder();
        String sourceClassName = sourceClass.getName();
        String targetClassName = targetClass.getName();
        sb.append(sourceClassName).append(keySplitor).append(targetClassName);
        return sb.toString();
    }

    //    public static class BeanCopierConverter<T> implements Converter {
//        @SuppressWarnings("rawtypes")
//        @Override
//        public Object convert(Object source, Class target, Object context) {
//            return (T)source;
//
//        }
//    }



}