package com.wasu.vrsite.entity;

import lombok.Data;

@Data
public class GeoSearchDTO {
	
	private int uid;
	
	private String geotable_id;
	
	private String title;
	
	private String address;
	
	private String province;
	
	private String city;
	
	private String district;
	
	private int coord_type;
	
	private double[] location;
	
	private String 	tags;
	
	private int distance;
	
	private int weight; 
}
