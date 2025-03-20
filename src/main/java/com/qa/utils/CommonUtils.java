package com.qa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class provides globally reusable methods.
 */
public class CommonUtils {

	public static String getMonthAndDate() {
		String pattern = "yyyy-MMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		String monthAndDate = date.substring(5);
		return monthAndDate;
	}
	/**
	 * <ul>
	 * <li> Format: </li>
	 * <li> hh – Hour in 12-hour format (01 to 12)  </li>
	 * <li> mm – Minutes (00 to 59)  </li>
	 * <li> ss – Seconds (00 to 59)  </li>
	 * <li> SSS – Milliseconds (000 to 999)  </li>
	 * <li> a – AM or PM  </li>
	 * </ul>
	 * @return current timestamp in the format "hh-mm-ss-SSS"
	 */
	public static String getTimeStamp() {
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh-mm-ss-SSSS");
		String digitTimeStamp = simpleDateFormat2.format(new Date());
		return digitTimeStamp;
	}

}
