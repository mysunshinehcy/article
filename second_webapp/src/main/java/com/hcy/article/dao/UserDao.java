package com.hcy.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcy.ariticle.bean.User;
import com.hcy.utils.ConnectionUtil;

import com.test.user.UserService;

public class UserDao implements UserService{

	public UserDao() {
		
		
	}
	
	
	public User findById(int id) {
		User user = new User();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from user where u_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				user.setUsername(rs.getString("u_name"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return  user;
	}
	
	
	public void  testGetName() {
		int id = 1;
		User user = findById( id);
		System.out.println("name = " + user.getUsername());
	}
	
	public static void main(String[] args) {
		UserDao userDao  = new UserDao();
		userDao.testGetName();
		
				
	}




	@Override
	public int addStu(User stu) {
		return 0;
	}


	@Override
	public List<User> findStuById(User stu) {
		
		return null;
	}


	@Override
	public int delStu(User stu) {
		
		return 0;
	}


	@Override
	public int updateStu(User stu) {
	
		return 0;
	}


	@Override
	public List<User> findStu(User stu) {
		  List<User>  list = new ArrayList<User>();
			
			Connection conn = ConnectionUtil.getConn();
			String username = stu.getUsername();
			String password = stu.getPassword();
			String  f1 = "select * from user where u_name='"+username+
					"' and u_password='"+password+"'";
			
			System.out.println("f1 = " + f1);
			try {
				PreparedStatement pstmt = conn.prepareStatement(f1);
			    ResultSet rs = pstmt.executeQuery();
			  
			    while(rs.next()) {
			    	User stu1 = new User();
			    	stu1.setUsername(rs.getString(2));
			    	stu1.setPassword(rs.getString(3));
			    	System.out.println("rs.getInt(3) = " + rs.getInt(3)) ;
			    	stu1.setUid(rs.getInt(1));
			    	
			    	list.add(stu1);
			    }
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return list;
	}


	

}
