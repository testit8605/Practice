package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingDown3Ways {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0, 3000)", "");
		
		//WebElement shopnow = driver.findElement(By.xpath("//a[@aria-label='Best Sellers in Kitchen - Shop now']"));
		//js.executeScript("arguments[0].scrollIntoView();", shopnow);
		
		
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		//js.executeScript("window.scrollBy(0,500)");
		
		
		



	}

}
