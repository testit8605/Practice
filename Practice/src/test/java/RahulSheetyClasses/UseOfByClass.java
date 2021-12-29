package RahulSheetyClasses;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UseOfByClass {

	public static By emailTextField = By.id("email");
	public static By passTextField = By.id("pass");
	public static By createNewButton = By.xpath("//a[@role='button' and contains(text(), 'Create New Account')]");
	
	public static By signUpTextFilds(String text)
	{
		return By.xpath("//input[contains(@name, '"+text+"')]");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test(dataProvider="loginData", dataProviderClass=B.class)
//	public void loginData(String uname, String pwd)
//	{
//		System.out.println(uname+":"+ pwd);
//	}
//	
//	@DataProvider(name ="loginData")
//	public String[][] getData()
//	{
//		String arr[][] = {{"Akshay", "Bhagat"},{"vaibhav", "Bhagat"},{"Swapnil", "Bhagat"}};
//		return arr;
//	}

}
