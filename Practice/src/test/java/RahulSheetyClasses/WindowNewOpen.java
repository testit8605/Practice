package RahulSheetyClasses;

import java.awt.Window;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowNewOpen {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");	
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Open new Balnk window
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> winID = driver.getWindowHandles();
		Iterator<String> it = winID.iterator();
		String parentWindow = it.next();
		String childwindow = it.next();
		
		driver.switchTo().window(childwindow);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		Thread.sleep(3000);

		String copytext = driver.findElements(By.cssSelector("[id=\"radio-btn-example\"] label")).get(0).getText();
		System.out.println(copytext);
		String copytext2 = driver.findElements(By.xpath("//label[contains(@for,'radio')]")).get(2).getText();
		System.out.println(copytext2);
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		driver.findElement(By.name("name")).sendKeys(copytext);
		
		//open 3 image on 3 windows
//		for(int i=footerColoumn.size()-1;i>=0;i--)
//		{
//			String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
//			footerColoumn.get(i).sendKeys(clickOnLinkTab);
//			Thread.sleep(2000);
//		}
//		
	}

}
