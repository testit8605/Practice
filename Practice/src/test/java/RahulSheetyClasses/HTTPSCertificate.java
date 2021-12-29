package RahulSheetyClasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTTPSCertificate {

	public static void main(String[] args) {
		
		DesiredCapabilities desiredcapabilities = new DesiredCapabilities();
		desiredcapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		desiredcapabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		
		ChromeOptions options = new ChromeOptions();
		options.merge(desiredcapabilities);
		options.addArguments("--disable-notifications");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

}
