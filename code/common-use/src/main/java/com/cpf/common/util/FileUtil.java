package com.cpf.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import com.mysql.jdbc.Field;

public class FileUtil
{
	public static void copyFile(BufferedReader in, BufferedWriter out) throws IOException
	{
		String str = "";
		while ((str = in.readLine()) != null)
		{
			out.write("\n" + str);
		}
	}

	/**
	 * 根据url下载文件
	 * @param urlString
	 * @param fileName
	 * @param savePath
	 * @return savePath/fileName
	 */
	public static String downloadFile(String urlString, String fileName, String savePath)
	{
		FileOutputStream out=null;
		InputStream in=null;
		try
		{
			URL url = new URL(urlString);
			URLConnection connection = url.openConnection();
			in = connection.getInputStream();
			File file=new File(savePath);
			if (!file.exists())
			{
				file.mkdirs();
			}
			String result=savePath+"/"+fileName;
			out = new FileOutputStream(result);
			byte[] bs = new byte[1024];
			int len = 0;
			while ((len = in.read(bs)) != -1)
			{
				out.write(bs, 0, len);
			}
			return result;
		} catch (Exception e)
		{
			e.printStackTrace();
		}finally {
			try
			{
				if (in!=null)
				{
					in.close();
				}
				if(out!=null){
					out.close();
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	public static void main(String[] args)
	{
		downloadFile("https://img3.doubanio.com/spic/s1001902.jpg", "1.png", "/111");
	}
}
