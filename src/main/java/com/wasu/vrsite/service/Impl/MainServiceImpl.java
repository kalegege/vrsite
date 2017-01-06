package com.wasu.vrsite.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.wasu.vrsite.controller.IndexController;
import com.wasu.vrsite.dao.CityHotelMapper;
import com.wasu.vrsite.dao.HotelMapper;
import com.wasu.vrsite.dao.RecommendMapper;
import com.wasu.vrsite.entity.CityHotel;
import com.wasu.vrsite.entity.CityHotelExample;
import com.wasu.vrsite.entity.Hotel;
import com.wasu.vrsite.entity.HotelDO;
import com.wasu.vrsite.entity.HotelExample;
import com.wasu.vrsite.entity.ItemDTO;
import com.wasu.vrsite.entity.PageDevide2;
import com.wasu.vrsite.entity.PoiDO;
import com.wasu.vrsite.entity.Poster;
import com.wasu.vrsite.entity.Recommend;
import com.wasu.vrsite.entity.RecommendExample;
import com.wasu.vrsite.entity.Result;
import com.wasu.vrsite.exception.MyException;
import com.wasu.vrsite.service.IMainService;
import com.wasu.vrsite.utils.BadiduYunUtils;

@Service("iMainService")
public class MainServiceImpl implements IMainService{
	private static Logger logger = Logger.getLogger(MainServiceImpl.class.getName());

	@Resource
	private CityHotelMapper cityHotelMapper;
	@Resource
	private HotelMapper hotelMapper;
	@Resource
	private RecommendMapper recommendMapper;
	@Resource
	private BadiduYunUtils badiduYunUtils;
	
	@Override
	public Result<PageDevide2<HotelDO>> getDefaultHotel(String cityId,Integer pageIndex, Integer pageSize) {

		Result<PageDevide2<HotelDO>> result = new Result<PageDevide2<HotelDO>>(0);
		// 调用百度接口获取该点200米内酒店数据

		if (cityId != null) {
			try {
				int cityid= Integer.parseInt(cityId);
				PageDevide2<HotelDO> data = new PageDevide2<HotelDO>();
				HotelDO items = new HotelDO();
				List<ItemDTO> item1 = new ArrayList<ItemDTO>();
				// 获取酒店VR信息
				
				CityHotelExample cityHotelExample=new CityHotelExample();
				CityHotelExample.Criteria criteria3=cityHotelExample.createCriteria();
				criteria3.andCityIdEqualTo(cityid).andStatusEqualTo(1);
				
				List<CityHotel> cityHotel=cityHotelMapper.selectByExample(cityHotelExample);
				CityHotel kk=cityHotel.get(0);
				
				HotelExample hotelExample = new HotelExample();
				HotelExample.Criteria criteria = hotelExample.createCriteria();
				hotelExample.setOffset((pageIndex - 1) * pageSize);
				hotelExample.setPageSize(pageSize);

				criteria.andHotelIdEqualTo(kk.getHotelId());
					List<Hotel> hotel = hotelMapper.selectByExample(hotelExample);

					// 分页
					data.setTotalItems(hotel.size(), pageSize);
					if (hotel.size() > 0) {
						for (Hotel ex : hotel) {
							ItemDTO item = new ItemDTO();
							item.setDes(ex.getDescription());
							item.setName(ex.getName());
							item.setPicture(ex.getPicture());
							item.setUrl(ex.getUrl());
							item1.add(item);
						}

//						Hotel all = hotel.get(0);
//						items.setUid(all.getHotelId());
//						items.setName(all.getHotelName());
					}
					
					//添加酒店所属的城市
					items.setCityid(kk.getCityId());
					items.setCity(kk.getCityName());
					items.setDes(kk.getDescription());
					items.setUid(kk.getHotelId());
					items.setName(kk.getHotelName());
					
					RecommendExample recommendExample = new RecommendExample();
					RecommendExample.Criteria criteria1 = recommendExample.createCriteria();
					criteria1.andUidEqualTo(items.getUid()).andStatusEqualTo(1);
					List<Recommend> recommends = recommendMapper.selectByExample(recommendExample);
					List<Poster> posters=new ArrayList<Poster>();
					for(Recommend ex:recommends){
						Poster a=new Poster();
						a.setPoster(ex.getPoster());
						a.setUrl(ex.getUrl());
						a.setId(ex.getId());
						posters.add(a);
						if(ex.getDescription() != null){
							items.setDes(ex.getDescription());
						}
					}
					items.setPoster(posters);
					items.setItems(item1);

					data.setFolders(items);
				data.setPageIndex(pageIndex);
				result.setData(data);
				result.setMessage("SUCCESS");
				result.setSuccess(1);
				result.setCode("1");
			} catch (Exception e) {
				result.setMessage("百度接口异常");
				result.setCode("-1");
				logger.error("error:", e);
			}
		} else {
			result.setMessage("范围内没有酒店");
			result.setCode("0");
		}
		return result;
	}

