package Selenium.workingWithElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class CheckAllBrokenImages {
	ChromeDriver driver;
	private static int brokenImages;

	@BeforeTest
	public void openURL() {
		String chromePath = System.getProperty("user.dir")+"\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromePath);
		driver = new ChromeDriver();
		driver.navigate().to("https://the-internet.herokuapp.com/broken_images");

	}
	@Test()
	public void testBrokenImages() {
		brokenImages =0;
		List<WebElement>images = driver.findElements(By.tagName("img"));
		for (WebElement image : images) {
			if (image != null) {
				verifyImage(image);
				
			}
			
		}
		System.out.println("no. og broken images =  " + brokenImages);
		
	}
	
	public static void verifyImage(WebElement img) {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(img.getAttribute("src"));
		try {
			CloseableHttpResponse response =client.execute(request);


		if (response.getStatusLine().getStatusCode()!= 200) {
			brokenImages++;
			
			
		}
		
	}
	 catch (ClientProtocolException e) {
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
