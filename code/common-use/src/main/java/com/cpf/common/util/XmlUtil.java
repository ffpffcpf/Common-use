package com.cpf.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmlUtil {
	
	
	@SuppressWarnings("unchecked")
	public static <T> Map<String,Object> convertXmlToMap(InputStream input){
		try {
			Map<String,Object> map=new HashMap<String,Object>();
			Document document = new SAXReader().read(input);
			Element root = document.getRootElement();
			List<Element> elements = root.elements();
			for (Element e : elements) {
				map.put(e.getName(), e.getTextTrim());
			} 
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.logException("convertXmlToObject has Exception", e);
		}
		return null;
	}
	
	public static <T> T convertXmlToObject(Class<T> clazz,InputStream input){
		try
		{
			Map<String,Object> map=convertXmlToMap(input);
			T obj=clazz.newInstance();
			for (String key : map.keySet())
			{
				System.out.println(key+":"+map.get(key));
				Method method=clazz.getMethod("set"+key, String.class);
				method.invoke(obj, map.get(key));
//				Field field=clazz.getDeclaredField(StringUtil.lowerFirstChar(key));
//				field.set(obj, map.get(key));
			}
			return obj;
		} 
		catch (Exception e)
		{
			e.printStackTrace();
			LogUtil.logException("convertXmlToObject has Exception", e);
			return null;
		}
	}
	
	
	
	public static void main(String[] args) throws Exception {
		File file=new File("E:/test.xml");
		Map<String,Object> map=convertXmlToMap(new FileInputStream(file));
		for (String key : map.keySet()) {
			System.out.println(key+":"+map.get(key));
		}
	}
}
