package Selenium.workingWithElements;

import static org.testng.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollToBottomOfPage {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://www.amazon.com");

	}
	@Test
	public void testScrollToBottomOfPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,4000)");
		WebElement amazonLogo = driver.findElement(By.cssSelector("div.nav-logo-base.nav-sprite"));
		assertTrue(amazonLogo.isDisplayed());
	}

	
	@AfterTest
	public void close () {
		driver.quit();
	}

}
