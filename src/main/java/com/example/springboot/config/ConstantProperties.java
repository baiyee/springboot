package com.example.springboot.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xinye
 * @version 1.0.0
 * <p>
 * ----------------------------------------------------------------------------
 * modifyer    modifyTime                 comment
 * ----------------------------------------------------------------------------
 * </p>
 * @ClassName: ConstantProperties
 * @Description: aliyun 配置文件配置项
 * @date 2019-06-05 12:21
 */
@Component
public class ConstantProperties implements InitializingBean {

    @Value("${oss.file.endpoint}")
    private String oss_file_endpoint;

    @Value("${oss.file.keyid}")
    private String oss_file_keyid;

    @Value("${oss.file.keysecret}")
    private String oss_file_keysecret;

    @Value("${oss.file.filehost}")
    private String oss_file_filehost;

    @Value("${oss.file.bucketname1}")
    private String oss_file_bucketname1;


    public static String OSS_END_POINT;
    public static String OSS_ACCESS_KEY_ID;
    public static String OSS_ACCESS_KEY_SECRET;
    public static String OSS_BUCKET_NAME1;
    public static String OSS_FILE_HOST;

    @Override
    public void afterPropertiesSet() throws Exception {
        OSS_END_POINT = oss_file_endpoint;
        OSS_ACCESS_KEY_ID = oss_file_keyid;
        OSS_ACCESS_KEY_SECRET = oss_file_keysecret;
        OSS_FILE_HOST = oss_file_filehost;
        OSS_BUCKET_NAME1 = oss_file_bucketname1;
    }
}
