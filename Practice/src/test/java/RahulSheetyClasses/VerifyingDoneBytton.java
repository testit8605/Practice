package RahulSheetyClasses;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyingDoneBytton {

	public static void main(String[] args) throws InterruptedException {

		myTest();
	}

	@Test
	public static void myTest() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Selecting one way checkbox
		List<WebElement> checkBoxes = driver.findElements(By.xpath("//div[contains(@data-testid,'radio-button')]"));
		Thread.sleep(1000);
		for (WebElement checkBox : checkBoxes) {
			System.out.println(checkBox.getText());
			if (checkBox.getText().equalsIgnoreCase("One Way")) {
				checkBox.click();
				break;
			}
		}
		//Verify checkbox is selected
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@data-testid,'one-way-radio-button')]")).isEnabled());

		// selecting cities
		String sourceCity = "Mumbai";
		String destinationCity = "Pune";
		driver.findElement(By.xpath("//div[text()='From']")).click();
		driver.findElement(By.xpath("//*[text()='"+sourceCity+"']")).click();
		driver.findElement(By.xpath("//*[text()='"+destinationCity+"']")).click();

		// Selecting Todays date
		Calendar calendar = Calendar.getInstance();
		String[] month = new String[] { "January", "February", "March", "April", "May", "June", "July", "August","September", "October", "November", "December" };
		String currentDay = Integer.toString(calendar.get(calendar.DATE));
		String currentMonth = month[calendar.get(Calendar.MONTH)];
		int currentYear = calendar.get(calendar.YEAR);

		List<WebElement> allDates = driver.findElements(By.xpath("//*[@data-testid='undefined-month-" +currentMonth+"-"+currentYear+"']//div[contains(@data-testid,'undefined-calendar')]"));
		for (WebElement alldate : allDates) {
			String dt = alldate.getText();
			if (dt.equals(currentDay)) {
				alldate.click();
				break;
			}
		}

		// Validation of Return type Data Drop down disabled
		if (driver.findElement(By.xpath("//div[contains(text(),'Return Date')]")).getAttribute("style").contains("opacity: 0.5")) 
		{
			System.out.println("Return type Dropdown is disabled");
			Assert.assertTrue(true);
		} 
		else 
		{
			System.out.println("Return type Dropdown is enabled");
			Assert.assertTrue(false);
		}

		//Select Passengers
		int selectNumberOfAdults= 5;
		String numbersOfAdults = driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText();
		Assert.assertEquals(numbersOfAdults, "1 Adult");
		driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).click();
		for(int i=1;i<selectNumberOfAdults;i++)
		{
			driver.findElement(By.xpath("//div[contains(@data-testid,'Adult-testID-plus')]")).click();
		}
		driver.findElement(By.xpath("//div[text()='Done']/parent::div")).click();
		Thread.sleep(1000);
		numbersOfAdults = driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText();
		Assert.assertEquals(numbersOfAdults, ""+selectNumberOfAdults+" Adults");

		// Select currency
		driver.findElement(By.xpath("//*[text()='Currency']/parent::div/parent::div")).click();
		List<WebElement> drpOptions = driver.findElements(By.xpath("//div[text()='Currency']/parent::div/following-sibling::div//div[contains(@style,'font-family')]"));
		for (WebElement drpOption : drpOptions) 
		{
			if (drpOption.getText().contains("LKR")) 
			{
				drpOption.click();
				break;
			}
		}

		// Click on LTC radio button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@style,'cursor')]//div[text()='LTC']")).click();

		// Click on search button
		driver.findElement(By.xpath("//div[text()='Search Flight']/parent::div/parent::div")).click();;
			
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(),"SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");

	}

}
