package cn.appsys.dao.Dev_user;

import org.apache.ibatis.annotations.Param;

import cn.appsys.pojo.Dev_user;


public interface Dev_userMapper {
	public Dev_user getLoginUser(@Param("devCode") String devCode) throws Exception;

}
