package com.vcg.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonObject;
import com.vcg.boss.user.model.UInterUser;
import com.vcg.boss.feignClient.Boss_accountbaseClient;
import com.vcg.boss.user.model.UInterUser;

import com.vcg.config.SpringUtils;

@Component
public class AuthInterceptor implements HandlerInterceptor{

	
	@Autowired
	private Boss_accountbaseClient boss_accountbaseClient;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//允许跨域访问
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Allow", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
		response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
		response.addHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");
		
		if(true){return true;}
		//过滤url
		String url = request.getRequestURI();
		if(url.indexOf("/indexing")!=-1||url.indexOf("/outInterface")!=-1||url.indexOf("/me")!=-1
				||url.indexOf("/health")!=-1||url.indexOf("/configuration/ui")!=-1 
						||url.indexOf("/v2/api-docs")!=-1||url.indexOf("/swagger-resources")!=-1){
			return true;
		}
		
	/*	if(true)
			return true;
		*/
		
		String token = request.getParameter("token");
		
		JsonObject result=new JsonObject();
		//token 为null
		if(StringUtils.isBlank(token)){
			result.addProperty("status", 300);
			result.addProperty("msg", "token is null");
			response.getWriter().write(result.toString());
			response.getWriter().flush();
			return false;
		}
		
		HttpSession session = request.getSession();
		//session 有此用户 说明已经登录
		Object user = session.getAttribute(token);
		if(user!=null){
			return true;
		}
		
 
		
		UInterUser person = boss_accountbaseClient.getUInterUserByUcToken(token);
		
		if(person==null){
			result.addProperty("status", 300);
			result.addProperty("msg", "token is erro");
			
			response.getWriter().write(result.toString());
			response.getWriter().flush();
			return false;
			
		}else{
			session.setAttribute(token, person);
			return true;
		}
	
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
