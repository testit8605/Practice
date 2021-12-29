package Practice;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot
{
	
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Windows.html");
		
		//Full ss of page
//		TakesScreenshot ts = (TakesScreenshot)driver;
//		File scr = ts.getScreenshotAs(OutputType.FILE);
//		File tgr = new File(".\\Screenshot\\Akshay.png");
//		FileUtils.copyFile(scr, tgr);
		
		//SS of element
//		WebElement e = driver.findElement(By.tagName("a"));
//		File scr = e.getScreenshotAs(OutputType.FILE);
//		File tgr = new File(".\\Screenshot\\Akshay.png");
//		FileUtils.copyFile(scr, tgr);
		
		
		
		
		
	}
}
