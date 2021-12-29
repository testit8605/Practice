package Practice;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class CapturedLogoImage {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		WebElement logoimage = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver,logoimage);
		ImageIO.write(logoImageScreenshot.getImage(), "png", new File(System.getProperty("user.dir")+ "\\Downloads\\C.png"));
		
		File f = new File(System.getProperty("user.dir")+ "\\Downloads\\C.png");
		if(f.exists()==true)
		{
			System.out.println("Test Pass");
		}
		
		
//		 TakesScreenshot scrShot =((TakesScreenshot)driver);
//		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//		 File DestFile=new File(fileWithPath);
//		 FileUtils.copyFile(SrcFile, DestFile);

	}

}
