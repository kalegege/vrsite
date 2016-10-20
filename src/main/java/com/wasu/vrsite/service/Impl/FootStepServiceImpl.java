package com.wasu.vrsite.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wasu.vrsite.dao.FootStepMapper;
import com.wasu.vrsite.entity.FootStep;
import com.wasu.vrsite.entity.FootStepExample;
import com.wasu.vrsite.service.IFootStepService;

@Service("iFootStepService")
public class FootStepServiceImpl implements IFootStepService{
	
	@Resource
	private FootStepMapper footStepMapper;


	@Override
	public int insert(FootStep footStep) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FootStep> selectBySiteId(String IMEI, String cityId) {
		// TODO Auto-generated method stub
		int imei=Integer.parseInt(IMEI);
		int cityid=Integer.parseInt(cityId);
		FootStepExample footStepExample=new FootStepExample();
		FootStepExample.Criteria criteria=footStepExample.createCriteria();
		criteria.andImeiEqualTo(imei).andCityIdEqualTo(cityid);
		return footStepMapper.selectByExample(footStepExample);
	}

	@Override
	public int updateByHotelId(String IMEI, String hotelId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
