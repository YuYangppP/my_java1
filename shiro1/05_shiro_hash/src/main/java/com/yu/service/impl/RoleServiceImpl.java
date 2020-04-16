package com.yu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.yu.service.RoleService;

public class RoleServiceImpl implements RoleService {

	public List<String> queryRolesByUserName(String username) {
		List<String> roles=new ArrayList<String>();
		roles.add("role1");
		roles.add("role2");
		roles.add("role3");
		return roles;
	}

}
