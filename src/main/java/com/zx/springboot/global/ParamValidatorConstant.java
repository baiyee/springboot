package com.zx.springboot.global;

/**
 * @ClassName:
 * @Description:
 * @Author zhangxuan
 * @Date 2018/5/16 10:56
 * @Copyright: (c) 2018 gc by https://www.gc.com.cn/
 * @Version : 1.0.0
 */
  public interface ParamValidatorConstant {
    interface Base{
         String PARAMS_RANGE_ERROR = "参数范围错误";
    }
    interface User{
             String USER_ID_IS_NOT_NULL = "用戶ID不能为空";
             String USER_NAME_IS_NOT_NULL = "用戶号码或者邮箱不能为空";
             String SIGN_IS_NOT_NULL = "密钥不能为空";
             String VERSION_IS_NOT_NULL = "版本不能为空";
             String CLIENT_IS_NOT_NULL = "客户端平台不能为空";
             String TIMESTAMP_IS_NOT_NULL = "时间戳不能为空";
             String CHECK_S_IS_NOT_NULL = "校验参数不能为空";
             String ENCRYPT_PARM_IS_NOT_NULL = "加密参数不能为空";
             String CUID_IS_NOT_NULL = "用户识别号不能为空";
    }

    interface System{
            final String CLIENT_TYPE_IS_NOT_NULL = "客户端类型不能为空";
            final String SOURCE_IS_NOT_NULL = "用户来源不能为空";
            final String USER_ID_IS_NOT_NULL  = "用户id不能为空";
            final String TOKEN_IS_NOT_NULL  = "token不能为空";
            final String CLIENT_IS_NOT_NULL = "客户端编号不能为空";
            final String VERSION_IS_NOT_NULL = "客户端版本不能为空";
            final String SYS_VERSION_IS_NOT_NULL = "客户端操作系统版本不能为空";
            final String DEVICE_IS_NOT_NULL = "设备标识不能为空";
            final String CHANNEL_IS_NOT_NULL = "渠道号不能为空";
            final String SIGN_IS_NOT_NULL = "签名不能为空";
            final String TIMES_IS_NOT_NULL = "时间戳不能为空";
            final String CHANNEL_CODE_IS_NOT_NULL = "渠道编码不能为空";
            final String REQUEST_TYPE_ERROR = "类型必须是HTTP或RPC";
            final String MODULE_IS_NULL = "模块不能为空";
            final String UUID_IS_NOT_NULL = "UUID不能为空";
    }
    interface Oauth{
            final String CLIENT_ID_IS_NOT_NULL = "客户端ID不能为空";
            final String ACCESS_TOKEN_IS_NOT_NULL = "ACCESS_TOKEN不能为空";
            final String USER_NAME_IS_NOT_NULL = "用户名不能为空";
            final String SIGN_IS_NOT_NULL = "加密key";
            final String V_IS_NOT_NULL = "版本号不能为空";
            final String CHANNEL_CODE_IS_NOT_NULL = "客户端渠道编码不能为空";
            final String VALIDCODE_IS_NOT_NULL = "验证码不能为空";
            final String UUID_IS_NOT_NULL = "UUID不能为空";
            final String CLIENT_IS_NOT_NULL = "客户端类型不能为空";
        String OPID_IS_NOT_NULL = "第三方自动登录唯一标识opid不能为空";
    }

    interface Order{
        final String ORDER_STATUS_TYPE_IS_NOT_NULL = "订单查询类型不能为空";
        final  String ORDER_ID_IS_NOT_NULL = "订单ID不能为空";
        final String ORDER_ID_IS_NOT_CONFORMED = "订单ID格式不符合";
    }

    interface Assets {
        final String GIFT_STATUS_IS_NOT_NULL = "礼包状态不能为空";
        final String PAGE_NUM_LESS_ZERO = "当前页应为正整数";
        final String PAGE_SIZE_LESS_ZERO = "每页数量应为正整数";
    }
}
