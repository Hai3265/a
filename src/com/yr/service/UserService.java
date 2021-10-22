package com.yr.service;

import com.yr.dao.UserDao;
import com.yr.entity.Page;
import com.yr.entity.User;

public class UserService {
	public void getList(Page<User> page)
	{
		new UserDao().getList(page);
	}
	
	public int addUser(User user)
	{
		return new UserDao().addUser(user);
	}
	
	public void delete(int id)
	{
		new UserDao().delete(id);
	}
	
	public User getUserById(int id)
	{
		return new UserDao().getUserById(id);
	}
	
	public void updateUser(User user)
	{
		new UserDao().updateUser(user);
	}
}
