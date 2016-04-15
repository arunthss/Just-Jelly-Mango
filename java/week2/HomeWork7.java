package week2;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class HomeWork7 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// declare variable to store frame count
		int totalFrames = 0;

		// set system properties for chrome driver
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		// create object for chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		// open url
		driver.get("http://layout.jquery-dev.com/demos/iframes_many.html");
		
		// get list of all frames present in page
		List <WebElement> frameList = driver.findElementsByTagName("iframe");
		
		// store frame count to variable declared
		totalFrames = frameList.size();
		
		//print frame count
		System.out.println("Frame Count "+totalFrames);
		
		// enter for each loop
		for (WebElement webElement : frameList) 
		{
			// switch to frames one by one
			driver.switchTo().frame(webElement);
			
			// count frames inside the current frame and add it to total frames variable
			totalFrames += driver.findElementsByTagName("iframe").size();
			
			// switch back to main page
			driver.switchTo().defaultContent();
		}
		
		// print total number of frames present on page
		System.out.println("Total number of Frames "+totalFrames);
	}

}
