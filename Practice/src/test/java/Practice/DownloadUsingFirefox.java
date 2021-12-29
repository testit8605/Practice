package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadUsingFirefox {

	public static void main(String[] args) {
		
		// WOrd File
		
		
		/*String location = System.getProperty("user.dir")+"\\Downloads\\";
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/msword");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", location);
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		

		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver(options);
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		
		driver.close();  */
		
		
		
		//PDF File
		
        
		
		String location = System.getProperty("user.dir")+"\\Downloads\\";
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference("browser.download.dir", location);
		
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(profile);
		

		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver(options);
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
		
		driver.close();
		
		
		

	}

}
