package com.cpf.common.util;

import java.util.Collection;

@SuppressWarnings("rawtypes")
public class CollectionUtil
{
	
	public static boolean isListEmpty(Collection collection){
		if(collection==null||collection.size()<1)
			return true;
		else 
			return false;
	} 
	
	public static boolean isListNotEmpty(Collection collection){
		return !isListEmpty(collection);
	}
}
