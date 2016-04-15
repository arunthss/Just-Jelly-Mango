package week2;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;

public class HomeWork12 {

	public static void main(String[] args) 
	{
		// create object for firefox driver
		FirefoxDriver driver = new FirefoxDriver();
		
		// get URL
		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		// create object for select class by pointing to a dropdown
		Select obj = new Select(driver.findElementById("userRegistrationForm:countries"));
		
		// store list of options in a list
		List <WebElement> list = obj.getOptions();
		
		// print total number of options present in drop down box
		System.out.println("Drop Down has "+list.size()+ " options");
		
		// enter for each loop and print option text 
		for (WebElement ele : list) {
			System.out.println(ele.getText());
		}
		
		// select second option in dropdown INDIA
		obj.selectByIndex(1);
		
		// close driver
		driver.close();
	}

}
