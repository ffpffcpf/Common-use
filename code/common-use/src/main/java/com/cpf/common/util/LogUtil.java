package com.cpf.common.util;

import org.apache.log4j.Logger;

public class LogUtil {

	/**
	 * 日志实例
	 */
	private static final Logger logger = Logger.getLogger(LogUtil.class);

	public static void logException(String errorTitle, Exception e) {
		StringBuilder errorBuilder = new StringBuilder();
		errorBuilder.append(errorTitle).append(" : ").append(e);
		logger.error(errorBuilder.toString());
	}

	
	public static void log(String message){
		logger.info(message);
	}
}
