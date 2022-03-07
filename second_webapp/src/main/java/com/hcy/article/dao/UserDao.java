package com.hcy.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcy.ariticle.bean.Role;
import com.hcy.ariticle.bean.User;
import com.hcy.utils.ConnectionUtil;

import com.test.user.UserService;

public class UserDao implements UserService{

	public UserDao() {
		
		
	}
	
	
	//rid
	@Override
	public List<User> findRidByUid(User role) {
		List<User>  list = new ArrayList<User>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from user u where u.u_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, role.getUid());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User userin = new User();
				userin.setPassword(rs.getString("u_password"));
				userin.setUsername(rs.getString("u_name"));
				userin.setUid(rs.getInt("u_id"));
				userin.setRid(rs.getInt("r_id"));
				//根据r_id查询r_name
				
				
				list.add(userin);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void testFindRoleByUid() {
		User role = new User();
		role.setUid(20);
		List<User>  list = findRidByUid( role);
		for(int i = 0 ; i < list.size() ; i ++) {
			User roler = list.get(i);
			
				System.out.println(roler.toString());	
		}
		
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
		//UserDao userDao  = new UserDao();
		//userDao.testGetName();
		
		//UserDao userDao = new UserDao();
		
		//userDao.testFindRoleByUid();
		
			UserDao userDao = new UserDao();
			userDao.testStu();
	}




	@Override
	public int addStu(User stu) {
		int result = 0;
		Connection conn = ConnectionUtil.getConn();
		String sql = "insert into user(u_name,u_password,r_id) values(?,?,?)";
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu.getUsername());
			pstmt.setString(2, stu.getPassword());
			pstmt.setInt(3, stu.getRid());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	
	public  void testStu() {
		UserDao userDao = new UserDao();
		User user = new User();
		user.setPassword("123");
		user.setUsername("王五");
		user.setRid(4);
		int result = userDao.addStu(user);
		System.out.println("result = " + result);
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
					"' and u_password='"+password+"'  and r_id=?";
			
			System.out.println("f1 = " + f1);
			try {
				PreparedStatement pstmt = conn.prepareStatement(f1);
				pstmt.setInt(1, stu.getRid());
			    ResultSet rs = pstmt.executeQuery();
			  
			    while(rs.next()) {
			    	User stu1 = new User();
			    	stu1.setUsername(rs.getString("u_name"));
			    	stu1.setPassword(rs.getString("u_password"));
			    	System.out.println("rs.getInt(3) = " + rs.getInt(3)) ;
			    	
			    	stu1.setUid(rs.getInt("u_id"));
			    	
			    	list.add(stu1);
			    }
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return list;
	}


	

}
