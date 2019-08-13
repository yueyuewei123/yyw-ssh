/** 
 * <pre>项目名称:book_ssm 
 * 文件名称:Role.java 
 * 包名:com.jk.pojo 
 * 创建日期:2019年7月3日下午5:54:06 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */
package com.jk.model;

import java.io.Serializable;

public class Role implements Serializable {

	   private Integer id;

	    private String name;

	    private String description;

	    private String  checked;
	    
	    private String text;
	    
	    
	    
		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public String getChecked() {
			return checked;
		}

		public void setChecked(String checked) {
			this.checked = checked;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
	    
	    
	
}
