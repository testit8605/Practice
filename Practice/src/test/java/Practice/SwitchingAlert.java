package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchingAlert {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.automationtesting.in/Alerts.html");
		
		driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
		
		driver.switchTo().alert().sendKeys("Testing");
		driver.switchTo().alert().accept();
		
		String Exptext = "Hello Testing How are you today";
		
		String actText = driver.findElement(By.xpath("//p[@id='demo1']")).getText();
		
		if(Exptext.equals(actText))
		{
			System.out.println("Test is pass");
		}

	}

}
