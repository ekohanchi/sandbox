package com.projects.sandbox.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class QueryRetrieval {

	public static void main(String[] args) {
		String baseUrl = "https://www.google.com/search?source=hp&ei=5tgzXN7wHerd0gLlhI_QAQ&q=coding+practice&btnK=Google+Search&oq=coding+practice&gs_l=psy-ab.3..0l10.2715.14050..14213...2.0..0.357.3245.20j9j0j1......0....1..gws-wiz.....6..35i39j0i131j0i10.qWv7Q41gByM";
		String value = getValueForKey(baseUrl, "q");
		System.out.println("Value: " + value);
	}

	private static String getValueForKey(String urlString, String key) {
		URL url;
		String queryValue = "";
		try {
			url = new URL(urlString);

			String query = url.getQuery();
			String[] params = query.split("&");
			String name = "";
			String value = "";
			Map<String, String> map = new HashMap<String, String>();
			for (String param : params) {
				name = param.split("=")[0];
				if (param.split("=").length < 2) {
					value = "";
				} else {
					value = param.split("=")[1];
				}
				map.put(name, value);
			}
			queryValue = map.get(key);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return queryValue;
	}

}
