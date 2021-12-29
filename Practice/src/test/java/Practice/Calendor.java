package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendor {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "D://Selenium Project/Drivers/chromedriver1.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		
		for(int i=7; i>=1; i--) 
		{
			String month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			
			
			if(month.equals("December"))
			{
				driver.findElement(By.linkText("10")).click();
			}
			
		}
		
		
		

	}

}
