package com.wasu.vrsite.service;

import java.util.List;

import com.wasu.vrsite.entity.BaseDO;
import com.wasu.vrsite.entity.FootStep;
import com.wasu.vrsite.entity.FootStepDO;
import com.wasu.vrsite.entity.PageDevide2;
import com.wasu.vrsite.entity.Result;
import com.wasu.vrsite.entity.SiteDO;

public interface IFootStepService {
	
	List<FootStep> selectBySiteId(String IMEI,String cityId);
	
	public int updateByHotelId(String IMEI,String hotelId); 
	
	public int insert(FootStep footStep); 
	
	//增加记录
	public int addFootStep(String IMEI,String longitude,String latitude,BaseDO baseDO);

	//查找记录
	public Result<List<FootStepDO>> getFootStep(String iMEI,int status);

	public Result<List<FootStepDO>> getFootStephotel(String iMEI,int status);
	
	public Result<List<FootStepDO>> getFootSteptravel(int status);
	
}
