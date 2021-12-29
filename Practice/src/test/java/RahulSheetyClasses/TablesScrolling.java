package RahulSheetyClasses;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TablesScrolling extends UseOfByClass 
{
	public static void main(String[] args) throws InterruptedException, IOException 
	{
	   myTest();
    }
	
	@Test
	public static void myTest() throws InterruptedException
	{
		//WebDriverWait wait;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//scrolling
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");
		
		List<WebElement> amounts = driver.findElements(By.xpath("//div[@class='tableFixHead']//td[4]"));
		int sum=0;
		for(WebElement amount:amounts)
		{
			sum = sum + Integer.parseInt(amount.getText());
		}
		System.out.println(sum);
		
		int totalAmountColleceted = Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		
		Assert.assertEquals(totalAmountColleceted, sum);
		System.out.println("Passed");
	}
}
