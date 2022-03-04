package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.StudentDao;
import com.test.entity.Student;
import com.test.impl.StudentImpl;

/**
 * Servlet implementation class AddServlet
 */
//@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		username =URLDecoder.decode(username, "utf-8");
		password =URLDecoder.decode(password, "utf-8");
		//URLDecoder.decode(condition, "utf-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		StudentImpl sudentD = new StudentDao();
		Student student = new Student();
		student.setUsername(username);
		student.setPassword(password);
		
		int result = sudentD.addStu(student);
		if(result == 1) {
			request.getRequestDispatcher("/login.html").forward(request, response);
		}else {
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("hello world,servlet");
		doGet(request, response);
	     

	}

}
