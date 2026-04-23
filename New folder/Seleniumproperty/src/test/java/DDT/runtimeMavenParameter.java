package DDT;

import org.testng.annotations.Test;
 
public class runtimeMavenParameter {
	 @Test
	 public void runtimeParameter() {
		 String url=System.getProperty("url");
		 System.out.println("env Data====>URL==>" +url);
		  }

}
