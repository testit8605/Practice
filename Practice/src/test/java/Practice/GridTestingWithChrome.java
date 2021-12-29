package Practice;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GridTestingWithChrome 
{
	WebDriver driver;
	
	@Test(priority=1)
	void setup() throws MalformedURLException
	{
		String nodeurl = "http://192.168.43.174:4444/wd/hub";
		
		//DesiredCapabilities cap = DesiredCapabilities.chrome(); // use selenium version 3.14
		//cap.setBrowserName("chrome");
		//cap.setPlatform(Platform.WIN10);
		
		WebDriverManager.chromedriver().setup();
		//driver = new RemoteWebDriver(new URL(nodeurl), cap);
	}
	
	//Node--> java -Dwebdriver.chrome.driver="C:\Users\admin\Desktop\chromedriver_win32\driver\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.43.174:4444/grid/register/
	//Hub---> java -jar selenium-server-standalone-3.141.59.jar -role hub
	//check grid is online: http://localhost:4444/grid/console
	
	
	@Test(priority=2)
	void capcha() throws NotFoundException, IOException
	{
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		String barcodeURL = driver.findElement(By.xpath("//div[@id='HTML4']//div[@class='widget-content']//img")).getAttribute("src");
		URL url = new URL(barcodeURL);
		
		BufferedImage bufferedimage = ImageIO.read(url);
		LuminanceSource luminancesource = new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));
		Result result = new MultiFormatReader().decode(bitmap);
		System.out.println(result);
		System.out.println("Test pass");
	}
	
	
	

}
