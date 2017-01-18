package com.muke.employee.domain;

import java.util.List;

//	for fenye class
public class PageBean<T> {
	private int currPage;
	private int pageSize;	//  num of records display in each page
	private int totalCount;	//	num of all the records
	private int totalPage;	//	num of all the pages
	private List<T> list;	//	the data in each page
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
