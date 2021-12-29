package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable2 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium Project/Drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		
		driver.findElement(By.xpath("//b[normalize-space()='Admin']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='User Management']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Users']")).click();
		
		int rowcount = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[4]/table[1]/tbody[1]/tr")).size();
		System.out.println(rowcount);
		int colcount = driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/form[1]/div[4]/table[1]/thead[1]/tr[1]/th")).size();
		System.out.println(colcount);
		
		//int counter=0;
		
		for(int i =1; i<=rowcount; i++)
		{
			
			String UserRole = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+i+"]/td[3]")).getText();
			
			if(UserRole.equals("Admin")) {
				
		
			String EMPName = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+i+"]/td[4]")).getText();
			String Status = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr["+i+"]/td[5]")).getText();
			System.out.println(UserRole+ " " +EMPName);
		
			}
		
		}
		
		

	}

}
