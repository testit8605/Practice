package Stream;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumStreamWindowHandler {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0]. click();", driver.findElement(By.xpath("//button[@class='btn btn-primary']")));
		
		String title = switchToWindowTest(driver, "Selenium");
		System.out.println(title);
		
		

	}
	
	public static String switchToWindowTest(WebDriver driver, String title)
	{
		return driver.getWindowHandles().stream().map(handler-> driver.switchTo().window(handler).getTitle())
		.filter(ele->ele.contains(title))
		.findFirst()
		.orElseThrow(() -> {
			throw new RuntimeException("No Such Window");
		});			
	}

}
