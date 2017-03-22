package com.cpf.common.service;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface BaseService
{
	void addObject(Object obj);
	
	void removeObject(Object obj);
	
	void removeObject(Class clazz ,long id);
	
	Object modifyObject(Object obj);
	
	Object retrieveAnObject(Class clazz,long id);
	
	List retrieveObjectAll(Class clazz);
}
