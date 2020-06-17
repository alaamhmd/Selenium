package uploadDownloadFiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFileUsingRobotClass {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");

	}
	
	@Test()
	public void testUploadFileUsingRobotClass() throws AWTException{
		String imageName = "jean.jpg";
		String imagePath = System.getProperty("user.dir")+"\\uploads\\"+imageName;
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.id("file-upload"))).click().build().perform();
		StringSelection selection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(2000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(2000); 
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		WebElement uploadBtn = driver.findElement(By.id("file-submit"));
		builder.moveToElement(uploadBtn).click().build().perform();
		WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
		System.out.println(uploadedFiles.getText());
		Assert.assertEquals(imageName, uploadedFiles.getText());

		
		
		
	}

	
	@AfterTest
	public void close () {
		driver.quit();
	}
}


