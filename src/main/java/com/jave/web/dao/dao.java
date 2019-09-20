
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
	public HashMap<String, Object> getUser(HashMap<String, Object> params) {
		/*
		int res = s.selectOne("Board.SelectUser", params);
		System.out.println("getUser : " + res);
		
		return res;
		*/
		HashMap<String, Object> res = s.selectOne("Board.SelectUser", params);
		//System.out.println(res.toString());
		return res;
		//return s.selectOne("Board.SelectUser", params);
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
	public int allowList(HashMap<String, Object> data) {
		int res = s.update("Board.UpdateAllowUser", data);
		return res;
	}
	
	/************
	 * LogIn And LogOut Table accountLog insert Process
	 * 
	 * 
	 ***********/
	@Override
	public void LogInAndOut(HashMap<String, Object> params) {
		
		s.insert("Board.InsertAccountLog" , params);
		
		
	}
	@Override
	public List<HashMap<String, Object>> LogInAndOutList() {
		return s.selectList("Board.SelectAccountLog");
	}
	
	
	
	
	
	
	
	
	
	
}
