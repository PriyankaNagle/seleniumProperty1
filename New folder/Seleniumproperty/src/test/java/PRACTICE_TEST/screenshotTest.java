package PRACTICE_TEST;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class screenshotTest {

	@Test
	public void amazonTest() throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/?tag=msndeskabkin-21&ref=pd_sl_myh38910b_e&adgrpid=1324913121555467&hvadid=82807336470514&hvnetw=o&hvqmt=e&hvbmt=be&hvdev=c&hvlocint=&hvlocphy=262729&hvtargid=kwd-82807957656483:loc-90&hydadcr=5620_2377278&mcid=bf83b4991e2f3eb79d07c8f0ac1b5488");
		Random r=new Random();
		int ran=r.nextInt(100);
		
		Thread.sleep(2000);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./screenshot/test1"+ran+".png"));
		driver.close();
		
		
	}
}
