package DriverService;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverServiceLearn {

	public static void main(String[] args) throws IOException {
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.acceptInsecureCerts();
		cap.setAcceptInsecureCerts(true);
		cap.setJavascriptEnabled(true);
//		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
		cap.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
		
		ChromeDriverService service = new ChromeDriverService.Builder()
												.usingAnyFreePort()
												.usingDriverExecutable(new File("E:\\chromedriver.exe"))
											//	.withLogFile(new File(System.getProperty("user.dir")+"/logger.log"))
												.build(); // Creating A Service.
		
		service.start(); // Start The Service. Means Server. Gets A Session ID On Some Port

		WebDriver driver= new ChromeDriver(service); // Creating Chrome Driver Using Service. Driver Will Use The Service's Server Session
		driver.get("https://google.com");		
		driver.close(); // Closing Driver But Not The Service
		
		driver = new ChromeDriver(service);	// Starting Browser Not The Service Again. Communicate On Same Service Session And Port
		driver.get("https://google.com");
		driver.close(); // Closing Browser
		
		driver = new ChromeDriver(service);	
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("krishna");
		driver.findElement(By.name("btnK")).submit();
		driver.close();
		
		FileHandler.createDir(new File("."+"/xyz.txt")); // FileHandler & Zip Class By Selenium.
		Zip.zip(new File("."+"/xyz.txt"));
		
		// Preferred Method For Driver Creation.
		ChromeOptions chrome = new ChromeOptions(); // For Desired BrowserOption.
		chrome.merge(cap);
		driver = new RemoteWebDriver(service.getUrl(), chrome); // Creating Driver Using Service
		System.out.println("Service URL :: "+service.getUrl());
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("krishna");
		driver.findElement(By.name("btnK")).submit();
		
		driver.close();
		service.stop(); // Service Stops At The Last.
	
	}

}