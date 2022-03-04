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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("update servlet get");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	    StudentImpl simpl = new StudentDao();
	    int id = Integer.parseInt(request.getParameter("id"));
	    String username = (String)request.getParameter("username");
	    String password = (String)request.getParameter("password");
	    username =URLDecoder.decode(username, "GBK");
		password =URLDecoder.decode(password, "GBK");
		
	    Student stu = new Student();
	    stu.setId(id);
	    stu.setUsername(username);
	    stu.setPassword(password);
	    System.out.println("username =" + username);
	    System.out.println("password = "+ password);
	  
	    int result = simpl.updateStu(stu);
	    if(result == 1) {
	    	request.getRequestDispatcher("/servlet/showAllServlet?id="+id).forward(request, response);
	    }else {
	    	request.getRequestDispatcher("/fail.jsp").forward(request, response);
	    }
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		doGet(request, response);
	}

}
