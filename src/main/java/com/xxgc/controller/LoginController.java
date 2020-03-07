package com.xxgc.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xxgc.po.Manager;
import com.xxgc.service.ManagerService;
import com.xxgc.utils.AESUtil;
import com.xxgc.utils.RandomValidateCode;

/**
 * 登录登出
 * @author 花怜
 *
 */
@Controller
public class LoginController {
	
	@Resource
	private ManagerService managerService;

	
	@RequestMapping(value="/code")
	public void code(HttpServletResponse response,HttpServletRequest request) {
		response.setContentType("image/jpeg");
        
        //设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expire", 0);
        
        RandomValidateCode randomValidateCode = new RandomValidateCode();
        try {
            randomValidateCode.getRandcode(request, response);//输出图片方法
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(HttpServletRequest request,HttpServletResponse response,String managername,String password,HttpSession session,String code,String autologin) throws Exception{
		Manager managerList = managerService.findByName(managername);
		String randomcode_key = (String) session.getAttribute("randomcode_key");
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(randomcode_key.endsWith(code)) {
			if(managerList != null) {
				//判断用户是否启用
				if(managerList.getMatate().endsWith("1")) {
					if(managerList.getPasswd().endsWith(password)) {
						session.setAttribute("managername", managername);
						request.setAttribute("password", password);
						request.setAttribute("autologin", autologin);
					}else {
						out.flush();
					    out.println("<script>");
					    out.println("alert('密码错误！');");
					    out.println("history.back();");
					    out.println("</script>");
					}
				}else {
					out.flush();
				    out.println("<script>");
				    out.println("alert('用户已禁用！');");
				    out.println("history.back();");
				    out.println("</script>");
				}
			}else {
				out.flush();
			    out.println("<script>");
			    out.println("alert('用户不存在！');");
			    out.println("history.back();");
			    out.println("</script>");
			}
		}else {
			out.flush();
		    out.println("<script>");
		    out.println("alert('验证码错误！');");
		    out.println("history.back();");
		    out.println("</script>");
		}
		return "forward:autologin";
	}
	
	//autoligin
	@RequestMapping("autologin")
	public String autologin(HttpServletRequest request,HttpSession session,HttpServletResponse response,String password,String autologin) throws IOException {
		String path = request.getContextPath()+"/background/login.jsp";
		String managername = (String) session.getAttribute("managername");
		password = AESUtil.encrypt(password);
		managername = AESUtil.encrypt(managername);
		if(managername == null) {
			response.sendRedirect(path);
		}else {
			//获取所有的cookie，并将这些cookie存放在数组中
	   		Cookie[] cookies = request.getCookies();
	   		String LastAccessTime = null;
	   		String cnumber = "1";
	   		//遍历cookie数组
		   	for(int i=0;cookies!=null && i<cookies.length;i++) {
		   		if((cookies[i].getName()).endsWith("lastAccess")) {
		   			LastAccessTime = cookies[i].getValue();
		   			break;
		   		}
		   	}
		   	for(int i=0;cookies!=null && i<cookies.length;i++) {
		   		//如果cookie的名称为lastAccess，则获取该cookie的值
		   		if("number".equals(cookies[i].getName())){
		   			int numbers = Integer.parseInt(cookies[i].getValue())+1;
		   			cnumber = numbers+"";
		   			break;
		   		}
		   	}
		   	if(LastAccessTime == null) {
		   		LastAccessTime = "First-Login!";
		   	}
		   	String nowtime = new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss").format(new Date());
		   	Cookie cookienowtime = new Cookie("nowtime", nowtime);
	   		Cookie cookietime = new Cookie("lastAccess", LastAccessTime);
	   		
		   	Cookie cookienumber = new Cookie("number", cnumber);
			Cookie cookieautologin = new Cookie("autologin", managername + "-"+password);
			cookieautologin.setMaxAge(Integer.parseInt(autologin));
			cookienumber.setMaxAge(999999999);
			cookienowtime.setMaxAge(999999999);
	   		cookietime.setMaxAge(999999999);
	   		response.addCookie(cookietime);
	   		response.addCookie(cookienowtime);
			response.addCookie(cookieautologin);
			response.addCookie(cookienumber);
		}
		return "redirect:/background/index.jsp";
	}
	
	//登出
	@RequestMapping(value="loginout")
	public void loginout(HttpServletRequest request,HttpSession session,HttpServletResponse response) throws IOException {
		session.removeAttribute("managername");
		Cookie[] cookies = request.getCookies();
		String nowtime = null;
		for(int i=0;cookies!=null && i<cookies.length;i++) {
   			//如果cookie的名称为lastAccess，则获取该cookie的值
   			if((cookies[i].getName()).endsWith("nowtime")) {
   				nowtime = cookies[i].getValue();
   				break;
   			}
		}		
		Cookie autologin = new Cookie("autologin", "msg");
		autologin.setMaxAge(0);
		response.addCookie(autologin);
		
		Cookie cookie = new Cookie("lastAccess", nowtime);
		cookie.setMaxAge(999999999);
		response.addCookie(cookie);
		String path = request.getContextPath()+"/background/login.jsp";
		response.sendRedirect(path);
	}
}
