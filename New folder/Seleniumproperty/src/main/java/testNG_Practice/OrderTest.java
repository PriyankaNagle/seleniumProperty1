package testNG_Practice;


	
	import org.testng.annotations.Test; 
	public class OrderTest {
		
	@Test ( dependsOnMethods = "billingAnOrderTest")  
	public void createOrderTest() {  
	System.out.println("Execute createOrderTest===123"); 
	}
	
	
	@Test ( dependsOnMethods = "createOrderTest")  
	public void billingAnOrderTest() {  
	System.out.println("Execute billingAnOrderTest===123");  
	}} 


