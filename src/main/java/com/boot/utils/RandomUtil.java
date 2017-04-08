package com.boot.utils;

import java.util.Random;

public class RandomUtil {

	public static String createRandomVcode(){
	
		Random random = new Random();
		String result =   random.nextInt(1000000)+"";
		
        if(result.length()!=6){  
            return createRandomVcode();  
        }  
        System.out.println(result);
        return result; 
	}

}
