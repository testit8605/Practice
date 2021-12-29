package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTabCHORDLocationSizeTooltip 
{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		//Open in new tab
//		String tab = Keys.chord(Keys.CONTROL, Keys.RETURN);
//		driver.findElement(By.linkText("Register")).sendKeys(tab);
		
		//Open url in new tab 
//		driver.switchTo().newWindow(WindowType.TAB);
//		driver.switchTo().newWindow(WindowType.WINDOW);
//		driver.navigate().to("www");
		
		//Location of element
		WebElement logo = driver.findElement(By.tagName("img"));
		logo.getLocation();
		logo.getLocation().getX();
		logo.getLocation().getY();
		
		//Anather method
		logo.getRect().getX();
		logo.getRect().getY();
		
		//Size 
		
		logo.getSize();
		logo.getSize().getHeight();
		logo.getSize().getWidth();
		
		logo.getRect().getDimension().getHeight();
		logo.getRect().getDimension().getWidth();
		
		//For tooltip use get attribute
	}

}
