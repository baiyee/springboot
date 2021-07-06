package com.zx.springboot.uitl.core.baidu;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class Sample2 {
    //设置APPID/AK/SK
    //"你的 App ID";
    public static final String APP_ID = "11784039";
    //"你的 Api Key";
    public static final String API_KEY = "nDuA7GxRW3cFc0bU1j6yEZKF";
    //"你的 Secret Key";
    public static final String SECRET_KEY = "9y8cKbk5jhMueYZdxutM9MX4I984LrDw";

    public static void main(String[] args) throws Exception {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
          String str = "字式之，----號石屏，台州黃岩(今屬浙江)人。以詩鳴江湖間，為江湖詩人之重要作家。有《石屏詩集》、《石屏詞》。主要作品有:滿江紅（赤壁磯頭）','(1167－？)字式之，號石屏，台州黃岩(今屬浙江)人。以詩鳴江湖間，為江湖詩人之重要作家。有《石屏詩集》、《石屏詞》。";

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
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("spd", "5");
        options.put("pit", "5");
        options.put("vol", "8");
        options.put("per", "0");

        str = "百度您好";
        TtsResponse res = client.synthesis(str, "zh", 1, options);



//          TtsResponse res = client.synthesis(str, "zh", 1, null);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, "output.wav");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            System.out.println(res1.toString(2));
        }

    }

    public static void main4(String[] args) throws Exception {
//        main3(args);
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
//        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");
        //目前rate参数仅提供8000,16000两种
        String str = "/Users/suven/project/workspace/redfinger/hsz/output.wav";
        JSONObject res =  client.asr(str,"wav", 8000, null);
        // 调用接口
//        JSONObject res = client.asr("test.pcm", "pcm", 16000, null);
        System.out.println(res.toString());
        
    }
}