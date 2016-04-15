package week3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class OpenTapsHelper {

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
	
	public void enterTextById(String id, String value)
	{
		try
		{
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(value);
		}
		
		catch(NoSuchElementException e)
		{
			System.out.println(id+" Not Found");
		}
		
	}
	
	public void clickByClassName(String classname)
	{
		try
		{
			driver.findElementByClassName(classname).click();
		}
		catch(NoSuchElementException e)
		{
			System.out.println(classname+" Not Found");
		}	
	}
	
	public boolean compareTitle(String expected)
	{
		boolean result = false;
		if(driver.getTitle().equalsIgnoreCase(expected))
		{
			System.out.println("Titles Match");
			result = true;
		}
		else
		{
			System.out.println("Titles Didnot match");
			System.out.println("Actual Title "+driver.getTitle());
			System.out.println("Expected Title " +expected);
		}
		return result;
	}
	
	public void getURL()
	{
		System.out.println(driver.getCurrentUrl());
	}
	
	public void driverclose()
	{
		driver.close();
	}
	
	
	
	
	
	
	/*
- selectValueByIndex
- switchToPrimaryWindow
- switchToLastWindow
- switchToFrameByElement
- switchToFirstFrame
- acceptAlert
- dismissAlert
- verifyUrl
- verifyText
- verifyTitle
- clickByXpath
- enterByName
- enterById
- enterByClassName
 */
	
}
