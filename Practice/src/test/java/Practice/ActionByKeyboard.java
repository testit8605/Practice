package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionByKeyboard 
{
	public static void main (String args[])
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Windows.html");
		
//		Actions act = new Actions(driver);
//		act.sendKeys(Keys.ENTER).build().perform();
//		act.sendKeys(Keys.BACK_SPACE).build().perform();
//		act.sendKeys(Keys.CONTROL).build().perform();
//		act.sendKeys(Keys.ADD).build().perform();
//		
		WebElement e1 = driver.findElement(By.xpath(null));
		WebElement e2 = driver.findElement(By.xpath(null));
		
		e1.sendKeys("Akshsay");
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		act.sendKeys(Keys.TAB);
		act.perform();
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		//Action interfact and have build 
		Action ac = act.moveToElement(e2).build();
		ac.perform();
		
	}

}
