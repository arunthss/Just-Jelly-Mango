package week3;

import org.junit.Test;

public class WrapperFunctions extends OpenTapsHelper{

	@Test
	public void perform()
	{
		openUrl("firefox", "http://demo1.opentaps.org/");
		enterTextById("username", "DemoSalesManager");
		enterTextById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		if(compareTitle("Opentap Open Source ERP + CRM"))
		{
			getURL();
		}
		else
		{
			System.out.println("Titles didnt match quitting");
		}
		
		
		
		driverclose();
	}
	
}
