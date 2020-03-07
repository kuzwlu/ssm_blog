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
 * 文章实现
 * @author 花怜
 *
 */

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	@Resource
	private ArticleMapper articleMapper;
	
	@Resource
	private ArticleMapperCustom articleMapperCustom;
	
	//分页查询
	public List<Article> findByPage(Map<String, Object> map) {
		return articleMapperCustom.findByPage(map);
	}

	//分页总数
	public long countByExample(ArticleExample articleExample) {
		return articleMapper.countByExample(articleExample);
	}

	//跳转文章添加页面
	public int findMaxCanumber() {
		return articleMapperCustom.findMaxCanumber();
	}

	//添加一条article
	public void saveArticle(Article article) {
		articleMapperCustom.saveArticle(article);
	}

	//查询关于arid的一条信息
	public Article findByArid(int arid) {
		return articleMapperCustom.findByArid(arid);
	}

	//编辑文字
	public void updateArticle(Article article,Integer arid){
		articleMapper.updateByPrimaryKey(article);
	}

	//上移
	public void updateExchange(Map<String, Object> map) throws Exception {
		articleMapperCustom.updateExchange(map);
	}

	//查询比arnumber大的数
	public String findArnumber(String arnumber) {
		return articleMapperCustom.findArnumber(arnumber);
	}

	//删除
	public void deleteArticle(int arid) throws Exception {
		articleMapper.deleteByPrimaryKey(arid);
	}

	//查询artitle符合的
	public List<Article> findByArtitle(String artitle) {
		return articleMapperCustom.findByArtitle(artitle);
	}

}
