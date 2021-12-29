package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		
     
		System.setProperty("webdriver.chrome.driver","D://Selenium Project/Drivers/chromedriver1.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/newtours/");
		
		
		FileInputStream file = new FileInputStream("D://TestData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet2");
		
		int rowcount = sheet.getLastRowNum();
		int cellcount = sheet.getRow(0).getLastCellNum();
		
		for(int row=1; row<=rowcount; row++)
		{
			XSSFRow currentrow= sheet.getRow(row);
			
			String FirstName = currentrow.getCell(0).getStringCellValue();
			String LastName = currentrow.getCell(1).getStringCellValue();
			int phone = (int)currentrow.getCell(2).getNumericCellValue();
			String Email = currentrow.getCell(3).getStringCellValue();
			String address = currentrow.getCell(4).getStringCellValue();
			String city = currentrow.getCell(5).getStringCellValue();
			String state = currentrow.getCell(6).getStringCellValue();
			int pincode = (int)currentrow.getCell(7).getNumericCellValue();
			
			String country = currentrow.getCell(8).getStringCellValue();
			String uname = currentrow.getCell(9).getStringCellValue();
			String paww = currentrow.getCell(10).getStringCellValue();
			
			driver.findElement(By.xpath("//a[normalize-space()='REGISTER']")).click();
			
			driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(FirstName);
			driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(LastName);
			driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(String.valueOf(phone));
			driver.findElement(By.xpath("//input[@id='userName']")).sendKeys(Email);
			driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address);
			driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
			driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
			driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(String.valueOf(pincode));
			
			Select select = new Select(driver.findElement(By.xpath("//select[@name='country']")));
			select.selectByVisibleText(country);
			
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("uname");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(paww);
			driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(paww);
			
			
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			
			
			if(driver.getTitle().equals("Register: Mercury Tours")) {
				System.out.println("Pass");
			}
			else {
				System.out.println("Failed");
			}
			
			driver.findElement(By.xpath("//a[normalize-space()='sign-in']")).click();
			
		}
		

	}
	
//	String username = xlreader.getCellData("Sheet1", i, 0);
//	String password = xlreader.getCellData("Sheet1", i, 1);
//	String exp = xlreader.getCellData("Sheet1", i, 2);

}
