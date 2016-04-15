package week3;

import org.junit.Test;

public class HomeWork1 extends MyWrapper{

	@Test
	public void workFlow()
	{
		//open web page in browser specified
		
		// open in chrome
		getPage("chrome","http://demo1.opentaps.org/opentaps/control/main"); 
		
		// open in firefox
		//getPage("firefox","http://demo1.opentaps.org/opentaps/control/main");
		
		// open in IE
		//getPage("ie","http://demo1.opentaps.org/opentaps/control/main");
		
		// enter username
		enterByName("USERNAME", "DemoSalesManager");
		
		// enter password
		enterById("password", "crmsfa");
		
		// click on login 
		clickByXpath("//p[@id='login']/p[3]/input");
		
		// verify welcome message
		System.out.println(verifyText(driver.findElementByXPath("//div[@id='form']/h2"), "Welcome <br> Demo Sales Manager"));
		
		// click on CRM/SFA link
		clickByXpath("//div[@id='button']/a");
		
		// click on create lead link
		driver.findElementByLinkText("Create Lead").click();
		
		// enter company name
		enterById("createLeadForm_companyName", "Jumped");
		
		// enter firstname
		enterById("createLeadForm_firstName", "Arun");
		
		// enter lastname
		enterById("createLeadForm_lastName", "Rajamani");
		
		// change currency type
		selectValueByIndex(driver.findElementById("createLeadForm_currencyUomId"), 35);
		
		// click on submit button
		driver.findElementByName("submitButton").click();
		
		// verify view lead page opened
		System.out.println(verifyText(driver.findElementById("sectionHeaderTitle_leads"), "View Lead"));
		
		// click on my home link
		driver.findElementByLinkText("My Home").click();
		
		// click on create contact link
		driver.findElementByLinkText("Create Contact").click();
		
		// enter first name
		enterById("firstNameField", "Arun");
		
		// enter last name
		enterById("lastNameField", "Rajamani");
		
		// clikc on create contact button
		driver.findElementByLinkText("Create Contact").click();
		
		// click on log out
		driver.findElementByLinkText("Logout").click();
		
		// close page
		driver.close();
	}

}
