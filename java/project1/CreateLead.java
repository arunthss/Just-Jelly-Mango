package project1;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

public class CreateLead extends OpenTapsWrapper{
	@Test
	public void create() throws IOException, InvalidFormatException
	{
		String userName;
		String password;
		String companyName;
		String firstName;
		String lastName;
		int sourceOption;
		int marketingOption;
		String phoneNum;
		String emailAddress;
		
		String fileName = "D:\\NewMavenPro\\SelMarch\\data\\TestData.xlsx";
		
	try {
		
		openSheet(fileName, "Login");
		
		userName = getStringData(1, 0);
		password = getStringData(1, 1);
		
		readClose();
		
		openSheet(fileName, "CreateLead");
		
		companyName = getStringData(1, 0);
			//System.out.println(companyName);
		firstName = getStringData(1, 1);
			//System.out.println(firstName);
		lastName = getStringData(1, 2);
			//System.out.println(lastName);
		sourceOption = Integer.parseInt(getStringData(1, 3));;
			//System.out.println(sourceOption);
		marketingOption = Integer.parseInt(getStringData(1, 4));
			//System.out.println(marketingOption);
		phoneNum = getStringData(1, 5);
			//System.out.println(phoneNum);
		emailAddress = getStringData(1, 6);
			//System.out.println(emailAddress);
		
		String tempID = null;
		String leadID = null;
		
		readClose();
		
		getPage("firefox", "http://demo1.opentaps.org/opentaps/control/main");
		
		if(loginOpenTaps(userName, password))
		{
			System.out.println("Login Successful");
			openCreateLeadPage();
			
			enterById("createLeadForm_companyName", companyName);
			enterById("createLeadForm_firstName", firstName);
			enterById("createLeadForm_lastName", lastName);
			
			selectValueByIndex(getReference("id", "createLeadForm_dataSourceId"), sourceOption);
			selectValueByIndex(getReference("id", "createLeadForm_marketingCampaignId"), marketingOption);
			
			enterById("createLeadForm_primaryPhoneNumber", phoneNum);
			enterById("createLeadForm_primaryEmail", emailAddress);
			
			clickByClassName("smallSubmit");
			
			if(verifyTitle("View Lead | opentaps CRM"))
			{
				tempID = getReference("id", "viewLead_companyName_sp").getText();
				leadID = tempID.substring(tempID.indexOf('(')+1, tempID.length()-1);
				System.out.println("Lead Created Successfully, ID "+leadID);
				
				appendSheet(fileName, "CreateLead");
				updateData(1, 7, leadID);
				writeAndClose();
			}
			else
			{
				System.out.println("Unable to Create Lead");
			}	
		}
		else
		{
			System.out.println("Unable to Login Now");
		}
		}
	catch(NullPointerException e)
	{
		System.out.println("References to text values in excel invalid");
	}
	catch(NumberFormatException e)
	{
		System.out.println("References to numeric data invalid");
	}
}
	
}
