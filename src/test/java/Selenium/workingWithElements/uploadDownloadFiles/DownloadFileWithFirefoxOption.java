package uploadDownloadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DownloadFileWithFirefoxOption {
	FirefoxDriver driver;
	public static String downloadPath = System.getProperty("user.dir")+"\\downloads";
	
	public static FirefoxOptions firefoxOption() 
	{
		FirefoxOptions option = new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.saveToDisk","application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting",false);
		return option;
	}
	

	@BeforeTest
	public void openURL() {
		String firefoxPath = System.getProperty("user.dir")+"\\resources\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", firefoxPath);
		driver = new FirefoxDriver(firefoxOption());
		driver.navigate().to("https://the-internet.herokuapp.com/download");
	}
	
	@Test
	public void testDownloadFileWithFirefoxOption() {
		driver.findElement(By.linkText("some-file.txt")).click();
		
		
	}



	@AfterTest
	public void close () {
		driver.quit();
	}
}
