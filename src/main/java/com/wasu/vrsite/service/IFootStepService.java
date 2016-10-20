package com.wasu.vrsite.service;

import java.util.List;

import com.wasu.vrsite.entity.FootStep;

public interface IFootStepService {
	
	public List<FootStep> selectBySiteId(String IMEI,String cityId); 
	
	public int updateByHotelId(String IMEI,String hotelId); 
	
	public int insert(FootStep footStep); 
	
}
