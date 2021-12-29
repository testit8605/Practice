package RahulSheetyClasses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkByNaveen {

	public static void main(String[] args) throws IOException 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		List<String> urlList= new ArrayList();
		
		for(WebElement allLink: allLinks)
		{
			String url = allLink.getAttribute("href");
			//System.out.println(url);
			urlList.add(url);
			//findBrokenLinkMethod(url);
		}
		
		
		long stTime = System.currentTimeMillis();
		urlList.parallelStream().forEach(j -> {
			try {
				findBrokenLinkMethod(j);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		long enTime = System.currentTimeMillis();
		System.out.println(enTime);
		
		
		
		driver.quit();
	}
	
	
	@Test
	public static void findBrokenLinkMethod(String linkUrl) throws IOException
	{
		SoftAssert a = new SoftAssert();
		URL link = new URL(linkUrl);
		HttpURLConnection con = (HttpURLConnection) link.openConnection();
		con.setConnectTimeout(9000);
		con.connect();
		int resCode = con.getResponseCode();
		if(resCode>=400)
		{
			System.out.println(linkUrl+" ----> "+resCode+" "+con.getResponseMessage()+" is Broken Link");
			a.assertTrue(false);
		}
		else
		{
			System.out.println(linkUrl+" ----> "+resCode+" "+con.getResponseMessage()+" Valid Link");
			a.assertTrue(true);
		}
		a.assertAll();
	}

}
