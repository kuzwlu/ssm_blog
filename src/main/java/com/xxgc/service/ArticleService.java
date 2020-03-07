package com.xxgc.service;

import java.util.List;
import java.util.Map;

import com.xxgc.po.Article;
import com.xxgc.po.ArticleExample;

/**
 * 文章
 * @author 花怜
 *
 */
public interface ArticleService {

	//分页查询
	public List<Article> findByPage(Map<String, Object> map);
	
	//页数
	public long countByExample(ArticleExample articleExample);
	
	//查询文章arnumber最大数
	public int findMaxCanumber();
	
	//添加数据
	public void saveArticle(Article article) throws Exception;
	
	//通过arid查询文章
	public Article findByArid(int arid);
	
	//update
	public void updateArticle(Article article,Integer arid) throws Exception;
	
	//exchange
	public void updateExchange(Map<String, Object> map)throws Exception;
	
	//查询比arnumber大的数
	public String findArnumber(String arnumber);
	
	//delete
	public void deleteArticle(int arid) throws Exception;
	
	public List<Article> findByArtitle(String artitle);
}
