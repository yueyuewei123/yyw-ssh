/** 
 * <pre>项目名称:book_0805 
 * 文件名称:CusService.java 
 * 包名:com.jk.service 
 * 创建日期:2019年8月5日下午7:50:55 
 * Copyright (c) 2019, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.service;

import java.util.List;

import com.jk.model.Customer;

/** 
 * <pre>项目名称：book_0805    
 * 类名称：CusService    
 * 类描述：    
 * 创建人：王航
 *
 * 励志语录:逆水行舟不进则退
 *
 * 创建时间：2019年8月5日 下午7:50:55    
 * 修改人：王航  whkokon@163.com
 * 修改时间：2019年8月5日 下午7:50:55    
 * 修改备注：       
 * @version </pre>    
 */
public interface CusService {

	/** <pre>queryCust(这里用一句话描述这个方法的作用)   
	 * 创建人：王航  whkokon@163.com
	 * 创建时间：2019年8月5日 下午8:08:15    
	 * 修改人：王航
	 * 修改时间：2019年8月5日 下午8:08:15    
	 * 修改备注： 
	 * @return</pre>    
	 * @throws Exception 
	 */
	List<Customer> queryCust() throws Exception;

    void addCust(Customer cust);
}
