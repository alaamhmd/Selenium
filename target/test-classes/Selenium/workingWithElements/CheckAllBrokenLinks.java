package Selenium.workingWithElements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckAllBrokenLinks {
	ChromeDriver driver;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com");

	}
	@Test()
	public void testBrokenLinks() {

		List<WebElement>links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			verifyLink(url);		
		}

	}
	public static void verifyLink(String urlLink) {
		try {
			URL link = new URL(urlLink);
			HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();
			httpCon.setConnectTimeout(2000);
			httpCon.connect();
			if (httpCon.getResponseCode()==200) {
				System.out.println(urlLink + " - "+ httpCon.getResponseMessage()) ;

			}
			if (httpCon.getResponseCode()==404) {
				System.out.println(urlLink + " - "+ httpCon.getResponseMessage()) ;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@AfterTest
	public void close () {
		driver.quit();
	}


}
