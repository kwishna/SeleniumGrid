package selenium_grid.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SeleniumGrid {
	
	WebDriver driver;
	String nodeUrl;
	
	@BeforeSuite
	public void setUp(){
		nodeUrl = "http://10.0.0.5:4444/wd/hub";
//		FirefoxOptions f = new FirefoxOptions();
//		f.setAcceptInsecureCerts(true);
//		f.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
		
		DesiredCapabilities dc = DesiredCapabilities.firefox();
		dc.acceptInsecureCerts();
		dc.setBrowserName("firefox");
		dc.setPlatform(Platform.WIN10);
		dc.setCapability("marionette", true);
		
		try {
			driver = new RemoteWebDriver(new URL(nodeUrl), dc);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}	
	
	@Test
		public void amazonTest(){
			driver.get("http://www.amazon.in");
			driver.findElement(By.partialLinkText("Today's")).click();		
	}
		@AfterSuite
		public void tearDown(){
			driver.close();
		}
	
}
