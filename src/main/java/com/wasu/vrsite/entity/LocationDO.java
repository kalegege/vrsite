package com.wasu.vrsite.entity;

import lombok.Data;

@Data
public class LocationDO {
	
	private double lng;
	
	private double lat;

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}
}
