package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcy.ariticle.bean.User;
import com.mysql.cj.xdevapi.SessionFactory;

import com.test.user.UserService;


public class UserDao implements UserService {

	
	@Override
	public int addStu(User stu) {
		int result = 0;
		Connection conn = getConn() ;
		String add = "insert into  user(u_name ,u_password) values(?,?)";
		System.out.println("add= " + add);
		try {
			PreparedStatement pstmt = conn.prepareStatement(add);
			pstmt.setString(1, stu.getUsername());
			pstmt.setString(2, stu.getPassword());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public int delStu(User stu) {
		int result = 0;
		Connection conn = UserDao.getConn();
		String sql = "delete from student where u_number = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getUid());
			 result= pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateStu(User stu) {
		Connection conn = UserDao.getConn();
		String sql = "update student set username = ? , password = ? where u_number=?";
		System.out.println(sql+",username="+ stu.getUsername()+
				", password="+stu.getPassword()+", u_number=" + stu.getUid());
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu.getUsername());
			pstmt.setString(2, stu.getPassword());
			pstmt.setInt(3, stu.getUid());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<User> findStu(User stu)
			 {
		  List<User>  list = new ArrayList<User>();
		
		Connection conn = UserDao.getConn();
		String username = stu.getUsername();
		String password = stu.getPassword();
		String  f1 = "select * from student where username='"+username+
				"' and password='"+password+"'";
		
		System.out.println("f1 = " + f1);
		try {
			PreparedStatement pstmt = conn.prepareStatement(f1);
		    ResultSet rs = pstmt.executeQuery();
		  
		    while(rs.next()) {
		    	User stu1 = new User();
		    	stu1.setUsername(rs.getString(1));
		    	stu1.setPassword(rs.getString(2));
		    	System.out.println("rs.getInt(3) = " + rs.getInt(3)) ;
		    	stu1.setUid(rs.getInt(3));
		    	
		    	list.add(stu1);
		    }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	
	//连接mysql数据库
	public  static Connection getConn() 
			 {
		Connection conn = null;
		//先forName
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/testStu";
			String user = "root";
			String password = "root";
			 try {
				conn = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
	
		 
		
		
		return conn;
	}
	
	
	
	
	public static void testAdd() {
		UserDao studentD = new UserDao();
		User stu = new User();
		stu.setUsername("zhang");
		stu.setPassword("zhang");
		int result = studentD.addStu(stu);
		System.out.println("result=" + result);
	}
	
	public static void testFind() throws 
	ClassNotFoundException, SQLException {
		Connection conn  = UserDao.getConn();
		//StudentDao st = new StudentDao();
		System.out.println(conn);
		UserDao stuD = new UserDao();
		User student = new User();
		student.setUsername("123");
		student.setPassword("123");
		List<User>  list = stuD.findStu(student);
		if(list.size() != 0 ) {
			System.out.println(list.get(0).getUsername());
			System.out.println(list.get(0).getPassword());
		}
	}
	
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		//StudentDao.testFind();
		UserDao.testAdd();
		//修改
		
		//删除
		
	}

	@Override
	public List<User> findStuById(User stu) {
		List<User> list = new ArrayList<User>();
		Connection conn = UserDao.getConn();
		String sql = "select * from student where u_number=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getUid());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
			User student = new User();
			student.setUsername(rs.getString("username"));
			student.setPassword(rs.getString("password"));
			student.setUid(rs.getInt("u_number"));
			list.add(student);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		return list;
	}

	

	

}
