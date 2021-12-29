package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendor2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		String month = "August";
		String day = "25";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		
		Thread.sleep(3000);																						
		
		//String fixdate = driver.findElement(By.xpath("//body/div[@id='datepickers-container']/div[2]/nav[1]/div[2]")).getText();
		//System.out.println(fixdate);
		//div[@id='datepickers-container']
		
		while(true)
		{
			String fixdate = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			System.out.println(fixdate);
			if(fixdate.equals(month)) 
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				
			}
		}
		
		driver.findElement(By.linkText("10")).click();
	}

}
