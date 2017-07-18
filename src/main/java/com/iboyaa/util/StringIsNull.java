package com.iboyaa.util;

public class StringIsNull {

	public StringIsNull() {
		// TODO Auto-generated constructor stub
	}

	public static Boolean isNULL(String str) {

		return str == null || str.trim().length() == 0;
	}

	public static Boolean isNotNull(String str) {
		return str != null || str.trim().length() > 0;
	}
}
