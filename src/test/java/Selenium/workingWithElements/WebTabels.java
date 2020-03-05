package Selenium.workingWithElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTabels {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/tables");

	}
	@Test
	public void TestWebTable() {
		WebElement table = driver.findElement(By.id("table1"));
		List<WebElement>tableRows = driver.findElements(By.tagName("tr"));
		for (WebElement Row : tableRows) {
			List<WebElement>tableCols =Row.findElements(By.tagName("td"));
			for (WebElement Col : tableCols) {
				System.out.println(Col.getText());
				
			}
			System.out.println();
				
			}
			
		}

	@AfterTest
	public void close () {
		driver.quit();
	}

}
