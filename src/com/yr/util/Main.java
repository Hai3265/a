package com.yr.util;

import java.util.Date;

import com.yr.entity.User;

public class Main {
	public static void main(String[] args) {
		User user = new User();
		user.setId(1);
		user.setName("aaa");
		user.setLikes("bbb");
		user.setAddr("ccc");
		user.setDate(new Date());
		
		
		String str = JsonUtils.beanToJson(user);
		System.out.println(str);
	}
}
