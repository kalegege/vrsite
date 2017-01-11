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


	public String getFormatted_address() {
		return formatted_address;
	}

	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getSematic_description() {
		return sematic_description;
	}

	public void setSematic_description(String sematic_description) {
		this.sematic_description = sematic_description;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public LocationDO getLocation() {
		return location;
	}

	public void setLocation(LocationDO location) {
		this.location = location;
	}

	public AddressDO getAddressComponent() {
		return addressComponent;
	}

	public void setAddressComponent(AddressDO addressComponent) {
		this.addressComponent = addressComponent;
	}

	public List<PoisDO> getPois() {
		return pois;
	}

	public void setPois(List<PoisDO> pois) {
		this.pois = pois;
	}

	public List<RegionDO> getPoiRegions() {
		return poiRegions;
	}

	public void setPoiRegions(List<RegionDO> poiRegions) {
		this.poiRegions = poiRegions;
	}
}
