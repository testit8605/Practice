package Practice;

import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/nri-banking");
		
		driver.findElement(By.xpath("//div[@class='drp1']//div[@class='dropdown']")).click();
		List <WebElement> SelectProductType = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']//li"));
		System.out.println(SelectProductType.size());
		selectOptionsFromBootstrapDropdown(SelectProductType, "Loans");
		
		driver.findElement(By.xpath("//div[@class='drp2']//div[@class='dropdown']")).click();
		List <WebElement> SelectProduct = driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
		System.out.println(SelectProduct.size());
		selectOptionsFromBootstrapDropdown(SelectProduct, "Home Loan");
		
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//a[normalize-space()='Apply online']")).click();
		
		//driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		
		Set <String> windowsID = driver.getWindowHandles();
		List <String> windowIDList = new ArrayList(windowsID);
		
		String childWindowID = windowIDList.get(0);
		String parntWindowID = windowIDList.get(1);
		driver.switchTo().window(parntWindowID);
		
		
		driver.findElement(By.xpath("//input[@id='txtFName']")).sendKeys("Akshay");
		driver.findElement(By.xpath("//input[@id='txtLName']")).sendKeys("Bhagat");
		
		driver.findElement(By.xpath("//input[@id='txtDateOfBirth']")).click();
		
		WebElement monthDrp = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		selectOptionsFromDropdown(monthDrp, "Feb");
		WebElement yearDrp = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		selectOptionsFromDropdown(yearDrp, "1995");
		
		List <WebElement> dateSelection = driver.findElements(By.xpath("//div[@id='ui-datepicker-div']//td"));
		selectDayFromDatePicker(dateSelection, "28");
		
		WebElement selectCountry = driver.findElement(By.name("ddlCountry"));
		selectOptionsFromDropdown(selectCountry, "INDIA");
		
		WebElement netSalaryIncome = driver.findElement(By.name("ddlNetIncome"));
		selectOptionsFromDropdown(netSalaryIncome, "10000-15000");
		
		driver.findElement(By.id("accHolderY")).click();
		
		WebElement loanRequired = driver.findElement(By.name("ddlLoanAmtReq"));
		selectOptionsFromDropdown(loanRequired, "0 to 30 Lac");
		
		
		//driver.close();
		
	}
	
	public static void selectOptionsFromBootstrapDropdown(List<WebElement> options, String value)
	{
		
		for(WebElement option:options)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}
	}
	
	public static void selectOptionsFromDropdown(WebElement element, String value)
	{
		Select select = new Select(element);
		List <WebElement> options = select.getOptions();
		
		for(WebElement option:options)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}
		
	}
	
	public static void selectDayFromDatePicker(List <WebElement> options, String value)
	{
		for(WebElement option:options)
		{
			if(option.getText().equals(value))
			{
				option.click();
				break;
			}
		}
	}

}
