package com.cpf.common.bean;

public class ResponseBean
{
	private String status;
	
	private String message;
	
	
	private Object result;


	public ResponseBean(String status, String message)
	{
		super();
		this.status = status;
		this.message = message;
	}




	public ResponseBean(String status, String message, Object result)
	{
		super();
		this.status = status;
		this.message = message;
		this.result = result;
	}




	public String getMessage()
	{
		return message;
	}


	public void setMessage(String message)
	{
		this.message = message;
	}


	public Object getResult()
	{
		return result;
	}


	public void setResult(Object result)
	{
		this.result = result;
	}




	public String getStatus()
	{
		return status;
	}




	public void setStatus(String status)
	{
		this.status = status;
	}
	
	
}
