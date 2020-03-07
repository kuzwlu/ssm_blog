package com.xxgc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xxgc.po.Article;
import com.xxgc.po.ArticleExample;
import com.xxgc.po.Catalog;
import com.xxgc.po.CatalogExample;
import com.xxgc.service.ArticleService;
import com.xxgc.service.CatalogService;
import com.xxgc.utils.DelHTMLTag;
import com.xxgc.utils.TimeUtil;

@Controller
@RequestMapping("article")
public class ArticleController {
	
	@Resource
	private ArticleService articleService;
	
	@Resource
	private CatalogService catalogService;
	
	private ArticleExample articleExample = new ArticleExample();
	
	//分页查询article
	@RequestMapping(value="/list/{page}",method = RequestMethod.GET)
	public String findByPage(Model model,@PathVariable("page")int page,@RequestParam(value = "limit",defaultValue = "10",required = true) int limit){
		//分页
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page-1)*limit);
		map.put("limit", limit);
		List<Article> articleList = articleService.findByPage(map);
		for(Article a:articleList) {
			String title = a.getArtitle();
			if(title.length()>10) {
				title = title.substring(0,10);
			}else {
				title=title.substring(0, title.length());
			}
			a.setArtitle(title);
			
			String htmlTag = a.getArcontent();
			//去除html标签
			String html = DelHTMLTag.delHTMLTag(htmlTag);
			if(html.length()>20) {
				html=html.substring(0, 20);
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
			
		}
		//栏目
		CatalogExample catalogExample = new CatalogExample();
		catalogExample.setDistinct(false);
		catalogExample.setOrderByClause(null);
		List<Catalog> catalogList = catalogService.findAll(catalogExample);
		//分页总数
		int pageSize = (int) articleService.countByExample(articleExample);
		int lastPage;
		if((pageSize%limit)!=0) {
			lastPage = Math.floorDiv(pageSize, limit)+1;
		}else {
			lastPage = Math.floorDiv(pageSize, limit);
		}
		//文章
		model.addAttribute("articleList", articleList);
		//栏目
		model.addAttribute("catalogList", catalogList);
		//总页数
		model.addAttribute("pageSize", pageSize);
		//当前页
		model.addAttribute("startPage", page);
		//最后一页
		model.addAttribute("lastPage", lastPage);
		return "background/articlelist";
	}
	
	
	//跳转文章添加
	@RequestMapping("article_info")
	public String findMaxCanumber(Model model) {
		int arnumber = articleService.findMaxCanumber();
		//栏目
		CatalogExample catalogExample = new CatalogExample();
		catalogExample.setDistinct(false);
		catalogExample.setOrderByClause(null);
		List<Catalog> catalogList = catalogService.findAll(catalogExample);
		model.addAttribute("arnumber", arnumber);
		model.addAttribute("catalogList", catalogList);
		return "background/articleadd";
	}
	
	@RequestMapping(value="insert",method = RequestMethod.POST)
	//添加文章
	public String saveArticle(Model model,Article article,HttpServletRequest request,MultipartFile file,String type) {
		String imagePath = "/article";
		String path = request.getSession().getServletContext().getRealPath("upload"+imagePath);  
        String fileName = file.getOriginalFilename();    
        if(fileName == null || fileName == "") {
        	article.setArimage("err.png");
        }else {
        	fileName = UUID.randomUUID().toString() + "_" + fileName;
            File dir = new File(path,fileName);          
            if(!dir.exists()){  
                dir.mkdirs();  
            }  
            try {
    			file.transferTo(dir);
    			//文件名
    			article.setArimage(fileName);
    		} catch (IllegalStateException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
        try {
        	//设置时间戳
        	article.setArtime(TimeUtil.dateToStamp(article.getArtime()));
			articleService.saveArticle(article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:list/1";
	}
	
	//编辑跳转页面
	@RequestMapping(value="article_update/{arid}",method = RequestMethod.GET)
	public String findByArid(Model model,@PathVariable("arid") int arid) {
		//栏目
		CatalogExample catalogExample = new CatalogExample();
		catalogExample.setDistinct(false);
		catalogExample.setOrderByClause(null);
		List<Catalog> catalogList = catalogService.findAll(catalogExample);
		
		Article articleList = articleService.findByArid(arid);
		Catalog caname = catalogService.findByCaid(articleList.getCaid());
		model.addAttribute("articleList", articleList);
		model.addAttribute("catalogList", catalogList);
		model.addAttribute("caname", caname.getCaname());
		return "background/articleupdate";
	}
	
	
	//编辑
	@RequestMapping(value="update" ,method = RequestMethod.POST)
	public String updateArticle(Model model,Article article,Integer arid,HttpServletRequest request,MultipartFile file,String type) {
		Article articleList = articleService.findByArid(arid);
		String imagePath = "/article";
		String path = request.getSession().getServletContext().getRealPath("upload"+imagePath);  
        String fileName = file.getOriginalFilename();    
        if(fileName == null || fileName == "") {
        	article.setArimage(articleList.getArimage());
        }else {
        	fileName = UUID.randomUUID().toString() + "_" + fileName;
            File dir = new File(path,fileName);          
            if(!dir.exists()){  
                dir.mkdirs();  
            }  
            try {
    			file.transferTo(dir);
    			//文件名
    			article.setArimage(fileName);
    		} catch (IllegalStateException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
		try {
			//设置时间戳
        	article.setArtime(TimeUtil.dateToStamp(article.getArtime()));
			articleService.updateArticle(article, arid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list/1";
	}
	
	//上移
	@RequestMapping(value="exchange/{arnumber}",method = RequestMethod.GET)
	public String updateExchange(Model model,@PathVariable("arnumber") String arnumber) {
		String arnumberup = articleService.findArnumber(arnumber);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("arnumberup", arnumberup);
		map.put("arnumber", arnumber);
		try {
			articleService.updateExchange(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:../list/1";
	}
	
	//删除文章
	@RequestMapping("delete/{arid}")
	public String deleteArticle(Model model,@PathVariable("arid") int arid) {
		try {
			articleService.deleteArticle(arid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:../list/1";
	}
	
	//搜索
	@RequestMapping(value="search",method = RequestMethod.POST)
	public String findByArtitle(Model model,String artitle) {
		List<Article> articleList = articleService.findByArtitle(artitle);
		for(Article a:articleList) {
			String title = a.getArtitle();
			if(title.length()>10) {
				title = title.substring(0,10);
			}else {
				title=title.substring(0, title.length());
			}
			a.setArtitle(title);
			
			String htmlTag = a.getArcontent();
			//去除html标签
			String html = DelHTMLTag.delHTMLTag(htmlTag);
			if(html.length()>20) {
				html=html.substring(0, 20);
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
		}
		//栏目
		CatalogExample catalogExample = new CatalogExample();
		catalogExample.setDistinct(false);
		catalogExample.setOrderByClause(null);
		List<Catalog> catalogList = catalogService.findAll(catalogExample);
		//文章
		model.addAttribute("articleList", articleList);
		//栏目
		model.addAttribute("catalogList", catalogList);
		return "background/articlefind";
	}
	
	@RequestMapping(value="down",method = RequestMethod.GET)
	public void down(HttpServletRequest request,HttpServletResponse response,String filename) throws Exception{
		String path = request.getSession().getServletContext().getRealPath("upload/article")+"\\"+filename;
		System.out.println("-------------------------------------"+filename);
        System.out.println("--------------------------------"+path);
        
        //得到要下载的文件
        //File file = new File(path);
//        if (!file.exists()) {
//        	response.setContentType("text/html; charset=UTF-8");//注意text/html，和application/html
//        	response.getWriter().print("<html><body><script type='text/javascript'>alert('您要下载的资源已被删除！');</script></body></html>");
//        	response.getWriter().close(); 
//            System.out.println("您要下载的资源已被删除！！");  
//            return;  
//		}
        //转码，免得文件名中文乱码  
        filename = URLEncoder.encode(filename,"UTF-8");  
        //设置文件下载头  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
        response.setContentType("multipart/form-data"); 
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte buffer[] = new byte[1024]; // 缓冲区的大小设置是个迷  我也没搞明白
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len = in.read(buffer)) > 0){
        	out.write(buffer, 0, len);
        }
        //关闭文件输入流
        in.close();
        // 关闭输出流
        out.close();
	}
}
