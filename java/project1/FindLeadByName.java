package project1;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebElement;

public class FindLeadByName extends OpenTapsWrapper
{
	String fileName = "D:\\NewMavenPro\\SelMarch\\data\\TestData.xlsx";
	String sheetName = "Details"; 

	String sourceText;
	String marketText;
	
	WebElement elem;
	
	@Test
	public void findByName() throws IOException
	{
		if(login())
		{
			
			System.out.println("Login Successful");
			
			String firstName = getStringFromFile(fileName, sheetName, 1, 0);
				System.out.println(firstName);
				
			firstName = "wwq";	
			
			if(findLeadsBy("firstname",firstName))
			{
				clickByXpath("//div[@class='frameSectionExtra']/a[contains(text(),'Edit')]");
				
				sourceText = getStringFromFile(fileName, sheetName, 1, 4);
					System.out.println(sourceText);
				marketText = getStringFromFile(fileName, sheetName, 1, 5);
					System.out.println(marketText);
				
				elem = getReference("id", "addDataSourceForm_dataSourceId");
				selectValueByText(elem, sourceText);
				clickByXpath("(//input[@class='smallSubmit'])[2]");
					System.out.println(sourceText);
				
				myWait(30);
					
				elem = getReference("id", "addMarketingCampaignForm_marketingCampaignId");
				selectValueByText(elem, marketText);
				clickByXpath("(//input[@class='smallSubmit'])[3]");	
					System.out.println(marketText);	
				
				myWait(30);
				if(getReference("xpath", "//div[@class='messages']/ul/li").getText().contains("Failed to add marketing campaign"))
				{
					System.out.println("Marketing Source Already Exist");
					System.out.println("Exiting from Program");
					return;
				}
						
				// click on update
				clickByXpath("//input[@class='smallSubmit']");
				
				if(getReference("id", "viewLead_dataSources_sp").getText().contains(sourceText))
				{
					System.out.println(sourceText +" Updated");
				}
				else
				{
					System.out.println(sourceText +" NOT Updated");
				}
				
				if(getReference("id", "viewLead_marketingCampaigns_sp").getText().contains(marketText))
				{
					System.out.println(marketText +" Updated");
				}
				else
				{
					System.out.println(marketText +" NOT Updated");
				}
			}
			else
			{
				System.out.println("Unable to open View Lead Page");
			}
			
		}
		else
		{
			System.out.println("Unable to Login");
		}
	}
	
	public boolean login() throws IOException
	{
		String userName;
		String password;
		openSheet(fileName, "Login");
		userName = getStringData(1, 0);
		password = getStringData(1, 1);
		readClose();
		getPage("firefox", "http://demo1.opentaps.org/opentaps/control/main");
		return loginOpenTaps(userName, password);
	}
	
	public String getStringFromFile(String fileName, String sheetName, int rowNum, int colNum) throws IOException
	{
		String value = "";
		openSheet(fileName, sheetName);
		value = getStringData(rowNum, colNum);
		readClose();
		return value;
	}

}
