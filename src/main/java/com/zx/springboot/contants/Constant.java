package com.zx.springboot.contants;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiongyikai on 2018/1/31.
 */
public class Constant {

    public static final String HEADER_KEY_AUTHORIZATION = "Authorization";
    //app系统
    public static final String APP_SYSTEM = "system";
    //app版本号
    public static final String APP_VERSION = "version";

    //tb_cointype表ID
    //正式链
    public static final int BTC = 1;//正式币链
    public static final int ETH = 2;//正式币链
    public static final int VNS = 5;//vns正式
    public static final int RIPPLE = 7;//Ripple正式

    //测试链
    public static final int BTC_TEST = 3;//测试币链
    public static final int ETH_TEST = 4;//测试币链
    public static final int VNS_TEST = 6;//vns测试
    public static final int RIPPLE_TEST = 8;//Ripple测试

    //币种英文名称
    public static final String COIN_EN_BTC = "BTC";
    public static final String COIN_EN_ETH = "ETH";
    public static final String COIN_EN_VNS = "VNS";
    public static final String COIN_EN_RIPPLE = "RIPPLE";
    public static final String COIN_EN_TESTBTC = "TestBTC";
    public static final String COIN_EN_TESTETH = "TestETH";
    public static final String COIN_EN_TESTRIPPLE = "TestRIPPLE";

    //币种标识符
    public static final String COIN_TYPE_ETH = "ETH";
    public static final String COIN_TYPE_BTC = "BTC";
    public static final String COIN_TYPE_VNS = "VNS";
    public static final String COIN_TYPE_RIPPLE = "RIPPLE";
    public static final String COIN_TYPE_TESTBTC = "TestBTC";
    public static final String COIN_TYPE_TESTETH = "TestETH";
    public static final String COIN_TYPE_TESTVNS = "TestVNS";
    public static final String COIN_TYPE_TESTRIPPLE = "TestRIPPLE";


    public static final String RIPPLE_ERROR = "error";

    //1ETH对应的位
    public static final String ETH_TO_WEI = "1000000000000000000";

    //1BTC对应的位
    public static final String BTC_TO_WEI = "100000000";

    //etherscan.io的APIKEY
    public static final String ETHERSCAN_APIKEY = "AEUVWQDAH1319ZMJWCZUWDEQKZKVIID7J";

    //测式链的以太坊及代币的查询地址 util
    public static final String ETH_API_SEARCH_URL = "http://api-rinkeby.etherscan.io/api?module=account&action=txlist&address=%s&startblock=0&endblock=99999999&sort=asc&apikey=" + ETHERSCAN_APIKEY;
    //正式链的以太坊及代币的查询地址 util
    public static final String PRO_ETH_API_SEARCH_URL = "http://api.etherscan.io/api?module=account&action=txlist&address=%s&startblock=0&endblock=99999999&sort=asc&apikey=" + ETHERSCAN_APIKEY;

    //api.blocktrail.com的APIKEY
    public static final String BLOCKTRAIL_APIKEY = "88c2874b9f97331581c3c208755cd375094f6374";

    //比特币的交易记录查询地址 {address}:1H6ZZpRmMnrw8ytepV3BYwMjYYnEkWDqVP(正式链)
    //测式链环境需要把/tbtc更改为/btc)util
    public static final String BTC_API_ADDRESS_TRANSACTIONS_URL = "https://api.blocktrail.com/v1/tbtc/address/%s/transactions?api_key=" + BLOCKTRAIL_APIKEY;
    //正式链上的比特币的交易记录查询地址
    public static final String PRO_BTC_API_ADDRESS_TRANSACTIONS_URL = "https://api.blocktrail.com/v1/btc/address/%s/transactions?api_key=" + BLOCKTRAIL_APIKEY;

