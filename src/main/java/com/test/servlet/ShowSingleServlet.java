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
 * Servlet implementation class ShowSingleServlet
 */
@WebServlet("/ShowSingleServlet")
public class ShowSingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowSingleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GBK");
		//response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("GBK");
		HttpSession session = request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		StudentImpl simpl = new StudentDao();
		Student stu = new Student();
		stu.setId(id);
		List<Student> list = simpl.findStuById(stu);
		
		if(list.size() != 0 ) {
			session.setAttribute("user", list.get(0));
		}
		
		
		request.getRequestDispatcher("/update.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
