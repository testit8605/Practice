package RahulSheetyClasses;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkByOmegaAutoTest {

	WebDriver driver;
	static int  brokenImage = 0;
	static int serverErrorImageLink = 0;
	static int validImageLink = 0;
	
	@BeforeTest
	public void setUp() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.oyorooms.com/np/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testBrokenImages() throws IOException, InterruptedException
	{
		List<WebElement> imgLists = driver.findElements(By.tagName("img"));
		System.out.println("The total number of images:: "+imgLists.size());
		
//		imgLists.forEach(v ->{
//			
//			try {
//				verify(v);
//			}
//			catch(Exception e)
//			{
//				e.printStackTrace();
//			}
//		});
		
		//int sum=0;
		
		for(WebElement imgList:imgLists)
		{
			//sum = sum+verify(imgList);
			List<Integer> images = verify(imgList, "src");
			
			brokenImage = brokenImage+images.get(0);
			serverErrorImageLink = serverErrorImageLink+images.get(1);
			validImageLink = validImageLink+images.get(2);
		}
		System.out.println();
		System.out.println("Valid image link count is:: "+validImageLink);
		System.out.println("Broken image link count is:: "+brokenImage);
		System.out.println("Internal Server Error image link count is:: "+serverErrorImageLink);
	}
	
	
	@Test
	public void testBrokenLinks() throws IOException, InterruptedException
	{
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("The total number of Links:: "+allLinks.size());
		
		for(WebElement allLink:allLinks)
		{
			List<Integer> images = verify(allLink, "href");
			
			brokenImage = brokenImage+images.get(0);
			serverErrorImageLink = serverErrorImageLink+images.get(1);
			validImageLink = validImageLink+images.get(2);
		}
		
		System.out.println();
		System.out.println("Valid link count is:: "+validImageLink);
		System.out.println("Broken link count is:: "+brokenImage);
		System.out.println("Internal Server Error link count is:: "+serverErrorImageLink);
	}
	
	
	public static List<Integer> verify(WebElement element, String attr) throws IOException, InterruptedException
	{
		String link = element.getAttribute(attr);
		HttpClient client = HttpClient.newBuilder().build();
		boolean isBrokenimage = false;
		int isBrokenImageLinkCount = 0;
		boolean serverErrorforImage = false;
		int serverErrorImageCount = 0;
		boolean validImageLink = false;
		int validLinkImageCount = 0;
		if(!(link==null))
		{
			HttpRequest request = HttpRequest.newBuilder(URI.create(link)).GET().build();
			HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
			
			int statusCode = response.statusCode();
			
			switch(statusCode%100)
			{
			case 2: validImageLink=true;
			break;
			case 4: isBrokenimage=true;
			break;
			case 5: serverErrorforImage=true;
			break;
			default:
			}
			
			//System.out.println("Link::: "+link+"  :::status :::"+statusCode+" :::is broken link::: "+isBroken+" :::got server error::: "+serverError);
			
			if(isBrokenimage==true)
			{
				isBrokenImageLinkCount++;
				System.out.println("Link::: "+link+"  :::status :::" +statusCode+" :::is broken link");
			}
			else if(serverErrorforImage==true)
			{
				serverErrorImageCount++;
				System.out.println("Link::: "+link+"  :::status :::" +statusCode+" :::got internal server error for that link");	
			}
			else if(validImageLink=true)
			{
				validLinkImageCount++;
				System.out.println("Link::: "+link+"  :::status :::" +statusCode+" :::is valid link");
			}
			
			
			
		}
		
		return Arrays.asList(isBrokenImageLinkCount,serverErrorImageCount,validLinkImageCount);
	}

	@AfterTest
	public void tearDown() 
	{
		driver.quit();
	}

}
