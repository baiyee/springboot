package com.zx.springboot.global.enums;


import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Title: MsgEnumType.java
 * @author Joven.wang
 * @date 2015年2月10日
 * @version V1.0
 * @Description: TODO(说明) 此类封装了,从第三方平台的返回code,转换成业务逻辑用户错误提示信息; eg:
 *               SYS_CODE_为前缀,后缀编码为第三方反回code信息,括号为提前端编码和提示信息;
 */

public enum SysMsgEnumType implements IMsgEnumType{

	/** 编码规范说明: 1,1 01 001 错误编码的意思,第一位(1)代码是系统,第2位是功能码
	 第3，4位( eg: 01用户信息模块, 02礼物模块),第5，6，7号(该模块用到的返回提示用号的编码code)
	 1. 1 00 01 - 100 99(共99个系统级别) 是手端(看7.0 app 2.0) 应用后台系统级别返回来的统一规范编码
	 1.第1位表示软件平台：1
	 2.第2位表示功能类型：1.弹窗提示，2.软接连，3.跳转url
	 3.第3.4位表示模块分类名称：00系统 01 用户 02 验证 03 资源 04 支付 05 资产 06 设备 07 订单 08 活动 09 桌面 10 配置 11 MQ 12 定时 13 第三方 14 应用市场
	 4.第5，6，7位表示错误序列号；
	 */
	SYS_SUCCESS(0, "成功"),

	/** 系统返回错误码 10000~10099*/
	SYS_UNKOWNN_FAIL(1100000, "操作失败!"),
	SYS_TOKEN_NULL(1100001, "请重新登录"),
	SYS_INVALID_REQUEST(1100002,"无效请求"),
	SYS_PARAM_ERROR(1100003,"参数请求错误，%s！"),
	SYS_PARAM_CHECK(1100004,"参数检验不符要求！"),
	SYS_CUID_FORMAT_ERROR(1100005,"cuid不合法！"),
	SYS_PROJECT_MAINTAIN(1100006,"服务维护中！"),
	SYS_VISITS_WAIT(1100007,"当前访问人数过多，请稍后重试！"),
	SYS_VERSION_NEW_UPDATE(1100008,"新版本更新提示"),
	SYS_VERSION_FORCE_UPDATE(1100009,"强制更新版本提示"),
    SYS_REQUEST_URL_NOT_FOUND(1100010,"该请求不存在,请确认api :[ %s ]"),
	SYS_PARAM_JSON_FAIL(1100011,"JSON 请求参数转换失败"),

	SYS_WEB_CHECK_INFO_FAIL(2100001, "请选择需要处理的记录"),
	SYS_WEB_UPD_INFO_NO_EXIST(2100002, "待操作的记录不能为空"),

