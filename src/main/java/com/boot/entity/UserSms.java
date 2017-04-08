package com.boot.entity;

import java.util.Date;

public class UserSms {

	private String phone;

	private String code;

	private Date time;
	private static UserSms sms;
	
	public static  UserSms  getInstance(){
		if(sms==null){
			sms = new UserSms();
		}
		return sms;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date date) {
		this.time = date;
	}

	@Override
	public String toString() {
		return "UserSms [phone=" + phone + ", code=" + code + ", time=" + time + ", getPhone()=" + getPhone()
				+ ", getCode()=" + getCode() + ", getTime()=" + getTime() + "]";
	}
}
