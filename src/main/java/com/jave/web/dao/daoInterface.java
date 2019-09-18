package com.jave.web.dao;

import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

public interface daoInterface {
	
	public List<HashMap<String, Object>> getData();
	public int setArticle(Object bean);
	public int getUser(HashMap<String, Object> params);
	public int setUser(HashMap<String, Object> params);
	public List<HashMap<String, Object>> acceptList();
	public List<HashMap<String, Object>> allowList(List<HashMap<String, Object>> params);
}
