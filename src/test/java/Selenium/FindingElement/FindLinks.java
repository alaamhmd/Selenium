package Selenium.FindingElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindLinks{
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

	}

	@Test
	public void FindLinksByLinkText() {
		WebElement seleniumLink =driver.findElement(By.linkText("Elemental Selenium"));
		System.out.println(seleniumLink.getAttribute("href"));

	}
	@Test
	public void FindLinksByPartialLinkText() {
		WebElement seleniumLink =driver.findElement(By.partialLinkText("Elemental"));
		System.out.println(seleniumLink.getAttribute("href"));

	}

	@AfterTest
	public void close () {

		driver.quit();
	}

}


