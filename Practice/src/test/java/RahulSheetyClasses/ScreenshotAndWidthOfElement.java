package RahulSheetyClasses;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotAndWidthOfElement {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");	
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement e = driver.findElement(By.name("name"));
		e.sendKeys("Akshay");
		File src = e.getScreenshotAs(OutputType.FILE);
		//File tgr = new File("C://Users//bhaga//myworkspace//Practice//Downloads//ak.PNG");
		File tgr2 = new File("Downloads//Aksha.PNG");
		FileUtils.copyFile(src, tgr2);
		
		System.out.println(e.getRect().getDimension().getWidth());
		System.out.println(e.getRect().getDimension().getHeight());
		
		driver.close();
	}

}
