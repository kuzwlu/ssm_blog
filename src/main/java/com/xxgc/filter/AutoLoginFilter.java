package com.xxgc.filter;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.xxgc.po.Manager;
import com.xxgc.service.ManagerService;
import com.xxgc.utils.AESUtil;

@Component
public class AutoLoginFilter implements Filter{

	@Resource
	private ManagerService managerService;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		String autologin = null;
		for(int i = 0;cookies != null && i<cookies.length;i++){
			if("autologin".equals(cookies[i].getName())){
   				autologin = cookies[i].getValue();
   				break;
   			}
		}
		if(autologin != null){
			String[] parts = autologin.split("-");
			String managername = parts[0];
			String password = parts[1];
			managername = AESUtil.decrypt(managername);
			password = AESUtil.decrypt(password);
			Manager managerList = managerService.findByName(managername);
			if(managerList !=null) {
				if(managerList.getMatate().endsWith("1")) {
					if(managerList.getPasswd().endsWith(password)) {
						session.setAttribute("managername", managername);
					}
				}
			}
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}
