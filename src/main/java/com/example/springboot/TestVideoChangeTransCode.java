package com.example.springboot;

import com.example.springboot.uitl.MediaUtil;

import java.io.File;

import static com.example.springboot.uitl.changevideo.enums.PresetVauleEnum.*;

/**
 * @author xinye
 * @version 1.0.0
 * <p>
 * ----------------------------------------------------------------------------
 * modifyer    modifyTime                 comment
 * ----------------------------------------------------------------------------
 * </p>
 * @ClassName: TestVideoChangeTransCode
 * @Description: testVideoChangeTransCode
 * @date 2019-06-11 20:57
 */
public class TestVideoChangeTransCode {
    public static void main(String[] args) {
        File fileInput = new File("/Users/xinye/Documents/live.mp4");
        File fileOutput = new File("/Users/xinye/Documents/live_mp4_second.mp4");
        MediaUtil.convertVideo(fileInput,fileOutput,false,
                28,MEDIUM_ZIP_SPEED.getPresetValue(),null,null);
    }
}
