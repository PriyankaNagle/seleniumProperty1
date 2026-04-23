package DDT;

import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class readDataFromJSON {
	public static void main(String[] args) throws Exception {
		
		//step1: parse json physical file intp java object using json parse class
		
		JSONParser par=new JSONParser();
		Object obj=par.parse(new FileReader("C:\\Users\\PRIYANKA\\Desktop\\commapp.json"));
		
		//step2:convert java object to Json Object using downcast 
		JSONObject map=(JSONObject)obj;
		
		//step3: get the value of json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("password"));
		System.out.println(map.get("username"));
		System.out.println(map.get("Browser"));
		
		
		
		
	}

}
