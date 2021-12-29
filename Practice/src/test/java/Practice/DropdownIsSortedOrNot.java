package Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropdownIsSortedOrNot {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		WebElement drp1 = driver.findElement(By.id("number"));
		
		Select select = new Select(drp1);
		List <WebElement> drpOptions = select.getOptions();
		
		List originalList = new ArrayList();
		List tempList = new ArrayList();
		
		for(WebElement drpOption:drpOptions)
		{
			originalList.add(drpOption.getText());
			tempList.add(drpOption.getText());
			
		}
		Collections.sort(tempList);
		
		if(originalList.equals(tempList))
		{
			Assert.assertTrue(true);
			System.out.println("Test Pass");
		}
		else
		{
			System.out.println("Test Fail");
		}

	}

}
