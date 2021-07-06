package com.zx.springboot.global.enums;

/**
 * @ClassName:
 * @Description:
 * @Author liulu
 * @Date 2018/5/29 10:49
 * @Copyright: (c) 2018 gc by https://www.gc.com.cn/
 * @Version : 1.0.0
 */
public enum SysDefineTypeEnum {
    //绑定状态
    NO_BIND(0, "未绑定"), BIND(1, "已绑定"),
    //设备等级
    FREE(0, "普通"), VIP(1, "vip"), TASTE(2, "体验"), SVIP(3, "超级VIP"), GAME(4, "游戏试玩"), GVIP(5, "GVIP"),

    undo(0, "未做"), done(1, "已做"),

    //会员类型
    ORDINARY(1, "个人会员"), STUDIO(2, "工作室会员"),

    //申请普通，体验设备状态，第三方登录时，一台手机只能绑定一次体验设备，如第三登录时，该手机下已绑定过体验设备，则设置为2
    FIRST(0,"首次"),NOT_FIRST(1,"再次"),THIRD_NOT_FIRST(2,"再次"),

    //客户端类型,电脑，Android手机，iPhone手机，官网，重复发送,工作室
    ANDROID(1,"android"),IOS(2,"ios"),PC(3,"win"),WIN_ST(4,"win_st"),websit(5,"websit"),RESEND(6,"resend"),

    //上传状态˙
    UPLOAD(0,"已提交审核"),UPLOAD_SUCCESS(1,"上传成功"),UPLOAD_FAILED(2,"上传失败"),UPLOAD_PROGRESS(4,"上传中"),
    INSTALL_SUCCESS(5,"安装成功"),INSTALL_FAIL(6,"安装失败"),

    //安装类型
    NEW_INSTALL(1,"首次安装"),UPDATE_INSTALL(2,"更新安装"),RE_INSTALL(3,"卸载安装"),

    //优惠卷操作类型
    COUPON_BATCH_ADD(1,"批量新增"),COUPON_UPDATE(2,"修改"),COUPON_ENABLE(3,"禁用"),COUPON_START(4,"启用"),
    COUPON_DELETE(5,"删除"),COUPON_BATCH_UPDATE(6,"批量修改"),COUPON_BIND(7,"绑定"),COUPON_USE(8,"使用"),

    //设备池类型
    MAIN_POOL(1,"主营设备池"),CLOUD_POOL(2,"云控设备池"),DISK_POOL(3,"网络云存储设备池"),MICRO_BUSINESS_POOL(4,"微商设备池"),POJIE_POOL(6,"破解设备池"),APPSTORE_POOL(7,"appstore设备池"),

    //奖励类型
    AWARD_RBC(1,"红豆"),AWARD_SCORE(2,"积分"),AWARD_ACTIVATION_CODE(3,"激活码"),AWARD_COUPON(4,"优惠券"),AWARD_LOTTERY(5,"抽奖次数"),

    //用户账号类型：qq是openid，微信是unionid
    USER_ACCOUNT_EMAIL(1,"邮箱"),USER_ACCOUNT_PHONE(2,"手机号码"),USER_ACCOUNT_QQ(3,"QQ"),USER_ACCOUNT_WEIXIN(4,"微信"),

    //有效，无效
    VALID(1,"有效"),INVALID(0,"无效"),


    MAINT_STATUS_NORMAL(0,"正常"),MAINT_STATUS_MAINT(1,"维护"),

    //是，否
    STATUS_YES(1,"是"),STATUS_NO(0,"否"),

    //是，否
    ENABLE_STATUS_DISABLE(0,"禁用"),ENABLE_STATUS_ENABLE(1,"启用"),ENABLE_STATUS_RELIEVE(2,"解绑禁用"),ENABLE_STATUS_EXPERIENCE_RELIEVE(4,"体验设备解绑禁用"),

    //用户任务状态
    USER_TASK_RECEIVE(1,"已接取"),USER_TASK_FINISH(2,"完成"),USER_TASK_AWARD(3,"领取奖励"),

    TASK_RECORD_RECEIVE(1,"未完成"),TASK_RECORD_FINISH(2,"完成"),TASK_RECORD_AWARD(3,"领取奖励"),

    //任务类型:1、游戏达到xx等级2、游戏单次充值3、游戏累计充值
    TASK_CONDITION_LEVEL(1,"等级"),TASK_CONDITION_RECHARGE(2,"单次充值"),TASK_CONDITION_TOTAL_RECHARGE(3,"累计充值"),

    //设备类型
    MAINNPAD(1,"主营设备"),GAMEPAD(2,"游戏设备"),GVIPPAD(3,"GVIP设备"),SVIPPAD(4,"SVIP设备"),

    // 设备授权码
    GRANT_CODE_UNUSE(0, "未使用"), GRANT_CODE_USED(1, "已使用"),
    GRANT_MODE_ACCOUNT(1, "指定账号"), GRANT_MODE_CODE(2, "授权码"),

    RECOVERY_STATUS_ENABLE(1,"不回收"),RECOVERY_STATUS_DISABLE(0,"回收"),

    PAD_STATUS_OFFLINE(0,"离线"),PAD_STATUS_ONLINE(1,"在线"),PAD_STATUS_CONTROL(2,"控制"),

    USER_PAD_STATUS_OFFLINE(0,"离线"),USER_PAD_STATUS_ONLINE(1,"在线"),

    FAULT_STATUS_NORMAL(0,"正常"),USER_PAD_STATUS_FAULT(1,"故障"),

    ACTIVE_STATUS_FREEZE(0,"冻结"),ACTIVE_STATUS_ACTIVE(1,"活跃"),

