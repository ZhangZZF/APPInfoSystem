package cn.appsys.service.app_info;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.App_info.App_infoMapper;
import cn.appsys.pojo.App_info;

@Service
public class App_infoServiceImpl implements App_infoService{
	
	@Resource
	private App_infoMapper app_infoMapper;

	@Override
	public List<App_info> app_infolist() {
		return app_infoMapper.app_infolist();
	}

}
