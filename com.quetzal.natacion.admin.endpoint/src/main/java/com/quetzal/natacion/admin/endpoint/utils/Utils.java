/**
 * Classname: Utils.java
 * Author: Diego Hernandez Cote
 * Date: 07 de feb. 2025
 * quetzal developer
 */
package com.quetzal.natacion.admin.endpoint.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;

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

}
