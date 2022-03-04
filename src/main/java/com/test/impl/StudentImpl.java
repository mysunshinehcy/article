package com.test.impl;

import java.util.List;

import com.test.entity.Student;

public interface StudentImpl {
     
	
	//根据编码查询
	public List<Student>  findStuById(Student stu);
	//增
	public int addStu(Student stu);
	
	
	//删
	public int delStu(Student stu);
	
	//改
	public int updateStu(Student stu);
	
	//查
	public List<Student> findStu(Student stu);
}
