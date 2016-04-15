/*	LOGIC
 * 	Open IRCTC Site
 *  Now driver is pointing to parent page (IRCTC home page)
 *  Click on contact us, this will open new page (Child Page)
 *  Since driver is pointing to Parent page, we need to switch to child page 
 *  Whenever a page is opened by Selenium driver it tracks that page with session ID 
 *  We use getWindowHandles to retrieve all session ID's
 *  GetWindowHandles.size() returns number of pages opened by current driver
 *  As driver is pointing to parent page, run for each loop to assign next handle to driver 
 *  Print session ID
 *  Print URL title 
 *  Assign next handle to driver
 *  Close all open windows
 */

package week2;

import java.util.Set;

import org.openqa.selenium.firefox.FirefoxDriver;

public class IRTCTC_Windows 
{

	public static void main(String[] args) 
	{
		// create object for FireFoxDriver class
		FirefoxDriver driver = new FirefoxDriver();
		
		// open IRCTC website
		driver.get("https://www.irctc.co.in/");
		
		// Click on contact us link
		driver.findElementByLinkText("Contact Us").click();
		
		// Assign return type of getWindowHandles() to object called myObj
		Set<String> myObj = driver.getWindowHandles();
		
		// Print number of session ids available in above set
		System.out.println("Number of windows "+myObj.size());
		
		// open for each loop for above set of session ID
		for (String win : myObj) 
		{
			// switch driver from parent page to next
			driver.switchTo().window(win);
			
			// print session id currently driver points to
			System.out.println("Session Id "+driver.getWindowHandle());
			
			// print URL driver currently points too
			System.out.println(driver.getCurrentUrl());
		}
		
		// close all windows opened by current driver
		driver.quit();
	}

}
