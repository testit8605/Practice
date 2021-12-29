package Practice;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		Set <Cookie> cookies = driver.manage().getCookies();
		System.out.println(cookies.size());
		
		for(Cookie cookie: cookies) 
		{
			
		  System.out.println(cookie.getName() + ":" + cookie.getValue());
		
		  System.out.println(driver.manage().getCookieNamed("csm-hit"));
		
		}
		
		Cookie cobj = new Cookie("MyCookie1111", "1234543");
		driver.manage().addCookie(cobj);
		cookies= driver.manage().getCookies();
		System.out.println(cookies.size());
		
		driver.manage().deleteCookie(cobj);
		cookies= driver.manage().getCookies();
		System.out.println(cookies.size());
		
		driver.manage().deleteAllCookies();
		cookies= driver.manage().getCookies();
		System.out.println(cookies.size());
		
		
		driver.close();

	}

}
