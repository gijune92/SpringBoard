package com.jave.web.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jave.web.Bean.BoardBean;
import com.jave.web.service.BoardService;
import com.jave.web.service.LoginService;
import com.jave.web.utils.boardUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class BoardController {

	@Autowired
	BoardService bs;
	LoginService ls;
	
	@RequestMapping("/")
	public String Main(HttpServletRequest req) {
		return "main";
	}
	/***
	 * login 
	 ***/
	@RequestMapping("/login")
	public String Login() {
		return "login";
	}
	@RequestMapping("/loginAccept")
	public String LoginCheck(HttpServletRequest req, HttpSession session) {
		String id = (String)req.getParameter("id");
		String pw = (String)req.getParameter("password");
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("id", id);
		params.put("pw", pw);
		
		int res = ls.loginCheck(params);
		
		return "redirect:/";
	}
	@RequestMapping("/newAccount")
	public String Account() {
		return "account";
	}
	@RequestMapping("/account")
	public String Account(HttpServletRequest req, HttpServletResponse res, HttpSession session) {
		
		
		return null;
	}
	// Login End

	/*
	 * Board
	 * 
	 * 
	 * */ 
	@RequestMapping("/s")
	public void select(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setCharacterEncoding("UTF-8");
		
		List<HashMap<String, Object>> articles = new ArrayList<HashMap<String, Object>>();
		articles = bs.articleSelect();
		System.out.println("Select : " + articles.toString());
		JSONArray jsonArray = new JSONArray();
		for (int i = 0; i < articles.size(); i++) {
			JSONObject jobj = new JSONObject();
			jobj.putAll(articles.get(i));
			jsonArray.add(jobj);
		}
		res.getWriter().write(jsonArray.toString());
	}
	
	@RequestMapping("/i")
	public String Iview() {
		return "board_add";
	}
	@RequestMapping("/d")
	public String Dview() {
		return "board_detail";
	}
	
	@RequestMapping("/Articleinsert")
	public String ArticleInsert(HttpServletRequest req, BoardBean bean,
										HttpSession session,
										@RequestParam("files") MultipartFile[] file) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = new Date();
		
		
		// Login Session 구현 이후 추가 코드
		//bean.setUsrname((String)session.getAttribute("nick"));
		
		bean.setUsrname("admin");
		bean.setCtime((String)df.format(time));
		System.out.println("parameter : " + bean.toString());
		
		bs.articleInsert(bean);
		return "redirect:/";
	}
	
	@RequestMapping("/accountLog")
	public String AccountLogView() {
		return "/accountLog";
	}
	@RequestMapping("/downLog")
	public String DownloadLogView() {
		return "/fileLog";
	}
}
