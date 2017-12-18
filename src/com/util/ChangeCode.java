package com.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ChangeCode {
	public String changCode(String str) {
		try {
			return URLEncoder.encode(str,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "No";
	}
}
