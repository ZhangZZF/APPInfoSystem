package cn.appsys.service.Backend_user;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.Backend_user.Backend_userMapper;
import cn.appsys.pojo.Backend_user;

@Service
public class Backend_userServiceImpl implements Backend_userService{

	@Resource
	private Backend_userMapper backend_userMapper;
	@Override
	public Backend_user login(String userCode, String userPassword)
			throws Exception {
		Backend_user backend_user=null;
		backend_user=backend_userMapper.getLoginUser(userCode);
		if (null!=backend_user) {
			if (!backend_user.getUserPassword().equals(userPassword)) {
				backend_user=null;
			}
		}
		return backend_user;
	}

}
