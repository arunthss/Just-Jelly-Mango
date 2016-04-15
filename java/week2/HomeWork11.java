package week2;

import java.util.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomeWork11 
{
	public static void main(String[] args) 
	{
		// create string to store session id of parent window
		String parentWindow = "";
		
		// create object for firefox driver
		FirefoxDriver driver = new FirefoxDriver();
		
		// get URL
		driver.get("http://www.popuptest.com");
		
		// click on multi popup link
		driver.findElementByLinkText("Multi-PopUp Test #2").click();
		
		// store session id of parent window 
		parentWindow = driver.getWindowHandle();
		
		// print session id of parent window
		System.out.println("Session ID for Parent Window "+parentWindow);
		
		// create a set of open window session id
		Set <String> win =  driver.getWindowHandles();
		
		// enter for each loop for every window created
		for (String session : win) 
		{	
			// if current session id is equal to parent id skip current iteration
			if(session.equalsIgnoreCase(parentWindow))
				continue;
			// else switch driver to that window and close it
			else
			{
				driver.switchTo().window(session);
				driver.close();
			}
		}
		
		// switch driver to parent window
		driver.switchTo().window(parentWindow);
		
		// print URL of parent window
		System.out.println("URL of parent window is "+driver.getCurrentUrl());
		
		// close all tabs (only one in this case)
		driver.quit();
	}
}
