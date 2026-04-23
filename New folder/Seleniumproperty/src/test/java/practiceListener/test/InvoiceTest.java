package practiceListener.test;


	import org.testng.Assert;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

	import com.crm.baseTest.baseClass;
	
	//@Listeners(com.crm.listenerUtility.listenerImplementation.class)
	
	public class InvoiceTest extends baseClass{
	@Test
	public void createInvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "vtiger");
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		System.out.println("step 4");
		String var=driver.getTitle();
		System.out.println(var);
		}
	@Test
	public void createInvoiceWithContactTest()
	{
		System.out.println("execute createInvoiceWithContactTest ");
		
	
		System.out.println("step 1");
		System.out.println("step 2");
		System.out.println("step 3");
		System.out.println("step 4");

}
	}
