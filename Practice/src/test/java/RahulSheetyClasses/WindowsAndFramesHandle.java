package RahulSheetyClasses;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsAndFramesHandle {

	public static void main(String[] args) 
	{
		
	}
	
	@Test
	public static void myTest() throws InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		//Windows handle
		driver.findElement(By.cssSelector("[class='blinkingText']")).click();
		
		Set<String> winID = driver.getWindowHandles();
		Iterator<String> it = winID.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		String email = driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		System.out.println(email);
		driver.close();
		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("username")).sendKeys(email);
		
		
		//Frame handle
		
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement desti = driver.findElement(By.id("droppable"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(source, desti).perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[text()='Accept']")).click();
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		WebElement footerDriver = driver.findElement(By.xpath("//*[@class='clearfix simple']"));
		
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		List<WebElement> footerColoumn = footerDriver.findElements(By.xpath("//*[@class='clearfix simple']//div[@class='row']//a"));
		
		for(int i=footerColoumn.size()-1;i>=0;i--)
		{
			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerColoumn.get(i).sendKeys(clickOnLinkTab);
			Thread.sleep(2000);
		}
		
		Set<String> windId = driver.getWindowHandles();
		Iterator<String> it1 = windId.iterator();
		
		while(it1.hasNext())
		{
			driver.switchTo().window(it1.next());
			System.out.println(driver.getTitle());
			driver.close();
		}
		
		driver.quit();
		
	}

}
