package com.hcy.role.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hcy.ariticle.bean.Role;
import com.hcy.role.dao.RoleDao;
import com.hcy.role.service.RoleService;

/**
 * Servlet implementation class RolesServlet
 */
@WebServlet("/RolesServlet")
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RolesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   response.setCharacterEncoding("utf-8");
	   request.setCharacterEncoding("utf-8");
		RoleService roleService = new RoleDao(); 
		List<Role> list = roleService.findRoles();
		Gson gson = new Gson();
		String result = gson.toJson(list);
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
