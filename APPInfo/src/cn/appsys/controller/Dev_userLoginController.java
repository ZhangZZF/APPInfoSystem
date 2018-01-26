package cn.appsys.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import cn.appsys.pojo.Dev_user;
import cn.appsys.service.Dev_user.Dev_userService;
import cn.appsys.tools.Constants;
@Controller
public class Dev_userLoginController {
	private Logger logger=Logger.getLogger(Backend_userLoginController.class);
	@Resource
	private Dev_userService dev_userService;
	@RequestMapping(value="/devdologin")
	public String dologin(){
		return "/devlogin";
	}
	@RequestMapping(value="/devmain",method=RequestMethod.POST)
	public String dologin(@RequestParam String devCode,
			@RequestParam String devPassword,
			HttpServletRequest request,
			HttpSession session)throws Exception{
		Dev_user dev_user = null;
		dev_user = dev_userService.login(devCode, devPassword);
		if (null != dev_user) {
			session.setAttribute(Constants.USER_SESSION, dev_user);
			return "/developer/main";
		}else{
			request.setAttribute("error", "用户名或密码不正确");
			return "/devlogin";
		}
	}
}
