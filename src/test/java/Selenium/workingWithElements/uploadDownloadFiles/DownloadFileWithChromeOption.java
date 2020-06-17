package uploadDownloadFiles;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFileWithChromeOption {
	ChromeDriver driver;
	public static String downloadPath = System.getProperty("user.dir")+"\\"+"downloads";

	public static ChromeOptions chromeOption() 
	{
		ChromeOptions options = new ChromeOptions();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory",downloadPath);
		options.setExperimentalOption("prefs", chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options ; 		
	}
	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver(chromeOption());
		driver.navigate().to("http://the-internet.herokuapp.com/download");

		
	}
		@Test
		public void testDownloadFileWithChromeOption()  {
			WebElement fileLink =driver.findElement(By.linkText("empty.txt"));
			Actions builder = new Actions(driver);
			builder.moveToElement(fileLink).click().build().perform();
			

			
			
		}
		@AfterTest
		public void close () {
			driver.quit();
		}
	}


