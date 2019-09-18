package com.jave.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jave.web.dao.dao;

import net.sf.json.JSONArray;

@Service
public class LoginService {
	@Autowired
	dao d;

	public int loginCheck(HashMap<String, Object> params) {
		System.out.println(params.get("id"));
		System.out.println(params.get("pw"));
		int res = d.getUser(params);
		return res;
	}

	/**********************
	 * 회원 가입 서비스 부분
	 * AccountDiv 
	 * 1 : 학생
	 * 3 : 강사
	 * 5 : 관리자
	 * 9 : admin계정
	 * 
	 **********************/ 
	public int addAccount(HttpServletRequest req) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", req.getParameter("id"));
		params.put("pw", req.getParameter("pw"));
		params.put("name", req.getParameter("name"));
		params.put("addr", req.getParameter("addr"));
		params.put("accountDiv", req.getParameter("accountDiv"));
		int res = d.setUser(params);
		return res;
	}
	
	public List<HashMap<String, Object>> accountList(){
		return d.acceptList();
	}
	
	public String allow(List<HashMap<String, Object>> params) {
		
	    for(int i = 0; i < params.size(); i++) {
	    	System.out.println("Service : " + params.get(i).toString());
	    }
	    d.allowList(params);
	    return null;
	}
	
}
