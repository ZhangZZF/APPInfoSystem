package cn.appsys.dao.Backend_user;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.Backend_user;

public interface Backend_userMapper {
	public Backend_user getLoginUser(@Param("userCode")String userCode) throws Exception;
}
