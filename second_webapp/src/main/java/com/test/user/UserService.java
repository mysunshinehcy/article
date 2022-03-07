package com.test.user;

import java.util.List;

import com.hcy.ariticle.bean.User;


public interface UserService {
     
	
	//根据编码查询
	public List<User>  findStuById(User stu);
	//增
	public int addStu(User stu);
	
	
	//删
	public int delStu(User stu);
	
	//改
	public int updateStu(User stu);
	
	//查
	public List<User> findStu(User stu);
}
