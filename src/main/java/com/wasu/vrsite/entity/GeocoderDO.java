package com.wasu.vrsite.entity;

import lombok.Data;

@Data
public class GeocoderDO {
	private int status;
	
	private GeocoderDTO result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public GeocoderDTO getResult() {
		return result;
	}

	public void setResult(GeocoderDTO result) {
		this.result = result;
	}
}
