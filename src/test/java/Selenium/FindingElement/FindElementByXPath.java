package Selenium.FindingElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElementByXPath {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

	}
	@Test
	public void FindElementByAbslouteXPath () {

		WebElement usernameTxt =driver.findElement(By.xpath("//*[@id=\"username\"]"));
		System.out.println(usernameTxt.getTagName());
	}
	@Test
	public void FindElementByRelativeXPath () {

		WebElement passwordTxt =driver.findElement(By.xpath("//input[1]"));
		WebElement usernameTxt =driver.findElement(By.xpath("//input"));
		WebElement loginBtn =driver.findElement(By.xpath("//button[@class ='radius']"));

		System.out.println(passwordTxt.getTagName());
		System.out.println(usernameTxt.getTagName());
		System.out.println(loginBtn.getText());
	}
	@AfterTest
	public void close () {
		
		driver.quit();
	}
}
