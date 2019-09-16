package com.jave.web.utils;

import java.util.Map;

import net.sf.json.JSONObject;

public class boardUtils {
	
	public static JSONObject convertMapToJson(Map<String, Object> map) {
		JSONObject json = new JSONObject();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			json.put(key, value);
		}
		return json;
	}
}
