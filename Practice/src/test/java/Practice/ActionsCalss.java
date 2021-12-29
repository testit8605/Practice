package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsCalss {
	
	public static void main (String args[])
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		WebElement e = driver.findElement(By.xpath(""));
		WebElement e1 = driver.findElement(By.xpath(""));
		
		Actions act = new Actions(driver);
		act.doubleClick(e).perform();
		act.contextClick(e).perform();
		
		act.dragAndDrop(e, e1).perform();
		
		
		
		
	}
}
