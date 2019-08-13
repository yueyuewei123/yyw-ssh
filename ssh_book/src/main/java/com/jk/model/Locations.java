/** 
 * <pre>项目名称:book_0805 
 * 文件名称:Locations.java 
 * 包名:com.jk.model 
 * 创建日期:2019年8月5日下午7:37:17 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * <pre>项目名称：book_0805    
 * 类名称：Locations    
 * 类描述：    
 * 创建人：王航
 *
 * 励志语录:逆水行舟不进则退
 *
 * 创建时间：2019年8月5日 下午7:37:17    
 * 修改人：王航  whkokon@163.com
 * 修改时间：2019年8月5日 下午7:37:17    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="t_locations")
public class Locations implements Serializable{
			
	private static final long serialVersionUID = -6932124055955577108L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer lid;
	private String lname;
	private Integer pid;

	
	
	

	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Locations [lid=" + lid + ", lname=" + lname + ", pid=" + pid + "]";
	}
}
