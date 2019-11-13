package browserStack;

import java.net.MalformedURLException;
import java.net.URI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStack {
	
	  public static final String USERNAME = "baba123";
	  public static final String AUTOMATE_KEY = "D3BxRYBJrHutSx3LZtvm";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Safari");
	    caps.setCapability("browser_version", "12.0");
	    caps.setCapability("os", "OS X");
	    caps.setCapability("os_version", "Mojave");
	    caps.setCapability("resolution", "1024x768");
		
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		driver.get("https://www.google.com");
		driver.findElement(By.cssSelector("[name='q']")).sendKeys("My Location");
		driver.findElement(By.cssSelector("[name='btnK']")).click();
		
		driver.findElement(By.xpath("//div[@id='hdtb-msb-vis']/div[2]")).click();

	}

}
