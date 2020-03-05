package Selenium.workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDropActions {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/DragDropDemo.html");

	}
	@Test
	public void TestDragAndDrop() {
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target =driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		Assert.assertEquals("Dropped!", target.getText());


	}
	@AfterTest
	public void close () {
		driver.quit();
	}

}
