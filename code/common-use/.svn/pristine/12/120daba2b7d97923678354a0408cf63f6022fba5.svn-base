package com.cpf.common.model;

import java.util.List;

/**
 * 分页使用
 * @author Romi
 *
 */
public class Pager
{
	private Integer pageNo;
	
	private Integer pageSize;
	
	private Long rowCount;
	
	private Long pageCount;
	
	private List<Object> resultList;
	
	public Pager(){
		setPageCount();
	}
	
	public Pager(Integer pageNo,Integer pageSize,Long rowCount,List<Object> list)
	{
		this.pageNo=pageNo;
		this.pageSize=pageSize;
		this.rowCount=rowCount;
		this.resultList=list;
		setPageCount();
	}

	public Integer getPageNo()
	{
		return pageNo;
	}

	public void setPageNo(Integer pageNo)
	{
		if(pageNo<0){
			this.pageNo=1;
		}else{
			this.pageNo = pageNo;
		}
	}

	public Integer getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(Integer pageSize)
	{
		this.pageSize = pageSize;
		setPageCount();
	}

	public Long getRowCount()
	{
		return rowCount;
	}

	public void setRowCount(Long rowCount)
	{
		this.rowCount = rowCount;
		setPageCount();
	}

	public Long getPageCount()
	{
		return pageCount;
	}

	private void setPageCount()
	{
		this.pageCount = rowCount%pageSize==0?(rowCount/pageSize):(rowCount/pageSize)+1;
	}

	public List<Object> getResultList()
	{
		return resultList;
	}

	public void setResultList(List<Object> resultList)
	{
		this.resultList = resultList;
	}
}
