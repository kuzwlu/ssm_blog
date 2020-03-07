package com.xxgc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xxgc.po.Article;
import com.xxgc.po.ArticleExample;
import com.xxgc.po.Catalog;
import com.xxgc.po.CatalogExample;
import com.xxgc.service.ArticleService;
import com.xxgc.service.CatalogService;
import com.xxgc.utils.DelHTMLTag;
import com.xxgc.utils.TimeUtil;

/**
 * 主页
 * @author 花怜
 *
 */

@Controller
@RequestMapping("index")
public class IndexController {

	@Resource 
	private ArticleService articleService;
	
	@Resource
	private CatalogService catalogService;
	
	@RequestMapping(value="/{page}",method = RequestMethod.GET)
	public String index(Model model,@PathVariable("page")int page ,@RequestParam(value = "limit",defaultValue = "5",required = true) int limit) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page-1)*limit);
		map.put("limit", limit);
		List<Article> articles = articleService.findByPage(map);
		for(Article a:articles) {
			String title = a.getArtitle();
			if(title.length()>25) {
				title = title.substring(0,25);
			}else {
				title=title.substring(0, title.length());
			}
			a.setArtitle(title);
			
			String htmlTag = a.getArcontent();
			//去除html标签
			String html = DelHTMLTag.delHTMLTag(htmlTag);
			if(html.length()>50) {
				html=html.substring(0, 50);
			}else {
				html=html.substring(0, html.length());
			}
			a.setArcontent(html);
			
			//格式化时间
			String time = TimeUtil.stampToDate(a.getArtime());
			a.setArtime(time);
			
			if(a.getArstate().endsWith("1")) {
				a.setArstate("显示");
			}
			if(a.getArstate().endsWith("2")) {
				a.setArstate("隐藏");
			}
			if(a.getClick()==null) {
				a.setClick(0);
			}
			
		}
		CatalogExample catalogExample = new CatalogExample();
		ArticleExample articleExample = new ArticleExample();
		//分页总数
		int pageSize = (int) articleService.countByExample(articleExample);
		int lastPage;
		if((pageSize%limit)!=0) {
			lastPage = Math.floorDiv(pageSize, limit)+1;
		}else {
			lastPage = Math.floorDiv(pageSize, limit);
		}
		List<Catalog> catalogs = catalogService.findAll(catalogExample);
		model.addAttribute("articles", articles);
		model.addAttribute("catalogs", catalogs);
		//总页数
		model.addAttribute("pageSize", pageSize);
		//当前页
		model.addAttribute("startPage", page);
		//最后一页
		model.addAttribute("lastPage", lastPage);
		return "index";
	}
	
	@RequestMapping("list/{arid}")
	public String articleList(Model model,@PathVariable("arid") int arid) {
		Article articleList = articleService.findByArid(arid);
		ArticleExample articleExample = new ArticleExample();
		int pageSize = (int) articleService.countByExample(articleExample);
		model.addAttribute("articleList", articleList);
		model.addAttribute("pageSize", pageSize);
		return "article";
	}
}
