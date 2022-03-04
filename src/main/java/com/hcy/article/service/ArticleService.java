package com.hcy.article.service;

import java.util.List;

import com.hcy.ariticle.bean.Article;
import com.hcy.pagenation.PagenationU;

public interface ArticleService {
	
	//添加文章
    public int addArticle(Article article);
    
    public List<Article> getArticle(PagenationU pagenationU);
}
