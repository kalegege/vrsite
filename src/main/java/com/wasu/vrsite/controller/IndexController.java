package com.wasu.vrsite.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wasu.vrsite.dao.CityHotelMapper;
import com.wasu.vrsite.dao.HotelMapper;
import com.wasu.vrsite.dao.RecommendMapper;
import com.wasu.vrsite.dao.SiteMapper;
import com.wasu.vrsite.entity.AppInfo;
import com.wasu.vrsite.entity.CityHotel;
import com.wasu.vrsite.entity.CityHotelExample;
import com.wasu.vrsite.entity.FootStep;
import com.wasu.vrsite.entity.GeoSearchDO;
import com.wasu.vrsite.entity.GeoSearchDTO;
import com.wasu.vrsite.entity.GeocoderDO;
import com.wasu.vrsite.entity.Hotel;
import com.wasu.vrsite.entity.HotelDO;
import com.wasu.vrsite.entity.HotelExample;
import com.wasu.vrsite.entity.ItemDTO;
import com.wasu.vrsite.entity.PageDevide;
import com.wasu.vrsite.entity.PageDevide2;
import com.wasu.vrsite.entity.PoiDO;
import com.wasu.vrsite.entity.Poster;
import com.wasu.vrsite.entity.Recommend;
import com.wasu.vrsite.entity.RecommendExample;
import com.wasu.vrsite.entity.Response;
import com.wasu.vrsite.entity.Result;
import com.wasu.vrsite.entity.Site;
import com.wasu.vrsite.entity.SiteDO;
import com.wasu.vrsite.entity.SiteExample;
import com.wasu.vrsite.exception.MyException;
import com.wasu.vrsite.filter.TerminalInterceptor;
import com.wasu.vrsite.service.IFootStepService;
import com.wasu.vrsite.service.IMainService;
import com.wasu.vrsite.utils.BadiduYunUtils;
import com.wasu.vrsite.utils.StringUtile;

@Controller
@RequestMapping("/index")
public class IndexController {

	private static Logger logger = Logger.getLogger(IndexController.class.getName());

	public static int defaultPageSize = 10;

	@Resource
	private BadiduYunUtils badiduYunUtils;
	@Resource
	private HotelMapper hotelMapper;
	@Resource
	private RecommendMapper recommendMapper;
	@Resource
	private SiteMapper siteMapper;
	@Resource
	private IFootStepService iFootStepService;
	@Resource
	private IMainService iMainService;
	@Resource
	private CityHotelMapper cityHotelMapper;

	// 百度云存储创建数据库接口
	@RequestMapping(value = "/create")
	@ResponseBody
	public Object create(HttpServletRequest request, HttpServletResponse response) throws MyException {
		Response responses = badiduYunUtils.createGeotable("geotable");
		System.out.println("message" + responses.getMessage() + "id" + responses.getId());
		return null;
	}

	// 百度云查询200米范围内数据
	@RequestMapping(value = "/geosearch")
	@ResponseBody
	public Object search(String longitude, String latitude, HttpServletRequest request, HttpServletResponse response)
			throws MyException {
		double longitudeDO = Double.parseDouble(longitude);
		double latitudeDO = Double.parseDouble(latitude);
		GeoSearchDO result = badiduYunUtils.geosearch(longitudeDO, latitudeDO, 200);
		System.out.println(result.getContents());
		return result;
	}

	// 百度获取机顶盒imei
	@RequestMapping(value = "/imei")
	@ResponseBody
	public Object hotel(String longitude, String latitude, HttpServletRequest request, HttpServletResponse response)
			throws MyException {
		// 获取IMEI
		AppInfo appInfo = TerminalInterceptor.getAppInfo();
		int IMEI = Integer.parseInt(appInfo.getIMEI());

		// iFootStepService.addFootStep(IMEI,new HotelDO());

		GeoSearchDO result = badiduYunUtils.localSearch("酒店");
		System.out.println(result.getContents());
		return result;
	}
	
	// 通过经度和维度获取足迹
	@RequestMapping(value = "/getfootstephotel")
	@ResponseBody
	public Object getfootstephotel(Integer pageIndex, Integer pageSize,HttpServletRequest request, HttpServletResponse response)throws MyException {
		
		// 获取IMEI
		AppInfo appInfo = TerminalInterceptor.getAppInfo();
		String IMEI = appInfo.getIMEI();
		int status=1;
		//返回足迹
		return iFootStepService.getFootStephotel("a1e488cda01aa50dbfa09326dd284b265e7b4541",status);
	}
	// 通过id获取酒店
	@RequestMapping(value = "/gethotelbyid")
	@ResponseBody
	public Object gethotelbyid(String hotelId,Integer pageIndex, Integer pageSize,HttpServletRequest request, HttpServletResponse response)throws MyException {
		
		if (!StringUtile.isEmpety(pageSize))
			pageSize = defaultPageSize;
		if (!StringUtile.isEmpety(pageIndex))
			pageIndex = 1;
		
		return iMainService.getHotelById(hotelId, pageIndex, pageSize);	
	}
	
