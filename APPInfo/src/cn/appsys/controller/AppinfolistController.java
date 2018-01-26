package cn.appsys.controller;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.appsys.pojo.App_info;
import cn.appsys.service.app_info.App_infoService;

@Controller
public class AppinfolistController {
	@Resource
	private App_infoService app_infoService;
	
	@RequestMapping("/appinfolist")
	public String app_infolist(Model model){
		List<App_info> list = null;
		list = app_infoService.app_infolist();
		model.addAttribute("list",list);
		return "/developer/appinfolist";
	}
}
