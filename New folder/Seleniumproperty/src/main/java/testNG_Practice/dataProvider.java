package testNG_Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider{
	
	@DataProvider(name="TestData")
	public Object[][] testdata(){
	Object[][] data=new Object[2][2];
	data[0][0]="Rohit";
	data[0][1]="Sharma";
	data[1][0]="virat";
	data[1][1]="kohli";
	return data;
	}


@Test(dataProvider="TestData")
	public void TC1(String name,String lastname) {
	System.out.println(name+" "+lastname);
	
}
}