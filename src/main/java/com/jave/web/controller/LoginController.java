package com.jave.web.controller;

import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jave.web.service.LoginService;
import com.jave.web.utils.boardUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class LoginController {

	@Autowired
	LoginService ls;
	// Logout Process
	@RequestMapping("/logout")
	public String Logout(HttpSession session) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		// 로그아웃 데이터 테이블 insert 처리
		params.put("IOflag", "O");
		params.put("id", session.getAttribute("user"));
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
		String ctime = format.format(time);
		params.put("ctime", ctime);
		
		ls.accountLogService(params);
		
		session.invalidate();
		return "redirect:/";
	}
	
	// Login View
	@RequestMapping("/login")
	public String Login() {
		return "login";
	}
	
	// Login Data Check
	@RequestMapping("/loginAccept")
	public String LoginCheck(HttpServletRequest req, HttpSession session) {
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", (String)req.getParameter("id"));
		params.put("pw", (String)req.getParameter("pw"));
		
		//int res = ls.loginCheck(params);
		HashMap<String, Object> res = ls.loginCheck(params);
		System.out.println("Check : " + res.toString());

		if(Integer.parseInt(res.get("count").toString()) == 1) {
			session.setAttribute("msg", "로그인 되었습니다.");
			session.setAttribute("user", res.get("id"));
			session.setAttribute("accountDivision", res.get("accountDivision"));
			//로그인 데이터 테이블 insert 처리
			params.clear();
			params.put("IOflag", "I");
			params.put("id", res.get("id"));
			Date time = new Date();
			SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
			String ctime = format.format(time);
			params.put("ctime", ctime);
			
			ls.accountLogService(params);
			
			return "redirect:/";
		} else {
			session.setAttribute("msg", "등록된 사용자가 없습니다.");
			return "redirect:/login";
		}
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
	
	@RequestMapping(value = "/select", method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String select(HttpServletResponse res) {
		System.out.println("Select TEST");
		List<HashMap<String, Object>> article = ls.accountList();
		System.out.println("article : " + article);
		JSONArray jsonArray = new JSONArray();
		for (Map<String, Object> map : article) {
			jsonArray.add(boardUtils.convertMapToJson(map));
		}
		System.out.println("jsonArray : " + jsonArray.toString());
		return jsonArray.toString();
	}

	// 회원 대기자 명단 Data 처리
	@RequestMapping(value = "/acceptList/add", method=RequestMethod.POST)
	@ResponseBody
	public int ListToAdd (@RequestBody String paramData, HttpServletRequest req, HttpServletResponse res) {
	
		//System.out.println(paramData);
		//System.out.println(req.getParameter("data"));
		List<HashMap<String,Object>> resultMap = new ArrayList<HashMap<String,Object>>();
		JSONObject jobj = new JSONObject();

		// 전송받은 JSON Parameter -> List<HashMap<String,Object>> Type으로 변환 
		resultMap = JSONArray.fromObject(paramData);
		int result = ls.allow(resultMap);
		
		System.out.println("[acceptList/Add] - result : " + result);

		return result;
	}
}
