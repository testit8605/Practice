package Practice;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BarCodeTesting {

	public static void main(String[] args) throws IOException, NotFoundException {


		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		
		String barcodeURL = driver.findElement(By.xpath("//div[@id='HTML4']//div[@class='widget-content']//img")).getAttribute("src");
		URL url = new URL(barcodeURL);
		
		
		BufferedImage bufferedimage = ImageIO.read(url);
		LuminanceSource luminancesource = new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(luminancesource));
		Result result = new MultiFormatReader().decode(bitmap);
		System.out.println(result);	


		
		

	}

}
