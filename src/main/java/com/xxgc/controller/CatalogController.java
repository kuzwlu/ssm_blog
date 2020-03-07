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

import com.xxgc.po.Catalog;
import com.xxgc.po.CatalogExample;
import com.xxgc.service.CatalogService;

/**
 * 
 * @author 花怜
 *
 */
@Controller
@RequestMapping("catalog")
public class CatalogController {

	@Resource
	private CatalogService catalogService;
	
	private CatalogExample example = new CatalogExample();
	
	@RequestMapping(value="/list/{page}",method = RequestMethod.GET)
	public String findByPage(Model model,@PathVariable("page")int page,@RequestParam(value = "limit",defaultValue = "10",required = true) int limit) {
		//分页设置
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page-1)*limit);
		map.put("limit", limit);
		List<Catalog> catalogList = catalogService.findByPage(map);
		for(Catalog c:catalogList) {
			if(c.getCastate().endsWith("1")) {
				c.setCastate("启用");
			}
			if(c.getCastate().endsWith("2")) {
				c.setCastate("未启用");
			}
		}
		//查询catalog总数
		int pageSize = (int) catalogService.countByExample(example);
		int lastPage;
		if((pageSize%limit)!=0) {
			lastPage = Math.floorDiv(pageSize, limit)+1;
		}else {
			lastPage = Math.floorDiv(pageSize, limit);
		}
		//栏目
		model.addAttribute("catalogList", catalogList);
		//总页数
		model.addAttribute("pageSize", pageSize);
		//当前页
		model.addAttribute("startPage", page);
		//最后一页
		model.addAttribute("lastPage", lastPage);
		return "background/cataloglist";
	}
	
	//在添加栏目，固定canumber最大值
	@RequestMapping("/catalog_info")
	public String findMaxCanumber(Model model) {
		int maxCanumber = catalogService.findMaxCanumber();
		model.addAttribute("maxCanumber", maxCanumber);
		return "background/catalog_info";
	}
	
	//添加栏目
	@RequestMapping(value="/insert",method = RequestMethod.PUT)
	public String saveCatalog(Model model,Catalog catalog) {
		//判断栏目名称是否重复
		Catalog catalogList = catalogService.findByName(catalog.getCaname());
		if(catalogList != null) {
			return "redirect:catalog_info";
		}else {
			try {
				catalogService.saveCatalog(catalog);
				return "redirect:list/1";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:catalog_info";
	}
	
	//编辑跳转页面
	@RequestMapping(value = "/catalog_update/{caid}",method = RequestMethod.GET)
	public String findByCaid(Model model,@PathVariable("caid")Integer caid) {
		Catalog catalogList = catalogService.findByCaid(caid);
		model.addAttribute("catalogList", catalogList);
		return "background/catalogupdate";
	}
	
	//编辑栏目
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public String updateCatalog(Model model,Catalog catalog,Integer caid) {
		//判断栏目名称是否重复
		Catalog catalogList = catalogService.findByName(catalog.getCaname());
		if(catalogList ==null) {
			try {
				Catalog catalogInfo = catalogService.findByCaid(caid);
				if(catalog.getCaname() == null || catalog.getCaname() == "") {
					catalog.setCaname(catalogInfo.getCaname());
				}
				catalogService.updateCatalog(catalog, caid);
				return "redirect:list/1";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:catalog_update/"+caid;
	}
	
	//上移
	@RequestMapping(value="exchange/{canumber}",method = RequestMethod.GET)
	public String updateExchange(Model model,@PathVariable("canumber")String canumber) {
		String canumberup = catalogService.findCanumber(canumber);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("canumber", canumber);
		map.put("canumberup", canumberup);
		try {
			catalogService.updateExchange(map);
			return "redirect:../list/1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:../list/1";
	}
	
	//删除栏目
	@RequestMapping(value="delete/{caid}/{canumber}",method = RequestMethod.GET)
	public String deleteCatalog(Model model,@PathVariable("caid")Integer caid,@PathVariable("canumber")String canumber) {
		try {
			catalogService.deleteCatalog(caid);
			catalogService.deleteUpdate(canumber);
			return "redirect:list/1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:list/1";
	}
	
	//搜索
	@RequestMapping("search")
	public String searchByName(Model model,String caname) {
		List<Catalog> catalogList = catalogService.searchByName(caname);
		for(Catalog c:catalogList) {
			if(c.getCastate().endsWith("1")) {
				c.setCastate("启用");
			}
			if(c.getCastate().endsWith("2")) {
				c.setCastate("未启用");
			}
		}
		//栏目
		model.addAttribute("catalogList", catalogList);
		return "background/catalogfind";
	}
}
