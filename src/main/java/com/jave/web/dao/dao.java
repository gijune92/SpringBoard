package com.jave.web.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.sf.json.JSONArray;

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
		System.out.println("getUser : " + res);
		return res;
	}

	@Override
	public int setUser(HashMap<String, Object> params) {
		int res = s.insert("Board.InsertUser", params);
		return res;
	}
	
	@Override
	public List<HashMap<String, Object>> acceptList() {
		
		return s.selectList("Board.SelectAcceptList");
	}
	@Override
	public List<HashMap<String, Object>> allowList(List<HashMap<String, Object>> params) {
		
		for(int i=0; i < params.size(); i++) {
			HashMap<String, Object> data = new HashMap<String, Object>();
			//data.put(params.get(i). )
			System.out.println(data.toString());
			//s.update("Board.UpdateAllowUser", params.get(i).toString());
		}
		
		return null;
	}
}
