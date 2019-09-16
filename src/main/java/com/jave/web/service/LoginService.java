package com.jave.web.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jave.web.dao.dao;

@Service
public class LoginService {
	@Autowired
	dao d;

	public int loginCheck(HashMap<String, Object> params) {
		d.getUser(params);
		return 0;
	}
}
