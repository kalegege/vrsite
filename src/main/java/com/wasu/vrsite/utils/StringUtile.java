package com.wasu.vrsite.utils;

public class StringUtile {
	public static boolean isEmpety(String a){
		if(a==null||a.equals("")){
			return false;
		}
		return true;
	}
	public static boolean isEmpety(Integer a){
		if(a==null){
			return false;
		}
		return true;
	}
}
