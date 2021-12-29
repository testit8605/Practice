package Practice;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hashmap {

	static HashMap <String, String> loginData()
	{
		HashMap <String, String> hm = new HashMap<String, String>();
		hm.put("x", "Akshay@Akhsay");
		hm.put("y", "Akshay@Akhsay");
		hm.put("z", "Akshay@Akhsay");
		
		return hm;
	}
	

	public static void main(String[] args) 
	{
		
		String data = loginData().get("x");
		System.out.println(data);
		String arr[] = data.split("@");
		System.out.println(arr[0]);
		System.out.println(arr[1]);

	}

}
