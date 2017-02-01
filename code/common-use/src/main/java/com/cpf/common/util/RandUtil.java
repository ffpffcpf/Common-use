package com.cpf.common.util;

import java.util.Random;

public class RandUtil
{
	private static Random rand=new Random();
	
	/**
	 * 产生随机位数的整数字符
	 * @param n
	 * @return
	 */
	public static String randStr(int n){
		StringBuffer sb=new StringBuffer();
		for (int i = 0; i < n; i++)
		{
			sb.append(rand.nextInt(10));
		}
		return sb.toString();
	}
}
