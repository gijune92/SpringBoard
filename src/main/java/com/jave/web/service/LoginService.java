package com.jave.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jave.web.dao.dao;

import net.sf.json.JSONArray;

@Service
public class LoginService {
	@Autowired
	dao d;

	public HashMap<String, Object> loginCheck(HashMap<String, Object> params) {
		HashMap<String, Object> res = d.getUser(params);
		
		Object count = res.get("count(*)");
		Object accountDivision = res.get("accountDivision");
		res.clear();
		res.put("count", count);
		res.put("accountDivision", accountDivision);
		res.put("id", params.get("id"));
		return res;
	}
	
	public void accountLogService(HashMap<String, Object> params) {
		d.LogInAndOut(params);
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
	
	public int allow(List<HashMap<String, Object>> params) {
		//System.out.println("Service : " + params.toString());
		int res = 0;
		for(int i =0; i<params.size(); i++) {
			HashMap<String, Object> p = new HashMap<String, Object>();
			int flag = 0;
			p.putAll(params.get(i));
			flag = d.allowList(p);
			System.out.println("flag : " + flag);
		}
	    return res;
	}
}
