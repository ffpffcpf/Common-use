package com.cpf.common.util;

public class BeanUtil
{
	public static boolean isValid(Object... objs){
		if (objs==null||objs.length<0)
		{
			return false;
		}
		for (Object object : objs)
		{
			if (object==null)
			{
				return false;
			}
		}
		return true;
	}
	
}
