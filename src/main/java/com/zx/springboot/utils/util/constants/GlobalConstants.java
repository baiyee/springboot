package com.zx.springboot.utils.util.constants;


/**
 * 服务参数
 */
public class GlobalConstants {

	/**  ================ 1. System  Reflections or ComponentScan start param   ================ **/

	public static final String DEPICT_PACKAGE = "com.st.live";
	public static final String POJECT_PATH = "com/st/live/";
	public static final String COMPONENT_SCAN_BASE_PACKAGES=  "com.st";

	public static final String THIRD_ALIYUN_CONFIG_PREFIX = "top.sms";

	public static final String THIRD_Login_CONFIG_PREFIX = "top.login";

	public static final String SPIDER_CONFIG_PREFIX = "top.spider";

	/**  ================ 1. System  Reflections or ComponentScan end param   ================ **/

	/**  ================ 2. http server start param   ================ **/

	public static final String JETTY_SERVER_ENABLED ="top.jetty.server.enabled";
	public static final String JETTY_SERVER_SETTINGS="top.jetty.server";
	public static final String JETTY_SERVER_FILTER_DOS_ENABLED = "top.jetty.filter.dos.enabled";
	public static final String JETTY_SERVER_FILTER_DOS = "top.jetty.filter.dos";


	public static final String JETTY_SERVER_PORT_SETTINGS = "top.server.port";

	public static final String GC_SERVER_PARAM = "top.server.param";
    public static final String GC_SERVER_INTER = "top.server.inter";
    public static final String GC_SERVER_CAT = "top.server.cat";

	public static final String GC_SERVER_ES_ENABLED = "top.server.es.enabled";
	public static final String GC_SERVER_ES = "top.server.es";

    public static final String GC_SERVER_API_ENABLED = "top.server.api.enabled";
    public static final String GC_SERVER_API_PARAM = "top.server.api";

	public static final String GC_DUBBO_SENTINEL = "top.dubbo.sentinel";


//    public static final String HTTP_START_SERVER_PORT = "server.port";
//    public static final String RPC_DUBBO_START_SERVER_NAME = "spring.application.name";
//    public static final String RPC_DUBBO_START_SERVER_NAME_OLD = "dubbo.application.name";
//    public static final String RPC_DUBBO_START_SERVER_PORT = "dubbo.protocol.port";



	/**  ================ 2. http serve end param   ================ **/

	/**  ================ 3. redis start param   ================ **/
	public static final String REDIS_AUTO_CONFIG_PREFIX = "top.redis.cluster";
	public static final String REDIS_AUTO_CONFIG_ENABLED = REDIS_AUTO_CONFIG_PREFIX + ".enabled";

	public static final String REDIS_CONFIG_CLUSTER_SERVERS = REDIS_AUTO_CONFIG_PREFIX + ".servers";
	public static final String REDIS_CONFIG_CLUSTER_PASSWORD = REDIS_AUTO_CONFIG_PREFIX + ".password";

	/**  ================ 3. redis end param   ================ **/



	/**  ================ 4. MQ start param   ================ **/
	public static final String KAFKA_CONFIG_PREFIX = "top.kafka";
	public static final String KAFKA_CONFIG_ENABLED = KAFKA_CONFIG_PREFIX + ".config.enabled";
	public static final String KAFKA_PRODUCER_ENABLED = KAFKA_CONFIG_PREFIX + ".producer.enabled";
	public static final String KAFKA_CONSUMER_ENABLED = KAFKA_CONFIG_PREFIX + ".consumer.enabled";


	public static final String ROCKT_MQ_CONFIG_ENABLED = "top.rocketmq.config.enabled";
	public static final String ROCKT_MQ_CONFIG_PREFIX  =  "top.rocketmq";

	/**  ================ 4. MQ end param   ================ **/






	/**  ================ 5. password key info start param   ================ **/
	public static final String POST = "POST";
	public static final String APPKEY = "H@s0zRed!fiNger8";
	/** 密码前缀 */
	public static final String PASSWORD_PREFIX = "";
	/** 密码后缀 */
	public static final String PASSWORD_SUFFIX = "H@s0zRed!fiNger8";


	public static final String VERSION_INFO_SERVICE_NAME = "versionValidatorService";
	public static final String VERSION_HANDLER_METHOD_NAME = "initLastAndUpdateVersionMap";

	public static  int GAME_OPEN_OR_CLOSE = 0;
	/**  ================ 5. password key info end param   ================ **/


	/**  ================ 6. OAuth start param   ================ **/
	public static final String OAuth_CONFIG_ENABLED = "top.oauth.config.enabled";
	public static final String OAuth_CONFIG_PREFIX = "top.oauth";



	/**  ================ 6. OAuth end param   ================ **/

	/**  ================ 7. LOGBACK start param   ================ **/
	public static final String LOGBACK_TRACE_ID = "logback_trace_id";
	public static final String LOGBACK_LOCAL_IP = "logback_local_ip";
	/**  ================ 7. LOGBACK end param   ================ **/

	/**  ================ 8. USER start param   ================ **/
	public static final String USER_CONFIG_ENABLED = "top.oauth.config.enabled";
	public static final String USER_CONFIG_PREFIX = "top.oauth";
	/**  ================ 8. USER end param   ================ **/

	/**  ================ 9. OSS start param   ================ **/
	public static final String RESOURCE_OSS_FILE = "top.resource.file.oss";
	public static final String RESOURCE_OSS_FILE_ENABLED = "top.resource.file.oss.enabled";
	/**  ================ 9. OSS end param   ================ **/
	
}
