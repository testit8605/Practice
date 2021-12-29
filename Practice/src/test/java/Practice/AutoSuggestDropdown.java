package Practice;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("sb_form_q")).sendKeys("Java");
		
		//Thread.sleep(5000);
		List <WebElement> list = driver.findElements(By.xpath("//li[@class='sa_sg']"));
		
		for(WebElement lists:list)
		{
			String autoSuggestOptions = lists.getText();
			if(autoSuggestOptions.contains("javatpoint"))
			{
				lists.click();
				break;
			}
		}
		

	}

}
