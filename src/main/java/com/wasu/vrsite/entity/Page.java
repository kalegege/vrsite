package com.wasu.vrsite.entity;

import lombok.Data;

abstract@Data
public class Page {
	
	private Integer offset;
	
	private Integer pageSize;

}
