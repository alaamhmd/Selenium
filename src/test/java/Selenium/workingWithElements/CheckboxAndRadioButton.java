package Selenium.workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxAndRadioButton {
	public class DropdownList {
		ChromeDriver driver;

		@BeforeTest
		public void openURL() {
			String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
			driver.navigate().to("https://the-internet.herokuapp.com/checkboxes");

		}
		@Test()
		public void TestCheckBox() {

			WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
			checkbox1.click();
			WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
			if (!checkbox2.isSelected()) {
				checkbox2.click();	
			} 
		}	
		private Boolean IsElementPresent(By by) {
			try {
				driver.findElement(by);
				return true;
			} catch (NoSuchElementException e) {
				return false;
			}

		}
		@Test 
		public  void TestIsElementPresent() {
			if(IsElementPresent(By.xpath("//*[@id=\"checkboxes\"]/input[1]"))){
				System.out.println("This element exists");
			}
			
		}

		@AfterTest
		public void close () {
			driver.quit();
		}
	}
}
