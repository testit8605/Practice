package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class jQueryDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.id("justAnInputBox")).click();
		
		List<WebElement> choiceList = driver.findElements(By.xpath("//span[@class = 'comboTreeItemTitle']"));
		selectChoiceValue(driver, choiceList, "All");
		//driver.close();

	}
	
	public static void selectChoiceValue(WebDriver driver, List<WebElement> choiceList, String...value) throws InterruptedException
	{
		
		
		
		if(!value[0].equalsIgnoreCase("All"))
		{
			for(WebElement allItems:choiceList)
			{
				String allOptionsList = allItems.getText();
				
				for(String selectedOptions:value) {
					
					if(allOptionsList.equals(selectedOptions))
					{
						allItems.click();
						break;
					}
				}
			}
		}
		else
		{
			for(WebElement allItems:choiceList)
			{
				allItems.click();
				Thread.sleep(500);
			}
		}
		
		
	}
	
	
			

}
