package com.xxgc.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xxgc.po.Manager;
import com.xxgc.po.ManagerExample;
import com.xxgc.service.ManagerService;

@Controller
@RequestMapping("manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	private ManagerExample managerExample = new ManagerExample();
	
	//����Ա��ҳ��ѯ
	@RequestMapping(value="/list/{page}",method = RequestMethod.GET)
	public ModelAndView findByPage(@PathVariable("page")int page,@RequestParam(value = "limit",defaultValue = "10",required = true) int limit) {
		//��ҳ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page-1)*limit);
		map.put("limit", limit);
		List<Manager> managerList = managerService.findByPage(map);
		for(Manager m:managerList) {
			if(m.getMatate().endsWith("1")) {
				m.setMatate("����");
			}
			if(m.getMatate().endsWith("2")) {
				m.setMatate("δ����");
			}
		}
		//manager����
		managerExample.setDistinct(false);
		managerExample.setOrderByClause(null);
		List<Manager> findAll = managerService.findAll(managerExample);
		int pageSize = findAll.size();
		int lastPage;
		if((pageSize%limit)!=0) {
			lastPage = Math.floorDiv(pageSize, limit)+1;
		}else {
			lastPage = Math.floorDiv(pageSize, limit);
		}
		ModelAndView modelAndView = new ModelAndView();
		//����Ա
		modelAndView.addObject("managerList", managerList);
		//��ҳ��
		modelAndView.addObject("pageSize", pageSize);
		//��ǰҳ
		modelAndView.addObject("startPage", page);
		//���һҳ
		modelAndView.addObject("lastPage", lastPage);
		modelAndView.setViewName("background/main_list");
		return modelAndView;
	}
	
	//��ӹ���Ա
	@RequestMapping(value="insert",method = RequestMethod.PUT)
	public String saveManager(Manager manager,String passwd2){
		//�ж��û����Ƿ��ظ�
		Manager managerList = managerService.findByName(manager.getManagername());
		if(managerList !=null) {
			return "redirect:../background/main_info.jsp";
		}else {
			//�ж������Ƿ�һ��
			if(manager.getPasswd().endsWith(passwd2)) {
				try {
					managerService.saveManager(manager);
					return "redirect:list/1";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				return "redirect:../background/main_info.jsp";
			}
		}
		return "redirect:../background/main_info.jsp";
	}
	
	@RequestMapping("findByManagerId/{managerid}")
	public String findByManagerId(Model model,@PathVariable("managerid")int managerid) {
		Manager managerList =  managerService.findByManagerId(managerid);
		model.addAttribute("managerList", managerList);
		return "background/managerUp";
	}
	
	//�༭����Ա
	@RequestMapping(value="update",method = RequestMethod.PUT)
	public String updateManager(Manager manager,Integer managerid,String passwd2) {
		//�����Ƿ�һ��
		if(manager.getPasswd().endsWith(passwd2)) {
			try {
				managerService.updateManager(manager,managerid);
				return "redirect:list/1";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			return "redirect:findByManagerId/"+managerid;
		}
		return "redirect:findByManagerId/"+managerid;
	}
	
	//ɾ������Ա
	@RequestMapping("delete/{managerid}")
	public String deleteManager(@PathVariable("managerid")int managerid) {
		try {
			managerService.deleteManager(managerid);
			return "redirect:../list/1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:../list/1";
	}
	
	//ģ������
	@RequestMapping(value="search",method = RequestMethod.GET)
	public ModelAndView searchByName(String managername,int page,@RequestParam(value = "limit",defaultValue = "10",required = true) int limit) {
		//��ҳ����
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page-1)*limit);
		map.put("limit", limit);
		map.put("managername", managername);
		List<Manager> managerList = managerService.searchByName(map);
		for(Manager m:managerList) {
			if(m.getMatate().endsWith("1")) {
				m.setMatate("����");
			}
			if(m.getMatate().endsWith("2")) {
				m.setMatate("δ����");
			}
		}
		//ȫ��manager������ע��������ȫ�����������ģ���ǲ�ѯ���ԶԲ���
		managerExample.setDistinct(false);
		managerExample.setOrderByClause(null);
		List<Manager> findAll = managerService.findAll(managerExample);
		int pageSize = findAll.size();
		int lastPage;
		if((pageSize%limit)!=0) {
			lastPage = Math.floorDiv(pageSize, limit)+1;
		}else {
			lastPage = Math.floorDiv(pageSize, limit);
		}
		ModelAndView modelAndView = new ModelAndView();
		//����Ա
		modelAndView.addObject("managerList", managerList);
		modelAndView.addObject("managername", managername);
		//��ҳ��
		modelAndView.addObject("pageSize", pageSize);
		//��ǰҳ
		modelAndView.addObject("startPage", page);
		//���һҳ
		modelAndView.addObject("lastPage", lastPage);
		modelAndView.setViewName("background/managerfind");
		return modelAndView;
	}
	
	//���ͷ��
	@RequestMapping(value="setimage",method = RequestMethod.POST)
	public void updateMaimage(HttpServletRequest request,String src,HttpServletResponse response) {
		HttpSession session=request.getSession();
		String managername = (String)session.getAttribute("managername");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("maimage", src);
		map.put("managername", managername);
		try {
			PrintWriter out = response.getWriter();
			out.print(src);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			managerService.updateMaimage(map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value="getimage",method = RequestMethod.POST)
	public void findMaimage(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		String managername = (String)session.getAttribute("managername");
		Manager managerList = managerService.findByName(managername);
		PrintWriter out = response.getWriter();
		out.print(managerList.getMaimage());
	}
	
	//����Ա����
	@RequestMapping(value="count",method =  RequestMethod.POST)
	public void count(HttpServletResponse response) throws IOException {
		managerExample.setDistinct(false);
		managerExample.setOrderByClause(null);
		List<Manager> managerList = managerService.findAll(managerExample);
		int count = managerList.size();
		PrintWriter out = response.getWriter();
		out.print(count);
	}
	

}
