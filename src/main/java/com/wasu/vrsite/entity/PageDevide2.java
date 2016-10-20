package com.wasu.vrsite.entity;

import java.util.List;

public class PageDevide2<T> {
	
	private int pageIndex;
	private int totalItems;
	private int totalPages;
	private T folders;
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getTotalItems() {
		return totalItems;
	}
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}	
	public void setTotalItems(int totalItems,int pageSize) {
		this.totalItems = totalItems;
		this.totalPages=totalItems/pageSize+1;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public T getFolders() {
		return folders;
	}
	public void setFolders(T folders) {
		this.folders = folders;
	}
	
	
}
