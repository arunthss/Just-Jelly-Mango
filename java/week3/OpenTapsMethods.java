package week3;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OpenTapsMethods {

	RemoteWebDriver driver;
	
	public void openUrl(String browser, String URL)
	{
		try {
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chromer.driver", "chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else
			{
				System.setProperty("webdriver.ie.driver", "IEDriverServer");
				driver = new InternetExplorerDriver();
			}
			
			driver.get(URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			System.out.println(browser+ " Browser cannot be launched");
		}
	}
	
	public void loginMethod(String username, String password)
	{
		try {
			driver.findElementById("username").sendKeys(username);
			driver.findElementById("password").sendKeys(password);
			driver.findElement(By.className("decorativeSubmit")).click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Requested Element in Login page not found");
		}
	}
	
	public void openCrmLink()
	{
		
		try {
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.findElementByXPath("//div[@id='label']/a").click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("CRM/SFA Element Not Found");
		}
	}
	
	public void createLead()
	{
		
		try {
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.findElementByLinkText("Create Lead").click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Create lead Element Not Found");
		}
	}
	
	public void findLead(String firstName) throws InterruptedException
	{
		WebElement lead;
		try {
			driver.findElementByLinkText("Leads").click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.findElementByLinkText("Find Leads").click();
			driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			
			driver.findElementByXPath("(//div[@class='x-form-element'])[19]/input").sendKeys(firstName);
			
			driver.findElementByXPath("//td/em/button[contains(text(),'Find Leads')]").click();
			
			Thread.sleep(5000);
			
			if(driver.findElementByClassName("x-paging-info").getText().equalsIgnoreCase("No records to display"))
			{
				System.out.println(firstName +" Lead Not found");
			}
			else
			{
				lead = driver.findElementByXPath("//div[@class='x-grid3-scroller']/div/div/table/tbody/tr/td/div/a[1]");
				lead.click();
			}		
		} 
		catch (StaleElementReferenceException e) 
		{
			// TODO Auto-generated catch block
			System.out.println("Find Lead Elemebt Not Found");
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Lead Not Found");
		}
	}
	/*
	public void findLead()
	{
		try {
			driver.findElementByLinkText("Leads").click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.findElementByLinkText("Find Leads").click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Find Lead Element Not found");
		}
		
	}
	*/
	public void findLead(String option, String value)
	{
		try {
			driver.findElementByLinkText("Leads").click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.findElementByLinkText("Find Leads").click();
			
			if(option.equalsIgnoreCase("name"))
			{
				driver.findElementByXPath("(//div[@class='x-panel-mc'])[6]/div/div/div/div/form/div/div[2]/div/div/div/div/div[2]/div/input").sendKeys(value);
				driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
			}
			else if(option.equalsIgnoreCase("number"))
			{
				driver.findElementByXPath("//div[@class='x-tab-strip-wrap']/ul/li[2]/a[2]").click();
				driver.findElementByName("phoneNumber").sendKeys(value);
				driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
			}
			else if(option.equalsIgnoreCase("id"))
			{
				driver.findElementByXPath("(//div[@class='x-panel-mc'])[6]/div/div/div/div/form/div/div[2]/div/div/div/div/div/div/input").sendKeys(value);
				driver.findElementByXPath("//button[contains(text(),'Find Leads')]").click();
			}
			
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			System.out.println("Find Lead Elemebt Not Found");
		}
	}
	
	public void clickFirstLead() throws InterruptedException
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			Thread.sleep(5000);
			driver.findElementByXPath("//div[@class='x-grid3-row   ']/table/tbody/tr/td/div/a").click();
		}
		
		catch(StaleElementReferenceException e)
		{
			System.out.println("Lead Not Found");
		}
	}
	
	public void mergeLead(String lead1, String lead2) throws InterruptedException
	{
		try {
			driver.findElementByLinkText("Leads").click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.findElementByLinkText("Merge Leads").click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			//--------------------------------------------------------
			driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a/img").click();
			String parent = driver.getWindowHandle();
			Set <String> windows = driver.getWindowHandles();
			for (String string : windows) {
				driver.switchTo().window(string);
			}

			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.findElementByXPath("(//div[@class='x-form-element'])[2]/input").sendKeys(lead1);
			driver.findElementByXPath("(//td[@class='x-btn-center'])[1]/em/button").click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			clickFirstLead();
			
			driver.switchTo().window(parent);
			//------------------------------------------------------
			
			driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a/img").click();
			windows = driver.getWindowHandles();
			for (String string : windows) {
				driver.switchTo().window(string);
			}

			Thread.sleep(5000);
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			driver.findElementByXPath("(//div[@class='x-form-element'])[2]/input").sendKeys(lead1);
			driver.findElementByXPath("(//td[@class='x-btn-center'])[1]/em/button").click();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			clickFirstLead();

			driver.switchTo().window(parent);
			
			driver.findElementByClassName("buttonDangerous").click();
			
			Alert a = driver.switchTo().alert();
			a.dismiss();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Merge Leads Element Not Found");
		}
		
	}
}
