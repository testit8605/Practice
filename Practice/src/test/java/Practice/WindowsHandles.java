package Practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandles {

	public static void main(String[] args) throws InterruptedException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		WebElement switchTo = driver.findElement(By.xpath("//a[normalize-space()='SwitchTo']"));
		WebElement windows = driver.findElement(By.xpath("//a[normalize-space()='Windows']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(switchTo).moveToElement(windows).click().perform();
		
		driver.findElement(By.xpath("//a[normalize-space()='Open New Tabbed Windows']")).click();
		driver.findElement(By.linkText("click")).click();
		
		Set <String> windowsID = driver.getWindowHandles();
		
		/*
		Iterator<String> it= windowsID.iterator(); 
		String parentID = it.next();
		String childID = it.next();
		
		System.out.println(parentID+ " " + childID);
		
		*/
		
		
		List<String> lists = new ArrayList(windowsID);
		
		/*for(String list:lists)
		{
			System.out.println(driver.switchTo().window(list).getTitle());
		}*/
		
		
		String parentID = lists.get(0);
		String childID = lists.get(1);
		
		System.out.println("First Time........");
		System.out.println(driver.switchTo().window(parentID).getTitle());
		System.out.println(driver.switchTo().window(childID).getTitle());
		
		driver.findElement(By.linkText("NAACP Legal Defense and Education Fund")).click();
		
		
		windowsID = driver.getWindowHandles();
		lists = new ArrayList(windowsID);
		
		parentID = lists.get(0);
		childID = lists.get(1);
		String childID1 = lists.get(2);
		
		System.out.println("Second Time........");
		System.out.println(driver.switchTo().window(parentID).getTitle());
		System.out.println(driver.switchTo().window(childID).getTitle());
		System.out.println(driver.switchTo().window(childID1).getTitle());
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[normalize-space()='About']")).click();
		driver.navigate().back();
		
		Thread.sleep(3000);
		
		driver.switchTo().window(parentID);
		Thread.sleep(3000);
		driver.findElement(By.linkText("Open New Seperate Windows")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		windowsID = driver.getWindowHandles();
		lists = new ArrayList(windowsID);
		
		Thread.sleep(3000);
		parentID = lists.get(0);
		childID = lists.get(1);
		childID1 = lists.get(2);
		String childID2 = lists.get(3);
		
		Thread.sleep(3000);
		
		System.out.println("Third Time........");
		System.out.println(driver.switchTo().window(parentID).getTitle());
		System.out.println(driver.switchTo().window(childID).getTitle());
		System.out.println(driver.switchTo().window(childID1).getTitle());
		System.out.println(driver.switchTo().window(childID2).getTitle());

	}

}
