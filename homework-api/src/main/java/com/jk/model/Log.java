package com.jk.model;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <pre>项目名称：ssm_logis    
 * 类名称：Log    
 * 类描述：    
 * 创建人：yueyuewei 
 *
 * 励志语录:业精于勤荒于嬉 行成于思毁于随
 *
 * 创建时间：2019年7月10日 下午7:32:23    
 * 修改人：yueyuewei  1476181116@qq.com
 * 修改时间：2019年7月10日 下午7:32:23    
 * 修改备注：       
 * @version </pre>
 */
public class Log implements Serializable {
	private String id;
	//属性名 必须和  mongo 的key 一致才能取到值
	private String logname;
	
	private String logip;
	
	private String logis;
	
	private String requerpath;
	
	private String parame;
	
    private String userid;

    private Object returningValue;

	private String logtime;

	public String getLogtime() {
		return logtime;
	}

	public void setLogtime(String logtime) {
		this.logtime = logtime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLogname() {
		return logname;
	}

	public void setLogname(String logname) {
		this.logname = logname;
	}

	public String getLogip() {
		return logip;
	}

	public void setLogip(String logip) {
		this.logip = logip;
	}

	public String getLogis() {
		return logis;
	}

	public void setLogis(String logis) {
		this.logis = logis;
	}

	public String getRequerpath() {
		return requerpath;
	}

	public void setRequerpath(String requerpath) {
		this.requerpath = requerpath;
	}

	public String getParame() {
		return parame;
	}

	public void setParame(String parame) {
		this.parame = parame;
	}


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Object getReturningValue() {
		return returningValue;
	}

	public void setReturningValue(Object returningValue) {
		this.returningValue = returningValue;
	}

}
