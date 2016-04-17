package openTapsGroups;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class CreateLead extends OpenTapsWrapper{

	@Test(dataProvider="data")
	public void createlead(String username, String password, String companyName, String firstName, String lastName)
	{
		System.out.println("Username "+username);
		System.out.println("Password "+password);
		System.out.println("Company Name "+companyName);
		System.out.println("First Name "+firstName);
		System.out.println("Last Name "+lastName);
		
		System.out.println("Lead Created");
	}
	
	@DataProvider
	public Object[][] data()
	{
		Object[][] data = new Object[2][5];
		
		data[0][0] = "AruRaj";
		data[0][1] = "1234";
		data[0][2] = "tcs";
		data[0][3] = "Arun";
		data[0][4] = "Rajamani";
		
		data[1][0] = "Dinesh";
		data[1][1] = "4321";
		data[1][2] = "inoryasoft";
		data[1][3] = "Dinesh";
		data[1][4] = "M";
		
		return data;
	}
}
