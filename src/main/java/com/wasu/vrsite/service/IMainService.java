package com.wasu.vrsite.service;

import com.wasu.vrsite.entity.HotelDO;
import com.wasu.vrsite.entity.PageDevide2;
import com.wasu.vrsite.entity.Result;
import com.wasu.vrsite.exception.MyException;

public interface IMainService {
	//通过城市ID获取默认酒店详细信息
	Result<PageDevide2<HotelDO>> getDefaultHotel(String cityId,Integer pageIndex, Integer pageSize);
	
	//通过酒店ID获取酒店详细信息
	Result<PageDevide2<HotelDO>> getHotelById(String id,Integer pageIndex, Integer pageSize) throws MyException;

	//通过经度和纬度获取最近酒店接口
	//Result<PageDevide2<HotelDO>> getHotelByEarth(String id,Integer pageIndex, Integer pageSize) throws MyException;
}
