package com.zx.springboot.global.enums;

public enum SocketCommandEnum {

	SEND_GIFT(601),	//移动直播房间送礼
    INVITE_NOTICE(624),//移动直播房间分享数公告
	ROOM_STATUS(1400),	//直播间房间状态
	MFX_LIVE_STARS_UPDATE(1600),//移动直播场次星光值更新
	REQUEST_PLAY_SONG(1703),//点歌
	DEAL_PLAY_SONG(1704),//处理点歌 同意或者拒绝
	CURRS_STATUS(1702),	//移动直播开唱结束
	SHARE_BROADCAST(1701),//主播开播分享，断流通知
	STAR_CENSORED_STATUS(1705);	//全民开播审核状态

	private int value;
	
	SocketCommandEnum(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
