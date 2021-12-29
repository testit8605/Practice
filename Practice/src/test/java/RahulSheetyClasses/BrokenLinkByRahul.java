package RahulSheetyClasses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkByRahul {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		myTest();
	}
	@Test
	public static void myTest() throws InterruptedException, IOException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		SoftAssert a = new SoftAssert();
		int count=0;
		for(WebElement allLink: allLinks)
		{
			String url = allLink.getAttribute("href");
			//Thread.sleep(3000);
			if(url==null || url.isEmpty())
			{
				System.out.println("Url is empty");
				continue;
			}
			
			//URL link = new URL(url);
			
			HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
			con.setConnectTimeout(5000);
			con.setRequestMethod("HEAD");
			con.connect();
			
			int recCode = con.getResponseCode();
			String message = con.getResponseMessage();
			
			//using soft assert
			a.assertTrue(recCode<400, "The link with text "+allLink.getText()+" and url with "+url+" is broken with response code: "+recCode+" "+message);
			count++;
			
			//using if else condition
//			if(recCode>400)
//			{
//				count++;
//				a.assertTrue(false);
//				System.out.println("The link with text "+allLink.getText()+" and url with "+url+" is broken with response code: "+recCode+" "+message);
//				
//			}
//			else 
//			{
//				System.out.println("The link with text "+allLink.getText()+" and url with "+url+" is valid with response code: "+recCode+" "+message);
//				a.assertTrue(true);
//			}
		}
		//Thread.sleep(3000);
		System.out.println(count);
		a.assertAll();
		
	}

}
