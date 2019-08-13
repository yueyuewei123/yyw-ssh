/** 
 * <pre>项目名称:book_ssm 
 * 文件名称:User.java 
 * 包名:com.jk.pojo 
 * 创建日期:2019年7月2日下午7:16:15 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;
import java.util.Date;


import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User implements Serializable {

	
	private String id;
	private String username;
	private String password;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
