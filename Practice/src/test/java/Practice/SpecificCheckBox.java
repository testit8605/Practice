package Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpecificCheckBox {

	public static void main(String[] args) {
			
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		List <WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id, 'day')]"));
		System.out.println(checkBox.size());
		
		//All checkbox
		/*for(int i=0; i<checkBox.size(); i++)
		{
			checkBox.get(i).click();
		}*/
		
		
		/*for(WebElement checkBoxs:checkBox)
		{
			checkBoxs.click();
		}*/
		
		//Perticular check box
		
		/*for(WebElement checkBoxs:checkBox)
		{
			String day = checkBoxs.getAttribute("id");
			
			if(day.equals("monday") || day.equals("wednesday"))
			{
				checkBoxs.click();
			}
		}*/
		
		//last 2 check box
		
		/*for(int i =checkBox.size()-3; i<checkBox.size(); i++)
		{
			checkBox.get(i).click();
		}*/
		
		//First 2 check box
		
		for(int i =0; i<checkBox.size(); i++)
		{
			if(i<2) 
			{
				checkBox.get(i).click();
			}
			
		}
				

	}

}
