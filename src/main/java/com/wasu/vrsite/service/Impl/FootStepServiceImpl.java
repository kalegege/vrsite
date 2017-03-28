package com.wasu.vrsite.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wasu.vrsite.controller.IndexController;
import com.wasu.vrsite.dao.CityHotelMapper;
import com.wasu.vrsite.dao.FootStepMapper;
import com.wasu.vrsite.entity.BaseDO;
import com.wasu.vrsite.entity.CityHotel;
import com.wasu.vrsite.entity.CityHotelExample;
import com.wasu.vrsite.entity.FootStep;
import com.wasu.vrsite.entity.FootStepDO;
import com.wasu.vrsite.entity.FootStepExample;
import com.wasu.vrsite.entity.PageDevide2;
import com.wasu.vrsite.entity.Result;
import com.wasu.vrsite.service.IFootStepService;

@Service("iFootStepService")
public class FootStepServiceImpl implements IFootStepService {
	
	private static Logger logger = Logger.getLogger(FootStepServiceImpl.class.getName());

	@Resource
	private FootStepMapper footStepMapper;
	@Resource
	private CityHotelMapper cityHotelMapper;

	@Override
	public int insert(FootStep footStep) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<FootStep> selectBySiteId(String IMEI, String cityId) {
		int cityid = Integer.parseInt(cityId);
		FootStepExample footStepExample = new FootStepExample();
		FootStepExample.Criteria criteria = footStepExample.createCriteria();
		criteria.andImeiEqualTo(IMEI).andUidEqualTo(cityid);
		return footStepMapper.selectByExample(footStepExample);
	}

	@Override
	public int updateByHotelId(String IMEI, String hotelId) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 添加足迹
	@Override
	public int addFootStep(String IMEI,String longitude,String latitude, BaseDO baseDO) {
		// TODO Auto-generated method stub
		int result = 0;
		int imei = 000000000;
		if (IMEI != null) {

			String name = baseDO.getName();
			int uid = baseDO.getUid();
			int status = baseDO.getStatus();
			FootStepExample footStepExample = new FootStepExample();
			FootStepExample.Criteria criteria = footStepExample.createCriteria();
			criteria.andUidEqualTo(uid).andStatusEqualTo(status).andImeiEqualTo(IMEI);
			FootStep footStep = new FootStep();
			footStep.setUid(uid);
			//footStep.setName(name);
			footStep.setStatus(status);
			footStep.setImei(IMEI);
			if(longitude != null){
				footStep.setLongitude(longitude);
			}
			if(latitude != null){
				footStep.setLatitude(latitude);
			}
			
			logger.info(name+footStep.getName() +":"+imei+footStep.getImei());
			int num = footStepMapper.updateByExampleSelective(footStep, footStepExample);
			if (num == 0) {
				try {
					footStep.setName(name);
					logger.info(name+footStep.getName() +":"+imei+footStep.getImei());
					footStepMapper.insert(footStep);
				} catch (Exception e) {
					System.out.println("error" + footStep);
				}
				result = 1;
			}
		}
		return result;
	}

	@Override
	public  Result<List<FootStepDO>> getFootStep(String iMEI,int status) {
		// TODO Auto-generated method stub
		Result<List<FootStepDO>> result=new Result<List<FootStepDO>>(0);
		FootStepExample footStepExample = new FootStepExample();
		FootStepExample.Criteria criteria = footStepExample.createCriteria();
		criteria.andStatusEqualTo(status);
		footStepExample.setOrderByClause("gm_modified desc");
	
		try{
			criteria.andImeiEqualTo(iMEI);
			List<FootStep> datas=footStepMapper.selectByExample(footStepExample);
			List<FootStepDO> data=new ArrayList<FootStepDO>();
						
			//1表示酒店足迹2表示旅游足迹
			if((status == 1)&&(datas.size() > 0)){
				
				for(FootStep kk:datas){
					FootStepDO dataes=new FootStepDO();
					dataes.setId(kk.getId());
					//dataes.setCityName(cityName);
					dataes.setHotelId(kk.getUid());
					dataes.setName(kk.getName());
					//dataes.setHotelName(hotelName);
					
					//添加酒店所属的城市
					CityHotelExample cityHotelExample=new CityHotelExample();
					CityHotelExample.Criteria criteria3=cityHotelExample.createCriteria();
					criteria3.andHotelIdEqualTo(dataes.getHotelId());
					
					List<CityHotel> cityHotel=cityHotelMapper.selectByExample(cityHotelExample);
					CityHotel tt=cityHotel.get(0);
					dataes.setCityId(tt.getCityId());
					data.add(dataes);
				}
				
				result.setMessage("酒店足迹获取成功");
				result.setSuccess(1);
				result.setCode("1");
			}else if((status == 4)&&(datas.size() > 0)){
				
				for(FootStep kk:datas){
					FootStepDO dataes=new FootStepDO();
					dataes.setId(kk.getId());
					//dataes.setCityName(cityName);
					dataes.setCityId(kk.getUid());
					//dataes.setHotelId(kk.getUid());
					dataes.setName(kk.getName());
					//dataes.setHotelName(hotelName);
					
					//添加酒店所属的城市
					CityHotelExample cityHotelExample=new CityHotelExample();
					CityHotelExample.Criteria criteria3=cityHotelExample.createCriteria();
					criteria3.andCityIdEqualTo(dataes.getCityId());
					
					List<CityHotel> cityHotel=cityHotelMapper.selectByExample(cityHotelExample);
					CityHotel tt=cityHotel.get(0);
					dataes.setHotelId(tt.getHotelId());
					data.add(dataes);
				}
				
				result.setMessage("旅游景点获取成功");
				result.setSuccess(1);
				result.setCode("1");
			}else{
				data=null;
				result.setMessage("IMEI缺失");
				result.setSuccess(1);
				result.setCode("1");
				
			}
			
				result.setData(data);
				
				
		}catch(Exception e){
			result.setMessage("数据错误");
			result.setCode("-1");
			logger.error("error:", e);
		}
		return result;
	}
	//hotel

