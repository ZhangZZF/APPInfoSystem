package cn.appsys.service.Dev_user;

import cn.appsys.pojo.Dev_user;

public interface Dev_userService {
	 Dev_user login(String devCode,String devPassword) throws Exception;
}
