package Stream;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumStreamAmazon {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
//		for(WebElement element:links)
//		{
//			System.out.println(element.getText());
//		}
				
//		links.forEach(s->System.out.println(s.getText()));
		
		List<String> newLinks =  links.stream().filter(s-> !s.getText().equals("")).map(s-> s.getText()).collect(Collectors.toList());
		
		newLinks.forEach(s->System.out.println(s));
		
		System.out.println("2*****************************************************");
		
		String firstText = links.stream().filter(s-> !s.getText().equals("")).findFirst().get().getText();
		System.out.println(firstText);
		
		System.out.println("3*****************************************************");
		
		String firstText2 = links.stream().filter(s-> !s.getText().equals("")).findAny().get().getText();
		System.out.println(firstText2);
		
		System.out.println("4*****************************************************");
		
		List<String> i =links.stream().filter(s-> !s.getText().equals("") && s.getText().startsWith("Amazon")).map(s-> s.getText()).collect(Collectors.toList());
		i.forEach(s->System.out.println(s));
		
		System.out.println("5*****************************************************");
		
		List<String> p = links.stream().filter(s->!s.getText().equals("") && s.getText().contains("Amazon")).map(s->s.getText()).collect(Collectors.toList());
		p.forEach(s->System.out.println(s));
		
		System.out.println("6*******************Should not any blank and space**********************************");
		
		List<String> a = links.stream()
				.filter(s->!s.getText().equals("") && !s.getText().isEmpty())
				.map(s->s.getText().trim())
				.collect(Collectors.toList());
		
		a.forEach(s->System.out.println(s));
		
		System.out.println("7*******************Should not any blank and space**********************************");
			
		
	}

}
