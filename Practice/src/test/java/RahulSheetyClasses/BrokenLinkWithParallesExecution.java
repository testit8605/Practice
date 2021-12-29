package RahulSheetyClasses;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkWithParallesExecution 
{
	static WebDriver driver;
	
	@BeforeTest
	public static void setUP() throws IOException 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://www.swiggy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testBrokenLink()
	{
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		List<String> urlList= new ArrayList<String>();
		int countOfEmptylink=0;
		for(WebElement allLink: allLinks)
		{
			String url = allLink.getAttribute("href");
			if(url==null || url.isEmpty())
			{
				countOfEmptylink++;
				System.out.println("Url is empty");
				continue;
			}
			urlList.add(url);
		}
		//for each loop using lambda 	
//		List<Integer> in = urlList.parallelStream().map(s-> {
//			try {
//				return verify(s);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			return null;
//		}).collect(Collectors.toList());
		

		
//		int countOfBrokenLink = 0;
//		for(Integer i:in)
//		{
//			if(i==null)
//			{
//				continue;
//			}
//			else
//			{
//				countOfBrokenLink=countOfBrokenLink+i;
//			}
//			//countOfBrokenLink=countOfBrokenLink+i;
//		}		
//		System.out.println("Count of empty Links: " +countOfEmptylink);
//		System.out.println("Count of broken link: "+countOfBrokenLink);	    
		
		
		
		long in = urlList.parallelStream().map(s-> {
			try {
				return verify(s);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}).count();
		
		System.out.println("Count of Broken Link: " +in);
		
//		Try this method
//		long d = urlList.parallelStream().mapToInt(s-> {
//			try {
//				return verify(s);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}).sum();
		
		
//		//Try this method
//		long sum = urlList.parallelStream().mapToLong(x-> {
//			try {
//				return verify(x);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return 0;
//		}).sum();
		
//		System.out.println("Count of Broken Link: " +sum);
		
	}
	public static int verify(String linkUrl) throws IOException
	{
		int counta=0;
		SoftAssert a = new SoftAssert();
		URL link = new URL(linkUrl);
		try 
		{
		HttpURLConnection con = (HttpURLConnection) link.openConnection();
		con.setConnectTimeout(9000);
		con.connect();
		int resCode = con.getResponseCode();
		if(resCode>=400)
		{
			counta++;
			System.out.println(linkUrl+" ----> "+resCode+" "+con.getResponseMessage()+" is Broken Link");
			//a.assertTrue(false);
		}
		else
		{
			//System.out.println(linkUrl+" ----> "+resCode+" "+con.getResponseMessage()+" Valid Link");
			//a.assertTrue(true);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		//a.assertAll();
		return counta;	
	}
}
