package com.crm.GENERIC.FILE_UTILITY;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	/**
	 * @author PRIYANKA
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader filR=new FileReader("./configurationData/appData.json");
		JSONParser par=new JSONParser();
		Object obj=par.parse(new FileReader("filR"));
		JSONObject map=(JSONObject)obj;
		String data=(String)map.get(key);
		return data;
		
		
	}

}
