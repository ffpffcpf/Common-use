package com.cpf.common.dao;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface BaseDao
{
	void save(Object obj);
	
	Object update(Object obj);
	
	void remove(Object obj);
	
	void remove(Class clazz,long id);
	
	Object get(Class clazz,long id);
	
	List getAll(Class clazz);
}
