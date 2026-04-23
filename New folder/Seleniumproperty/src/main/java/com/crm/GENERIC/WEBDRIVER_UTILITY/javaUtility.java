package com.crm.GENERIC.WEBDRIVER_UTILITY;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class javaUtility {
	public int randomNumber() {
		Random random=new Random();
		int randomNumber = random.nextInt(1000);
		return randomNumber;
	}
	
	
	
	public String getSystemDateYYYYDDMM() {
	 Date dateobj =new Date(0);
	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	 String date = sdf.format(dateobj);
	 return date ;
	}
	
	public String getRequiredDateYYYYDDMM(int days){
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=sim.getCalendar();
	
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate=sim.format(cal.getTime());
		return reqDate;
		}
	
	
}

