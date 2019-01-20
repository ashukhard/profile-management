package com.ashukhard.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Util {

	private static SimpleDateFormat formatter = 
			new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

	public static Date getDate(String date) {
		try {
			return formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getStringDate(Date date) {
		return formatter.format(date);
	}
}
