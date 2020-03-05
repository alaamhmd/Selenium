package Selenium.FindingElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindTableByTagName {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");
		
	}
	
	@Test
	public void FindElementsByTagName() {
		WebElement table =driver.findElement(By.id("table1"));
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		System.out.println(tableRows.size());
		System.out.println(tableRows.get(3).getText());
	
	}
	
	

	
	@AfterTest
	public void close () {
		
		driver.quit();
	}
	
}



