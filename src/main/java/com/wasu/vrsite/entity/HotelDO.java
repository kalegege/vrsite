package com.wasu.vrsite.entity;

import java.util.List;

import lombok.Data;

@Data
public class HotelDO {
	
    private String hotelName;

    private Integer hotelId;
    
    private List<ItemDTO> items;
    
    private Poster poster;
    
    private String description;

}
