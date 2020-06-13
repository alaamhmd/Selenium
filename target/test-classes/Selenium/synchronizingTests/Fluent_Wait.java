package synchronizingTests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fluent_Wait {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/AjaxDemo.html");

	}
	@Test
	public void testFluentWait() {
		driver.findElement(By.linkText("Page 4")).click();
		Wait<WebDriver> Fwait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);
		
		WebElement msg = Fwait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver F) {
				return F.findElement(By.id("page4"));
			}

		});

		assertTrue(msg.getText().contains("porta consequat"));

	}



	@AfterTest
	public void close () {
		driver.quit();
	}

}
