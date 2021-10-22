package com.yr.entity;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {
	private int pageSize;//每页显示多少条记录
	private int pageNo;//当前第几页
	private int pageCount;//总页数
	private int sum;//总条数
	private List<T> list = new ArrayList<T>();//数据集合
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	//返回总页数
	public int getPageCount() {
		if(sum % pageSize ==0)
		{
			return sum /pageSize;
		}
		else
		{
			return sum /pageSize + 1;
		}
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	public static void main(String[] args) {
		System.out.println(11/5);
	}
}
