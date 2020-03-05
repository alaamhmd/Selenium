package Selenium.workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownList {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

	}

	@Test
	public void TestDropdownList() {
		Select dropdownLs =new Select( driver.findElement(By.id("dropdown")));
		Assert.assertFalse(dropdownLs.isMultiple());
		Assert.assertEquals(3, dropdownLs.getOptions().size());
		dropdownLs.selectByVisibleText("Option 2");
		dropdownLs.selectByValue("1");
		dropdownLs.selectByIndex(2);
		Assert.assertEquals("Option 2", dropdownLs.getFirstSelectedOption().getText());

	}	



	@AfterTest
	public void close () {
		driver.quit();
	}



}
