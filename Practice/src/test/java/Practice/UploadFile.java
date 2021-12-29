package Practice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile {

	public static void main(String[] args) throws AWTException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//When type= file present use send keys method
		
		/*driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title='Click to upload your resume']")).click();
		
		driver.findElement(By.xpath("//input[@id='file-upload']")).sendKeys("C:\\Users\\bhaga\\Desktop\\sanju bHAI.pdf");
		WebElement button = driver.findElement(By.xpath("//input[@id='pop_upload']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button); */
		
		
		//When type= file not present 
		
		
		driver.get("https://www.monsterindia.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[@title='Click to upload your resume']")).click();
		
		WebElement button = driver.findElement(By.xpath("//input[@id='file-upload']"));
		//button.sendKeys(Keys.ENTER);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button); 

		Robot rb = new Robot();
		rb.delay(2000);
		StringSelection ss = new StringSelection("C:\\Users\\bhaga\\Desktop\\sanju bHAI.pdf");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.delay(2000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.delay(2000);
		
		
		
        WebElement button2 = driver.findElement(By.xpath("//input[@id='pop_upload']"));
		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].click();", button2); 
		
		
		
		

	}

}
