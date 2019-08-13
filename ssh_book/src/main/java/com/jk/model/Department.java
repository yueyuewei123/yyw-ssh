/** 
 * <pre>项目名称:book_0805 
 * 文件名称:Department.java 
 * 包名:com.jk.model 
 * 创建日期:2019年8月5日下午7:39:23 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t_department")
public class Department implements Serializable{
	
	private static final long serialVersionUID = 1323847491541958586L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer did;
	private String dname;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + "]";
	}
}
