package Practice;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadUsingChrome {

	public static void main(String[] args) {
		
		// WOrd File
		
		/*String location = System.getProperty("user.dir")+"\\Downloads\\";
		
		HashMap preferences = new HashMap();
		preferences.put("download.default_directory", location);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click(); */
		
		//PDF File
		
		String location = System.getProperty("user.dir")+"\\Downloads\\";
		
		HashMap preferences = new HashMap();
		preferences.put("plugins.always_open_pdf_externally", true);
		preferences.put("download.default_directory", location);
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-pdf-download/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]/a[1]")).click();
	

	}

}
