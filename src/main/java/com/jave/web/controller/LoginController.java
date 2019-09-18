package com.jave.web.controller;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jave.web.dao.dao;
import com.jave.web.dto.TestDto;
import com.jave.web.dto.myList;
import com.jave.web.service.LoginService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class LoginController {

	@Autowired
	LoginService ls;

	// Login View
	@RequestMapping("/login")
	public String Login() {
		return "login";
	}
	// Login Data Check
	@RequestMapping("/loginAccept")
	public String LoginCheck(HttpServletRequest req, HttpSession session) {
		String id = (String)req.getParameter("id");
		String pw = (String)req.getParameter("pw");
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("pw", pw);
		System.out.println(id + " : " + pw);
		int res = ls.loginCheck(params);
		System.out.println("login res : " + res);
		return "redirect:/";
	}
	
	//회원 가입 View
	@RequestMapping("/newAccount")
	public String Account() {
		return "account";
	}
	
	//회원 가입
	@RequestMapping("/account")
	public String Account(HttpServletRequest req, HttpServletResponse res) {
		
		// 회원가입 폼에서 입력된 Request Data를 서비스 객체로 전송
		ls.addAccount(req);
		return "redirect:/";
	}

	//회원 대기자 명단 View
	@RequestMapping("/acceptList")
	public String acceptList(HttpServletRequest req, HttpServletResponse res) throws IOException{

		return "/acceptList";
	}
	
	@RequestMapping("/acceptList/List")
	public void list (HttpServletRequest req, HttpServletResponse res) throws IOException{
		res.setCharacterEncoding("UTF-8");
		List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < ls.accountList().size(); i++) {
			JSONObject jobj = new JSONObject();
			jobj.putAll(ls.accountList().get(i));
			jsonArray.add(jobj);
		}
		
		res.getWriter().write(jsonArray.toString());
	}
	
	@Autowired
	SqlSession s;

	// 회원 대기자 명단 Data 처리
	@RequestMapping(value = "/acceptList/add", method=RequestMethod.POST)
	public String ListToAdd (@RequestBody String paramData, HttpServletRequest req, HttpServletResponse res) {
		List<HashMap<String,Object>> resultMap = new ArrayList<HashMap<String,Object>>();
		resultMap = JSONArray.fromObject(paramData);
	    JSONObject jobj = new JSONObject();
	    
		JSONArray ar = JSONArray.fromObject(paramData);
		
		for(int i =0; i<resultMap.size(); i++) {
			HashMap<String,Object> p = new HashMap<String, Object>();
			jobj.putAll(resultMap.get(i));
			System.out.println(jobj.get("id"));
			p.put("id", jobj.get("id"));
			s.update("Board.UpdateAllowUser", p);
		}
	    
		return "redirect:/";
	}
}
