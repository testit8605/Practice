package RahulSheetyClasses;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws MalformedURLException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://paytm.com/flights");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int brokenLinkCount=0;
		
		for(WebElement allLink:allLinks)
		{			
			String url = allLink.getAttribute("href");
			
			if(url==null || url.isEmpty())
			{
				System.out.println("Url is empty");
				continue;
			}
			
			URL link = new URL(url);
			
			try 
			{
				HttpURLConnection con = (HttpURLConnection) link.openConnection();
				
				con.connect();
				int responseCode = con.getResponseCode();
				if(responseCode>=400)
				{
					System.out.println(url+":"+ "is broken link");
					brokenLinkCount++;
				}
				else
				{
					System.out.println(url+":"+ "is valid link");
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}			
		}
		
		System.out.println("Number of broken Link"+brokenLinkCount);
		

	}

}
