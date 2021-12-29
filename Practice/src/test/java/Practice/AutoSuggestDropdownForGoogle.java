package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdownForGoogle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Java");
		Thread.sleep(3000);
		List<WebElement> autoSuggersOptions = driver.findElements(By.xpath("//li[@class='sbct']//div[@role='option']//div[1]//span"));
		System.out.println(autoSuggersOptions.size());
		
		for(WebElement autoSuggersOption:autoSuggersOptions)
		{
			if(autoSuggersOption.getText().contains("javascript"))
			{
				autoSuggersOption.click();
				break;
				
			}
		}

	}

}
