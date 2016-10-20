package com.wasu.vrsite.entity;

import java.util.List;

import lombok.Data;

@Data
public class SiteDO {
	
    private String siteName;

    private Integer siteId;
    
    private List<ItemDTO> items;
    
    private Poster poster;
    
    private String description;

}
