package project1;

import java.io.IOException;

import org.junit.Test;

public class FindByPhoneDelete extends OpenTapsWrapper
{
	String fileName = "D:\\NewMavenPro\\SelMarch\\data\\TestData.xlsx";
	String sheetName = "Details";
	String phoneNum = "";
	
	@Test
	public void start() throws IOException
	{
		if(login())
		{
			System.out.println("Login Successful");
			phoneNum = getStringFromFile(fileName, sheetName, 1, 3);
			System.out.println("Phone Num is "+phoneNum);
			findLeadsBy("phone", phoneNum);
			System.out.println("Deleting Lead");
			clickByXpath("//a[@class='subMenuButtonDangerous']");
			myWait(10);
			System.out.println("Opening CRM Page");
			clickByXpath("//img[@alt='opentaps CRM']");
			myWait(5);
			System.out.println("Validating in find Lead page");
			if(!findLeadsBy("phone", phoneNum))
			{
				System.out.println("Lead with Phone Num "+phoneNum+" Deleted");
			}
			else
			{
				System.out.println("Unable to DELETE");
			}
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
