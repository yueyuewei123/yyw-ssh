/** 
 * <pre>项目名称:book_0805 
 * 文件名称:CusServiceImpl.java 
 * 包名:com.jk.service.impl 
 * 创建日期:2019年8月5日下午7:51:03 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.dao.CusDao;
import com.jk.model.Customer;
import com.jk.service.CusService;

/** 
 * <pre>项目名称：book_0805    
 * 类名称：CusServiceImpl    
 * 类描述：    
 * 创建人：王航
 *
 * 励志语录:逆水行舟不进则退
 *
 * 创建时间：2019年8月5日 下午7:51:03    
 * 修改人：王航  whkokon@163.com
 * 修改时间：2019年8月5日 下午7:51:03    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class CusServiceImpl implements CusService {
		
	@Autowired
	private CusDao cDao;


	@Override
	public List<Customer> queryCust() throws Exception {
		
		//StringBuffer hql = new StringBuffer("from Customer a,Locations b,Department c where a.location_id=b.lid and a.department_id=c.did");
		StringBuffer hql = new StringBuffer("select new map(c.id as id,c.name as name,d.dname as dname,c.create_time as create_time,c.gj_time as gj_time,c.phone as phone,l.lname as lname,c.description as description) from Customer c,Locations l,Department d where c.location_id=l.lid and c.department_id=d.did");
		return cDao.queryCust(hql.toString());
	}

	@Override
	public void addCust(Customer cust) {

	}
}
