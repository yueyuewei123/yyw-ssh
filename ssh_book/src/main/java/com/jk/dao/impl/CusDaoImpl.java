/** 
 * <pre>项目名称:book_0805 
 * 文件名称:CusDaoImpl.java 
 * 包名:com.jk.dao.impl 
 * 创建日期:2019年8月5日下午7:51:24 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jk.dao.CusDao;
import com.jk.model.Customer;

/** 
 * <pre>项目名称：book_0805    
 * 类名称：CusDaoImpl    
 * 类描述：    
 * 创建人：王航
 *
 * 励志语录:逆水行舟不进则退
 *
 * 创建时间：2019年8月5日 下午7:51:24    
 * 修改人：王航  whkokon@163.com
 * 修改时间：2019年8月5日 下午7:51:24    
 * 修改备注：       
 * @version </pre>    
 */
@Repository
public class CusDaoImpl implements CusDao {
		

	@Autowired
	private SessionFactory sessionFactory;

	/* (non-Javadoc)    
	 * @see com.jk.dao.CusDao#queryCust(java.lang.String)    
	 */
	@Override
	public List<Customer> queryCust(String hql)throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		return query.list();
	}
}
