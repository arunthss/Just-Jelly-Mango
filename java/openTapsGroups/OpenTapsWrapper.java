package openTapsGroups;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class OpenTapsWrapper 
{
	
	@BeforeClass(groups={"smoke","sanity"})
	@Parameters("Browser")
	public void launchBrowser(String browser)
	{
		System.out.println(browser+" Browser Launched");
	}
	
	@BeforeMethod(groups={"smoke","sanity"})
	public void loginAndCrm()
	{
		System.out.println("Login Successful and CRM link opened");
	}
	
	@AfterMethod(groups={"smoke","sanity"})
	public void logout()
	{
		System.out.println("Logout Successful");
	}
	
	@AfterClass(groups={"smoke","sanity"})
	public void closeBrowser()
	{
		System.out.println("Browser Closed");
	}
}
