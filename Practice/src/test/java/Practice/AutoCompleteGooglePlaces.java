package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoCompleteGooglePlaces {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/newsearchserviceneed");
		
		WebElement AutoCompleteDrp = driver.findElement(By.id("autocomplete"));
		AutoCompleteDrp.clear();
		AutoCompleteDrp.sendKeys("Toronto");
		Thread.sleep(5000);
		
		String text=null;
		
		do 
		{
			AutoCompleteDrp.sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(3000);
			text = AutoCompleteDrp.getAttribute("value");
			
			if(text.equals("Toronto, KS, USA"))
			{
				AutoCompleteDrp.sendKeys(Keys.ENTER);
				break;
			}
			
			
			Thread.sleep(3000);
		} 
		
		while(!text.isEmpty());
		
		
		

	}

}
