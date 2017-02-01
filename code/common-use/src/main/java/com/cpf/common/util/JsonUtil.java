package com.cpf.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.cpf.common.util.FileUtil;
import com.cpf.common.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil
{
	/**
	 * 把json中的key放到map中
	 * @param json
	 * @param map
	 */
	public static Map<String, Object> convertJsonToMap(String jsonStr){
		Map<String, Object> map=new HashMap<>();
		JSONObject json=JSONObject.fromObject(jsonStr);
		convertJsonToMap(json, map);
		return map;
	}
	
	
	@SuppressWarnings("unchecked")
	private static void convertJsonToMap(JSONObject json,Map<String, Object> map){
		for (String key : (Set<String>)json.keySet())
		{
			Object value=json.get(key);
			if (value instanceof JSONObject)
			{
				map.put(key,value);
				convertJsonToMap((JSONObject)value, map);
			}else if (value instanceof JSONArray) {
				Object obj=((JSONArray) value).get(0);
				map.put(key, value);
				if(obj instanceof JSONObject){
					convertJsonToMap((JSONObject)obj, map);
				}
			}else {
				map.put(key, value);
			}
		}
	}
	
//	/**
//	 * 
//	 * 把json的键添加到常量文件中
//	 */
//	public static void main(String[] args)
//	{
//		String target = "E:/JavaWebPlace/bookManager/src/main/java/com/cpf/constant/WebConstant.java";
//		Map<String, Object> map=null;
//		String result=NetUtil.doGet(WebConstant.DOUBAN_API+"7505715666");
//		System.out.println(result);
//		map=convertJsonToMap(result);
//		addKey(map, target,"douban");
//	}
	
	/**
	 * 把map中的key以java常量的形式添加到某个文件中
	 * @param keyMap
	 * @param target 文件绝对路径
	 * @param mark 标志
	 */
	public static void addKey(Map<String, Object> keyMap,String target,String mark){
		BufferedWriter out = null;
		BufferedReader in = null;
		StringBuilder sb=new StringBuilder();
		try
		{
			String aString="E:/test.java";
			in = new BufferedReader(new InputStreamReader(new FileInputStream(target))) ;
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(aString)));
			char[] data = new char[1024];
			in.read(data);
			String string=new String(data);
			sb.append(string);
			sb.delete(sb.lastIndexOf(";")+1,sb.length());
			sb.append(jsonKeyToJavaKey(keyMap,mark))
			.append("\n}");
			out.write(sb.toString().toCharArray());
			in.close();
			out.close();
			in = new BufferedReader(new InputStreamReader(new FileInputStream(aString))) ;
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target)));
			FileUtil.copyFile(in, out);
//			out.write(data);
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * 把map中的key值转化为java代码中的常量字符串,例：
	 * {"a":123}->public static final String KEY_A="a";
	 * @param map
	 * @param mark 标志
	 * @return
	 */
	private static String jsonKeyToJavaKey(Map<String, Object> map,String mark){
		StringBuilder sb=new StringBuilder();
		for (Map.Entry<String,Object> e: map.entrySet())
		{
			sb.append("\n\t")
			.append("public static final String KEY_");
			if(StringUtil.isNotBlank(mark)){
				sb.append(mark.toUpperCase())
				.append("_");
			}
			sb.append(e.getKey().toUpperCase())
			.append("=\"")
			.append(e.getKey())
			.append("\";");
		}
		return sb.toString();
	}
}
