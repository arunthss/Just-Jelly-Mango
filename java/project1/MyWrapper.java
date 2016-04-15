package project1;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class MyWrapper extends ExcelHandling
{
	RemoteWebDriver driver; 
	Set <String> wHandles;
	String parent;
	List <WebElement> frames;
	WebElement elem;
	
	public void getPage(String browserName, String URL)
	{
		try {
				if(browserName.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver","chromedriver.exe");
					driver = new ChromeDriver();
				}
				else if(browserName.equalsIgnoreCase("firefox"))
				{
					driver = new FirefoxDriver();
				}
				else
				{
					System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
				
				driver.manage().window().maximize();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				parent = driver.getWindowHandle();
			} 
		catch (WebDriverException e) 
		{
			System.out.println("Couldn't launch" +browserName +" browser");
		}
	}

	public void selectValueByIndex(WebElement dropDown, int index)
	{
		try 
		{
			Select sel = new Select(dropDown);
			sel.selectByIndex(index);
		} 
		catch (NoSuchElementException e) 
		{
			System.out.println("Index "+index+" is Not Found");
		}
	}
	
	public void selectValueByText(WebElement dropDown, String text)
	{
		try 
		{
			Select sel = new Select(dropDown);
			sel.selectByVisibleText(text);
		} 
		catch (NoSuchElementException e) 
		{
			System.out.println("Text "+text+" is Not Found");
		}
	}
	
	public void switchToPrimaryWindow()
	{
		driver.switchTo().window(parent);
	}
	
	public void switchToLastWindow()
	{
		wHandles = driver.getWindowHandles();
		for (String handle : wHandles) 
		{
			driver.switchTo().window(handle);
		}
	}
	
	public void switchToFirstFrame()
	{
		try
		{
			driver.switchTo().frame(0);
		}
		catch(NoSuchFrameException e)
		{
			System.out.println("Frame Not Found");
		}
		
	}
	
	public void switchToFrameByElement(WebElement frame)
	{
		try
		{
			driver.switchTo().frame(frame);
		}
		catch(NoSuchFrameException e)
		{
			System.out.println("Frame "+frame+" Not Found");
		}
		
	}
	
	public void acceptAlert()
	{
		try
		{
			Alert pageAlert = driver.switchTo().alert();
			pageAlert.accept();	
		}
		catch(NoAlertPresentException e)
		{
			System.out.println("Alert Not Found");
		}
	}
	
	public void dismissAlert()
	{
		try
		{
			Alert pageAlert = driver.switchTo().alert();
			pageAlert.dismiss();
		}
		catch(NoAlertPresentException e)
		{
			System.out.println("Alert Not Found");
		}
		
	}
	
	public boolean verifyUrl(String URL)
	{
		if(driver.getCurrentUrl().equalsIgnoreCase(URL))
			return true;
		else
			return false;
	}

	public boolean verifyText(WebElement elem, String expected)
	{
		boolean result = false;
		try
		{
			if(elem.getText().trim().toLowerCase().equalsIgnoreCase(expected))
				return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Web Element "+elem+" Not Found");
		}
		return result;
	}
	
	public boolean verifyTitle(String expected)
	{
		if(driver.getTitle().compareTo(expected)==0)
			return true;
		else
			return false;
	}

	public boolean clickByXpath(String xpath)
	{
		try
		{
			driver.findElementByXPath(xpath).click();
			return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("No Element with Xpath "+xpath+" Found");
			return false;
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
			System.out.println("No Element with Class Name "+classname+" Found");
		}
	}
	
	public void enterByName(String name, String text)
	{
		try 
		{
			elem = driver.findElementByName(name);
			elem.clear();
			elem.sendKeys(text);
		} 
		catch (NoSuchElementException e) 
		{
			System.out.println("No Element with Name "+name+" Found");
		}
	}

	public void enterById(String id, String text)
	{
		try 
		{
			elem = driver.findElementById(id);
			elem.clear();
			elem.sendKeys(text);
		} 
		catch (java.util.NoSuchElementException e) 
		{
			System.out.println("No Element with ID "+id+" Found");
		}
	}
	
	public void enterByClassName(String className, String text)
	{
		try 
		{
			elem = driver.findElementByClassName(className);
			elem.clear();
			elem.sendKeys(text);
		} 
		catch (NoSuchElementException e) 
		{
			System.out.println("No Element with Class Name "+className+" Found");
		}
	}
	
	public void enterBy(WebElement elem, String text)
	{
		try
		{
			elem.clear();
			elem.sendKeys(text);
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element "+elem +" Not Found");
		}
	}
	
	public String getElementText(WebElement elem)
	{
		try
		{
			return elem.getText();
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element Not Found");
			return null;
		}
		
	}
	
	public WebElement getReference(String type, String text)
	{
		switch(type.toLowerCase())
		{
			case "id":
				return driver.findElementById(text);
			
			case "classname":
				return driver.findElementByClassName(text);
			
			case "xpath":
				return driver.findElementByXPath(text);
			
			case "name":
				return driver.findElementByName(text);
				
			default:
				return null;
		}
	}
	
	public void myWait(int secs)
	{
		driver.manage().timeouts().implicitlyWait(secs, TimeUnit.SECONDS);
	}
	
}
