package com.xxgc.mapper;

import java.util.List;
import java.util.Map;

import com.xxgc.po.Article;

public interface ArticleMapperCustom {

	List<Article> findByPage(Map<String, Object> map);
	
	int findMaxCanumber();
	
	void saveArticle(Article article);
	
	Article findByArid(int arid);
	
	void updateArticle(Article articles);
	
	void updateExchange(Map<String, Object> map);
	
	String findArnumber(String arnumber);
	
	List<Article> findByArtitle(String artitle);
}
