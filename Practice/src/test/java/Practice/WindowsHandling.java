package Practice;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "D://Selenium Project/Drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Windows.html");
		driver.findElement(By.xpath("//a[@href='http://www.selenium.dev']//button[@class='btn btn-info'][normalize-space()='click']")).click();
		
		
		
		Set <String> s = driver.getWindowHandles();
		
		for(String i: s)
		{
			System.out.println(i);
			
			String t = driver.switchTo().window(i).getTitle();
			if(t.equals("Frames & windows")) {
				driver.close();
			}
		}
		
		
		

	}

}
