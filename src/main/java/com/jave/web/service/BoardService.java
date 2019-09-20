package com.jave.web.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jave.web.Bean.BoardBean;
import com.jave.web.dao.dao;

@Service
public class BoardService {
	
	@Autowired
	dao d;
	
	public List<HashMap<String, Object>> articleSelect() {
		return d.getData();
	}
	
	public void articleInsert(BoardBean bean) {
		int res = d.setArticle(bean);
		if(res != 0) {
			System.out.println("데이터 입력 성공");
		}
	}
	
	public List<HashMap<String, Object>> accountLog(){
		
		return d.LogInAndOutList();
	}
}