	@Override
	public  Result<List<FootStepDO>> getFootStephotel(String iMEI,int status) {
		// TODO Auto-generated method stub
		Result<List<FootStepDO>> result=new Result<List<FootStepDO>>(0);
		FootStepExample footStepExample = new FootStepExample();
		FootStepExample.Criteria criteria = footStepExample.createCriteria();
	
		try{
			criteria.andImeiEqualTo(iMEI);
			criteria.andStatusEqualTo(status);
			List<FootStep> datas=footStepMapper.selectByExample(footStepExample);
			List<FootStepDO> data=new ArrayList<FootStepDO>();
						
			//1表示酒店足迹2表示旅游足迹
			if(datas.size() > 0){
				
				for(FootStep kk:datas){
					FootStepDO dataes=new FootStepDO();
					dataes.setId(kk.getId());
					//dataes.setCityName(cityName);
					dataes.setHotelId(kk.getUid());
					dataes.setName(kk.getName());
					//dataes.setHotelName(hotelName);
					
					//添加酒店所属的城市
					CityHotelExample cityHotelExample=new CityHotelExample();
					CityHotelExample.Criteria criteria3=cityHotelExample.createCriteria();
					criteria3.andHotelIdEqualTo(dataes.getHotelId());
					
					List<CityHotel> cityHotel=cityHotelMapper.selectByExample(cityHotelExample);
					CityHotel tt=cityHotel.get(0);
					dataes.setCityId(tt.getCityId());
					data.add(dataes);
				}
				
				result.setMessage("酒店足迹获取成功");
				result.setSuccess(1);
				result.setCode("1");
			}else{
				data=null;
				result.setMessage("IMEI缺失");
				result.setSuccess(1);
				result.setCode("1");
				
			}
			
				result.setData(data);
				
				
		}catch(Exception e){
			result.setMessage("数据错误");
			result.setCode("-1");
			logger.error("error:", e);
		}
		return result;
	}
	
	@Override
	public  Result<List<FootStepDO>> getFootSteptravel(int status) {
		// TODO Auto-generated method stub
		Result<List<FootStepDO>> result=new Result<List<FootStepDO>>(0);
		FootStepExample footStepExample = new FootStepExample();
		FootStepExample.Criteria criteria = footStepExample.createCriteria();
		criteria.andStatusEqualTo(status);
	
		try{
			List<FootStep> datas=footStepMapper.selectByExample(footStepExample);
			List<FootStepDO> data=new ArrayList<FootStepDO>();
						
			//1表示酒店足迹2表示旅游足迹
				
				for(FootStep kk:datas){
					FootStepDO dataes=new FootStepDO();
					dataes.setId(kk.getId());
					//dataes.setCityName(cityName);
					dataes.setCityId(kk.getUid());
					//dataes.setHotelId(kk.getUid());
					dataes.setName(kk.getName());
					//dataes.setHotelName(hotelName);
					
					//添加酒店所属的城市
					CityHotelExample cityHotelExample=new CityHotelExample();
					CityHotelExample.Criteria criteria3=cityHotelExample.createCriteria();
					criteria3.andCityIdEqualTo(dataes.getCityId());
					
					List<CityHotel> cityHotel=cityHotelMapper.selectByExample(cityHotelExample);
					CityHotel tt=cityHotel.get(0);
					dataes.setHotelId(tt.getHotelId());
					data.add(dataes);
				}
				
				result.setMessage("旅游景点获取成功");
				result.setSuccess(1);
				result.setCode("1");
			
				result.setData(data);
				
				
		}catch(Exception e){
			result.setMessage("数据错误");
			result.setCode("-1");
			logger.error("error:", e);
		}
		return result;
	}

}
