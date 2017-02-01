package com.cpf.common.dao;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HibernateDaoUtil
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	protected final Session getNewSession(){
		return this.sessionFactory.openSession();
	}
	
	protected final Session getCurrentSession()
	{
		return this.sessionFactory.getCurrentSession();
	}
}
