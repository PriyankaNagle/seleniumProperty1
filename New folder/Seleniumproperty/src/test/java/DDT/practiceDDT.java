package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class practiceDDT {
	public static void main(String[] args) throws IOException {
		//get the java representation object of the file
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		//using properties class load all the keys
		Properties pro=new Properties();
		pro.load(fis);
		//get the value based om nthe key
		System.out.println(pro.getProperty("browser"));
		System.out.println(pro.getProperty("url"));
		System.out.println(pro.getProperty("username"));
		System.out.println(pro.getProperty("password"));
		
	}

}
