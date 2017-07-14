package com.ksyun.ks3.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lijunwei[lijunwei@kingsoft.com]  
 * 
 * @date 2015年1月14日 下午2:44:15
 * 
 * @description 
 **/
public class PostPolicy {
	//指定签名过期时间 格式为2015-01-14T06:53:31.473Z 为格林时间
	private String expiration;
	private List<PostPolicyCondition> conditions = new ArrayList<PostPolicyCondition>();
	
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	public List<PostPolicyCondition> getConditions() {
		return conditions;
	}
	public void setConditions(List<PostPolicyCondition> conditions) {
		this.conditions = conditions;
	}
	
}
