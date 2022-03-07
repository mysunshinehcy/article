package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hcy.ariticle.bean.User;
import com.hcy.article.dao.UserDao;
import com.hcy.utils.Message;
import com.test.user.UserService;

public class LoginServlet extends HttpServlet{



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		Gson gson = new Gson();
		Message msg = new Message();
		UserService userService = new UserDao();
		List<User> list = userService.findStu(user);
		if(list.size() == 0) {
			msg.setMsg("fail");
			msg.setCode(0);
		}else {
			msg.setMsg("success");
			msg.setCode(1);
			session.setAttribute("user", list.get(0));
		}
		String result = gson.toJson(msg);
		PrintWriter out = response.getWriter();
		out.print(result);
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}
	


	


}