	/**  用户模块(1101) **/
	USER_CODE_NOT(1101001,"账号不存在！"),
	USER_CODE_EXIT(1101002,"账号已存在！"),
	USER_REGISTER_FAIL(1101003,"注册用户失败，请稍后再试！"),
    USER_REGISTER_ALIAS_FAIL(1101004,"注册用户登陆信息失败，请稍后再试！"),
	PAY_PASS_WORD_NOT_SAME(1101005,"2次付款密码不一致"),
	USER_SMS_CODE_FAILE(1101006,"无效的短信类型"),
	USER_SMS_GET_CODE_FAILE(1101007,"获取验证码失败，请稍后重试！"),
	USER_SMS_CODE_NOT_EXIT(1101008,"请先获取验证码"),
	USER_SMS_CODE_BE_INVALID(1101009,"验证码无效"),
	USER_CODE_IS_FORBID_LOGIN(1101010,"您的帐号已被禁止登录系统，如有疑问，请联系我司客服"),
	USER_CODE_IS_BACK_LIST(1101011,"您的帐号目前处于黑名单状态，暂时不能登录"),
	USER_CODE_NICKNAME_LENGTH(1101012,"您的昵称太长了"),
	USER_PHONE_NOT_SAME(1101014,"手机号码原有邦定号码不一致"),
	USER_PHONE_NOT_NULL(1101015,"手机号码不能为空"),
	USER_PASSWORD_NOT_NULL(1101016,"密码错误请重新输入!"),
	USER_SMS_CODE_NOT_NULL(1101017,"验证码不能为空"),
	USER_LOGIN_ALIAS_INOF_FAILE(1101018,"账号已存在,注册密码不一致,请重新登陆"),
	USER_LOGIN_PASSWORD_FAILE(1101019,"密码错误，请重先输入"),
	USER_LOGIN_PASSWORD_LENGTH(1101020,"新密码长度不能低于6位"),
	USER_PASSWORD_MODIFY_FAIL(1101021,"修改密码失败"),
	USER_APP_ROLE_NOT_EXIT(1101022,"该软件没有注册权限，请联系管理员"),
	USER_APP_ROLE_NOT_LOGIN(1101023,"该用户没有权限不足，请联系管理员"),
	USER_APP_PHONE_NUM_FAIL(1101024,"请输入正确的手机号码"),
	USER_PARTNER_ID_FAIL(1101025, "商户号错误，商户号以:“ %s “ 开头"),
	USER_UNIQUE_PRIMARY_KEY_FAIL(1101026, "AppId错误，appId以:“ %s “ 开头"),
	USER_PARTNER_CODE_NOT_EXIT(1101027, "该合作商户不存在"),
	USER_PARTNER_APP_NOT_EXIT(1101028, "该合作商户的APP号不存在"),
	USER_ADDRESS_NOT_EXIT(1101030,"用户地址不存在"),
	USER_ADDRESS_ADD_FAIL(1101031,"新增地址失败"),
	USER_ADDRESS_MODIFY_FAIL(1101032,"修改地址失败"),
	USER_ADDRESS_MODIFY_DEFAULT(1101033,"该地址已经是默认地址"),
	USER_ADDRESS_NOT_RIGHT(1101034,"该用户没有删除地址权限"),
	USER_ID_IS_ERROR(1101035,"用户id不存在"),
	USER_THIRD_LOGIN_PARM_IS_ERROR(1101037,"parm参数格式错误"),
	USER_THIRD_LOGIN_PADUNIQUE_IS_NULL(1101038,"设备唯一标识为空"),
	USER_THIRD_LOGIN_THIRDTYPE_IS_ERROR(1101039,"第三方登录的类型错误"),
	USER_THIRD_LOGIN_CLIENT_IS_ERROR(1101040,"客户端类型错误"),
	USER_THIRD_LOGIN_WEIXINCODE_IS_NULL(1101041,"微信授权码为空"),
	USER_THIRD_LOGIN_WEIXINLOGIN_IS_ERROR(1101042,"微信登录失败，请联系管理员"),
	USER_THIRD_LOGIN_WEIXINLOGIN_PARAMS_IS_NULL(1101043,"微博登录失败，参数为空"),
	USER_THIRD_LOGIN_WEIBOLOGIN_IS_ERROR(1101044,"微博登录失败，请联系管理员"),
	USER_THIRD_LOGIN_QQLOGIN_PARAMS_IS_NULL(1101045,"QQ登录失败，参数为空"),
	USER_THIRD_LOGIN_QQLOGIN_IS_ERROR(1101046,"QQ登录失败，请联系管理员"),
	USER_LOGIN_FAIL(1101047,"登录失败，请联系管理员"),
	USER_INFO_IS_NOT_FOUNT(1101048,"未找到用户资料"),
	USER_USERNAME_ERROR(1101049,"用户名错误！"),
	USER_MOBILEPHONE_EXISTS(1101050,"此号码已经被绑定了,请重新输入其他手机号码"),
	USER_INVITEECODE_ERROR(1101051,"邀请码不能在同一手机注册"),
	USER_BIND_TASE_PAD_ERROR(1101052,"用户申请体验设备状态和设备数量错误"),
    USER_BANK_CARD_NULL(1101053,"银行账号不能为空"),
    USER_BANK_NAME_NULL(1101054,"银行名称不能为空"),
    USER_BANK_USER_NAME_NULL(1101055,"开户人姓名不能为空"),
    USER_CONTACT_PHONE_NULL(1101056,"联系电话不能为空"),
    USER_SECURE_PWD_NULL(1101057,"安全口令不能为空"),
    USER_BIND_TASE_PADINFO_ERROR(1101058,"绑定失败,更新用户绑定信息失败"),
	USER_EMAIL_IS_NULL(1101059,"此邮箱没绑定账号"),
	USER_MOBILE_IS_NOT_REGISTERED(1101060,"此账号没有手机号码"),
	ALI_REALNAME_NULL(1101064,"未设置支付宝账号真实姓名"),
	USER_REPORT_EXIT(1101065,"用户资产信息未查到"),
	USER_RANK_IS_NOT_FOUNT(1101066,"系统不存在等级初始化等级信息"),
	USER_PHONE_IS_EXIT(1101067,"手机号码已经存在"),
	USER_INVITATION_CODE_NOT_EXIT(1101068,"邀请码不存在！"),
	USER_NAME_PASSWORD_NOT_EXIT(1101069,"手机号码或密码不正确"),
	USER_PHONE_BIND_IS_EXIT(1101070,"该手机号码已注册，请用新的手机号码进行绑定"),
	USER_PHONE__IS_REGISTER(1101071,"该手机号码已注册"),
	USER_PHONE_IS_NULL(1101072,"请输入手机号码"),
	USER_IS_ERROR(1101073,"用户不存在"),
	USER_MODIFY_PASSWORD_ERROR(1101074,"原密码错误，请重新输入"),

