package com.zx.springboot;

import com.zx.springboot.uitl.core.string.StringUtil;

/**
 * @author xinye
 * @version 1.0.0
 * <p>
 * ----------------------------------------------------------------------------
 * modifyer    modifyTime                 comment
 * ----------------------------------S------------------------------------------
 * </p>
 * @ClassName: TestVideoChangeTransCode
 * @Description: testVideoChangeTransCode
 * @date 2019-06-11 20:57
 */
public class TestVideoChangeTransCode {
    public static void main(String[] args) {
//        File fileInput = new File("/Users/xinye/Documents/live.mp4");
//        File fileOutput = new File("/Users/xinye/Documents/live_mp4_second.mp4");
//        MediaUtil.convertVideo(fileInput,fileOutput,false,
//                28,MEDIUM_ZIP_SPEED.getPresetValue(),null,null);
        String name = "刺梦.suv.ant.mv.mp4";
        System.out.println(name.substring(name.lastIndexOf(".") + 1));
        System.out.println(StringUtil.ReplaceLastString("6868,,,,,", ";"));

    }


}
