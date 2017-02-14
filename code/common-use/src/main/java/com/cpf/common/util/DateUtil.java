package com.cpf.common.util;

import java.util.Calendar;
import java.util.Date;


public class DateUtil {
	
	public static Date getNextDate(Date date,int day){
		Calendar c=Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DAY_OF_YEAR, day);
		return c.getTime();
	}
	
}
