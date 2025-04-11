/**
 * Classname: Utils.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.restaurant.admin.endpoint.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

	public static boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}

	public static boolean isNullOrEmpty(Object[] o) {
		return o == null || o.length == 0;
	}

	public static boolean isNullOrEmpty(Collection<?> c) {
		return c == null || c.isEmpty();
	}

	public static boolean isNullOrEmpty(Map<?, ?> m) {
		return m == null || m.isEmpty();
	}

	public static boolean isNullOrEmpty(Object o) {
		return o == null;
	}

	public static boolean isNullOrLessThan1(Integer i) {
		return i == null || i < 1;
	}

	public static String timestampToString(Timestamp timestamp) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return sdf.format(timestamp);
	}

	public static boolean isEmail(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
		Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
	}

	public static boolean isPhoneNumber(String phone) {
		if (phone.length() != 10) {
			return false;
		}
		
		return phone.matches("\\d+");
	}

	public static boolean isDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false; 
        }
	}

	public static LocalDateTime stringToLocalDateTime(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			java.time.LocalDate localDate = java.time.LocalDate.parse(date, formatter);
			return localDate.atStartOfDay();
		} catch (DateTimeParseException e) {
			return null; 
		}
	}

}
