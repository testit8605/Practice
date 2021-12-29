package Practice;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EncodeString {

	public static void main(String[] args) {
		
		/*String s = "admin123";
		
		byte[] encodedString = Base64.encodeBase64(s.getBytes());
		
		System.out.println("Encoded String:" + new String(encodedString));
		
		
		byte[] decodedString = Base64.decodeBase64(encodedString);
		System.out.println("Decoded String:"+ new String(decodedString));  
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(decodedString("YWRtaW4xMjM="));	//YWRtaW4xMjM=
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

	}
	
	static String decodedString(String password)
	{
		byte[] decodedstring = Base64.decodeBase64(password);
		return(new String(decodedstring));    */
	
	
		String t = "admin123";
		byte[] encodedString = Base64.encodeBase64(t.getBytes());
		
		System.out.println(new String(encodedString));
		
		byte[] decodedstring = Base64.decodeBase64(encodedString);
		
		System.out.println(new String(decodedstring));
		
		
	
	}
	
	
}