    //测式链查询比特币余额地址 util
    public static final String TEST_BTC_API_BALANCE_URL = "https://api.blocktrail.com/v1/tBTC/address/%s?api_key=" + BLOCKTRAIL_APIKEY;
    //测式链查询比特币余额地址2 util
    public static final String TEST_BTC_API_BALANCE_URL2 = "https://testnet.blockchain.info/q/addressbalance/%s";
    //测式链查询比特币余额地址3(多个地址间可以使用|来间隔)
    public static final String TEST_BTC_API_BALANCE_URL3 = "https://testnet.blockchain.info/zh-cn/balance?active=%s";


    //比特币交易记录查询地址
    public static final String BTC_TRANSACTIONS_BLOCKCHAIN_URL = "https://testnet.blockchain.info/rawaddr/%s";
    //正式环境
    public static final String PRO_BTC_TRANSACTIONS_BLOCKCHAIN_URL = "https://blockchain.info/rawaddr/%s";

    //正式链查询比特币余额地址 util
    public static final String PRO_PER_BTC_API_BALANCE_URL = "https://api.blocktrail.com/v1/BTC/address/%s?api_key=" + BLOCKTRAIL_APIKEY;
    //正式链查询比特币余额地址2 util
    public static final String PRO_BTC_API_BALANCE_URL2 = "https://blockchain.info/q/addressbalance/%s";

    //正试链查询比特币余额地址(多个地址间可以使用|来间隔)

    public static final String PRO_BTC_API_BALANCE_URL = "https://blockchain.info/zh-cn/balance?active=%s";

    //获取比特币交易费用查询地址
    public static final String TEST_BTC_API_fees_URL = "https://bitcoinfees.earn.com/api/v1/fees/recommended";

    //定义线程池大小,默认为(CPU+1)*2
    public static int Thread_SIZE = (Runtime.getRuntime().availableProcessors() + 1) * 2;

    //设计一个线程池，方便执行线程任务
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static ExecutorService executorService = new ThreadPoolExecutor(Thread_SIZE, Thread_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());

    //一次性获取钱包地址数量
    public static int MAX_LOAD_WALLET_ADDRESS = 10000;

    //确定BTC交易状态为成功的最小确认数6
    public static long BTC_MIN_CONFIRMATIONS = 2;


    // 广告表标识：资讯广告表的sign 1
    public static int ADVERTISEMENT_SIGN_INFORMATION = 1;

    //附件表tb_enclosure.sign
    //附件标识：tb_feedback意见反馈表图片附件
    public static int ENCLOSURE_SIGN_FEEBACK_PIC = 1;
    //附件标识：tb_feedback意见反馈表日志附件
    public static int ENCLOSURE_SIGN_FEEBACK_LOG = 2;
    //附件标识：tb_apply_token申请代币表图标附件
    public static int ENCLOSURE_SIGN_APPLY_TOKEN_ICON = 3;

    // 公链区块浏览器地址表tb_explorer_url.sign
    // 标识查询类型sign：0全局搜索;1区块(数字/Hash);2交易(Hash);3账户(地址);4合约(名称/地址);
    public static int EXPLORER_URL_SIGN_ALL = 0;
    public static int EXPLORER_URL_SIGN_BLOCK = 1;
    public static int EXPLORER_URL_SIGN_TRAN = 2;
    public static int EXPLORER_URL_SIGN_ADDR = 3;
    public static int EXPLORER_URL_SIGN_CONTR = 4;

    // 公链区块浏览器地址表tb_explorer_url.urlStyle
    // URL传参方式：0原始值;1数字;2Hash;3地址;4名称;
    public static int EXPLORER_URL_URLSTYLE_ANY = 0;
    public static int EXPLORER_URL_URLSTYLE_NUM = 1;
    public static int EXPLORER_URL_URLSTYLE_HASH = 2;
    public static int EXPLORER_URL_URLSTYLE_ADDR = 3;
    public static int EXPLORER_URL_URLSTYLE_NAME = 4;

    public static final String LOCALE = "locale";
    public static final String EN_US = "en_US";
    public static final String ZH_CN = "zh_CN";

}
