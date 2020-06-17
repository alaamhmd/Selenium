package htmlWebApp;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HTML5Canvas {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver= new ChromeDriver();
		driver.navigate().to("http://cookbook.seleniumacademy.com/html5canvasdraw.html");

	}
	@Test()
	public void testHTML5Canvas() throws IOException {
		WebElement canvas = driver.findElement(By.id("imageTemp"));
		WebElement drawList = driver.findElement(By.id("dtool"));
		Select select = new Select(drawList);
		//select pencil to draw with
		select.selectByVisibleText("Pencil");
		Actions builder = new Actions(driver);
        //start drawing with the pencil
		builder.clickAndHold(canvas).moveByOffset(80, 60).moveByOffset(60, 80)
		.moveByOffset(-80,-60).moveByOffset(-60, -80).release().perform();	
         //select rectangle to draw with
		select.selectByVisibleText("Rectangle");
		//start drawing rectangle
		builder.clickAndHold(canvas).moveByOffset(80, 30).moveByOffset(-30, -80).release().perform();
		//select line to draw with
		select.selectByVisibleText("Line");
		//start drawing line
		builder.clickAndHold(canvas).moveByOffset(80, 30).moveByOffset(-30, -80).release().perform();
		
		//take screenshot of the final result
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./screenshots/canavsDrawing.png"));



		
		
	}
	
	@AfterTest
	public void close () {
		driver.quit();
	}
}
