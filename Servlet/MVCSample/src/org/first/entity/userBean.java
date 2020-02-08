package org.first.entity;

public class userBean {

	private String uname;
	private String upwd;
	
	public userBean(String uname, String upwd) {
		this.uname = uname;
		this.upwd = upwd;
	}
	
	public userBean() {
		//空参构造函数
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	@Override
	public String toString() {
		return "userBean [uname=" + uname + ", upwd=" + upwd + "]";
	}
}
