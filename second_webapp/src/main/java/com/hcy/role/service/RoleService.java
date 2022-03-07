package com.hcy.role.service;

import java.util.List;

import com.hcy.ariticle.bean.Role;

public interface RoleService {
	
   public List<Role>  findRoleByUid(Role role);
   
}
