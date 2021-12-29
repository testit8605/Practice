package Practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtils {
	
	//Flashing
	
	public static void flashing(WebElement element, WebDriver driver)
	{
		String bgcolor = element.getCssValue("backgroundColor");
		
		for(int i= 0; i<=50; i++)
		{
			changeColor("#000000" , element, driver);
			changeColor(bgcolor, element, driver);
		}
	}
	
	public static void changeColor(String color, WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
	}
	
	
	//DrawBorder
	
	public static void DrawBorder(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border= '3px solid red'", element);
	}
	
	//GetTitle
	
	public static String getTitleByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		String title = js.executeScript("return document.title;").toString();
		return title;
	}
	
	//Click on Elements 
	
	public static void clickElementByJS(WebElement element, WebDriver driver)
	{
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	
	//Generate alert
	
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("alert('"+message+"')");
	}
	
	
	//Refresh page
	
	public static void refreshBrowserByJS(WebDriver driver)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)");
	}
	
	//Scrolling page to element 
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		//js.executeScript("window.scrollBy(0,500)");
		
	}
	
	//Scrolling page to bottom
	
		public static void scrollPageDown(WebDriver driver)
		{
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			//js.executeScript("window.scrollBy(0,500)");
			
		}
	
	
	
	
	

}
