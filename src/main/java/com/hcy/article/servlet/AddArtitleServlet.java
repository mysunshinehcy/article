package com.hcy.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hcy.ariticle.bean.Article;
import com.hcy.ariticle.bean.User;
import com.hcy.article.dao.ArticleDao;

/**
 * Servlet implementation class AddArtitleServlet
 */
//@WebServlet("/AddArtitleServlet")
public class AddArtitleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArtitleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Date date = new Date();
		Article article = new Article();
		User user = new User();
		user.setUid(1);
		article.setUser(user);
		article.setTitle(title);
		article.setContent(content);
		article.setCreateDate(date);
		ArticleDao articleDao = new ArticleDao();
		int result = articleDao.addArticle(article);
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(result == 1) {
			request.getRequestDispatcher("../article/showArticle.jsp").forward(request, response);
			//out.print("发表成功");
		}else {
			out.print("发表失败");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
