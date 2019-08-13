/** 
 * <pre>项目名称:book_ssm 
 * 文件名称:UserRole.java 
 * 包名:com.jk.pojo 
 * 创建日期:2019年7月4日上午10:53:10 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

public class UserRole implements Serializable {

	private Integer id;
	private Integer roleid;
	private Integer userid;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	
	
}
