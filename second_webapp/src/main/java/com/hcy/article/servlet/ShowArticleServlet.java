package com.hcy.article.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.hcy.ariticle.bean.Article;
import com.hcy.article.dao.ArticleDao;
import com.hcy.article.service.ArticleService;
import com.hcy.pagenation.PagenationU;

/**
 * Servlet implementation class ShowArticleServlet
 */
@WebServlet("/ShowArticleServlet")
public class ShowArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		 response.setCharacterEncoding("utf-8");
		String uid = request.getParameter("uid");
		int curpage = Integer.parseInt(request.getParameter("curpage"));
		System.out.println("uid = " + uid+", curpage =" + curpage);
		PagenationU  pagenationU = new PagenationU();
		pagenationU.setCurrentPage(curpage);
		 ArticleService  articleService = new ArticleDao();
		 List<Article> list = articleService.getArticle(pagenationU);
		//解析页面传来的数据
		System.out.println("list.size =" + list.size());
		Gson gson=new Gson();

		String liststr = gson.toJson(list);
		System.out.println("liststr = " + liststr);
		HttpSession session = request.getSession();
		session.setAttribute("articles", list);
		PrintWriter pw = response.getWriter();
		pw.print(liststr);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
