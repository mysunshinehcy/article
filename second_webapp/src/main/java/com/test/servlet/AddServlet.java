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
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hcy.ariticle.bean.User;
import com.hcy.article.dao.UserDao;
import com.hcy.utils.Message;


import com.test.user.UserService;

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
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String username = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		int rid = Integer.parseInt(request.getParameter("rid"));
		System.out.println("rid =" + rid);
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		username =URLDecoder.decode(username, "utf-8");
		password =URLDecoder.decode(password, "utf-8");
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		UserService sudentD = new UserDao();
		User student = new User();
		student.setUsername(username);
		student.setPassword(password);
		student.setRid(rid);
		int result = sudentD.addStu(student);
		PrintWriter out = response.getWriter();
		Message msg = new Message();
		
		if(result == 1) {
			msg.setCode(1);
			msg.setMsg("成功");
			//重新查询uid的值
			List<User> userO = sudentD.findStu(student);
			if(userO.size() != 0) {
				student.setUid(userO.get(0).getUid());
				System.out.println("uid="+ userO.get(0).getUid());
				session.setAttribute("user", student );
			}
			
		}else {
			msg.setCode(0);
			msg.setMsg("失败");
		}
		Gson gson = new Gson();
		String message = gson.toJson(msg);
		out.write(message);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("post");
		response.setContentType("text/html;charset=UTF-8");
	
		doGet(request, response);
	     

	}

}
