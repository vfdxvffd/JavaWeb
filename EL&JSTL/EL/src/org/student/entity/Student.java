package org.student.entity;


public class Student {

	public int sid;
	public String sname;
	public Address address;
	
	
	
	public Student(int sid, String sname, Address address) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.address = address;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", address=" + address + "]";
	}
	
	
}
