package com.hcy.ariticle.bean;

public class Role {

	private int rid;
	private String r_name;
	private int uid;
	
	public Role() {
		
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getR_name() {
		return r_name;
	}

	public void setR_name(String r_name) {
		this.r_name = r_name;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Role [rid=" + rid + ", r_name=" + r_name + ", uid=" + uid + "]";
	}

	
}
