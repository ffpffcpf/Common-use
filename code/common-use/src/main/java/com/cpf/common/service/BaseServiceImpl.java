package com.cpf.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cpf.common.dao.BaseDao;

@SuppressWarnings("rawtypes")
@Repository("baseService")
public class BaseServiceImpl implements BaseService
{

	@Autowired
	@Qualifier("baseDao")
	private BaseDao baseDao;
	
	@Override
	public void addObject(Object obj)
	{
		this.baseDao.save(obj);
	}

	@Override
	public void removeObject(Object obj)
	{
		this.removeObject(obj);
	}

	@Override
	public void removeObject(Class clazz, long id)
	{
		this.baseDao.remove(clazz, id);
	}

	@Override
	public Object modifyObject(Object obj)
	{
		return this.baseDao.update(obj);
	}

	@Override
	public Object retrieveAnObject(Class clazz, long id)
	{
		return this.baseDao.get(clazz, id);
	}

}
