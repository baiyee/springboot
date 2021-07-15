package com.zx.springboot.lambda.refactor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 专辑中的一只曲目
 * @date 2021/7/15
 * @author zhangxuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class Track {
    /**曲目名称 eg: 《黄色潜水艇》*/
    String name;
    /**曲目时长 eg: 5分钟*/
    Integer length;
}