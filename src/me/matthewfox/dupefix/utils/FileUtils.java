package me.matthewfox.dupefix.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
	
	public static String readFile(File file){
		try {
				String sCurrentLine;
				BufferedReader br = new BufferedReader(new FileReader(file));
				String list = "";
				while ((sCurrentLine = br.readLine()) != null) {
					list = list+"\r\n"+(sCurrentLine);
				}
				
				br.close();
				
				return list;
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		return null;
	}
	
}
