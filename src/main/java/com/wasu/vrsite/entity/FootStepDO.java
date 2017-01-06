package com.wasu.vrsite.entity;


public class FootStepDO {
	
    private Integer id;
    
    private String name;
	
	//private String hotelName;
	
	private int hotelId;
	
	//private String cityName;
	
	private int cityId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	
}
