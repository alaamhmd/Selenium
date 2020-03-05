package Selenium.workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TextBoxAndButton {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/login");

	}	


	@Test
	public void LoginPage() {

		WebElement usernameTxt =driver.findElement(By.id("username"));
		WebElement passwordTxt =driver.findElement(By.id("password"));
		WebElement loginButton =driver.findElement(By.className("radius"));
		usernameTxt.clear();
		usernameTxt.sendKeys("tomsmith");
		passwordTxt.clear();
		passwordTxt.sendKeys("SuperSecretPassword!");
		loginButton.click();
		WebElement logoutBtn = driver.findElement(By.cssSelector("a.button.secondary.radius"));
		Assert.assertEquals("Logout", logoutBtn.getText());
		WebElement loginMsg = driver.findElement(By.id("flash"));
		System.out.println(loginMsg.getText());
		Assert.assertTrue(loginMsg.getText().contains("You logged into a secure area!"));

	}





	@AfterTest
	public void close () {
		driver.quit();
	}

}
