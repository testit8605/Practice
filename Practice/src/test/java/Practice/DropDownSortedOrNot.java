package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownSortedOrNot {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D://Selenium Project/Drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		Select select = new Select(driver.findElement(By.xpath("//select[@id='speed']")));
		List <WebElement> options =  select.getOptions();
		
		List originallist = new ArrayList();
		List templist = new ArrayList();
		
		for(WebElement option:options)
		{
			originallist.add(option.getText());
			templist.add(option.getText());
		}
		
		System.out.println(originallist);
		System.out.println(templist);
		
		Collections.sort(templist);
		
		System.out.println(originallist);
		System.out.println(templist);
		
		if(originallist == templist)
		{
			System.out.println("Sorted");
		}
		else
			System.out.println("not sorted");
	}

}
