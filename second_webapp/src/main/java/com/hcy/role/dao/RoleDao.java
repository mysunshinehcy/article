package com.hcy.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcy.ariticle.bean.Role;
import com.hcy.role.service.RoleService;
import com.hcy.utils.ConnectionUtil;

public class RoleDao implements RoleService{

	public RoleDao() {
		
	}

	@Override
	public List<Role> findRoleByUid(Role role) {
		List<Role>  list = new ArrayList<Role>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from role r where r.user_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, role.getUid());
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Role rolein = new Role();
				rolein.setRid(rs.getInt("r_id"));
				rolein.setR_name(rs.getString("role_name"));
				rolein.setUid(rs.getInt("user_id"));
				list.add(rolein);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public void testFindRoleByUid() {
		Role role = new Role();
		role.setUid(1);
		List<Role>  list = findRoleByUid( role);
		for(int i = 0 ; i < list.size() ; i ++) {
			Role roler = list.get(i);
			
				System.out.println(roler.toString());	
		}
		
	}
	
	public static void main(String[] args) {
		RoleDao roleDao = new RoleDao();
		roleDao.testFindRoleByUid();
		
	}

}
