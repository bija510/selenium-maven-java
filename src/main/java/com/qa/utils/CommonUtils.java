package com.qa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This utility methods can be used across different :- 
 * @see a projects or test cases, 
 * @see a without necessarily being selenium-specific. 
 */
public class CommonUtils {

	public static String getMonthAndDate() {
		String pattern = "yyyy-MMdd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		String monthAndDate = date.substring(5);
		return monthAndDate;
	}

	public static String get6DigitTimeStamp() {
		String pattern2 = "HHmmss";
		SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(pattern2);
		String digit6TimeStamp = simpleDateFormat2.format(new Date());
		return digit6TimeStamp;
	}

}
