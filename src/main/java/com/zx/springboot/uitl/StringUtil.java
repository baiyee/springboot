package com.zx.springboot.uitl;

import org.apache.commons.lang3.StringUtils;

/**
 * @author zhangxuan
 * @description: 常用String 工具类
 * @date 2021/7/6
 */
public class StringUtil {

    /**
     * @Description: 替换String字符串中最后一个字符
     * @Description: example： oldString = "6868,,"  replaceStr = ";"  result = "6868,;"
     *
     * @param oldString
     * @param replaceStr
     * @return the isReplaceString
     */
    public static String ReplaceLastString(String oldString, String replaceStr) {
        if (StringUtils.isEmpty(oldString)) {
            throw new NullPointerException("oldString must not be null.");
        }
        if (StringUtils.isEmpty(replaceStr)) {
            throw new NullPointerException("replaceStr must not be null.");
        }
        int beginIndex = 0;
        int endIndex = oldString.length() - 1;
        String oldSubString = oldString.substring(beginIndex, endIndex);
        StringBuilder sb = new StringBuilder(oldSubString);
        return sb.append(replaceStr).toString();
    }
}
