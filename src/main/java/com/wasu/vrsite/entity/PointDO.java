package com.wasu.vrsite.entity;

import lombok.Data;

@Data
public class PointDO {
	private double x;
	
	private double y;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}
