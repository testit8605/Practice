package Practice;

import java.awt.image.BufferedImage;
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
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class CompareImages {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		BufferedImage expImage = ImageIO.read(new File(System.getProperty("user.dir")+ "\\Downloads\\A.png"));
		
		WebElement logoImage = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		
		Screenshot logoimagescreenshot = new AShot().takeScreenshot(driver,logoImage);
		BufferedImage actImage = logoimagescreenshot.getImage();
		
		ImageDiffer differ = new ImageDiffer();
		ImageDiff diff = differ.makeDiff(expImage, actImage);
		
		if(diff.hasDiff()==true)
		{
			System.out.println("Test fail");
		}
		else
		{
			System.out.println("Test Pass");
		}
		 driver.close();
		 

	}

}
