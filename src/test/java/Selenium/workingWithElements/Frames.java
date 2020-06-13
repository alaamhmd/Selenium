package Selenium.workingWithElements;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Frames {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Frames.html");

	}
	@Test
	public void testFramesWithIdOrName() {
		driver.switchTo().frame("left");
		WebElement msg = driver.findElement(By.tagName("p"));
		assertTrue(msg.getText().contains("Left Frame"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("right");
		WebElement msg2 = driver.findElement(By.tagName("p"));
		assertTrue(msg2.getText().contains("Right Frame"));
		driver.switchTo().defaultContent();

	}
	@Test
	public void testFramesWithIndex() {
		driver.switchTo().frame(1);
		WebElement msg = driver.findElement(By.tagName("p"));
		assertTrue(msg.getText().contains("doesn't have id or name"));
		System.out.println(msg.getText());

	}

	@AfterTest
	public void close () {
		driver.quit();
	}

}
