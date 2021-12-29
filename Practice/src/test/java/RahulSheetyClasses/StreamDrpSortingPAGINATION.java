package RahulSheetyClasses;


import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StreamDrpSortingPAGINATION 
{
	static WebDriver driver;
	
	@BeforeTest
	public void setUp() {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--disable-notifications");
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
	
	//sorting of table option
	@Test(enabled=false)
	public void SortingOfTableContent()
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//driver.findElement(By.xpath("//tr/th[1]")).click();
		
		List<WebElement> element = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList = element.stream().map(s-> s.getText()).collect(Collectors.toList());
		List<String> sortedlList = originalList.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(originalList.equals(sortedlList));	
	}
	
	
	
	
	@Test(enabled=false)
	public void getPriceOfRise()
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");		
		List<String> price;
		do {
		List<WebElement> element = driver.findElements(By.xpath("//tr/td[1]"));
		
		price = element.stream().filter(s->s.getText().contains("Tomato")).map(s-> getPriceOfBeans(s)).collect(Collectors.toList());
		price.forEach(s->System.out.println(s));
		long l = price.stream().filter(s->s.contains("37")).count();
		System.out.println("Exact number of price "+l);
		boolean sta = price.stream().anyMatch(s-> s.matches("37"));
		System.out.println("Print expected price is matches in array");
		Assert.assertTrue(sta);
		System.out.println("Print first price in array: "+price.get(0));
		Assert.assertEquals(price.get(0), "37");
		
		if(price.size()<1)
		{
			driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
		}
		}while(price.size()<1);
	}
	
	private static String getPriceOfBeans(WebElement s)
	{
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}
	
	
	
	@Test(enabled=true)
	public void filterTheResultsAndVerifyWordAvailableInList()
	{
		String vegName="Rice";
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");	
		driver.findElement(By.id("search-field")).sendKeys(vegName);
		List<WebElement> allMatchingElement = driver.findElements(By.xpath("//tr/td[1]"));
		
		List<WebElement> filteredList = allMatchingElement.stream().filter(s->s.getText().contains(vegName)).collect(Collectors.toList());
		
		Assert.assertEquals(allMatchingElement.size(), filteredList.size());
		
	}
	
	
	
	//sorting of dropdown option
	@Test(enabled=false)
	public void clickOnDropDown() throws InterruptedException
	{
		driver.get("https://www.spicejet.com/");
		Thread.sleep(50000);
		driver.findElement(By.xpath("//div[text()='Currency']/parent::div/parent::div")).click();		
		List<WebElement> drpElement = driver.findElements(By.xpath("//div[text()='Currency']/parent::div/following-sibling::div//div[@dir='auto']"));
		
		drpElement.stream().filter(s->s.getText().contains("SAR")).forEach(s->selectOptionFromDrp(s));
	}
	
	private static void selectOptionFromDrp(WebElement s)
	{
		s.click();
	}
	
	
	
	
	@Test(enabled=false)
	public void SortingOfDropDown() throws InterruptedException
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("dropdown-class-example")).click();	
		String option="Option3";
		List<WebElement> drpElement = driver.findElements(By.xpath("//*[@id='dropdown-class-example']/option[contains(@value, 'option')]"));
		
		List<String> drpOriginalOption = drpElement.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> drpSortedOption = drpOriginalOption.stream().sorted().collect(Collectors.toList());
		
		Assert.assertTrue(drpOriginalOption.equals(drpSortedOption));
		
		drpElement.stream().filter(s->s.getText().contains(option)).forEach(s->selectOptionFromDrp(s));
		
		String optionSelected = driver.findElement(By.xpath("//*[contains(text(),'"+option+"')]")).getText();
		
		Assert.assertEquals(optionSelected, option);
		
		driver.findElement(By.id("checkBoxOption1")).click();
		boolean status=driver.findElement(By.id("checkBoxOption1")).isSelected();
		Assert.assertTrue(status);
	}
	
	
	
	
	@AfterTest
	public void tearDown()
	{
		//driver.quit();
	}
}
