package cn.appsys.service.Backend_user;

import cn.appsys.pojo.Backend_user;

public interface Backend_userService {
	/**
	 * 用户登录
	 * 
	 */
	public Backend_user login(String userCode,String userPassword) throws Exception;
}