	@Override
	public Result<PageDevide2<HotelDO>> getHotelById(String id, Integer pageIndex, Integer pageSize) throws MyException  {
		
		Result<PageDevide2<HotelDO>> result = new Result<PageDevide2<HotelDO>>(0);
		PageDevide2<HotelDO> data = new PageDevide2<HotelDO>();
		HotelDO items = new HotelDO();
		List<ItemDTO> item1 = new ArrayList<ItemDTO>();
		// 根据id获取酒店
		PoiDO poiDO = badiduYunUtils.idSearch(id);
		
		try{
			HotelExample hotelExample = new HotelExample();
			HotelExample.Criteria criteria = hotelExample.createCriteria();
			hotelExample.setOffset((pageIndex - 1) * pageSize);
			hotelExample.setPageSize(pageSize);
			criteria.andHotelIdEqualTo(poiDO.getPoi().getId());
			List<Hotel> hotel = hotelMapper.selectByExample(hotelExample);

			// 分页
			data.setTotalItems(hotel.size(), pageSize);
			if (hotel.size() > 0) {
				for (Hotel ex : hotel) {
					ItemDTO item = new ItemDTO();
					item.setDes(ex.getDescription());
					item.setName(ex.getName());
					item.setPicture(ex.getPicture());
					item.setUrl(ex.getUrl());
					item1.add(item);
				}
//				Hotel all = hotel.get(0);
//				items.setUid(all.getHotelId());
//				items.setName(all.getHotelName());
			}
			//添加酒店所属的城市
			CityHotelExample cityHotelExample=new CityHotelExample();
			CityHotelExample.Criteria criteria3=cityHotelExample.createCriteria();
			criteria3.andHotelIdEqualTo(poiDO.getPoi().getId());
			
			List<CityHotel> cityHotel=cityHotelMapper.selectByExample(cityHotelExample);
			CityHotel kk=cityHotel.get(0);
			items.setCityid(kk.getCityId());
			items.setCity(kk.getCityName());
			items.setDes(kk.getDescription());
			items.setUid(kk.getHotelId());
			items.setName(kk.getHotelName());
			
			RecommendExample recommendExample = new RecommendExample();
			RecommendExample.Criteria criteria1 = recommendExample.createCriteria();
			criteria1.andUidEqualTo(items.getUid()).andStatusEqualTo(1);
			List<Recommend> recommends = recommendMapper.selectByExample(recommendExample);
			List<Poster> posters=new ArrayList<Poster>();
			for(Recommend ex:recommends){
				Poster a=new Poster();
				a.setPoster(ex.getPoster());
				a.setUrl(ex.getUrl());
				a.setId(ex.getId());
				posters.add(a);
			}
			items.setPoster(posters);
			items.setItems(item1);

			data.setFolders(items);
			data.setPageIndex(pageIndex);
			result.setData(data);
			result.setMessage("SUCCESS");
			result.setSuccess(1);
			result.setCode("1");
			
		}catch(Exception e){
			result.setMessage("id错误");
			result.setCode("0");
		}
		return result;
	}

}
