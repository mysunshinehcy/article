package com.hcy.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.hcy.ariticle.bean.Article;
import com.hcy.ariticle.bean.User;
import com.hcy.article.dao.ArticleDao;
import com.hcy.utils.Message;

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
		Message message = new Message();
		if(result == 1) {
            message.setCode(1);
			message.setMsg("success");
		}else {
		    message.setCode(0);
			message.setMsg("fail");
		}
		Gson gson = new Gson();
		String resultdf = gson.toJson(message);
		out.write(resultdf);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
