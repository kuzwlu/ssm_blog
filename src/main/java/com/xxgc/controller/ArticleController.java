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
	
	//��ҳ��ѯarticle
	@RequestMapping(value="/list/{page}",method = RequestMethod.GET)
	public String findByPage(Model model,@PathVariable("page")int page,@RequestParam(value = "limit",defaultValue = "10",required = true) int limit){
		//��ҳ
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
			//ȥ��html��ǩ
			String html = DelHTMLTag.delHTMLTag(htmlTag);
			if(html.length()>20) {
				html=html.substring(0, 20);
			}else {
				html=html.substring(0, html.length());
			}
			a.setArcontent(html);
			
			//��ʽ��ʱ��
			String time = TimeUtil.stampToDate(a.getArtime());
			a.setArtime(time);
			
			if(a.getArstate().endsWith("1")) {
				a.setArstate("��ʾ");
			}
			if(a.getArstate().endsWith("2")) {
				a.setArstate("����");
			}
			
		}
		//��Ŀ
		CatalogExample catalogExample = new CatalogExample();
		catalogExample.setDistinct(false);
		catalogExample.setOrderByClause(null);
		List<Catalog> catalogList = catalogService.findAll(catalogExample);
		//��ҳ����
		int pageSize = (int) articleService.countByExample(articleExample);
		int lastPage;
		if((pageSize%limit)!=0) {
			lastPage = Math.floorDiv(pageSize, limit)+1;
		}else {
			lastPage = Math.floorDiv(pageSize, limit);
		}
		//����
		model.addAttribute("articleList", articleList);
		//��Ŀ
		model.addAttribute("catalogList", catalogList);
		//��ҳ��
		model.addAttribute("pageSize", pageSize);
		//��ǰҳ
		model.addAttribute("startPage", page);
		//���һҳ
		model.addAttribute("lastPage", lastPage);
		return "background/articlelist";
	}
	
	
	//��ת�������
	@RequestMapping("article_info")
	public String findMaxCanumber(Model model) {
		int arnumber = articleService.findMaxCanumber();
		//��Ŀ
		CatalogExample catalogExample = new CatalogExample();
		catalogExample.setDistinct(false);
		catalogExample.setOrderByClause(null);
		List<Catalog> catalogList = catalogService.findAll(catalogExample);
		model.addAttribute("arnumber", arnumber);
		model.addAttribute("catalogList", catalogList);
		return "background/articleadd";
	}
	
	@RequestMapping(value="insert",method = RequestMethod.POST)
	//�������
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
    			//�ļ���
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
        	//����ʱ���
        	article.setArtime(TimeUtil.dateToStamp(article.getArtime()));
			articleService.saveArticle(article);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "redirect:list/1";
	}
	
	//�༭��תҳ��
	@RequestMapping(value="article_update/{arid}",method = RequestMethod.GET)
	public String findByArid(Model model,@PathVariable("arid") int arid) {
		//��Ŀ
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
	
	
	//�༭
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
    			//�ļ���
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
			//����ʱ���
        	article.setArtime(TimeUtil.dateToStamp(article.getArtime()));
			articleService.updateArticle(article, arid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list/1";
	}
	
	//����
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
	
	//ɾ������
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
	
	//����
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
			//ȥ��html��ǩ
			String html = DelHTMLTag.delHTMLTag(htmlTag);
			if(html.length()>20) {
				html=html.substring(0, 20);
			}else {
				html=html.substring(0, html.length());
			}
			a.setArcontent(html);
			
			//��ʽ��ʱ��
			String time = TimeUtil.stampToDate(a.getArtime());
			a.setArtime(time);
			
			if(a.getArstate().endsWith("1")) {
				a.setArstate("��ʾ");
			}
			if(a.getArstate().endsWith("2")) {
				a.setArstate("����");
			}
		}
		//��Ŀ
		CatalogExample catalogExample = new CatalogExample();
		catalogExample.setDistinct(false);
		catalogExample.setOrderByClause(null);
		List<Catalog> catalogList = catalogService.findAll(catalogExample);
		//����
		model.addAttribute("articleList", articleList);
		//��Ŀ
		model.addAttribute("catalogList", catalogList);
		return "background/articlefind";
	}
	
	@RequestMapping(value="down",method = RequestMethod.GET)
	public void down(HttpServletRequest request,HttpServletResponse response,String filename) throws Exception{
		String path = request.getSession().getServletContext().getRealPath("upload/article")+"\\"+filename;
		System.out.println("-------------------------------------"+filename);
        System.out.println("--------------------------------"+path);
        
        //�õ�Ҫ���ص��ļ�
        //File file = new File(path);
//        if (!file.exists()) {
//        	response.setContentType("text/html; charset=UTF-8");//ע��text/html����application/html
//        	response.getWriter().print("<html><body><script type='text/javascript'>alert('��Ҫ���ص���Դ�ѱ�ɾ����');</script></body></html>");
//        	response.getWriter().close(); 
//            System.out.println("��Ҫ���ص���Դ�ѱ�ɾ������");  
//            return;  
//		}
        //ת�룬����ļ�����������  
        filename = URLEncoder.encode(filename,"UTF-8");  
        //�����ļ�����ͷ  
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
        //1.�����ļ�ContentType���ͣ��������ã����Զ��ж������ļ�����    
        response.setContentType("multipart/form-data"); 
        // ��ȡҪ���ص��ļ������浽�ļ�������
        FileInputStream in = new FileInputStream(path);
        // ���������
        OutputStream out = response.getOutputStream();
        // ����������
        byte buffer[] = new byte[1024]; // �������Ĵ�С�����Ǹ���  ��Ҳû������
        int len = 0;
        //ѭ�����������е����ݶ�ȡ������������
        while((len = in.read(buffer)) > 0){
        	out.write(buffer, 0, len);
        }
        //�ر��ļ�������
        in.close();
        // �ر������
        out.close();
	}
}
