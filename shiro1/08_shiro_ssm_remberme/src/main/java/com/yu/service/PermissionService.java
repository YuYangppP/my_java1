package com.yu.service;


import java.util.List;


public interface PermissionService {
	
	/**
	 * 根据用户Id查询用户拥有的权限
	 * @param userid
	 * @return
	 */
	List<String> queryPermissionsByUserId(Integer userid);

}
