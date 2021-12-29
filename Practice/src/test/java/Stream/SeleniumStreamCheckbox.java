package Stream;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumStreamCheckbox {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.freshworks.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Selecting all checkboxex
		//List<WebElement> links = driver.findElements(By.xpath("//input[@type='checkbox']"));
		//links.stream().forEach(e->e.click()); //http://demo.automationtesting.in/Register.html
		
		//FooterLink text printing
		List<WebElement> footerLinks = driver.findElements(By.xpath("//div[@class='footer-main']//a"));
		ArrayList<String> al = new ArrayList();
		footerLinks.stream().forEach(s-> al.add(s.getText()));
		al.forEach(s-> System.out.println(s));
		
	}

}
