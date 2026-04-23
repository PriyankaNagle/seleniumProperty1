package PRACTICE_TEST;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

	public class getProductInfoTest {
	@Test(dataProvider ="getData" )
	public void getProdInfoTest(String brandname,String productName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/?tag=msndeskabkin-21&ref=pd_sl_myh38910b_e&adgrpid=1324913121555467&hvadid=82807336470514&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=262729&hvtargid=kwd-82807957656483:loc-90&hydadcr=5620_2377278&mcid=bf83b4991e2f3eb79d07c8f0ac1b5488");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandname,Keys.ENTER);
		driver.findElement(By.id("nav-search-submit-button")).click();
		String price = driver.findElement(By.xpath("//span[text()='"+productName+"']/ancestor::div[@class='a-section a-spacing-small a-spacing-top-small']/descendant::span[@class='a-price']")).getText();
		System.out.println(price);
	}
		@DataProvider
		public Object[][] getData(){
			Object[][] objArr=new Object[3][2];
			objArr[0][0] ="iphone";
			objArr[0][1] ="iPhone 17 Pro 1 TB: 15.93 cm (6.3″) Display with Promotion up to 120Hz, A19 Pro Chip, Breakthrough Battery Life, Pro Fusion Camera System with Center Stage Front Camera";
			objArr[1][0] ="iphone";
			objArr[1][1] ="iPhone Air 256 GB: Thinnest iPhone Ever, 16.63 cm (6.5″) Display with Promotion up to 120Hz, Powerful A19 Pro Chip, Center Stage Front Camera, All-Day Battery Life; Sky Blue";
			objArr[2][0] ="iphone";
			objArr[2][1] ="Nord CE5 | MediaTek Dimensity | Massive 7100mAh Battery | Powered by OnePlus AI | 128GB 8GB | Black Infinity";
			return objArr;
			
		}
	
	}


