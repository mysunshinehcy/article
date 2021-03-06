package com.test.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.dao.StudentDao;
import com.test.entity.Student;
import com.test.impl.StudentImpl;

/**
 * Servlet implementation class ShowAllServlet
 */
@WebServlet("/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("show  all servlet get");
		StudentImpl simpl = new StudentDao();
		Student stu = new Student();
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		
		stu.setId(Integer.parseInt((String)request.getParameter("id")));
		List<Student>  list = simpl.findStuById(stu);
		HttpSession session = request.getSession();
		session.setAttribute("users", list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("show all servlet post");
		doGet(request, response);
	}

}
