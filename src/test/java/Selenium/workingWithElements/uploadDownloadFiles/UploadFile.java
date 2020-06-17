package uploadDownloadFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadFile {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/upload");

	}
	
	@Test()
	public void testUploadeFile() {
		String imageName = "jean.jpg";
		WebElement chooseFileBtn = driver.findElement(By.id("file-upload"));
		WebElement uploadBtn = driver.findElement(By.id("file-submit"));
		String imagePath = System.getProperty("user.dir")+"/uploads/"+imageName;
		chooseFileBtn.sendKeys(imagePath);
		uploadBtn.click();
		WebElement uploadedFiles = driver.findElement(By.id("uploaded-files"));
		System.out.println(uploadedFiles.getText());
		Assert.assertEquals(imageName, uploadedFiles.getText());

		
		
		
	}

	
	@AfterTest
	public void close () {
		driver.quit();
	}
}
