package com.zx.springboot.lambda.stream;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangxuan
 * @description: 使用Stream Api 进行代码重构
 * @date 2021/7/15
 */
public class RefactorTest1 {

    public Set<String> findLongTracks(List<Album> albums) {
        Set<String> trackNames = new HashSet<>();
        for (Album album : albums) {
            for (Track track : album.getTracks()) {
                if (track.getLength() > 60) {
                    String name = track.getName();
                    trackNames.add(name);
                }
            }
        }
        return trackNames;
    }
}

