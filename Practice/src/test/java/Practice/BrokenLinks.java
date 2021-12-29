package Practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		int brokenLink=0;
		int validLink=0;
		
		List <WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		for(WebElement allLink:allLinks)
		{
			System.out.println(allLink.getText());
			String url = allLink.getAttribute("href");
			
			if(url==null || url.isEmpty())
			{
				System.out.println("Url if empty");
				continue;
			}
			
			URL link = new URL(url);
			try
			{
				HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
				httpConn.connect();
				int resCode = httpConn.getResponseCode();
					
					if(resCode>=400)
					{
						System.out.println(url+ "is broken link");
						brokenLink++;
					}
			
					else
					{
						System.out.println(url+ "is Valid link");
						validLink++;
					}
					
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
		
		System.out.println(brokenLink);
		System.out.println(validLink);
	}

}
