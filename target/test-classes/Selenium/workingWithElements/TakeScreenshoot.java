package Selenium.workingWithElements;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TakeScreenshoot {

	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://www.google.com");

	}
	@Test
	public void testTakeScreenshoot() {
		
		WebElement textBox = driver.findElement(By.name("Q"));
		textBox.sendKeys("Covid-19");
		textBox.submit();
		assertTrue(driver.getTitle().contains("Covid"));
	}
	@AfterMethod 
	public void takeScreenshootOfFailure(ITestResult result) throws IOException {
		if (ITestResult.FAILURE==result.getStatus()) {
			TakesScreenshot ts =(TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshots/" +result.getName()+".png"));
			
			
			
		}
		
	}
	
	
	@AfterTest
	public void close () {
		driver.quit();
	}
}
