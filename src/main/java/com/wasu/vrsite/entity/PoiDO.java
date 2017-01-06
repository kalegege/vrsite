package com.wasu.vrsite.entity;


public class PoiDO {
	private int status;
	
	private String message;
	
	private PoiDetailDO poi;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public PoiDetailDO getPoi() {
		return poi;
	}

	public void setPoi(PoiDetailDO poi) {
		this.poi = poi;
	}
	
	

}
