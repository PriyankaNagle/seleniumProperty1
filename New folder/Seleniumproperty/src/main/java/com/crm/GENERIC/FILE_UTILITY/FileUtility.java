package com.crm.GENERIC.FILE_UTILITY;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getDataFromPropertiesFile(String key) throws Exception{
		FileInputStream fis = new FileInputStream("./configurationData/commonData2.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);
		return data;
	}

}
