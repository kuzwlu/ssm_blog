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
 * @author ����
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
		//��ҳ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page-1)*limit);
		map.put("limit", limit);
		List<Catalog> catalogList = catalogService.findByPage(map);
		for(Catalog c:catalogList) {
			if(c.getCastate().endsWith("1")) {
				c.setCastate("����");
			}
			if(c.getCastate().endsWith("2")) {
				c.setCastate("δ����");
			}
		}
		//��ѯcatalog����
		int pageSize = (int) catalogService.countByExample(example);
		int lastPage;
		if((pageSize%limit)!=0) {
			lastPage = Math.floorDiv(pageSize, limit)+1;
		}else {
			lastPage = Math.floorDiv(pageSize, limit);
		}
		//��Ŀ
		model.addAttribute("catalogList", catalogList);
		//��ҳ��
		model.addAttribute("pageSize", pageSize);
		//��ǰҳ
		model.addAttribute("startPage", page);
		//���һҳ
		model.addAttribute("lastPage", lastPage);
		return "background/cataloglist";
	}
	
	//�������Ŀ���̶�canumber���ֵ
	@RequestMapping("/catalog_info")
	public String findMaxCanumber(Model model) {
		int maxCanumber = catalogService.findMaxCanumber();
		model.addAttribute("maxCanumber", maxCanumber);
		return "background/catalog_info";
	}
	
	//�����Ŀ
	@RequestMapping(value="/insert",method = RequestMethod.PUT)
	public String saveCatalog(Model model,Catalog catalog) {
		//�ж���Ŀ�����Ƿ��ظ�
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
	
	//�༭��תҳ��
	@RequestMapping(value = "/catalog_update/{caid}",method = RequestMethod.GET)
	public String findByCaid(Model model,@PathVariable("caid")Integer caid) {
		Catalog catalogList = catalogService.findByCaid(caid);
		model.addAttribute("catalogList", catalogList);
		return "background/catalogupdate";
	}
	
	//�༭��Ŀ
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public String updateCatalog(Model model,Catalog catalog,Integer caid) {
		//�ж���Ŀ�����Ƿ��ظ�
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
	
	//����
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
	
	//ɾ����Ŀ
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
	
	//����
	@RequestMapping("search")
	public String searchByName(Model model,String caname) {
		List<Catalog> catalogList = catalogService.searchByName(caname);
		for(Catalog c:catalogList) {
			if(c.getCastate().endsWith("1")) {
				c.setCastate("����");
			}
			if(c.getCastate().endsWith("2")) {
				c.setCastate("δ����");
			}
		}
		//��Ŀ
		model.addAttribute("catalogList", catalogList);
		return "background/catalogfind";
	}
}
