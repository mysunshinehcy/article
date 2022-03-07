package com.hcy.role.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hcy.ariticle.bean.Role;
import com.hcy.ariticle.bean.User;
import com.hcy.role.service.RoleService;
import com.hcy.utils.ConnectionUtil;

public class RoleDao implements RoleService{

	public RoleDao() {
		
	}


	
	
	

	
	public static void main(String[] args) {
	
		/*RoleDao roleDao = new RoleDao();
		List<Role>  list = roleDao.findRoles();
		for(Role role:list) {
			System.out.println("role_id:"+role.getRid()+",role_name:"+ role.getR_name());
		}*/
		
		RoleDao roleDao = new RoleDao();
		
		roleDao.testFindRoles();
			
		/*List<Role>  li = new ArrayList<Role>();
		Role rol1 = new Role();
		rol1.setRid(2);
		Role rol2 = new Role();
		rol2.setRid(3);
		li.add(rol1);
		li.add(rol2);
		
		String uids = "";
		for(Role role : li) {
			uids+= role.getRid()+",";
		}
		uids = uids.substring(0, uids.length() -1 );
		System.out.println("uids = " + uids);*/
	}

	public void testFindRoles() {
		 
		RoleDao roleDao = new RoleDao();
		List<Role> li = new ArrayList<Role>();
		Role rol1 = new Role();
		rol1.setRid(2);
		Role rol2 = new Role();
		rol2.setRid(3);
		li.add(rol1);
		li.add(rol2);
		
		List<Role> list = roleDao.findRole(li);
		for(Role rolebn :list) {
			System.out.println("rolebn name :" + rolebn.getR_name());
		}
	}
	
	@Override
	public List<Role> findRoles() {
		
		List<Role>  list = new ArrayList<Role>();
		Connection conn = ConnectionUtil.getConn();
		String sql = "select * from role";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet  rs = pstmt.executeQuery();
			while(rs.next()) {
				Role role = new Role();
				role.setRid(rs.getInt("r_id"));
				role.setR_name(rs.getString("role_name"));
				list.add(role);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return list;
	}







	@Override
	public List<Role> findRole(List<Role> roles) {
		List<Role>  list = new ArrayList<Role>();
		Connection conn = ConnectionUtil.getConn();
		
		for(Role role : roles) {
			String sql = "select * from role r where r_id  = ? ";	
			
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, role.getRid());
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					Role rolem = new Role();
					rolem.setR_name(rs.getString("role_name"));
					rolem.setRid(rs.getInt("r_id"));
					list.add(rolem);
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return list;
	}

}
