package com.hcy.role.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hcy.ariticle.bean.Role;
import com.hcy.ariticle.bean.User;
import com.hcy.article.dao.UserDao;
import com.hcy.role.dao.RoleDao;
import com.hcy.role.service.RoleService;
import com.hcy.utils.Message;
import com.test.user.UserService;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int uid = Integer.parseInt(request.getParameter("uid")) ;
		System.out.println("uid = "+ uid);
		User role = new User();
		role.setUid(uid);
		UserService userService = new UserDao();
		List<User>  list = userService.findRidByUid(role);
		
		RoleService roleService = new RoleDao();
		List<Role> roleLi = new ArrayList<Role>();
		for(User user : list) {
			Role rolemn = new Role();
			System.out.println("rid = " + user.getRid() );
			rolemn.setRid(user.getRid());
			roleLi.add(rolemn);
		}
		List<Role>  listR = roleService.findRole(roleLi);
		
		int count =0;
		for(Role myrole : listR) {
			System.out.println("r_name=" + myrole.getR_name());
			if("admin".equals(myrole.getR_name())) {
				count++;
				break;
			}
		}
		
		Message message = new Message();
		if(count == 1) {
			message.setCode(1);
			message.setMsg("success");
		}else {
			message.setCode(0);
			message.setMsg("fail");
		}
	   response.setCharacterEncoding("utf-8");
	   Gson gson = new Gson();
	   String result = gson.toJson(message);
	   PrintWriter out = response.getWriter();
	   out.write(result);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
