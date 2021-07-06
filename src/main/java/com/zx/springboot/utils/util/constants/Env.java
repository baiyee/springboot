package com.zx.springboot.utils.util.constants;

import com.zx.springboot.utils.util.ips.ServerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public abstract class Env {
    private static Logger logger = LoggerFactory.getLogger(Env.class);
    private static EnvType env = EnvType.PROD; //默认是生产环境
    private static String version;
    private static String serverName;
    private static String projectName;

    static {
        try {
            Properties props = new Properties();
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("env.conf"));
            switch (props.getProperty("env")) {
                case "prod":
                    env = EnvType.PROD;
                    break;
                case "stage":
                    env = EnvType.STAGE;
                    break;
                case "test":
                    env = EnvType.TEST;
                    break;
                case "dev":
                    env = EnvType.DEV;
                    break;
            }
            try {
                version = props.getProperty("version");
                logger.info("find version: {}", version);
            }catch (Exception e){
                logger.warn("find source version error: {}", e.toString());
            }
           
        } catch (Exception ignore) {
            logger.info("ignore", ignore);
        }
        logger.warn("env: {}", env);
    }

//    static {
//        try {
//            Properties props = new Properties();
//            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("project.properties"));
//            projectName = props.getProperty("name");
//        } catch (Exception ignore) {
//            logger.info("ignore", ignore);
//        }
//        logger.warn("projectName: {}", projectName);
//    }

//    static {
//        if (!Env.isDev()) {
//            try {
//                // version.properties是gradle打包时候自动产生的
//                Properties props = new Properties();
//                props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("version.properties"));
//                version = props.getProperty("version");
//                logger.info("find version: {}", version);
//            } catch (Exception e) {
//                logger.warn("find source version error: {}", e.toString());
//            }
//        }
//    }

    static {
        String ip;
        if (isProd()) {
            ip = ServerUtils.getLocalAddress("10.1", null);
            if (null == ip) {
                ip = ServerUtils.getLocalAddress("127.0.", null);
            }
        } else {
            ip = ServerUtils.getLocalAddress("192.168.", null);
            if(null == ip){
                ip = ServerUtils.getLocalAddress("172.", null);
                if (null == ip) {
                    ip = ServerUtils.getLocalAddress("10.", null);
                }
                if (null == ip) {
                    ip = ServerUtils.getLocalAddress("127.0.", null);
                }
            }
        }
        if (ip == null) {
            throw new IllegalStateException("can't gen serverName, ip not right, "+env);
        }
        serverName = "s"+ip.replace(".", "_");
        logger.info("serverName: {}", serverName);
    }

    /**
     * @return true 外网生产环境
     */
    public static boolean isProd() {
        return env == EnvType.PROD;
    }

    /**
     * @return true 开发人员自己的环境
     */
    public static boolean isDev() {
        return env == EnvType.DEV;
    }

    /**
     * @return true 内网服务器环境
     */
    public static boolean isStage() {
        return env == EnvType.STAGE;
    }

    /**
     * @return true 内网服务器环境
     */
    public static boolean isTest() {
        return env == EnvType.TEST;
    }

    /**
     * @return 线上环境获取打包的代码的git版本
     */
    public static String getEnv() {
        if(null == env){
            env = EnvType.PROD;
        }
        return env.name();
    }
    /**
     * @return 线上环境获取打包的代码的git版本
     */
    public static String getVersion() {
        return version;
    }

    /**
     * @return 服务器唯一名字
     */
    public static String getServerName() {
        return serverName;
    }

    /**
     * @return 获取项目名字
     */
    public static String getProjectName() {
        return projectName==null?"unnamed_project":projectName;
    }

    public static void main(String[] args) {
        System.out.println(Env.getServerName());
    }

    enum EnvType {
        PROD, STAGE, DEV,TEST
    }
}
