package com.wasu.vrsite.entity;


import java.util.List;

import com.wasu.vrsite.entity.GeoSearchDTO;

public class GeoSearchDO {
	
	private int status;
	
	private int size;
	
	private int total;
	
	private List<GeoSearchDTO> contents;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<GeoSearchDTO> getContents() {
		return contents;
	}

	public void setContents(List<GeoSearchDTO> contents) {
		this.contents = contents;
	}
	
	
}
