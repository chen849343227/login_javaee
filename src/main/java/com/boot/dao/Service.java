package com.boot.dao;

public interface Service {
	
		boolean regService(String user,String pass);
		
		boolean logService(String  user,String pass);
		
		boolean requestCodeService(String phone);
}
