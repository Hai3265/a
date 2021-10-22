package com.yr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yr.entity.User;
import com.yr.service.UserService;
import com.yr.util.JsonUtils;

@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		String strId = req.getParameter("id");
		int id = Integer.valueOf(strId);
		User user = new UserService().getUserById(id);
		String jsonStr = JsonUtils.beanToJson(user);
		resp.getWriter().write(jsonStr);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("updateName");
		String sex = req.getParameter("updateSex");
		String addr = req.getParameter("updateAddr");
		String likes = req.getParameter("updateLikes");
		String id = req.getParameter("updateId");
		
		User user = new User();
		user.setId(Integer.valueOf(id));
		user.setName(name);
		user.setSex(sex);
		user.setAddr(addr);
		user.setLikes(likes);
		
		new UserService().updateUser(user);
	}
}
