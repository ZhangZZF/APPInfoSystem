package cn.appsys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.Backend_user;
import cn.appsys.pojo.Dev_user;
import cn.appsys.service.Backend_user.Backend_userService;
import cn.appsys.tools.Constants;
@Controller
public class Backend_userLoginController {
	private Logger logger=Logger.getLogger(Backend_userLoginController.class);
	@Resource
	private Backend_userService backend_userService;
	//点击后台跳转到登录页面
	@RequestMapping(value="/backenddologin")
	public String dologin(){
		return "/backendlogin";
	}
	//登录验证
	@RequestMapping(value="/backendlogin",method=RequestMethod.POST)
	public String dologin(@RequestParam String userCode,
			@RequestParam String userPassword,
			HttpServletRequest request,
			HttpSession session)throws Exception{
		Backend_user backend_user=backend_userService.login(userCode, userPassword);
		if (null!=backend_user) {
			session.setAttribute(Constants.USER_SESSION, backend_user);
			return "/backend/main";
		}else{
			request.setAttribute("error", "用户名或密码不正确");
			return "/backendlogin";
		}
	}
}