	// 获取所有酒店
	@RequestMapping(value = "/getfootsteptravel")
	@ResponseBody
	public Object getfootsteptravel(Integer pageIndex, Integer pageSize,HttpServletRequest request, HttpServletResponse response)throws MyException {
		
		// 获取IMEI
//		AppInfo appInfo = TerminalInterceptor.getAppInfo();
//		String IMEI = appInfo.getIMEI();
		int status=4;
		//返回足迹
		return iFootStepService.getFootSteptravel(status);
	}

	// 百度云查询1000米范围内最近酒店
	@RequestMapping(value = "/hotelvr")
	@ResponseBody
	public Object hotelvr(String longitude, String latitude, Integer pageIndex, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws MyException {
		if (!StringUtile.isEmpety(pageSize))
			pageSize = defaultPageSize;
		if (!StringUtile.isEmpety(pageIndex))
			pageIndex = 1;

		// 获取IMEI
		AppInfo appInfo = TerminalInterceptor.getAppInfo();
		String IMEI = appInfo.getIMEI();

		int distance = 1001;
		int keyid = 0;
		Result<PageDevide2<HotelDO>> result = new Result<PageDevide2<HotelDO>>(0);
		// 调用百度接口获取该点200米内酒店数据
		double longitudeDO =0;
		double latitudeDO = 0;

		if(longitude != null && latitude != null){
			longitudeDO = Double.parseDouble(longitude);
			latitudeDO = Double.parseDouble(latitude);
		}else{
			RecommendExample recommendExample = new RecommendExample();
			RecommendExample.Criteria criteria0 = recommendExample.createCriteria();
			criteria0.andStatusEqualTo(3);
			List<Recommend> recommends = recommendMapper.selectByExample(recommendExample);
			longitudeDO=Double.parseDouble(recommends.get(0).getLongitude());
			latitudeDO=Double.parseDouble(recommends.get(0).getLatitude());
		}

		PageDevide2<HotelDO> data = new PageDevide2<HotelDO>();
		HotelDO items = new HotelDO();
		List<ItemDTO> item1 = new ArrayList<ItemDTO>();
		HotelExample hotelExample = new HotelExample();
		HotelExample.Criteria criteria = hotelExample.createCriteria();
		hotelExample.setOffset((pageIndex - 1) * pageSize);
		hotelExample.setPageSize(pageSize);
		
		
		GeoSearchDO geoSearchDO = badiduYunUtils.geosearch(longitudeDO, latitudeDO, 1000);
		GeoSearchDTO geoSearchDTO =null;
		int hotelId=0;
		if (geoSearchDO.getContents().size() == 0) {
			//一公里附近没有酒店获取默认酒店
			GeocoderDO geocoderDO=badiduYunUtils.geocoder(longitudeDO, latitudeDO);
			
			CityHotelExample cityHotelExample=new CityHotelExample();
			
			CityHotelExample.Criteria criteria3=cityHotelExample.createCriteria();
			criteria3.andCityNameEqualTo(geocoderDO.getResult().getAddressComponent().getCity()).andStatusEqualTo(1);
			
			List<CityHotel> cityHotel=cityHotelMapper.selectByExample(cityHotelExample);
			if(cityHotel.size() > 0){
				CityHotel pp=cityHotel.get(0);
				
				hotelId=pp.getHotelId();
			}else{
				hotelId=1836526239;
			}
				
			//criteria.andHotelIdEqualTo(pp.getHotelId());
		}else{
			// 选择距离最近的酒店
			for (int i = 0; i < geoSearchDO.getContents().size(); i++) {
				GeoSearchDTO geoSearchDTO1 = geoSearchDO.getContents().get(i);
				if (geoSearchDTO1.getDistance() < distance) {
					distance = geoSearchDTO1.getDistance();
					keyid = i;
				}
			}
			hotelId= geoSearchDO.getContents().get(keyid).getUid();
//			geoSearchDTO = geoSearchDO.getContents().get(keyid);
//			criteria.andHotelIdEqualTo(geoSearchDTO.getUid());
		}
		

			try {				
				// 获取酒店VR信息
					criteria.andHotelIdEqualTo(hotelId);	
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
					}
					//添加酒店所属的城市
					CityHotelExample cityHotelExample=new CityHotelExample();
					CityHotelExample.Criteria criteria3=cityHotelExample.createCriteria();
					criteria3.andHotelIdEqualTo(hotelId);
					
					List<CityHotel> cityHotel=cityHotelMapper.selectByExample(cityHotelExample);
					CityHotel kk=cityHotel.get(0);
					items.setCityid(kk.getCityId());
					items.setCity(kk.getCityName());
					items.setUid(kk.getHotelId());
					items.setName(kk.getHotelName());
					
					//获取海报接口
					RecommendExample recommendExample = new RecommendExample();
					RecommendExample.Criteria criteria1 = recommendExample.createCriteria();
					criteria1.andUidEqualTo(items.getUid()).andStatusEqualTo(1);
					List<Recommend> recommends = recommendMapper.selectByExample(recommendExample);
					if(recommends.size() > 0){
						//添加海报信息
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
					}
					
					items.setItems(item1);

					// 添加足迹
					iFootStepService.addFootStep(IMEI,longitude,latitude, items);

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
		return result;
	}
	
	// 通过城市ID查询默认酒店
	@RequestMapping(value = "/hotelvr/default")
	@ResponseBody
	public Object hotelvrdefault(String cityId, Integer pageIndex, Integer pageSize,
			HttpServletRequest request, HttpServletResponse response) throws MyException {
		if (!StringUtile.isEmpety(pageSize))
			pageSize = defaultPageSize;
		if (!StringUtile.isEmpety(pageIndex))
			pageIndex = 1;

		return iMainService.getDefaultHotel(cityId, pageIndex, pageSize);
	}
	

	// 数据库查询当前城市旅游
	@RequestMapping(value = "/travelvr")
	@ResponseBody
	public Object travelvr(String cityId, Integer pageIndex, Integer pageSize, HttpServletRequest request,
			HttpServletResponse response) throws MyException {
		if (!StringUtile.isEmpety(pageSize))
			pageSize = defaultPageSize;
		if (!StringUtile.isEmpety(pageIndex))
			pageIndex = 1;

		// 获取IMEI
		AppInfo appInfo = TerminalInterceptor.getAppInfo();
		String IMEI = appInfo.getIMEI();

		Result<PageDevide2<SiteDO>> result = new Result<PageDevide2<SiteDO>>(0);

		// 查询该城市的旅游景点
		//int cityIdDO = Integer.parseInt(cityId);
		
		int cityIdDO =0;
		if(cityId != null ){
			cityIdDO = Integer.parseInt(cityId);
		}else{
			
			CityHotelExample cityHotelExample=new CityHotelExample();
			CityHotelExample.Criteria criteria3=cityHotelExample.createCriteria();
			criteria3.andIdEqualTo(1);
			
			List<CityHotel> cityHotel=cityHotelMapper.selectByExample(cityHotelExample);
			cityIdDO=cityHotel.get(0).getCityId();
		}
		
		try {
			SiteExample siteExample = new SiteExample();
			SiteExample.Criteria criteria = siteExample.createCriteria();
			criteria.andCityIdEqualTo(cityIdDO);
			List<Site> sites = siteMapper.selectByExample(siteExample);
			if (sites.size() > 0) {
				PageDevide2<SiteDO> data = new PageDevide2<SiteDO>();
				SiteDO items = new SiteDO();
				List<ItemDTO> item1 = new ArrayList<ItemDTO>();

				// 分页
				data.setTotalItems(sites.size(), pageSize);

				// 获取推荐海报
				RecommendExample recommendExample = new RecommendExample();
				RecommendExample.Criteria criteria1 = recommendExample.createCriteria();
				criteria1.andUidEqualTo(cityIdDO).andStatusEqualTo(2);
				try {
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
					
					CityHotelExample cityHotelExample=new CityHotelExample();
					CityHotelExample.Criteria criteria3=cityHotelExample.createCriteria();
					criteria3.andCityIdEqualTo(cityIdDO);
					
					List<CityHotel> cityHotel=cityHotelMapper.selectByExample(cityHotelExample);
					CityHotel kk=cityHotel.get(0);
					items.setCityid(kk.getCityId());
					items.setCity(kk.getCityName());
					items.setDes(kk.getDescription());
					items.setName(kk.getCityName());
					items.setUid(kk.getCityId());
					
				} catch (Exception e) {
					result.setMessage("selectByExample错误");
					result.setCode("-1");
					logger.error("error:", e);
				}
				// 获取旅游数据
				for (Site ex : sites) {
					ItemDTO item = new ItemDTO();
					item.setDes(ex.getDescription());
					item.setName(ex.getName());
					item.setPicture(ex.getPicture());
					item.setUrl(ex.getUrl());
					item1.add(item);
				}

				items.setItems(item1);

				// 添加足迹
				iFootStepService.addFootStep(IMEI,null,null, items);

				data.setFolders(items);
				data.setPageIndex(pageIndex);
				result.setData(data);
				result.setMessage("SUCCESS");
				result.setSuccess(1);
				result.setCode("1");
			} else {
				result.setMessage("所在城市没有旅游景点");
				result.setCode("0");
			}
		} catch (Exception e) {
			result.setMessage("数据库错误");
			result.setCode("-1");
			logger.error("error:", e);
		}
		return result;
	}

}
