package com.zx.springboot.lambda.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @description: 专辑，由若干曲目组成。
 * @date 2021/7/15
 * @author zhangxuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class Album {
    /**专辑名 eg: 《寻物启事》》*/
    private String name;
    /**专辑上所有曲目的列表 eg: 《叹服》《灰色头像》*/
    private List<Track> tracks;
    /**参与创作本专辑上所有艺术家列表 eg: 许嵩，何曼婷*/
    private List<Artist> musicians;
}
