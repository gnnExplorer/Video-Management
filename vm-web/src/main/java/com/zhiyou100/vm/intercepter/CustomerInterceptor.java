package com.zhiyou100.vm.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomerInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res, Object arg2, ModelAndView arg3)
			throws Exception {
		

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		
		boolean b = true;
		/*String str = req.getServletPath();
		if(req.getSession().getAttribute("admin")==null){
			if(str.equals("/admin/login.action")){
				b=true;
			}else{
				res.sendRedirect(req.getContextPath()+"/index.jsp");
				b=false;
			}		
		}*/
		String str = req.getServletPath();
		//System.out.println(str);
		if(req.getSession().getAttribute("admin")==null && str.endsWith(".action")){
			res.sendRedirect(req.getContextPath()+"/index.jsp");
			b=false;
		}
		return b;
	}

}
