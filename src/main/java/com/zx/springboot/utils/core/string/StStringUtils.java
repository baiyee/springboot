package com.zx.springboot.utils.core.string;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StStringUtils extends StringUtils {
	private static final Random RANDOM = new Random();
	private static final char SEPARATOR = '_';
	private static final String CHARSET_NAME = "UTF-8";

	private static Logger logger = LoggerFactory.getLogger(StStringUtils.class);
	
	public static byte[] hexToByteArray(final String s) {
		final byte[] ret = new byte[s.length() / 2];
		for (int i = 0; i < ret.length; i++) {
			final int begin = i * 2;
			ret[i] = (byte) Integer.parseInt(s.substring(begin, begin + 2), 16);
		}
		return ret;
	}

	public static boolean isSameDay(final long lastTime) {
		final Calendar now = Calendar.getInstance();
		final Calendar last = Calendar.getInstance();
		last.setTimeInMillis(lastTime);

		now.clear(Calendar.MILLISECOND);
		now.clear(Calendar.SECOND);
		now.clear(Calendar.MINUTE);
		now.set(Calendar.HOUR_OF_DAY, 0);

		last.clear(Calendar.MILLISECOND);
		last.clear(Calendar.SECOND);
		last.clear(Calendar.MINUTE);
		last.set(Calendar.HOUR_OF_DAY, 0);

		return now.equals(last);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters
	 * specified.
	 * </p>
	 * 
	 * <p>
	 * Characters will be chosen from the set of all characters.
	 * </p>
	 * 
	 * @param count
	 *            the length of random string to create
	 * @return the random string
	 */
	public static String random(final int count) {
		return random(count, false, false);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters
	 * specified.
	 * </p>
	 * 
	 * <p>
	 * Characters will be chosen from the set of alpha-numeric characters as
	 * indicated by the arguments.
	 * </p>
	 * 
	 * @param count
	 *            the length of random string to create
	 * @param letters
	 *            if <code>true</code>, generated string will include alphabetic
	 *            characters
	 * @param numbers
	 *            if <code>true</code>, generated string will include numeric
	 *            characters
	 * @return the random string
	 */
	public static String random(final int count, final boolean letters, final boolean numbers) {
		return random(count, 0, 0, letters, numbers);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters
	 * specified.
	 * </p>
	 * 
	 * <p>
	 * Characters will be chosen from the set of alpha-numeric characters as
	 * indicated by the arguments.
	 * </p>
	 * 
	 * @param count
	 *            the length of random string to create
	 * @param start
	 *            the position in set of chars to start at
	 * @param end
	 *            the position in set of chars to end before
	 * @param letters
	 *            if <code>true</code>, generated string will include alphabetic
	 *            characters
	 * @param numbers
	 *            if <code>true</code>, generated string will include numeric
	 *            characters
	 * @return the random string
	 */
	public static String random(final int count, final int start, final int end, final boolean letters, final boolean numbers) {
		return random(count, start, end, letters, numbers, null, RANDOM);
	}

	/**
	 * <p>
	 * Creates a random string based on a variety of options, using supplied
	 * source of randomness.
	 * </p>
	 * 
	 * <p>
	 * If start and end are both <code>0</code>, start and end are set to
	 * <code>' '</code> and <code>'z'</code>, the ASCII printable characters,
	 * will be used, unless letters and numbers are both <code>false</code>, in
	 * which case, start and end are set to <code>0</code> and
	 * <code>Integer.MAX_VALUE</code>.
	 * 
	 * <p>
	 * If set is not <code>null</code>, characters between start and end are
	 * chosen.
	 * </p>
	 * 
	 * <p>
	 * This method accepts a user-supplied {@link Random} instance to use as a
	 * source of randomness. By seeding a single {@link Random} instance with a
	 * fixed seed and using it for each call, the same random sequence of
	 * strings can be generated repeatedly and predictably.
	 * </p>
	 * 
	 * @param count
	 *            the length of random string to create
	 * @param start
	 *            the position in set of chars to start at
	 * @param end
	 *            the position in set of chars to end before
	 * @param letters
	 *            only allow letters?
	 * @param numbers
	 *            only allow numbers?
	 * @param chars
	 *            the set of chars to choose randoms from. If <code>null</code>,
	 *            then it will use the set of all chars.
	 * @param random
	 *            a source of randomness.
	 * @return the random string
	 * @throws ArrayIndexOutOfBoundsException
	 *             if there are not <code>(end - start) + 1</code> characters in
	 *             the set array.
	 * @throws IllegalArgumentException
	 *             if <code>count</code> &lt; 0.
	 * @since 2.0
	 */
	public static String random(int count, int start, int end, final boolean letters, final boolean numbers, final char[] chars, final Random random) {
		if (count == 0) {
			return "";
		} else if (count < 0) {
			throw new IllegalArgumentException("Requested random string length " + count + " is less than 0.");
		}
		if ((start == 0) && (end == 0)) {
			end = 'z' + 1;
			start = ' ';
			if (!letters && !numbers) {
				start = 0;
				end = Integer.MAX_VALUE;
			}
		}

		final char[] buffer = new char[count];
		final int gap = end - start;

		while (count-- != 0) {
			char ch;
			if (chars == null) {
				ch = (char) (random.nextInt(gap) + start);
			} else {
				ch = chars[random.nextInt(gap) + start];
			}
			if ((letters && Character.isLetter(ch)) || (numbers && Character.isDigit(ch)) || (!letters && !numbers)) {
				if ((ch >= 56320) && (ch <= 57343)) {
					if (count == 0) {
						count++;
					} else {
						// low surrogate, insert high surrogate after putting it
						// in
						buffer[count] = ch;
						count--;
						buffer[count] = (char) (55296 + random.nextInt(128));
					}
				} else if ((ch >= 55296) && (ch <= 56191)) {
					if (count == 0) {
						count++;
					} else {
						// high surrogate, insert low surrogate before putting
						// it in
						buffer[count] = (char) (56320 + random.nextInt(128));
						count--;
						buffer[count] = ch;
					}
				} else if ((ch >= 56192) && (ch <= 56319)) {
					// private high surrogate, no effing clue, so skip it
					count++;
				} else {
					buffer[count] = ch;
				}
			} else {
				count++;
			}
		}
		return new String(buffer);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters
	 * specified.
	 * </p>
	 * 
	 * <p>
	 * Characters will be chosen from the set of alpha-numeric characters.
	 * </p>
	 * 
	 * @param count
	 *            the length of random string to create
	 * @return the random string
	 */
	public static String randomAlphanumeric(final int count) {
		return random(count, true, true);
	}

	/**
	 * <p>
	 * Creates a random string whose length is the number of characters
	 * specified.
	 * </p>
	 * 
	 * <p>
	 * Characters will be chosen from the set of characters whose ASCII value is
	 * between <code>32</code> and <code>126</code> (inclusive).
	 * </p>
	 * 
	 * @param count
	 *            the length of random string to create
	 * @return the random string
	 */
	public static String randomAscii(final int count) {
		return random(count, 32, 127, false, false);
	}

	public static String randomNumeric(final int count) {
		return random(count, false, true);
	}

	/**
	 * convert byte array to hexadecimal string
	 */
	public static String toHexString(final byte[] bytes) {
		final StringBuilder buf = new StringBuilder(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			buf.append(String.format("%02X", bytes[i]));
		}
		return buf.toString();
	}

	private StStringUtils() {

	}


	/**
	 * 判断该字符串是否为ip
	 * @param ip
	 * @return
	 */
	public final static boolean isIp(String ip) {
		return ip.trim().matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
	}

	/**
	 * 检查字符串是否为一个数字
	 * @author ruan
	 * @param value
	 * @return
	 */
	public final static boolean isNumber(Object value) {
		if (value == null) {
			return false;
		}
		return value.toString().trim().matches("\\-?[0-9]+(\\.[0-9]+)?");
	}

	/**
	 * 把异常信息打印
	 * 
	 * @author ruan 2013-8-9
	 * @param e
	 * @return
	 */
	public final static String getStackTrace(Throwable e) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String ret = sw.toString();
		pw.close();
		try {
			sw.close();
		} catch (IOException e1) {
		}
		return ret == null ? "" : ret;
	}
	
	/**
	 * 针对paramMap decode
	 * @throws UnsupportedEncodingException 
	 */
	public static Map<String, String[]> decodeParamMap(Map<String, String[]> param){
		Map<String,String[]> map = Maps.newHashMap();
		Set<Entry<String, String[]>> set = param.entrySet();
		for(Entry<String, String[]> entry:set){
			String key = entry.getKey();
			String[] arrValue = entry.getValue();
			if(arrValue == null || arrValue.length == 0){
				map.put(key, arrValue);
				continue;
			}
			String[] newArr = new String[arrValue.length];
			for(int i =0 ;i <  arrValue.length; i++){
				try {
					newArr[i] = URLDecoder.decode(arrValue[i],"UTF-8");
				} catch (UnsupportedEncodingException e) {
					logger.warn("urldecode error, value:{}", arrValue[i]);
				}
			}
			map.put(key, newArr);
		}
		return map;
	}

	/**
	 * 生成sql占位符
	 * @param length
	 * @return
	 */
	public static String generateSQLPlaceholders(int length){
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if(i > 0) builder.append(",");
			builder.append("?");
		}
		return builder.toString();
	}

	/**
	 * 判断是否为乱码
	 * @param strName
	 * @return
	 */
	public static boolean isMessyCode(String strName) {
		try {
			Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
			Matcher m = p.matcher(strName);
			String after = m.replaceAll("");
			String temp = after.replaceAll("\\p{P}", "");
			char[] ch = temp.trim().toCharArray();

			int length = (ch != null) ? ch.length : 0;
			for (int i = 0; i < length; i++) {
				char c = ch[i];
				if (!Character.isLetterOrDigit(c)) {
					String str = "" + ch[i];
					if (!str.matches("[\u4e00-\u9fa5]+")) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	/**
	 * 首字母转大写
	 * @param name
	 * @return
	 */
	public static String captureFirstUpperName(String name) {
		char[] cs=name.toCharArray();
		if(cs[0]<97 || cs[0]>122){
			return name;
		}
		cs[0]-=32;
		return String.valueOf(cs);

	}

	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val){
		if (val == null){
			return 0D;
		}
		try {
			return Double.valueOf(trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val){
		return toDouble(val).floatValue();
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val){
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val){
		return toLong(val).intValue();
	}



	public static String firstCharUpper(String s){
		if (s == null) {
			return null;
		}
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld"
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCamelCase(String s) {
		if (s == null) {
			return null;
		}

		s = s.toLowerCase();

		StringBuilder sb = new StringBuilder(s.length());
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == SEPARATOR) {
				upperCase = true;
			} else if (upperCase) {
				sb.append(Character.toUpperCase(c));
				upperCase = false;
			} else {
				sb.append(c);
			}
		}

		return sb.toString();
	}

	/**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld"
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toCapitalizeCamelCase(String s) {
		if (s == null) {
			return null;
		}
		s = toCamelCase(s);
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	/**
	 * 驼峰命名法工具
	 * @return
	 * 		toCamelCase("hello_world") == "helloWorld"
	 * 		toCapitalizeCamelCase("hello_world") == "HelloWorld"
	 * 		toUnderScoreCase("helloWorld") = "hello_world"
	 */
	public static String toUnderScoreCase(String s) {
		if (s == null) {
			return null;
		}

		StringBuilder sb = new StringBuilder();
		boolean upperCase = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			boolean nextUpperCase = true;

			if (i < (s.length() - 1)) {
				nextUpperCase = Character.isUpperCase(s.charAt(i + 1));
			}

			if ((i > 0) && Character.isUpperCase(c)) {
				if (!upperCase || !nextUpperCase) {
					sb.append(SEPARATOR);
				}
				upperCase = true;
			} else {
				upperCase = false;
			}

			sb.append(Character.toLowerCase(c));
		}

		return sb.toString();
	}

	/**
	 * 如果不为空，则设置值
	 * @param target
	 * @param source
	 */
	public static void setValueIfNotBlank(String target, String source) {
		if (isNotBlank(source)){
			target = source;
		}
	}

	/**
	 * 转换为JS获取对象值，生成三目运算返回结果
	 * @param objectString 对象串
	 *   例如：row.user.id
	 *   返回：!row?'':!row.user?'':!row.user.id?'':row.user.id
	 */
	public static String jsGetVal(String objectString){
		StringBuilder result = new StringBuilder();
		StringBuilder val = new StringBuilder();
		String[] vals = split(objectString, ".");
		for (int i=0; i<vals.length; i++){
			val.append("." + vals[i]);
			result.append("!"+(val.substring(1))+"?'':");
		}
		result.append(val.substring(1));
		return result.toString();
	}




	/**
	 * 字符串数组转逗号分隔字符串
	 * @param ids
	 * @return
	 */
	public static String arrayToString(String[] ids){
		if(ids==null || ids.length <= 0) return "";
		return Joiner.on(",").join(ids);
	}



	//随机生成字符串
	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789"; // 生成字符串从此序列中取
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/***
	 * 生成随机字符串，用户优惠劵
	 * @return
	 */
	public static String generateStr() {
		String[] beforeShuffle = new String[] {"0", "1", "2", "3", "4", "5", "6", "7",
				"8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "J",
				"K", "L", "M", "N", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" , "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "m", "n", "p", "q", "r", "s", "t", "u", "v",
				"w", "x", "y", "z" };
		List list = Arrays.asList(beforeShuffle);
		Collections.shuffle(list);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		String afterShuffle = sb.toString();
		String result = afterShuffle.substring(5, 13);
		return result;
	}

	public static StringBuilder toStringBuilder(Object ... params){
		StringBuilder sb = new StringBuilder();
		if(params == null || params.length == 0){
			return sb;
		}
		for (int i = 0,j = params.length - 1; i < j ; i++  ) {
			sb.append(params[i]).append(Splitable.ATTRIBUTE_SPLIT);
		}
		sb.append(params[params.length -1]);
		return sb;

	}
}