	USER_SMS_CODE_ERROR(1101075,"验证码错误，请重新输入"),
	USER_SMS_CODE_EXPIRED(1101076,"验证码已失效，请重新获取验证码"),

	USER_ACCOUNT_BANNED(1101077,"此账号因违规操作，已被封禁"),
	USER_COMMENT_BANNED(1101078,"此账号因发布不当言论，已被禁止发布评论"),
	USER_BARRAGE_BANNED(1101079,"此账号因发布不当言论，已被禁止发布弹幕"),

	USER_LOGIN_MANNY_ERROR(1101080,"登录密码错误次数连续超过5次，请稍后再尝试。"),

	USER_AUTH_LOGIN_FAIL(1101081,"授权登录失败，请稍后再试！"),



	/**  验证模块(1102) **/

	AUTH_CLIENT_ILLEGAL(1102001,"客户端类型不正确"),
	AUTH_CLIENT_SECRET_ILLEGAL(1102002,"客户端密码不正确"),
	AUTH_ACCESS_TOKEN_FAIL(1102003,"ACCESS_TOKEN校验过期,请重新登陆!"),
	AUTH_GET_ACCESS_TOKEN_FAIL(1102004,"获取ACCESS_TOKEN失败"),
	AUTH_VALIDCODE_IS_NULL(1102005,"请输入图形验证码"),
	AUTH_VALIDCODE_IS_FAIL(1102006,"手机验证码已失效，请重新获取"),
	AUTH_VALIDCODE_IS_ERROR(1102007,"图形验证码不正确，请重新输入"),
	AUTH_USER_LOGIN_USERNAME_IS_NULL(1102008,"用户账号为空"),
	AUTH_USER_TO_DB_ERROR(1102012,"存储验证码失败"),
	AUTH_USER_CLASSIFY_IS_ERROR2(1102013,"无效账号，请联系客服"),//工作室会员不能在红手指客户端登录
	AUTH_USER_MOBILE_UNBIND_FAILED(1102014,"用户未绑定手机号码,请绑定手机号码"),
	AUTH_USERNAME_IS_DISABLE(1102015,"此用户已经被冻结,请联系管理员"),
	AUTH_LOGINTYPE_IS_ERROR(1102016,"登录类型错误"),
	AUTH_LOGIN_FAILD_IS_ERROR(1102018,"请重新登录！"),
	AUTH_UUID_IS_NULL(1102019,"uuid不能为空"),
	AUTH_PASSWORD_IS_ERROR(1102020,"密码不正确"),
	AUTH_CHANNEL_CODE_IS_ERROR(1102021,"渠道编码非法"),
	AUTH_SIGN_IS_NULL(1102022,"加密参数不能为空"),
	AUTH_PROJECT_NAME(1102023,"项目名字不存在"),
	AUTH_SIGNUP_SERVERCODE_ERROR(1102024,"验证码失效，请重新获取"),
	AUTH_SIGNUP_PWD_REQSTPWD_ERROR(1102025,"两次输入密码不一致"),
	AUTH_SIGNUP_MOBILECODE_ERROR(1102026,"验证码不正确，请重新输入"),
	AUTH_SIGNUP_MOBILEPHONE_ERROR(1102027,"请输入正确手机号码"),
	AUTH_SIGNUP_PWD_ERROR(1102028,"密码格式不正确，密码须为6-16位字母和数字的组成"),
	AUTH_SIGNUP_MOBILE_ERROR(1102029,"验证参数错误，请重新注册"),
	AUTH_NO_PERMISSION(1102030,"当前客户端没有权限"),
	AUTH_PROBLEM_EXCEPTION(1102031,"AUTH校验参数失败"),


