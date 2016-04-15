package week2;

import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HomeWork6 
{
	public static void main(String[] args) throws InterruptedException
	{
		// Search text is stored as string
		String searchText = "Arun";
		
		// convert search text to lower case to accommodate case insensitive search  
		searchText = searchText.toLowerCase();
		
		// set a variable to store link text
		String pageText = "";
		
		// set variable to store number of links available in page
		int linkCount = 0;
		
		// set variable to store number of lines/words matching our search string
		int wordCount = 0;
	
		// google chrome driver
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		// create instance for chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		// create instance for firefox driver
		//FirefoxDriver driver = new FirefoxDriver();
		
		// open google.co.in
		driver.get("http://google.co.in/");
		
		// enter search text in search box
		driver.findElementById("lst-ib").sendKeys(searchText);
		
		// click on search icon
		driver.findElementByName("btnG").click();

		// wait for 5secs to page load
		Thread.sleep(5000);
		
		// store collection of all links to a list variable called namelist 
		List <WebElement> nameList = driver.findElementsByTagName("a");
		
		// count total number of links available in page and store it on linkcount variable
		linkCount  = nameList.size();
		
		// print linkcount
		System.out.println("There are "+linkCount+" links available");
		
		// loop through every element of list
		for(WebElement element: nameList)
		{
			// store link text to the pagetext variable
			pageText = element.getText();
			
			// convert pagetext to lower case and check for search text within it
			if(pageText.toLowerCase().contains(searchText))
			{
				// if above condition is true then print the line
				System.out.println(pageText);
				
				// print a line separator
				System.out.println("-------------------");
				
				//increment search result by one
				wordCount++;
			}
		}
		
		// print number of matches found
		System.out.println(wordCount+" Lines has requested string");
		
		// close browser tab
		driver.close();
	}
}
