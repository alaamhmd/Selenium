package Selenium.BrowserCommands;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBrowserCommands {

	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		driver.navigate().to("https://the-internet.herokuapp.com");

	}
	@Test
	public void testBrowserCommands() {

		driver.navigate().to("https://the-internet.herokuapp.com/login");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();
		System.out.println(driver.getCurrentUrl());


	}

	@AfterTest
	public void close () {

		driver.quit();
	}
}




