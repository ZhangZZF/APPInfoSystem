package cn.appsys.service.Dev_user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.Dev_user.Dev_userMapper;
import cn.appsys.pojo.Dev_user;

@Service
public class Dev_userServiceImpl implements Dev_userService{

	@Resource
	private Dev_userMapper dev_userMapper;
	@Override
	public Dev_user login(String devCode, String devPassword) throws Exception {
		Dev_user dev_user=null;
		dev_user=dev_userMapper.getLoginUser(devCode);
		if (null!=dev_user) {//登录成功
			//验证密码
			if (!devPassword.equals(dev_user.getDevPassword())) {
				dev_user=null;
			}
		}
		return dev_user;
	}

}
