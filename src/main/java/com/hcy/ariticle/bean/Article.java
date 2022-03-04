package com.hcy.ariticle.bean;

import java.util.Date;

public class Article {
  private int a_id;
  private String title;
  private String content;
  private Date createDate;
  private User user;
  
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public int getA_id() {
	return a_id;
}
public void setA_id(int a_id) {
	this.a_id = a_id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
  
}
