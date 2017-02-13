package com.cpf.common.util;

public class StringUtil
{
	public static boolean isBlank(String str)
	{
		if(str==null||str.equals(""))
		{
			return true;
		}else 
		{
			return false;
		}
	}
	
	public static boolean isNotBlank(String str){
		return !isBlank(str);
	}
	
	public static String lowerFirstChar(String str){
		String firstChar=str.substring(0, 1).toLowerCase();
		return firstChar+str.substring(1);
	}
	
	public static String upperFirstChar(String str){
		String firstChar=str.substring(0, 1).toUpperCase();
		return firstChar+str.substring(1);
	}
}
