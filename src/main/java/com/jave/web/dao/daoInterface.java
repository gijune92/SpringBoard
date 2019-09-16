package com.jave.web.dao;

import java.util.HashMap;
import java.util.List;

public interface daoInterface {
	
	public List<HashMap<String, Object>> getData();
	public int setArticle(Object bean);
	public int getUser(HashMap<String, Object> params);
	public int setUser(HashMap<String, Object> params);

}
