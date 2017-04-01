package com.boot.entity;

/**
 * Created by long on 17-3-22.
 */

public class BaseEntity<T> {

	private static BaseEntity entity;
	
	public  static BaseEntity getInstence(){
		if(entity == null){
			entity =  new BaseEntity();
		}
		return entity;
	}

    /**
     * code : BeJson
     * msg : http://www.bejson.com
     * data : {"user":"d","pass":"value","id":1}
     */

    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
