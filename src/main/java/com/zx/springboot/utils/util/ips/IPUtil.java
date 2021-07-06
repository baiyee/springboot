package com.zx.springboot.utils.util.ips;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.zx.springboot.utils.core.string.StStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class IPUtil {
	private static Logger logger = LoggerFactory.getLogger(IPUtil.class);
	public static final String API_USER = "kugousns";
	public static final String API_PWD = "sns222abcks88";
	public static final String KG_PWD = "jewry69tUEK23D";
	public static final String KG_COOKIENAME = "KuGoo";
	public static final String LOGIN_COOKIE = "wired-key";
	
	/** 用于广告渠道统计*/
	public static final String CHANNEL_COOKIE = "KTV_CHANNEL";
	/** 用于旧首页直接访问的统计*/
	public static final String CHANNEL_STAT_COOKIE = "KTV_CHANNEL_STAT";
	/** 用于注册方式统计*/
	public static final String OPEN_COOKIE = "KTV_OPEN";
	/** 用于新首页标示*/
	public static final String OLD_NEW_INDEX_COOKIE = "ktv-index";
	/** 用于固定文字直接游客进入标示*/
	public static final String GUEST_ENTER_COOKIE = "ktv-guest";
	
	private static SecretKey KUGOU_KEY;
	private static SecretKey KUGOU_SMS_KEY;
	private final static IvParameterSpec KUGOU_IV = new IvParameterSpec(new byte[] { 99, 22, 22, 33, 46, 33, 22, 44 });
	private final static IvParameterSpec KUGOU_SMS_IV = new IvParameterSpec(new byte[] { 11, 22, 22, 33, 46, 33, 22, 88 });
	static {
		try {
			final SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
			KUGOU_KEY = factory.generateSecret(new DESKeySpec(new byte[] { 21, 21, 21, 55, 76, 60, 33, 22 }));
			KUGOU_SMS_KEY = factory.generateSecret(new DESKeySpec(new byte[] { 16, 48, 73, 42, 59, 81, 34, 55 }));
			
		} catch (final Exception ex) {
			logger.error("", ex);
		}
	}


	private static final ObjectMapper mapper = new ObjectMapper();
	
	public static String toJson(Object obj) {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}
	
	
	private IPUtil() {
	}
	
	public static String decryptDES(final String str) {
		try {
			final Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
			c.init(Cipher.DECRYPT_MODE, KUGOU_KEY, KUGOU_IV);
			return new String(c.doFinal(StStringUtils.hexToByteArray(str)), Charsets.UTF_8);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String encryptDES(final String str) {
		try {
			final Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, KUGOU_KEY, KUGOU_IV);
			return StStringUtils.toHexString(c.doFinal(str.getBytes(Charsets.UTF_8)));
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String encryptSMSDES(final String str) {
		try {
			final Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
			c.init(Cipher.ENCRYPT_MODE, KUGOU_SMS_KEY, KUGOU_SMS_IV);
			return StStringUtils.toHexString(c.doFinal(str.getBytes(Charsets.UTF_8)));
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static void setChannelCookie(final HttpServletResponse res, final Integer channelId) {
		Cookie cookie_channel = new Cookie(CHANNEL_COOKIE, channelId.toString());
		cookie_channel.setDomain("kugou.com");
		cookie_channel.setPath("/");
		cookie_channel.setMaxAge(2 * 60 * 60);//设置两个小时失效
		res.addCookie(cookie_channel);
	}
	
	public static void setOpenCookie(final HttpServletResponse res, final Integer channelId) {
		Cookie cookie = new Cookie(OPEN_COOKIE, channelId.toString());
		cookie.setDomain("kugou.com");
		cookie.setPath("/");
		res.addCookie(cookie);
	}
	
	public static void setChannelStatCookie(final HttpServletResponse res, final Integer channelId) {
		Cookie cookie_channel = new Cookie(CHANNEL_STAT_COOKIE, channelId.toString());
		cookie_channel.setDomain("kugou.com");
		cookie_channel.setPath("/");
		res.addCookie(cookie_channel);
	}
	
	public static void setGuestEnterCookie(final HttpServletResponse res, final Integer value) {
		Cookie cookie_channel = new Cookie(GUEST_ENTER_COOKIE, value.toString());
		cookie_channel.setDomain("kugou.com");
		cookie_channel.setPath("/");
		cookie_channel.setMaxAge(2 * 60 * 60);//设置两个小时失效
		res.addCookie(cookie_channel);
	}

	public static void setCookie(final HttpServletResponse res,final String name, final Integer value) {
		Cookie cookie = new Cookie(name, value.toString());
		cookie.setDomain("kugou.com");
		cookie.setPath("/");
		res.addCookie(cookie);
	}
	
	public static String remoteIp(final HttpServletRequest request) {
		String ip = null;

		final String xff = request.getHeader("X-Forwarded-For");
		if (xff != null) {
			for (final String s : Splitter.on(',').split(xff)) {
				if (ip == null) {
					ip = s;
					break;
				}
			}
		}
		if (Strings.isNullOrEmpty(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
//	
//	private static DateTime weekStart = new DateTime(2010, 1, 4, 0, 0, 0, 0);
//	
//	/**
//	 * @month 1 一月 2 二月
//	 * @return 返回从2010年1月4日(星期一)起的周数
//	 */
//	public static int getWeek(int year, int month, int day) {
//		DateTime date = new DateTime(year, month, day, 0, 0, 0, 0);
//		return Weeks.weeksBetween(weekStart, date).getWeeks();
//	}
//	
	
	/**
	 * 解析json
	 * @param json 格式类似 [{},{}]
	 * @return List
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> jsonToList( String json ){
		try {
			return mapper.readValue(json, List.class);
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}
	
	
	/**
	 * 解析json
	 * @param json 格式类似 {"":""}
	 * @return Map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> jsonToMap( String json ){
		try {
			return mapper.readValue(json, Map.class);
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}
	

	public static String unicodeToUtf8(String str) {
		char aChar;
		int len = str.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = str.charAt(x++);
			if (aChar == '\\') {
				aChar = str.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = str.charAt(x++);
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
							throw new IllegalArgumentException(
									"Malformed   \\uxxxx   encoding.");
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}
	
	public static final String KEY_SPLITER = "_";
	public static final String KEY_SPLITER_CROSS = "-";
	/** 用于生成唯一的nsq判断的key,格式:kugouId_millis */
	public static String nsqKey(long kugouId) {
		return kugouId + KEY_SPLITER + System.currentTimeMillis();
	}
	
	/**
	 * 把ip转为10进制长整型
	 * 
	 * @author ruan 2013-1-21
	 * @param strip
	 * @return
	 */
	public final static long ip2Long(String strip) {
		String[] ipArr = strip.split("\\.");
		return (Long.parseLong(ipArr[0]) << 24)
				+ (Long.parseLong(ipArr[1]) << 16)
				+ (Long.parseLong(ipArr[2]) << 8) 
				+ Long.parseLong(ipArr[3]);
	}

	/**
	 * 把10进制长整型转为ip
	 * 
	 * @author ruan 2013-1-21
	 * @param longip
	 * @return
	 */
	public final static String long2Ip(long longip) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(longip >>> 24));
		sb.append(".");
		sb.append(String.valueOf((longip & 0x00ffffff) >>> 16));
		sb.append(".");
		sb.append(String.valueOf((longip & 0x0000ffff) >>> 8));
		sb.append(".");
		sb.append(String.valueOf(longip & 0x000000ff));
		return sb.toString();
	}


}
