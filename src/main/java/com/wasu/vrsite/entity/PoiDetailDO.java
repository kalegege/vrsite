package com.wasu.vrsite.entity;


public class PoiDetailDO {
	
	private String title;
	
	private double[] location;
	
	private String city;
	
	private String create_time;
	
	private int geotable_id;
	
	private String address;
	
	private String province;
	
	private String district;
	
	private double[] gcj_location;
	
	private int city_id;
	
	private int id;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double[] getLocation() {
		return location;
	}

	public void setLocation(double[] location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public int getGeotable_id() {
		return geotable_id;
	}

	public void setGeotable_id(int geotable_id) {
		this.geotable_id = geotable_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public double[] getGcj_location() {
		return gcj_location;
	}

	public void setGcj_location(double[] gcj_location) {
		this.gcj_location = gcj_location;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
