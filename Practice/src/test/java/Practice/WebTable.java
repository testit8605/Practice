package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D://Selenium Project/Drivers/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.javatpoint.com/html-table");
		
		int rownum  = driver.findElements(By.xpath("//*[@id=\"city\"]/table/tbody/tr/td/table[3]/tbody/tr")).size();
		System.out.println(rownum);
		int colcount = driver.findElements(By.xpath("//*[@id=\"city\"]/table/tbody/tr/td/table[3]/tbody/tr[1]/th")).size();
		System.out.println(colcount);
		
		for(int i=2; i<=rownum; i++)
		{
			for(int j=1; j<=colcount; j++)
			{
				System.out.print(driver.findElement(By.xpath("//*[@id=\"city\"]/table/tbody/tr/td/table[3]/tbody/tr["+i+"]/td["+j+"]")).getText()+" ");
				
			}
			System.out.println();	
		}
		
		
		

	}

}
