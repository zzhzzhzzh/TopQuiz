package com.topQuiz.util;

/**
 * String tool
 * @author jady
 *
 */
public class StringUtil {

	/**
	 * check whether the string is empty
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * check whether the string is not empty
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str != null && !"".equals(str.trim())) {
			return true;
		}
		return false;
	}
}
