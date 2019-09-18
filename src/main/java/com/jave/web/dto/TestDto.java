package com.jave.web.dto;

import java.util.List;

public class TestDto {
	public String id;
	public String name;
	public String addr;
	public String accountDivision;
	public List<TestDto> list;
	
	public List<TestDto> getList() {
		return list;
	}
	public void setList(List<TestDto> list) {
		this.list = list;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAccountDivision() {
		return accountDivision;
	}
	public void setAccountDivision(String accountDivision) {
		this.accountDivision = accountDivision;
	}
	@Override
	public String toString() {
		return "TestDto [id=" + id + ", name=" + name + ", addr=" + addr + ", accountDivision=" + accountDivision
				+ ", list=" + list + "]";
	}
	
	
}
