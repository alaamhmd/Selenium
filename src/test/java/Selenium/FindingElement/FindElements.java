package Selenium.FindingElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElements {

	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/");

	}

	@Test
	public void FindElementsByTagName() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Assert.assertEquals(46, links.size());
		for (WebElement link : links) {
			System.out.println(link.getAttribute("href"));

		}

	}


	@AfterTest
	public void close () {

		driver.quit();
	}

}






