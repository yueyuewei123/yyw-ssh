/** 
 * <pre>项目名称:book_0805 
 * 文件名称:CusAction.java 
 * 包名:com.jk.action 
 * 创建日期:2019年8月5日下午7:44:28 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.jk.model.Customer;
import com.jk.service.CusService;
import com.opensymphony.xwork2.ModelDriven;

/** 
 * <pre>项目名称：book_0805    
 * 类名称：CusAction    
 * 类描述：
 * 创建人：王航
 *
 * 励志语录:逆水行舟不进则退
 *
 * 创建时间：2019年8月5日 下午7:44:28    
 * 修改人：王航  whkokon@163.com
 * 修改时间：2019年8月5日 下午7:44:28    
 * 修改备注：       
 * @version </pre>    
 */
@Namespace("/")
@Action("customer")
@Results({
	@Result(name="index",location="/index.jsp")
})
public class CusAction extends BaseAction implements ModelDriven<Customer>{
		
	private static final long serialVersionUID = -1780888454006140698L;


	@Autowired
	private CusService cService;
	
	
	private Customer cust;
	
	public String queryCust() throws Exception{
		
		List<Customer> list = cService.queryCust();
		
		String jsonStringWithDateFormat = JSON.toJSONStringWithDateFormat(list,"yyyy-MM-dd");
		
		super.writeJson(list);
		
		return "index";
	}


	public void addCust(){
		cService.addCust(cust);
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public Customer getCust() {
		return cust;
	}


	public void setCust(Customer cust) {
		this.cust = cust;
	}

















	/* (non-Javadoc)    
	 * @see com.opensymphony.xwork2.ModelDriven#getModel()    
	 */
	@Override
	public Customer getModel() {
		// TODO Auto-generated method stub
		return cust;
	}
	
	
	
}
