/** 
 * <pre>项目名称:book_0805 
 * 文件名称:Customer.java 
 * 包名:com.jk.model 
 * 创建日期:2019年8月5日下午7:33:06 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

/** 
 * <pre>项目名称：book_0805    
 * 类名称：Customer    
 * 类描述：    
 * 创建人：王航
 *
 * 励志语录:逆水行舟不进则退
 *
 * 创建时间：2019年8月5日 下午7:33:06    
 * 修改人：王航  whkokon@163.com
 * 修改时间：2019年8月5日 下午7:33:06    
 * 修改备注：       
 * @version </pre>    
 */
@Entity
@Table(name="t_customer")
public class Customer implements Serializable{
	
	private static final long serialVersionUID = 5124945878736595453L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String description;
	private String name;
	private Integer location_id;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date create_time;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date gj_time;
	private String phone;
	private Integer department_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getGj_time() {
		return gj_time;
	}
	public void setGj_time(Date gj_time) {
		this.gj_time = gj_time;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	/* (non-Javadoc)    
	 * @see java.lang.Object#toString()    
	 */
	@Override
	public String toString() {
		return "Customer [id=" + id + ", description=" + description + ", name=" + name + ", location_id=" + location_id
				+ ", create_time=" + create_time + ", gj_time=" + gj_time + ", phone=" + phone + ", department_id="
				+ department_id + "]";
	}
}
