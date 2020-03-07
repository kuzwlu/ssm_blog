package com.xxgc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xxgc.mapper.ArticleMapper;
import com.xxgc.mapper.ArticleMapperCustom;
import com.xxgc.po.Article;
import com.xxgc.po.ArticleExample;
import com.xxgc.service.ArticleService;

/**
 * ����ʵ��
 * @author ����
 *
 */

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper articleMapper;
	
	@Resource
	private ArticleMapperCustom articleMapperCustom;
	
	//��ҳ��ѯ
	public List<Article> findByPage(Map<String, Object> map) {
		return articleMapperCustom.findByPage(map);
	}

	//��ҳ����
	public long countByExample(ArticleExample articleExample) {
		return articleMapper.countByExample(articleExample);
	}

	//��ת�������ҳ��
	public int findMaxCanumber() {
		return articleMapperCustom.findMaxCanumber();
	}

	//���һ��article
	public void saveArticle(Article article) {
		articleMapperCustom.saveArticle(article);
	}

	//��ѯ����arid��һ����Ϣ
	public Article findByArid(int arid) {
		return articleMapperCustom.findByArid(arid);
	}

	//�༭����
	public void updateArticle(Article article,Integer arid){
		articleMapper.updateByPrimaryKey(article);
	}

	//����
	public void updateExchange(Map<String, Object> map) throws Exception {
		articleMapperCustom.updateExchange(map);
	}

	//��ѯ��arnumber�����
	public String findArnumber(String arnumber) {
		return articleMapperCustom.findArnumber(arnumber);
	}

	//ɾ��
	public void deleteArticle(int arid) throws Exception {
		articleMapper.deleteByPrimaryKey(arid);
	}

	//��ѯartitle���ϵ�
	public List<Article> findByArtitle(String artitle) {
		return articleMapperCustom.findByArtitle(artitle);
	}

}
