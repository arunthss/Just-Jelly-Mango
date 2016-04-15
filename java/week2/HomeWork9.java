package week2;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork9 {

	public static void main(String[] args) throws InterruptedException
	{
		// create variable to store search text
		String srchString = "Arun";
		
		// set system property
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		// create object for chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		// get URL
		driver.get("https://www.google.co.in/");
		
		// maximize page
		driver.manage().window().maximize();
		
		// find search text box and pass search string to it
		driver.findElementById("lst-ib").sendKeys(srchString);
		
		// click out side of text box
		driver.findElementByTagName("body").click();
		
		// if btnk is displaying then click it else click button btng
		if(driver.findElementByName("btnK").isDisplayed())
		{
			driver.findElementByName("btnK").click();
		}
		else
		{
			driver.findElementByName("btnG").click();
		}
		
		// put thread to sleep, loading contents of page
		Thread.sleep(2000);
		
		// find all links present in page and store it to a list
		List <WebElement> links = driver.findElementsByTagName("a");
		
		// display number of links available
		System.out.println("There are "+ links.size()+" Links");
		
		// enter for each loop for every link present
		for (WebElement obj : links) 
		{
			// if link text is > 20 and link x axis location > 100 print it
			if(obj.getText().length()>20 && obj.getLocation().getX()>100)
			{
				System.out.println(obj.getText());
				System.out.println("**************************");
			}
		}
		
	}

}
