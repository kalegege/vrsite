package com.wasu.vrsite.entity;


import java.util.List;

import com.wasu.vrsite.entity.GeoSearchDTO;
import lombok.Data;

@Data
public class GeoSearchDO {
	
	private int status;
	
	private int size;
	
	private int total;
	
	private List<GeoSearchDTO> contents;
	
}
