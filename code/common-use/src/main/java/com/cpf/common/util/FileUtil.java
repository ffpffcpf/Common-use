package com.cpf.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileUtil
{
	public static void copyFile(BufferedReader in,BufferedWriter out) throws IOException{
		String str="";
		while((str=in.readLine())!=null){
			out.write("\n"+str);
		}
	}
}
