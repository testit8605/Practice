package RahulSheetyClasses;
import java.util.List;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AboveBelowRightLeftRefactor {

	public static void main(String[] args) throws InterruptedException 
	{
		DesiredCapabilities desiredcapabilities = new DesiredCapabilities();
		desiredcapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		desiredcapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");	
		Thread.sleep(3000);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement name = driver.findElement(By.name("name"));
		//driver.findElement(with(By.tagName("label")).above(name)).getText();
		
		//driver.findElement(with(By.tagName("label")).below(name)).getText();
		
		//driver.findElement(with(By.tagName("label")).toLeftOf(name)).getText();
		
		//driver.findElement(with(By.tagName("label")).toRightOf(name)).getText();
		
		
		
	}
}
