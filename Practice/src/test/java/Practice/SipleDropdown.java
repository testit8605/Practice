package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SipleDropdown {

	public static void main(String[] args) {


		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement SelectSpeed = driver.findElement(By.xpath("//select[@id='speed']"));
		selectOptionFromDropdown(SelectSpeed, "Slow");
		
		WebElement SelectFile = driver.findElement(By.xpath("//select[@id='files']"));
		selectOptionFromDropdown(SelectFile, "PDF file");
		
		WebElement selectNumber = driver.findElement(By.xpath("//select[@id='number']"));
		selectOptionFromDropdown(selectNumber, "5");
		
		WebElement selectProduct = driver.findElement(By.xpath("//select[@id='products']"));
		selectOptionFromDropdown(selectProduct, "Yahoo");
		
		WebElement selectAnimal = driver.findElement(By.xpath("//select[@id='animals']"));
		selectOptionFromDropdown(selectAnimal, "Avatar");
		
		System.out.println("Test Pass");
		
		driver.close();

	}
	public static void selectOptionFromDropdown(WebElement element, String value)
	{
		Select select = new Select(element);
		List <WebElement> allOptions = select.getOptions();
		
		for(WebElement option:allOptions)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}

	}

}
