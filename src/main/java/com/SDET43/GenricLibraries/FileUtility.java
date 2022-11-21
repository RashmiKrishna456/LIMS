package com.SDET43.GenricLibraries;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * This method is used to read the data from Property File 
	 * @author Admin
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String ReadDataFromPropertyFIle(String key) throws Throwable
	{
	FileInputStream fis = new FileInputStream(iPathConstant.FilePath);
	Properties pobj = new Properties();
	pobj.load(fis);
	String value = pobj.getProperty(key);
	return value;
	}
}
