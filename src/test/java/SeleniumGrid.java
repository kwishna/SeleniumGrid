
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SeleniumGrid {
	
	WebDriver driver;
	
	@Parameters({"browser", "port"})
	@BeforeTest
	public void setUp(String browser, String port) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setAcceptInsecureCerts(true);
		capabilities.setBrowserName(browser);
		capabilities.setPlatform(Platform.WIN10);
		driver = new RemoteWebDriver(new URL("http://10.0.0.14:"+port+"/wd/hub"), capabilities);
		
	}
	
	@Test
	public void testingOne() {
		
		driver.get("https://www.google.co.in");
	}
	
	@Test
	public void testingTwo() {
		
		driver.findElement(By.name("q")).sendKeys("Hello Krishna");
		driver.findElement(By.tagName("body")).click();
		driver.findElement(By.xpath("//*[@value='Google Search']")).click();
	}

}
