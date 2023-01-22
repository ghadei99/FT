package com.exaze;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import util.UtilsClass;

public class UserFixer extends HttpURLConnectionExample {

	private String baseurl;
	private String path;
	private String method;

	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int validateStatusCode() throws IOException {
		return HttpURLConnectionExample.sendingRequest(this.method, this.baseurl + this.path);
	}

	public static String validateNames() throws IOException {
		List arr = UtilsClass.returnListFromJSON(response);
		String names = "";
		List<String> ls = null;
		for (Object object : arr) {
			Map<String, String> map = (LinkedHashMap<String, String>) object;
			String name = map.get("name");
			ls.add(map.get("name"));
			System.out.println(name);
		}

		return ls.toString();
	}

	public static void main(String[] args) {
//		validateFields();
	}

}
