package com.yr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yr.entity.Page;
import com.yr.entity.User;
import com.yr.service.UserService;
import com.yr.util.JsonUtils;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		String pageSize = req.getParameter("pageSize");//每页显示多少条记录
		String pageNo = req.getParameter("pageNo");//显示第几页
		
		
		Page<User> page = new Page<User>();
		page.setPageSize(Integer.valueOf(pageSize));
		page.setPageNo(Integer.valueOf(pageNo));
		
		new UserService().getList(page);
		//page对象已经进行了改变.因为这个是对象地址值传递
		System.out.println(page);
		String pageString = JsonUtils.beanToJson(page);
		resp.getWriter().write(pageString);
	
		
		//String jsonStr = JsonUtils.beanListToJson(list);
		//resp.getWriter().write(jsonStr);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
