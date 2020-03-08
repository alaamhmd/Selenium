package Selenium.windows;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HadlingMultiWindows {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Config.html");

	}
	@Test 
	public void TestMultiWindow() {

		String currentWindowID = driver.getWindowHandle();
		WebElement visitUsBtn = driver.findElement(By.id("visitbutton"));
		visitUsBtn.click();
		for (String windowID : driver.getWindowHandles()) {
			String title = driver.switchTo().window(windowID).getTitle();
			if (title.equals("Visit Us")) {
				assertEquals("Visit Us", driver.getTitle());
				driver.close();
			}

		}
		driver.switchTo().window(currentWindowID);
		driver.findElement(By.id("helpbutton")).click();
		driver.switchTo().window("HelpWindow");
		assertEquals("Help", driver.getTitle());
		driver.close();
		driver.switchTo().window(currentWindowID);
	}
	@AfterTest
	public void close () {
		driver.quit();
	}

}

