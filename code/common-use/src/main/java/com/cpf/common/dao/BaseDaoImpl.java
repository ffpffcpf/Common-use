package com.cpf.common.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

@SuppressWarnings("rawtypes")
@Repository("baseDao")
public class BaseDaoImpl extends HibernateDaoUtil implements BaseDao
{

	@Override
	public void save(Object obj)
	{
		this.getCurrentSession().save(obj);
	}

	@Override
	public Object update(Object obj)
	{
		this.getCurrentSession().update(obj);
		return obj;
	}

	@Override
	public void remove(Object obj)
	{
		this.getCurrentSession().delete(obj);
	}

	@Override
	public void remove(Class clazz, long id)
	{
		Object object=this.get(clazz, id);
		this.getCurrentSession().delete(object);
	}

	
	@Override
	public Object get(Class clazz, long id)
	{
		return getCurrentSession().get(clazz, id);
	}

	@Override
	public List getAll(Class clazz)
	{
		Criteria c=getCurrentSession().createCriteria(clazz);
		return c.list();
	}

}
