package testNG_Practice;


	import java.lang.reflect.Method;  
	import org.testng.Assert;  
	import org.testng.annotations.Test; import org.testng.asserts.SoftAssert;  
	public class Sample {  
	   @Test  
	 public void HomepageTest(Method mtd) {        
	 
	System.out.println(mtd.getName()+" Test Start");  
	      SoftAssert sa = new SoftAssert();  
	      System.out.println("Step--1");      
	 System.out.println("Step--2");        
	sa.assertEquals("Home", "Home");        
	System.out.println("Step--3");  
	sa.assertEquals("Title", "Title-1");        
	System.out.println("Step--4");  
	  sa.assertAll();  
	  System.out.println(mtd.getName()+"  Test end");  
	 }  
	   @Test  
	 public void VerifyhomepageLogoTest(Method mtd) {        
	System.out.println( mtd.getName()+ " Test Start");  
	      SoftAssert sa = new SoftAssert();  
	      System.out.println("Step--1");      
	 System.out.println("Step--2");        
	sa.assertTrue(true);  
	      System.out.println("Step--3");  
	      System.out.println("Step--4");  
	      sa.assertAll();  
	      System.out.println(mtd.getName()+"  Test end");  
	    }  
	    }  


