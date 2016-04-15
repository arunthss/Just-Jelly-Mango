package project1;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class OpenTapsWrapper extends MyWrapper{

	public boolean loginOpenTaps(String username, String password)
	{
		boolean result = false;
		try 
		{
			enterById("username", username);
			enterById("password", password);
			clickByClassName("decorativeSubmit");
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			if(verifyText(driver.findElementByXPath("//div[@id='label']/a"), "CRM/SFA"))
			{
				result = true;
			}
		} 
		catch (NoSuchElementException e) 
		{
			System.out.println("Login Elements Unavailable");
		}
		return result;
	}
	
	public boolean openCRM()
	{
		// click CRM/SFA Link
		clickByXpath("//div[@id='label']/a");
		// wait for home page to load
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		// check if home page has opened
		if(verifyTitle("My Home | opentaps CRM"))
		{	
			System.out.println("My Home Page Opened");
			return true;
		}	
		else
			return false;
	}
	
	public boolean openCreateLeadPage()
	{	
		if(openCRM())
		{
			// check if Create Lead Link is available
			if(clickByXpath("//a[contains(text(),'Create Lead')]"))
			{
				System.out.println("Create Lead Click Successful");
				
				// check if Create Lead Page has opened
				if(verifyTitle("Create Lead | opentaps CRM"))
				{	
					// Print page opened confirmation and return true
					System.out.println("Create Lead Page Opened");
					return true;
				}
				else
				{
					// print unable to open create lead page, return false
					System.out.println("Unable to Open Create Lead page");
					return false;
				}
			}
			else
			{
				// print unable to find create lead link, return false
				System.out.println("Unable to find create lead link, stopping execution");
				return false;
			}
		}
		else
		{
			System.out.println("Unable to Open My Home Page");
			return false;
		}
	}

	public boolean findLeadsBy(String type, String value)
	{
		boolean result = false;
		if(openCRM())
		{
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			clickByXpath("//div[@class='x-panel-header']/a[contains(text(),'Leads')]");
			if(verifyText(getReference("id", "sectionHeaderTitle_leads"), "My Leads"))
			{
				System.out.println("Opened My Leads Page");
				clickByXpath("//ul[@class='shortcuts']/li/a[contains(text(),'Find Leads')]");
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				if(verifyText(getReference("xpath", "//span[contains(text(),'Find by')]"), "Find by"))
				{
					switch (type.trim().toLowerCase())
					{
					case "firstname" :
						enterBy(getReference("xpath", "(//div[@class='x-form-element']/input[@name='firstName'])[3]"), value);
						break;
					case "id":
						enterBy(getReference("xpath", "//div[@class='x-form-element']/input[@name='id']"), value);
						break;
					case "lastname":
						enterBy(getReference("xpath", "((//div[@class='x-form-element']/input[@name='lastName'])[3]"), value);
						break;
					case "companyname":
						enterBy(getReference("xpath", "(//div[@class='x-form-element']/input[@name='companyName'])[2]"), value);
						break;
					case "phone":
						clickByXpath("//span[@class='x-tab-strip-inner']/span[contains(text(),'Phone')]");
						enterBy(getReference("xpath", "//div[@class='x-plain-bwrap']/div/input[@name='phoneNumber']"), value);
						break;
					default:
						System.out.println("Invalid choice, stopping execution");
						return false;
					}
					System.out.println("Entering Find By Box");
					
					clickByXpath("//td[@class='x-btn-center']/em/button[contains(text(),'Find Leads')]");
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					
					if(verifyText(getReference("xpath", "//div[@class='x-panel-bbar']/div/div"), "No records to display"))
					{	
						System.out.println(getReference("xpath", "//div[@class='x-panel-bbar']/div/div").getText());
						System.out.println("No Records Found for "+type+" with value "+value);
						return false;
					}
					else
					{
						System.out.println(getReference("xpath", "//div[@class='x-panel-bbar']/div/div").getText());
						System.out.println("Lead Found opening View Lead Page");
						System.out.println(driver.findElementByXPath("(//a[@class='linktext'])[4]").getText());
						clickByXpath("(//a[@class='linktext'])[4]");
						if(verifyTitle("View Lead | opentaps CRM"))
						{
							System.out.println("View Lead Page Opened");
							return true;
						}
						else
						{
							System.out.println("Unable to Open View Lead Page");
							return false;
						}
					}
				}
				else
				{
					System.out.println("Unable to Open Find by Page");
					return result;
				}
			}
			else
			{
				System.out.println("Couldnt Open My Leads Page");
				return result;
			}
		}
		else
		{
			System.out.println("Unable to Open My Home Page");
			return result;
		}
	}

}
