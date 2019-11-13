package selenium_grid.grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Node1 {
	WebDriver driver;
	String nodeUrl;
	
	@BeforeSuite
	public void setUp(){
		nodeUrl = "http://10.0.0.5:5566/wd/hub";
		InternetExplorerOptions f = new InternetExplorerOptions();
		
		try {
			driver = new RemoteWebDriver(new URL(nodeUrl), f);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}	
		@Test
		public void yatraTest(){
			driver.get("http://www.yatra.com");
			System.out.println(driver.getTitle());
	}
		@AfterSuite
		public void tearDown(){
			
		}
	
}



