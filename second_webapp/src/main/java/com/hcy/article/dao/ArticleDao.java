package com.hcy.article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.hcy.ariticle.bean.Article;
import com.hcy.ariticle.bean.User;
import com.hcy.article.service.ArticleService;
import com.hcy.pagenation.PagenationU;
import com.hcy.utils.ConnectionUtil;

public class ArticleDao implements ArticleService{
   
	public int addArticle(Article article) {
		System.out.println("1111111111111111111111111111111");
		System.out.println(" artiledao  addArticle");
		System.out.println("22222222222222222222222222");
		int result = 0;
		Connection conn = ConnectionUtil.getConn();
		String sql = "insert into article(r_content,r_title,create_time,u_id) values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getContent());
			pstmt.setString(2, article.getTitle());
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format( new Date());//将时间格式转换成符合Timestamp要求的格式.

			Timestamp goodsC_date =Timestamp.valueOf(nowTime);//把时间转换
		
			pstmt.setTimestamp(3,goodsC_date);
			pstmt.setInt(4, article.getUser().getUid());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
		
			System.out.println("aaaaa");
			e.printStackTrace();
		}
		
		return result;
	}
	
	//测试添加
	public void testGetArti() {
		ArticleDao articleDao = new ArticleDao();
		Article  article  = new Article();
		article.setContent("asssssssssssssssssssssssss");
		article.setTitle("azz");
		User user = new User();
		user.setUid(1);
		article.setUser(user);
		int result =  articleDao.addArticle( article);
		System.out.println(result);
	}
	
	
	
	public void testFindArti() {
		List<Article>  list = new ArrayList<Article>();
		
		Gson gson=new Gson();
		PagenationU pagenationU  = new PagenationU ();
		pagenationU.setCurrentPage(2);
		list =  getArticle( pagenationU) ;
		System.out.println("list.size =" + list.size());
		String result = gson.toJson(list);
		System.out.println(result);
	}
	

	public static void main(String[] args) {
		ArticleDao articleDao  = new ArticleDao();
		articleDao.testFindArti();
		
		
	}

	//只返回当前页的数据，要用append的方式来做，不能每次都覆盖，有bug。。。
	//js代码来修改。。。
	@Override
	public List<Article> getArticle(PagenationU pagenationU) {
		List<Article>  list = new ArrayList<Article>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from article  a order by a.create_time desc limit ?,? ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int curpage = pagenationU.getCurrentPage();
			int count = pagenationU.getCount();
			int startIndex =  ( curpage - 1) *count;
			int endIndex =  count;
			System.out.println("startIndex = " + startIndex);
			System.out.println("endIndex = " + endIndex);
			pstmt.setInt(1, startIndex);
			pstmt.setInt(2, endIndex);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				Article artcile = new Article();
				artcile.setContent(rs.getString("r_content"));
				artcile.setTitle(rs.getString("r_title"));
			    String name = findNameById(rs.getInt("u_id"));
			    User user = new User();
				user.setUsername(name);
				artcile.setUser(user);
				list.add(artcile);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String findNameById(int id) {
		String name = "";
		
		//嵌套查询用户名
		UserDao userDao = new UserDao();
		User user = userDao.findById(id);
		 name = user.getUsername();
		return name;
	}

}
