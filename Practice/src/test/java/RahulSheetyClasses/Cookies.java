package RahulSheetyClasses;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cookies {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		//Delete all cookies
		driver.manage().deleteAllCookies();
		//Delete all particular cookies
		driver.manage().deleteCookieNamed("Akshay");
		//get all cookies and print count of all cookies
		Set<Cookie> cokkies = driver.manage().getCookies();
		System.out.println(cokkies.size());
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//get all cookies and print count of all cookies
		cokkies = driver.manage().getCookies();
		System.out.println(cokkies.size());
		
		Cookie cookies = new Cookie("Akshay","Bhagat");
		driver.manage().addCookie(cookies);
		
		//get all cookies and print count of all cookies
	    cokkies = driver.manage().getCookies();
		System.out.println(cokkies.size());
		
		//print all cookies
		//validate after deleting particular cookie we are able to logout or not
		for(Cookie cokkiess:cokkies)
		{
			System.out.println(cokkiess.getName() +": "+ cokkiess.getValue());
		}

	}

}
