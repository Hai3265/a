package com.yr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yr.entity.Page;
import com.yr.entity.User;
import com.yr.util.DBUtil;

public class UserDao {
	//查询所有，到时这里还需要加分页
	public void getList(Page<User> page)
	{
		List<User> list = new ArrayList<User>();
		
		try{
			Connection conn = DBUtil.getCons();
			String sqlCount = "select count(*) from user";
			PreparedStatement ps1 = conn.prepareStatement(sqlCount);
			ResultSet rs1 = ps1.executeQuery();
			rs1.next();
			
			//总记录数
			int sum = rs1.getInt(1);
				
			
			int start = (page.getPageNo() - 1) * page.getPageSize();
			String sql = "select * from user limit ?,?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, page.getPageSize());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setAddr(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setLikes(rs.getString(5));
				user.setDate(rs.getDate(6));
				
				list.add(user);
			}
			page.setList(list);//我们现在需要查询总页面,先需要查询总条数
			page.setSum(sum);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}
	
	//新增用户
	public int addUser(User user)
	{
		String sql = "insert into user(name,addr,sex,likes) values(?,?,?,?);";
		Connection conn = DBUtil.getCons();
		try {
			PreparedStatement ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getName());
			ps.setString(2, user.getAddr());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getLikes());
			ps.executeUpdate();
			
			
			//返回新增的ID
			ResultSet rs = ps.getGeneratedKeys();
			int id = 0;
	        if (rs.next()) {
	           id  = rs.getInt(1);
	        }
	        
	        return id;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}
	
	public void delete(int id)
	{
		String sql = "delete from user where id = ?";
		Connection conn = DBUtil.getCons();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User getUserById(int id)
	{
		try{
			String sql = "select * from user where id = ?";
			Connection conn = DBUtil.getCons();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setAddr(rs.getString(3));
				user.setSex(rs.getString(4));
				user.setLikes(rs.getString(5));
				return user;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateUser(User user)
	{
		String sql = "update user set name =?,addr=?,sex=?,likes = ? where id = ?";
		Connection conn = DBUtil.getCons();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2,user.getAddr());
			ps.setString(3, user.getSex());
			ps.setInt(5, user.getId());
			ps.setString(4, user.getLikes());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
