package Practice;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		WebElement joinfree = driver.findElement(By.xpath("//ul[@class='control-bar']//li[2]//a[1]"));
		WebElement joinNow = driver.findElement(By.xpath("//li[@id='centered-btns2_s0']//a[@class='btn green']"));
		
		/*
		//getTitle
		System.out.println(JavascriptUtils.getTitleByJS(driver));
		//driver.getTitle();
		
		Thread.sleep(5000);
		
		//flashing
		JavascriptUtils.flashing(joinfree, driver);
		
		Thread.sleep(5000);
				
		//draw and capture screenshot
		JavascriptUtils.DrawBorder(joinfree, driver);
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "\\Downloads\\p.png\\");
		FileUtils.copyFile(src, target);
		
		//click on element by java script
		
		JavascriptUtils.clickElementByJS(joinfree, driver);
		//Thread.sleep(5000);
				
		//Generate alert
		JavascriptUtils.generateAlert(driver, "You click on join free");
		Thread.sleep(5000);
		
		JavascriptUtils.refreshBrowserByJS(driver);
		
		*/
		
		//JavascriptUtils.scrollIntoView(driver, joinNow);
		JavascriptUtils.scrollPageDown(driver);
		
		//driver.close();
		
		

	}

}
