package cn.appsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.appsys.pojo.Backend_user;
import cn.appsys.tools.Constants;


public class Syslnterceptor extends HandlerInterceptorAdapter{
	private Logger logger=Logger.getLogger(Syslnterceptor.class);
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response,Object handler)throws Exception{
		logger.debug("Syslnterceptor preHandle");
		HttpSession session=request.getSession();
		 Backend_user backend_user=(Backend_user)session.getAttribute(Constants.USER_SESSION);
		if (null==backend_user) {
			response.sendRedirect(request.getContextPath()+"/401.jsp");
			return false;
		}
		return true;
	}
}
