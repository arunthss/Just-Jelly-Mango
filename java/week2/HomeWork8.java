package week2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork8 
{
	public static void main(String[] args) 
	{
		// set system property
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		//create object for chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		// get URL
		driver.get("http://layout.jquery-dev.com/demos/iframe_local.html");
		
		// store list of frames present in the page
		List <WebElement> frameList = driver.findElementsByTagName("iframe");
		
		// print number of frames present 
		System.out.println(frameList.size());
		
		// store list of buttons present in page
		List <WebElement> button = driver.findElementsByTagName("button");
		
		// enter for each loop for every button present
		for (WebElement webElement : button) 
		{
			// if this button has text close within it then click it
			if(webElement.getText().contains("Close"))
				webElement.click();
		}
		
		// switch to first frame
		driver.switchTo().frame(0);
		
		// print URL of current frame 
		System.out.println("Frame src is "+ driver.getCurrentUrl());
		
		// store list of buttons present within the frame
		button = driver.findElementsByTagName("button"); 
		
		// enter for each loop for every button present
		for (WebElement webElement : button) 
		{
			// if this button has text close within it then click it
			if(webElement.getText().contains("Close"))
				webElement.click();
		}
		
	}
}
