package com.xxgc.service;

import java.util.List;
import java.util.Map;

import com.xxgc.po.Article;
import com.xxgc.po.ArticleExample;

/**
 * ����
 * @author ����
 *
 */
public interface ArticleService {

	//��ҳ��ѯ
	public List<Article> findByPage(Map<String, Object> map);
	
	//ҳ��
	public long countByExample(ArticleExample articleExample);
	
	//��ѯ����arnumber�����
	public int findMaxCanumber();
	
	//�������
	public void saveArticle(Article article) throws Exception;
	
	//ͨ��arid��ѯ����
	public Article findByArid(int arid);
	
	//update
	public void updateArticle(Article article,Integer arid) throws Exception;
	
	//exchange
	public void updateExchange(Map<String, Object> map)throws Exception;
	
	//��ѯ��arnumber�����
	public String findArnumber(String arnumber);
	
	//delete
	public void deleteArticle(int arid) throws Exception;
	
	public List<Article> findByArtitle(String artitle);
}
