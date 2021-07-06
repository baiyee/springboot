package com.zx.springboot.utils.core.baidu;

import com.zx.springboot.utils.core.json.JsonUtils;
import java.util.HashMap;

/**
 * @ClassName BaiduOptions
 * @Author suven.wang
 * @Description //TODO ${END}$
 * @CreateDate 2018-11-29  11:08
 * @WeeK 星期四
 * @Version v2.0
 **/
public class BaiduOptions {
    //        参数	类型	描述	是否必须
//        tex	String	合成的文本，使用UTF-8编码，
//        请注意文本长度必须小于1024字节	是
//        cuid	String	用户唯一标识，用来区分用户，
//        填写机器 MAC 地址或 IMEI 码，长度为60以内	否
//        spd	String	语速，取值0-9，默认为5中语速	否
//        pit	String	音调，取值0-9，默认为5中语调	否
//        vol	String	音量，取值0-15，默认为5中音量	否
//        per	String	发音人选择, 0为女声，1为男声，
//        3为情感合成-度逍遥，4为情感合成-度丫丫，默认为普通女	否
// 设置可选参数
    private String spd = "2";
    private String pit = "5";
    private String vol = "5";
    private String per = "0";

    public static BaiduOptions build(){
        return new BaiduOptions();
    }

    public HashMap<String, Object> getOptionsMap(){
       return new HashMap<>(JsonUtils.objectToMap(this));
    }

    public String getSpd() {
        return spd;
    }

    public BaiduOptions setSpd(int spd) {
        this.spd = String.valueOf(spd);
        return this;
    }

    public String getPit() {
        return pit;
    }

    public BaiduOptions setPit(int pit) {
        this.pit = String.valueOf(pit);
        return this;
    }

    public String getVol() {
        return vol;
    }

    public BaiduOptions setVol(int vol) {
        this.vol = String.valueOf(vol);
        return this;
    }

    public String getPer() {
        return per;
    }

    public BaiduOptions setPer(int per) {
        this.per = String.valueOf(per);
        return this;
    }



}
