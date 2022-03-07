package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcy.ariticle.bean.User;
import com.hcy.article.dao.UserDao;
import com.test.user.UserService;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("show get");
		request.setCharacterEncoding("utf-8");
		//response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//PrintWriter out = response.getWriter();
		//out.println("hello world,get,ShowServlet");
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		username =URLDecoder.decode(username, "UTF-8");
		password =URLDecoder.decode(password, "UTF-8");
		
		System.out.println("username= " + request.getParameter("username")) ;
		System.out.println("password = " + request.getParameter("password"));
		User stu = new User();
		stu.setUsername(username);
		stu.setPassword(password);
		UserService simpl = new UserDao();
		List<User> list = simpl.findStu(stu);
		if(list.size() != 0 ) {
			System.out.println("list.get(0).getId()="+list.get(0).getUid());
			request.getRequestDispatcher("/servlet/showAllServlet?id="+list.get(0).getUid()).forward(request, response);
		}else {
			request.getRequestDispatcher("/fail.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("show post");
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		doGet(request, response);
	}

}
