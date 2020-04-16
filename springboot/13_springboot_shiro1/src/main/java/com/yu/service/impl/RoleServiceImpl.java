package com.yu.service.impl;

import com.yu.domain.Role;
import com.yu.mapper.RoleMapper;
import com.yu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<String> queryRoleByUserId(Integer userId) {
		List<Role> list = roleMapper.queryRolesByUserId(userId);
		List<String> roles=new ArrayList<String>();
		for (Role role : list) {
			roles.add(role.getRolename());
		}
		return roles;
	}


}
