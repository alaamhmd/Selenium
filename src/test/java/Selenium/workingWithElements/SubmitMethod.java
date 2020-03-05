package Selenium.workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SubmitMethod {
	ChromeDriver driver;
	WebElement textboxSearch; 


	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.com");

	}
	@Test
	public void TestSubmitMethod() {
		textboxSearch = driver.findElement(By.name("q"));
		textboxSearch.clear();
		textboxSearch.sendKeys("Automation testing");
		textboxSearch.submit();
		textboxSearch = driver.findElement(By.name("q"));
		textboxSearch.clear();
		textboxSearch.sendKeys("automation tools");
		textboxSearch.submit();
	}


	@AfterTest
	public void close () {
		driver.quit();
	}


}
