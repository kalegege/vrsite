package com.wasu.vrsite.entity;

import lombok.Data;

@Data
public class Response {
	private int status;
	
	private int id;
	
	private String message;
}
