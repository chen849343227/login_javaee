package com.boot.entity;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by long on 17-3-22.
 */
public class User {
    /**
     * user : d
     * pass : value
     * id : 1
     */

	private static User bean;
	
	public static User getInstence(){
		if(bean == null){
			bean =  new User();
		}
		return bean;
	}
	
	 @NotEmpty
	private int id;
	 @NotEmpty
    private String user;
    @NotEmpty
    @Size(min = 6,max = 16)
    private String pass;
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

 
}
