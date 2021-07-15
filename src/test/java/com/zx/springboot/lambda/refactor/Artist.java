package com.zx.springboot.lambda.refactor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 创作音乐的个人或团队。
 * @date 2021/7/15
 * @author zhangxuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Artist {
    /**艺术家或团队的名字 eg: 许嵩*/
    private String name;
    /**乐队成员 eg: 许嵩*/
    private String members;
    /**乐队来自哪儿 eg: 中国*/
    private String origin;
}
