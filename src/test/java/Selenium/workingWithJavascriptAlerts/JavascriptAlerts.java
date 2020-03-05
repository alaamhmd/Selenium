package Selenium.workingWithJavascriptAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavascriptAlerts {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/Alerts.html");

	}
	@Test
	public void ConfirmAlert() {
		WebElement btn1 =driver.findElement(By.id("simple"));
		btn1.click();
		Alert alert1 = driver.switchTo().alert();
		String alert1Text=alert1.getText();
		System.out.println(alert1Text);
		alert1.accept();
		Assert.assertEquals("Hello! I am an alert box!", alert1Text);
		WebElement btn2 =driver.findElement(By.id("prompt"));
		btn2.click();
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();

		
;
	}
	@Test
	public void DismissAlert() {
		WebElement btn2 =driver.findElement(By.id("confirm"));
		btn2.click();
		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();
		
	}
	
	

}
