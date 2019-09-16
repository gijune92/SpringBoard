package com.jave.web.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class dao implements daoInterface{

	@Autowired
	SqlSession s;
	
	/*****************
	 * Board 
	 * 
	 *****************/
	
	@Override
	public List<HashMap<String, Object>> getData() {
		return s.selectList("Board.SelectArticle");
	}
	
	@Override
	public int setArticle(Object bean) {
		int res = s.insert("Board.InsertArticle", bean);
		return res;
	}
	
	/*****
	 * User
	 *  
	 *****/
	
	@Override
	public int getUser(HashMap<String, Object> params) {
		int res = s.selectOne("Board.SelectUser", params);
		return res;
	}

	@Override
	public int setUser(HashMap<String, Object> params) {
		int res = s.insert("Board.InsertUser", params);
		return res;
	}
}
