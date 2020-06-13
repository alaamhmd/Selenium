package synchronizingTests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EmplicitlyWait {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");

	}
	@Test

	public void testEmplicitlyWait() {

		WebElement textBox = driver.findElement(By.name("q"));
		textBox.sendKeys("Covid-19");
		textBox.submit();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains("Covid"));
		assertTrue(driver.getTitle().toLowerCase().startsWith("covid"));

	}

	@AfterTest
	public void close () {
		driver.quit();
	}
}