	/**  资源模块 RESOURCE (1103)**/
	RESOURCE_BANNER_SAVE_FAIL(1103001,"保存广告banner失败"),

	UPLOAD_FILE_IS_NULL_FAIL(1103002,"上传文件不能为空"),
	UPLOAD_FILE_SIZE_FAIL(1103003,"上传文件大小不一致"),
    UPLOAD_FILE_PATH_NULL(1103004,"下载文件URL不能为空"),
    UPLOAD_FILE_SIZE_ZERO(1103005,"文件大小不能为0"),

	RESOURCE_BANNER_UPDATE_FAIL(1103006,"更新启动页广告失败"),
	RESOURCE_BANNER_DELETE_FAIL(1103007,"删除启动页广告失败"),
	/**  支付模块(1104)**/

	ORDER_IS_NOT_EXIST(1104001,"订单不存在"),
	ORDER_PARAM_NOT_SAME(1104002,"订单金额不一致"),
	ORDER_NOT_PAY(1104003,"订单未支付完成"),
	ORDER_DIVIDE_INTO_FINISH(1104004,"订单已分成完成"),
	ORDER_DIVIDE_ING(1104005,"订单结算分成中,请稍后再试"),

	/**  资产模块(1105)**/
	ASSETS_COUPONTYPEID_IS_ERROR(1105001,"优惠卷类型找不到对应的优惠卷"),
	ASSETS_COUPON_IS_NO_GOODS(1105002,"优惠卷没有关联产品"),
	ASSETS_ACTIVATIONCODE_IS_OVER(1105003,"激活码已发放完，请联系客服"),
	ASSETS_COUPON_IS_OVER(1105004,"优惠券已发放完，请联系客服"),
	ASSETS_COUPON_BIND_ERROR(1105005,"绑定优惠券失败,请联系客服"),
	ASSETS_TYPE_ENUM_NOT_EXIT(1105006,"资产类型不存在"),

	/**  视频模块(1106) **/

	VIDEO_VIDEO_INFO_SAVE_FAIL(1106001,"保存视频信息失败"),
	VIDEO_CLASSIFY_SAVE_FAIL(1106002,"保存视频分类失败"),
	VIDEO_LABEL_SAVE_FAIL(1106003,"保存视频标签失败"),
	VIDEO_REPORT_SAVE_FAIL(1106004,"保存统计数据失败"),
	VIDEO_COMMENT_SAVE_FAIL(1106005,"发表评论失败"),
	VIDEO_PRAISE_SAVE_FAIL(1106006,"保存点赞失败"),
	VIDEO_PLAY_SAVE_FAIL(1106007,"保存播放历史失败"),
	VIDEO_STORE_SAVE_FAIL(1106008,"保存收藏失败"),
    VIDEO_VIDEO_INFO_NOT_EXIST(1106009,"保存收藏失败"),
	VIDEO_INFO_NOT_EXIST(1106010,"视频信息不存在"),
	VIDEO_VIDEO_STAR_SAVE_FAIL(1106011,"保存影员信息失败"),
	VIDEO_VIDEO_STAR_NOT_EXIST(1106012,"影员信息不存在"),
	VIDEO_VIDEO_STAR_SHIP_SAVE_FAIL(1106013,"保存影员与电影关系失败"),
	VIDEO_VIDEO_STAR_SHIP_NOT_EXIST(1106014,"影员与电影关系信息不存在"),
	VIDEO_VIDEO_CLASSIFY_SHIP_SAVE_FAIL(1106015,"保存电影与分类关系失败"),
	VIDEO_VIDEO_CLASSIFY_SHIP_NOT_EXIST(1106016,"电影与分类关系信息不存在"),
	VIDEO_USER_PLAY_FAIL(1106017,"播放历史用户关系不存在"),
	VIDEO_USER_PLAY_COUNT_FAIL(1106018,"您今日观影次数已用完"),
	VIDEO_REPORT_NOT_EXIST(1106019,"视频数据统计信息不存在"),
	VIDEO_USER_DOWNLOAD_COUNT_FAIL(1106020,"您今日下载次数已用完"),
	VIDEO_VIDEO_ID_NOT_EXIT(1106021,"视频id不存在"),
	VIDEO_CLASSIFY_ID_NOT_EXIST(1106022,"视频类别主键不存在"),
	VIDEO_SHARE_NOT_EXIST(1106023,"视频不存在分享信息"),
	VIDEO_SHARE_DELETE_FAIL(1106024,"删除强制视频分享失败"),
	VIDEO_SHARE_UPDATE_FAIL(1106025,"修改强制视频分享失败"),
    /**  订单模块(1107) **/
	ORDER_FAILED(1107001,"下单失败，请联系管理员"),
	ORDER_ALREADY_BUY_VIP(1107002,"您已购买过超级VIP商品"),
	ORDER_TOO_FREQUENT(1107003,"订单提交太频繁"),
	ORDER_IS_NULL(1107004,"订单不存在"),

