package Selenium.FindingElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FindElement {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");
		
	}
	@Test
	public void FindElementByID() {
		
		WebElement usernameTxt =driver.findElement(By.id("username"));
		WebElement passwordTxt =driver.findElement(By.id("password"));
		System.out.println(usernameTxt.getLocation());
		System.out.println(passwordTxt.getTagName());
		
	}
	
	@Test
	public void FindElementByName() {
		WebElement usernameTxt =driver.findElement(By.name("username"));
		WebElement passwordTxt =driver.findElement(By.name("password"));
		System.out.println(usernameTxt.getLocation());
		System.out.println(passwordTxt.getTagName());


		
	}
	
	@Test
	public void FindElementByClass() {
		WebElement loginButton =driver.findElement(By.className("radius"));
		System.out.println(loginButton.getText());	
	}
	
	@Test
	public void FindElementByTagName() {
		WebElement loginButton =driver.findElement(By.tagName("button"));
		System.out.println(loginButton.getText());	
	}
	
	@Test
	public void FindElementByCssSelector() {
		WebElement loginButton =driver.findElement(By.cssSelector("button.radius"));
		WebElement usernameTxt =driver.findElement(By.cssSelector("input#username"));
		System.out.println(loginButton.getText());	
		System.out.println(usernameTxt.getTagName());	

	}
	
	
	@AfterTest
	public void close () {
		
		driver.quit();
	}
	
}
