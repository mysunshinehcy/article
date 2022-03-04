package com.hcy.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.hcy.ariticle.bean.User;


public class TestGson {

	public TestGson() {
		
	}
	
	public static void main(String[] args) {
		User user =  new User();
		user.setPassword("ass");
		user.setUsername("aaaa");
		List<User> list = new ArrayList<User>();
		list.add(user);
		Gson gson=new Gson();

		String result = gson.toJson(list);
		System.out.println("result = "+ result);
	}
	


}
