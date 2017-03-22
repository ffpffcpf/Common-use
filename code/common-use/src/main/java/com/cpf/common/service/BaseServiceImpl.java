package com.cpf.common.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cpf.common.constant.CommonConstant;
import com.cpf.common.dao.BaseDao;
import com.cpf.common.model.Pager;
import com.cpf.common.util.CollectionUtil;

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

	@SuppressWarnings("unchecked")
	protected Pager getPager(Integer pageNo, Integer pageSize,List list,Integer rowCount) {
		try {
			checkPageValue(pageNo, pageSize);
		} catch (NullPointerException e) {
			pageNo = CommonConstant.PAGER_NO;
			pageSize = CommonConstant.PAGER_SIZE;
		}
		if (CollectionUtil.isListEmpty(list))
			return new Pager(pageSize, pageNo, 0L, list);
		
		List resultList = new ArrayList();
		
		// 进行分页处理
		if(null==rowCount){
			rowCount = list.size(); // 11
			int fromIndex = (pageNo.intValue() - 1) * pageSize.intValue(); //8 = (2-1)*8
			if(fromIndex>=rowCount)// 8>=11
				return new Pager(pageSize, pageNo, rowCount.longValue(), resultList);
			int toIndex = fromIndex + pageSize.intValue();// 16 = 8+8
			if(toIndex >= rowCount){// 16>=11  
				resultList.addAll(list.subList(fromIndex, rowCount));
			}else{
				resultList.addAll(list.subList(fromIndex, toIndex));
			}
		}else{
			resultList.addAll(list);
		}
		
		return new Pager(pageSize, pageNo, rowCount.longValue(), resultList);
	}


	private static void checkPageValue(Integer... page) {
		for (Integer no : page) {
			if (null == no || no.intValue() < 0)
				throw new NullPointerException();
		}
	}

	@Override
	public List retrieveObjectAll(Class clazz)
	{
		return baseDao.getAll(clazz);
	}

}
