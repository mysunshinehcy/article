package com.hcy.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcy.ariticle.bean.User;
import com.hcy.utils.ConnectionUtil;

public class UserDao {

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

}
