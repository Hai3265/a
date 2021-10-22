package com.yr.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yr.entity.User;
import com.yr.service.UserService;

@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("addName");
		String sex = req.getParameter("addSex");
		String addr = req.getParameter("addAddr");
		String likes = req.getParameter("addLikes");
		
		User user = new User();
		user.setName(name);
		user.setSex(sex);
		user.setAddr(addr);
		user.setLikes(likes);
		
		//返回的ID
		int id = new UserService().addUser(user);
		String jsonStr = "{\"id\":"+id+"}";
		resp.getWriter().write(jsonStr);
		
	}
}
