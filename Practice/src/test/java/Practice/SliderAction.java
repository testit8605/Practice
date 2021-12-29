package Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderAction 
{
	
	public static void main (String args[])
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		WebElement min_slider = driver.findElement(By.xpath(""));
		WebElement max_slider = driver.findElement(By.xpath(""));
		
		//Add Dimention extension for chrome
		System.out.println("Location min slider "+min_slider.getLocation());
		System.out.println("height and width min slider "+min_slider.getSize());
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(max_slider, 100, 0).perform();
		
	}
}
