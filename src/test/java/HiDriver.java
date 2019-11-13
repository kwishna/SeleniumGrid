import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HiDriver {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setAcceptInsecureCerts(true);
		capabilities.setBrowserName("firefox");
		capabilities.setVersion("65.0.2");
		capabilities.setPlatform(Platform.WIN10);
		
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://10.0.0.14:5555/wd/hub"), capabilities);
		driver.get("https://www.google.co.in");

	}

}
