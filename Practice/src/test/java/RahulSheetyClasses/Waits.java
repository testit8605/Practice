package RahulSheetyClasses;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits 
{
	public static void main(String[] args) throws InterruptedException {
		
		myTest();
	}
	
	@Test
	public static void myTest() throws InterruptedException 
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		int j=0;
		//Identify all product and add product in cart
		List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class='products']//h4"));
		String[] items = {"Apple","Mango","Cucumber","Beans"};
		List<String> itemsToBeAdded = Arrays.asList(items);
		for(int i=0;i<allProducts.size();i++)
		{
			String products[] = allProducts.get(i).getText().split(" ");
			String product = products[0];
			if(itemsToBeAdded.contains(product))
			{
				Thread.sleep(2000);
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
				if(j==items.length)
				{
					break;
				}
			}
		}
		
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//div[@class='action-block']/button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[@class='promoBtn']")).click();
		
		//Wait
		WebDriverWait wait1 = new WebDriverWait(driver, 5);
		wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo' and contains(text(),'Code applied')]")));
		
		//Verify code applied successfully
		String codeAppliedText = driver.findElement(By.xpath("//span[@class='promoInfo' and contains(text(),'Code applied')]")).getText();
		Assert.assertEquals(codeAppliedText, "Code applied ..!");
		
		driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(20))
			       .pollingEvery(Duration.ofSeconds(4))
			       .ignoring(NoSuchElementException.class);
		
		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {

			   public WebElement apply(WebDriver driver) {
		       
				   if(driver.findElement(By.id("finish")).isDisplayed())
					{
					   return driver.findElement(By.id("finish"));
					}
				   else
				   {
					   return null;
				   }		   
		     }
		   });
		//driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed();
		Assert.assertTrue(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
		
		
	}
	
}
