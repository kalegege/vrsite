package com.wasu.vrsite.entity;

import java.util.List;

import lombok.Data;

@Data
public class GeocoderDTO {
	private String formatted_address;
	
	private String business;
	
	private String sematic_description;
	
	private int cityCode;
	
	private LocationDO location;
	
	private AddressDO addressComponent;
	
	private List<PoisDO> pois;
	
	private List<RegionDO> poiRegions;

}
