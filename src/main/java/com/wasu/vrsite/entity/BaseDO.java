package com.wasu.vrsite.entity;

import java.util.List;

import lombok.Data;


public class BaseDO {
    private List<ItemDTO> items;
    
    private List<Poster> poster;
    
    private String des;
    
    private String name;
    
    private int uid;
    
    private int status;
    
    private int cityid;
    
    private String city;

    
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	public List<Poster> getPoster() {
		return poster;
	}

	public void setPoster(List<Poster> poster) {
		this.poster = poster;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getStatus() {
		return 0;
	}

	public void setStatus(int status) {
		this.status = status;
	}
    
    

}