	/**  活动模块(1108) **/
	ACTIVITY_COUPONTYPEID_IS_ERROR(1108001,"优惠卷类型找不到对应的优惠卷"),
	ACTIVITY_COUPON_IS_NO_GOODS(1108002,"优惠卷没有关联产品"),
	ACTIVITY_TASK_IS_ERROR(1108003,"此任务不存在或已失效"),
	ACTIVITY_TASK_GET_ERROR(1108004,"您领取该任务失败"),
	ACTIVITY_TASK_NO_GET(1108005,"您未领取该任务"),
	ACTIVITY_TASK_OVER_TODAY(1108006,"您今日已完成该任务"),
	ACTIVITY_TASK_OVER(1108007,"您已完成该任务"),
	ACTIVITY_TASK_GET_DUBBO(1108008,"任务重复领取"),
	ACTIVITY_TASK_FINISH_ERROR(1108009,"完成该任务失败,更新用户任务异常"),
	ACTIVITY_TASK_RECEIVE_AWARD(1108010,"已领取过任务奖励,不能重复领取"),
	ACTIVITY_TASK_AWARD_ERROR(1108011,"当前奖励已失效,请重新完成任务"),
	ACTIVITY_TASK_RECEIVE_AWARD_ERROR(1108012,"领取奖励失败"),
	ACTIVITY_IS_OVER(1108013,"活动已结束，请关注下次活动时间"),
	ACTIVITY_NOT_GOODS(1108014,"套餐已经被抢购一空，请关注下次活动时间"),
	ACTIVITY_INVITECODE_ERROR(1108015,"邀请码错误，请重新输入"),
	ACTIVITY_PASS_INTERFACE_LIST(1108016,"非法请求接口"),
	ACTIVITY_TASK_NOFINISH_RECEIVE_AWARD_ERROR(1108017,"任务未完成,无法领取奖励"),
	ACTIVITY_TASK_EVERYDAY_RECEIVE_AWARD_ERROR(1108018,"领取奖励失败,每日任务只能领取当日奖励"),

	/**  桌面模块(1109) **/

	/**  配置模块(1110) **/

	/**  MQ模块(1111) **/
	MQ_ROCKET_CONFIG_IS_NULL(1111001,"系统引入ROCKET_MQ但未配置相关信息"),
	MQ_ROCKET_CONSUMER_GROUPNAME_IS_NULL(1111002,"ROCKET_MQ的消费者分组名字配置不能为空"),
	MQ_ROCKET_TOPIC_NAME_IS_NULL(1111003,"ROCKET_MQ的TOPIC名字不能为空"),
	MQ_ROCKET_TAG_IS_NULL(1111004,"ROCKET_MQ的名字不能为空"),
	MQ_ROCKET_ADDRESS_IS_NULL(1111005,"ROCKET_MQ的服务器地址不能为空"),
	MQ_ROCKET_PRODUCER_GROUPNAME_IS_NULL(1111006,"ROCKET_MQ的生产者分组名字配置不能为空"),
	MQ_ROCKET_PRODUCER_SEND_ERROR(1111007,"ROCKET_MQ消息发送失败"),
	MQ_ROCKET_PRODUCER_NOT_FOUND(1111008,"ROCKET_MQ的生产者配置未找到"),
	MQ_ROCKET_TOPIC_NOT_FOUND(1111009,"ROCKET_MQ的TOPIC未找到"),
	MQ_ROCKET_TOPIC_SEND_ERROR(1111010,"消息发送失败"),

