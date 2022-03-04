package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.SessionFactory;
import com.test.entity.Student;
import com.test.impl.StudentImpl;


public class StudentDao implements StudentImpl {

	
	@Override
	public int addStu(Student stu) {
		int result = 0;
		Connection conn = getConn() ;
		String add = "insert into  student(username ,password) values(?,?)";
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
	public int delStu(Student stu) {
		int result = 0;
		Connection conn = StudentDao.getConn();
		String sql = "delete from student where u_number = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getId());
			 result= pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateStu(Student stu) {
		Connection conn = StudentDao.getConn();
		String sql = "update student set username = ? , password = ? where u_number=?";
		System.out.println(sql+",username="+ stu.getUsername()+
				", password="+stu.getPassword()+", u_number=" + stu.getId());
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu.getUsername());
			pstmt.setString(2, stu.getPassword());
			pstmt.setInt(3, stu.getId());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<Student> findStu(Student stu)
			 {
		  List<Student>  list = new ArrayList<Student>();
		
		Connection conn = StudentDao.getConn();
		String username = stu.getUsername();
		String password = stu.getPassword();
		String  f1 = "select * from student where username='"+username+
				"' and password='"+password+"'";
		
		System.out.println("f1 = " + f1);
		try {
			PreparedStatement pstmt = conn.prepareStatement(f1);
		    ResultSet rs = pstmt.executeQuery();
		  
		    while(rs.next()) {
		    	Student stu1 = new Student();
		    	stu1.setUsername(rs.getString(1));
		    	stu1.setPassword(rs.getString(2));
		    	System.out.println("rs.getInt(3) = " + rs.getInt(3)) ;
		    	stu1.setId(rs.getInt(3));
		    	
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
		StudentDao studentD = new StudentDao();
		Student stu = new Student();
		stu.setUsername("zhang");
		stu.setPassword("zhang");
		int result = studentD.addStu(stu);
		System.out.println("result=" + result);
	}
	
	public static void testFind() throws 
	ClassNotFoundException, SQLException {
		Connection conn  = StudentDao.getConn();
		//StudentDao st = new StudentDao();
		System.out.println(conn);
		StudentDao stuD = new StudentDao();
		Student student = new Student();
		student.setUsername("123");
		student.setPassword("123");
		List<Student>  list = stuD.findStu(student);
		if(list.size() != 0 ) {
			System.out.println(list.get(0).getUsername());
			System.out.println(list.get(0).getPassword());
		}
	}
	
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		//StudentDao.testFind();
		StudentDao.testAdd();
		//修改
		
		//删除
		
	}

	@Override
	public List<Student> findStuById(Student stu) {
		List<Student> list = new ArrayList<Student>();
		Connection conn = StudentDao.getConn();
		String sql = "select * from student where u_number=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getId());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
			Student student = new Student();
			student.setUsername(rs.getString("username"));
			student.setPassword(rs.getString("password"));
			student.setId(rs.getInt("u_number"));
			list.add(student);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