    VM_STATUS_OFFLINE(0,"离线"),VM_STATUS_ONLINE(1,"在线"),

    DEVICE_STATUS_OFFLINE(0,"离线"), DEVICE_STATUS_ONLINE(1,"在线"),

    ON(1,"开启"),OFF(0,"关闭"),

    //svip退款状态
    BACK(-1,"申请退回"),CANCEL(0,"取消"),USER_APPLY(1,"用户申请退款"),ACCEPT(2,"受理"),VERIFY(3,"审核"),REFUNDS(4,"退款"),SYSTEM_APPLY(5,"系统发起退款"),

    //设备加时日志类型
    RBC_RECHARGE(1,"红豆续费"),SHARE_RECHARGE(2,"分享加时"),

    //礼包类型
    GIFT_TYPE_GAME(0,"游戏道具礼包"), GIFT_TYPE_ACTIVATION_CODE(1,"激活码"), GIFT_TYPE_COUPON(2,"优惠券"),

    //礼包来源
    GIFT_SOURCE_TASK(1,"红手指任务"),GIFT_SOURCE_ACTIVITY(2,"充值活动"),GIFT_SOURCE_LOTTER(3,"抽奖活动"),GIFT_SOURCE_TREASURE(4,"夺宝商城"),GIFT_SOURCE_INVITEE_COUPON_ACTIVITY(5,"邀请登录赠送活动"),

    //消息提醒类型
    NOTIFY_PART(0,"发送少量用户"),NOTIFY_TOTAL(1,"发送全部用户"),NOTIFY_PAD_EXCHANGE(9,"设备更换"),NOTIFY_PAD_GRANT(12,"获取设备通知"),NOTIFY_PAD_RENEWAL(13,"云手机更换通知"),

    //是否自动安装
    AUTO_INSTALL(1,"自动安装"),NOT_AUTO_INSTALL(0,"不自动安装"),

    //存储类型 ,网络存储
    STORAGE_TYPE_LOCAL_STORAGE(0,"本地存储"), STORAGE_TYPE_SHEEPDOG1_0(1,"sheepdog1.0"),

    //第三方登录类型
    THIRD_LOGIN_BY_WEIXIN(1,"微信登录"),THIRD_LOGIN_BY_QQ(2,"qq登录"),THIRD_LOGIN_BY_WEIBO(3,"微博登录"),

    //验证码类型
    IMAGE_TYPE_LOGIN(1,"登录验证码"),IMAGE_TYPE_REGISTE(2,"  注册验证码"),IMAGE_TYPE_BIND_FREEPAD(3,"绑定普通设备"),

    //奖励状态
    AWARD_YES(1,"成功"),AWARD_NO(0,"失败"),

    //是否弹出
    POP_STATUS_YES(1,"弹出"),POP_STATUS_NO(0,"不弹出"),

    //是否全文字
    IS_TOTAL_WORDS_YES(1,"是"),IS_TOTAL_WORDS_NO(0,"否"),

    //优惠劵是否使用
    COUPON_STATUS_YES(1,"是"),COUPON_STATUS_NO(0,"否"),

    //优惠劵是否使用
    TASK_START(1,"开始"), TASK_RUN(2,"进行"), TASK_END(3,"结束"),

    //优惠劵是否使用
    TASK_RESULT_STATUS_YES(1,"成功"),TASK_RESULT_STATUS_NO(2,"失败"),

    RECORD_NO_FINISH(1,"未完成"),RECORD_FINISH(2,"已完成"),RECORD_RECEIVE(3,"已领取奖励"),

    USERTASK_STATUS_RECEIVE(1,"已接取"), USERTASK_STATUS_FINISH(2,"已完成"), USERTASK_STATUS_AWARD(3,"已领取奖励"),

    HANDLE_RETURNED(-1,"退款申请被退回"), HANDLE_CANCEL(0,"退款申被退回"),HANDLE_APPLY_REFUND(1,"用户申请退款"),HANDLE_REFUND_ACCEPT(0,"退款已受理"),HANDLE_REVIEW(0,"资料审核中"),
                        HANDLE_REFUND(0,"已退款"),HANDLE_SYS_APPLY_REFUND(0,"系统发起退款申请"),HANDLE_ARCHIVE(0,"归档"),

    READ_STATUS_YES(1,"已读"), READ_STATUS_NO(0,"未读"),

    AD_STATUS_YES(1,"启用"), AD_STATUS_NO(0,"禁用"),

    GRANT_TYPE_ADMIN(0,"管理员授权"),GRANT_TYPE_USER(1,"用户授权"),

    GRANT_STATUS_ZERO(0,"未授权"),GRANT_STATUS_ONE(1,"授权出去的设备"),GRANT_STATUS_TWO(2,"被授权的设备"),

    PAY_TYPE_ALIPAY(0,"支付宝"),PAY_TYPE_UNIONPAY_PAY(1,"银联"),PAY_TYPE_TENPAY(2,"微信"),PAY_TYPE_BILL(3,"快钱"),PAY_TYPE_RF_WALLET(4,"钱包"),

    PAD_MAINT_NORMAL(0,"正常"),PAD_MAINT_MAINT(1,"维护"),
    ;
    // 成员变量
    private int index;
    private String name;

    // 构造方法
    private SysDefineTypeEnum(int index, String name) {
        this.name = name;
        this.index = index;
    }
    // 普通方法
//    public static String getName(int index) {
//        for (SysDefineEnumType c : SysDefineEnumType.values()) {
//            if (c.getIndex() == index) {
//                return c.name;
//            }
//        }
//        return null;
//    }
    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getIndexStr() {
        return String.valueOf(index);
    }

}
