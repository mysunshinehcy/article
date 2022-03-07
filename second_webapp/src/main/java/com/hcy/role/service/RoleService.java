package com.hcy.role.service;

import java.util.List;

import com.hcy.ariticle.bean.Role;
import com.hcy.ariticle.bean.User;

public interface RoleService {
	

   
   public List<Role>  findRoles();
   
   public List<Role>  findRole(List<Role> list);
   
   
   
}
