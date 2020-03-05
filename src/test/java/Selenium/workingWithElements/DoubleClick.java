package Selenium.workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DoubleClick {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");

	}
	@Test
	public void TestDoubleClick() {
		WebElement msg = driver.findElement(By.id("message"));
		String cssValue = msg.getCssValue("background-color");
		System.out.println(cssValue);
		Assert.assertEquals(cssValue,"rgba(0, 0, 255, 1)");
		Actions doubleClick =new Actions(driver);
		doubleClick.doubleClick(msg).perform();
		Assert.assertEquals("rgba(255, 255, 0, 1)",msg.getCssValue("background-color"));




	}
	@AfterTest
	public void close () {
		driver.quit();
	}



}
