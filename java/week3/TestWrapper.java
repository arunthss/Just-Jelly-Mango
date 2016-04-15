package week3;

import org.junit.Test;
import org.openqa.selenium.support.ui.Select;

public class TestWrapper extends OpenTapsMethods{

	@Test
	public void myMethod() throws InterruptedException
	{
		/*
		openUrl("firefox", "http://demo1.opentaps.org/");
		loginMethod("DemoSalesManager", "crmsfa");
		openCrmLink();
		createLead();
		
		
		
		driver.findElementById("createLeadForm_companyName").sendKeys(company);
		driver.findElementById("createLeadForm_firstName").sendKeys("SHA_Arun");
		driver.findElementById("createLeadForm_lastName").sendKeys("SHA_Rajamani");
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("123456");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("test@test.com");
		
		Select mySel = new Select(driver.findElementById("createLeadForm_dataSourceId"));
		mySel.selectByIndex(5);
		
		mySel = new Select(driver.findElementById("createLeadForm_marketingCampaignId"));
		mySel.selectByIndex(2);
		
		driver.findElementByName("submitButton").click();
		
		*/

		//String value = driver.findElementById("viewLead_firstName_sp").getText();
		String id = "SHA_test (10050)";
		
		
		System.out.println(id.substring(id.indexOf('(')+1,id.length()-1));
	}
}
