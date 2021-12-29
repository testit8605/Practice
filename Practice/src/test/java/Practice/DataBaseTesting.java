package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataBaseTesting {

	public static void main(String[] args) throws InterruptedException, SQLException {
		String firstName = "Akshay";
		String lastName = "Bhagat";
		String email = "test.com";
		String tele = "989898";
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/openshop", "root", "");
		Statement st = con.createStatement();
		String query = "Select firstName, lastName, email, telephone from or_Customer";
		ResultSet rs = st.executeQuery(query);
		
		boolean status = false;
		
		while(rs.next())
		{
			String c_firstName = rs.getString("firstname");
			String c_lastName = rs.getString("lastname");
			String c_email = rs.getString("email");
			String c_telephone = rs.getString("telephone");
			
			if(c_firstName.equals("firstName") && c_lastName.equals(lastName) && c_email.equals(email) && c_telephone.equals(tele))
			{
				System.out.println("record fount in table");
				status=true;
				break;
			}
		}
		if(status==false)
		{
			System.out.println("Record not found");
		}
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/nri-banking");
	}
	

	

}
