package Selenium.workingWithJavascriptAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WorkingWithConfirmAlert {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");

	}
	@Test
	public void TestConfirmAlert() {
		WebElement btn = driver.findElement(By.id("confirm"));
		btn.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		WebElement msg = driver.findElement(By.id("demo"));
		String msgContent = msg.getText();
		System.out.println(msgContent);
		Assert.assertEquals(msgContent, msg.getText());
		btn.click();
		alert.dismiss();	
	}
	
	@AfterTest
	public void close () {
		driver.quit();
	}

	

}
