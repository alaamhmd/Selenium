package htmlWebApp;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HTML5VideoPlayer {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/html5video.html");

	}
	@Test()
	public void testHTML5VideoPlayer() {
		WebElement video = driver.findElement(By.id("vplayer"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String source = (String) js.executeScript("return arguments[0].currentSrc", video);
		long duration = (Long) js.executeScript("return arguments[0].duration", video);
		assertEquals("http://html5demos.com/assets/dizzy.mp4", source);
		assertEquals(25, duration);
		js.executeScript(" return arguments[0].play()",video);
		js.executeScript(" retur arguments[0].pause()",video);

		

		
		
		
				
		
		
	}
	
	
	
	@AfterTest
	public void close () {
		driver.quit();
	}


}