	/**  定时模块(1112) **/

	/**  第三方模块(1113) **/

	/**  公告模块(1114) **/
	NOTICE_NOTICE_INFO_SAVE_FAIL(1114001,"保存公告信息失败"),
	NOTICE_TITLE_ERROR(1114002,"公告标题请输入15字以内"),
	NOTICE_NOTICE_INFO_UPDATE_FAIL(1114003,"修改公告信息失败"),
	NOTICE_NOTICE_INFO_IS_SHOW(1114004,"公告已弹出,操作失败"),


	/** 二维码  **/
	QR_CODE_NOT_FOUNT(1115001,"Code信息不存在"),
	QR_CODE_USER_NOT_LOGIN(1115002,"二维码扫描，用户没登陆 ,直接跳到登陆页面"),
	QR_CODE_USER_IS_LOGIN(1115003,"您已经是会员了，无法获取本次福利"),
	QR_CODE_INVALID(1115004,"无法识别该二维码！"),
	QR_CODE_LOGIN_INVALID(1115005,"二维码已经失效，请重新刷新！"),

	/** 激活码 **/
	ACTIVATE_CODE_SAVE_FAIL(1116001,"激活码保存失败"),
	ACTIVATE_CODE_IDS_IS_NULL(1116002,"激活码ID不能为空"),

	SMS_ERROR_MSG(1117000,"系统繁忙，请稍后再试。"),

	/** **/
	BARRAGE_BANNER_INFO_SAVE_FAIL(1118001,"保存弹幕广告失败"),
	BARRAGE_BANNER_INFO_MODIFY_FAIL(1118002,"修改弹幕广告失败"),
	BARRAGE_BANNER_INFO_IS_NULL(1118003,"弹幕广告ID不能为空"),

	;

	private int code;
	private String msg;
	private static Map<String, IMsgEnumType> msgTypeMap = Maps.newHashMap();
	private static Map<Object, Integer> checkTypeMap = Maps.newHashMap();
	static {
		for(SysMsgEnumType msgType : values()) {
			msgTypeMap.put(msgType.name(), msgType);
			if(null != checkTypeMap.get(msgType.getCode())){
				throw new RuntimeException(" SysMsgEnumType is type double :" +msgType.getCode()+" and "+ msgType.getMsg() +"is exist ");
			}
			checkTypeMap.put(msgType.getCode(), 0);
		}
		checkTypeMap = null;
	}

	SysMsgEnumType(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}


	public String getMsg() {
		return msg;
	}

	public IMsgEnumType cloneMsg(String msg) {
        IMsgEnumType msgEnum  = MsgEnumType.clone(this,msg);
        return msgEnum;

	}

    public IMsgEnumType formatMsg(String msgContent) {
	    IMsgEnumType msgEnum = MsgEnumType.format(this,msgContent);
	    return msgEnum;
    }

	public static Map<String, IMsgEnumType> getSysMsgEnumTypeMap(){
	    return msgTypeMap;
    }



    public static class MsgEnumType implements IMsgEnumType {


        private int errCode = SYS_UNKOWNN_FAIL.code;
        private String errMsg = SYS_UNKOWNN_FAIL.msg;

        private MsgEnumType(int errCode, String errMsg) {
            this.errCode = errCode;
            this.errMsg = errMsg;
        }

        protected static  IMsgEnumType format(IMsgEnumType enumType, String... msgContent){
            String msg =  String.format(enumType.getMsg(), msgContent);
            return new MsgEnumType(enumType.getCode(),msg);

        }
        protected static  IMsgEnumType clone(IMsgEnumType enumType, String msgContent){
            return new MsgEnumType(enumType.getCode(),msgContent);

        }

        public int getCode() {
            return errCode;
        }
        public String getMsg() {
            return errMsg;
        }


    }


}
