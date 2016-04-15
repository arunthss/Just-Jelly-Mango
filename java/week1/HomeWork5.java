package week1;
import org.openqa.selenium.firefox.FirefoxDriver;
public class HomeWork5 
{
	public static void main(String[] args) 
	{
		// Create object for Driver
		FirefoxDriver myDriver = new FirefoxDriver();
		
		// Open opentaps.or website
		myDriver.get("http://demo1.opentaps.org/");
		
		// enter username
		myDriver.findElementById("username").sendKeys("DemoSalesManager");
		
		//enter password
		myDriver.findElementById("password").sendKeys("crmsfa");
		
		// click submit button
		myDriver.findElementByClassName("decorativeSubmit").click();
		
		// now click on crm/sfa link 
		myDriver.findElementByLinkText("CRM/SFA").click();
		
		// click on create lead link
		myDriver.findElementByLinkText("Create Lead").click();
		
		//enter company name as test leaf
		myDriver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
		
		//enter firstname as test 
		myDriver.findElementById("createLeadForm_firstName").sendKeys("Test");
		
		//enter last name as test
		myDriver.findElementById("createLeadForm_lastName").sendKeys("Test");
		
		// click submit button
		myDriver.findElementByName("submitButton").click();
		
		// written instructions for logout and close
		
		//myDriver.findElementByName("Logout").click();
		//myDriver.close();
	}

}
