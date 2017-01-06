package com.wasu.vrsite.utils;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.wasu.vrsite.entity.GeoSearchDO;
import com.wasu.vrsite.entity.GeocoderDO;
import com.wasu.vrsite.entity.PoiDO;
import com.wasu.vrsite.entity.Response;
import com.wasu.vrsite.entity.ResultCode;
import com.wasu.vrsite.exception.MyException;
import com.wasu.vrsite.http.LocalHttpRequest;

@Service("BadiduYunUtils")
public class BadiduYunUtils {
	
	//创建表（create geotable）接口
	public Response createGeotable(String name) throws MyException {
		try {
			String url = "http://api.map.baidu.com/geodata/v3/geotable/create";
			String body="ak=5VLpwNVFKqD6M0A0gVIBvfVuBgxBFEmS&is_published=1&geotype=1&name=" + name;
			String result = LocalHttpRequest.post1(url, body);
			return JSON.parseObject(result, Response.class);
			//return null;
		} catch (Exception e) {
			throw new MyException(ResultCode.DAO_DEF_EXCEPTION, e);
		}
	}
	
	
	//查询指定id的数据（poi）详情接口
	public Response detailSearch1(int id) throws MyException {
		try {
			String url = "http://api.map.baidu.com/geodata/v3/poi/detail?";
			String body="ak=5VLpwNVFKqD6M0A0gVIBvfVuBgxBFEmS&is_published=1&geotype=1&id=" + id;
			String result = LocalHttpRequest.post1(url, body);
			return JSON.parseObject(result, Response.class);
			//return null;
		} catch (Exception e) {
			throw new MyException(ResultCode.DAO_DEF_EXCEPTION, e);
		}
	}
	
	//创建数据（create poi）接口
	public Response createGeodata(String name) throws MyException {
		try {
			String url = "http://api.map.baidu.com/geodata/v3/poi/create";
			String body="ak=5VLpwNVFKqD6M0A0gVIBvfVuBgxBFEmS&is_published=1&geotype=1&name=" + name;
			String result = LocalHttpRequest.post1(url, body);
			return JSON.parseObject(result, Response.class);
			//return null;
		} catch (Exception e) {
			throw new MyException(ResultCode.DAO_DEF_EXCEPTION, e);
		}
	}
	
	
	//poi周边搜索周边检索是指以一点为中心（中心点通过location参数指定），搜索中心点附近指定距离范围
	//（搜索半径通过radius参数指定）内的POI点。检索时可通过tags参数指定检索的类型；通过sortby参数进行检索结果的排序
	//（支持多字段排序）；filter参数可以完成对指定数据范围的筛选。
	public GeoSearchDO geosearch(double longitude ,double latitude , int radius) throws MyException{
		try {
			java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.000000"); 
			
			String url = "http://api.map.baidu.com/geosearch/v3/nearby";
			url=url+"?ak=5VLpwNVFKqD6M0A0gVIBvfVuBgxBFEmS&geotable_id=155102&location="+df.format(longitude)+","+df.format(latitude)+"&radius="+ radius+"&tags="+ "酒店";
			String result = LocalHttpRequest.get(url);
			return JSON.parseObject(result, GeoSearchDO.class);
		} catch (Exception e) {
			throw new MyException(ResultCode.DAO_DEF_EXCEPTION, e);
		}
		
	}
	
	//poi详情检索
	public GeoSearchDO detailSearch(String uid) throws MyException{
		try {
			String url = "http://api.map.baidu.com/geosearch/v3/detail/" + uid;
			url=url+"?ak=5VLpwNVFKqD6M0A0gVIBvfVuBgxBFEmS&geotable_id=155102";
			String result = LocalHttpRequest.get(url);
			return JSON.parseObject(result, GeoSearchDO.class);
		} catch (Exception e) {
			throw new MyException(ResultCode.DAO_DEF_EXCEPTION, e);
		}
	}
	
	
	//poi本地检索
	public GeoSearchDO localSearch(String keywords) throws MyException{
		try {
			String url = "http://api.map.baidu.com/geosearch/v3/local";
			url=url+"?ak=5VLpwNVFKqD6M0A0gVIBvfVuBgxBFEmS&geotable_id=155102?q="+ keywords;
			String result = LocalHttpRequest.get(url);
			return JSON.parseObject(result, GeoSearchDO.class);
		} catch (Exception e) {
			throw new MyException(ResultCode.DAO_DEF_EXCEPTION, e);
		}
	}
	
	//查询指定id的数据（poi）详情接口
	public PoiDO idSearch(String id) throws MyException{
		try {
			String url = "http://api.map.baidu.com/geodata/v3/poi/detail";
			url=url+"?ak=5VLpwNVFKqD6M0A0gVIBvfVuBgxBFEmS&geotable_id=155102&id="+ id;
			String result = LocalHttpRequest.get(url);
			return JSON.parseObject(result, PoiDO.class);
		} catch (Exception e) {
			throw new MyException(ResultCode.DAO_DEF_EXCEPTION, e);
		}
	}
	
	//根据经度和纬度查询所在城市
	public GeocoderDO geocoder(double longitude ,double latitude ) throws MyException{
		try {
			java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.000000");
			
			String url = "http://api.map.baidu.com/geocoder/v2/";
			url=url+"?ak=5VLpwNVFKqD6M0A0gVIBvfVuBgxBFEmS&location="+df.format(latitude)+","+df.format(longitude)+"&output=json&pois=1";
			String result = LocalHttpRequest.get(url);
			return JSON.parseObject(result, GeocoderDO.class);
		} catch (Exception e) {
			throw new MyException(ResultCode.DAO_DEF_EXCEPTION, e);
		}
	}
	
}
