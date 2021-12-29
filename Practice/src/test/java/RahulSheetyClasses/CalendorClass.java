package RahulSheetyClasses;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendorClass {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		//driver.get("https://www.path2usa.com/travel-companions/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
//		driver.findElement(By.id("travel_date")).click();
//		
//		while(!driver.findElement(By.xpath("//table[@class=' table-condensed']//th[@class='datepicker-switch']")).getText().contains("December 2022"))
//		{
//			driver.findElement(By.xpath("//table[@class=' table-condensed']//th[@class='next']")).click();
//		}
//		
//		List<WebElement> e= driver.findElements(By.xpath("//*[@class='day']"));
//		for(WebElement f:e)
//		{
//			if(f.getText().equals("30"))
//			{
//				f.click();
//				break;
//			}
//		}
		
		driver.get("https://www.makemytrip.com/flights");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='departure']/parent::label")).click();
		
		//Select month
		
		String monthName = "December 2022";
		String selectDay = "19";
		
		List<WebElement> option = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']"));
		
		for(int i=0;i<option.size();i++)
		{
			int count=0;
			
			if(option.get(i).getText().contains(monthName))
			{
				System.out.println(option.get(i).getText());
				List<WebElement> days = driver.findElements(By.xpath("//div[contains(text(),'"+monthName+"')]/parent::div/parent::div//div//div[contains(@aria-disabled,'false')]"));
				for(WebElement day:days)
				{
					System.out.println(day.getText());
					if(day.getText().contains(selectDay))
					{
						day.click();
						break;
					}
				}
			}
			else
			{
				count++;
				if(count==2)
				{
					driver.findElement(By.xpath("//span[contains(@class,'NavButton--next')]")).click();
					Thread.sleep(3000);
				}
				
			}
		}
	}

}
