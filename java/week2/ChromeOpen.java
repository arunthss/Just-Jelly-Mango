package week2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeOpen 
{

	public static void main(String[] args)
	{
		// set property to enable chrome driver
		//System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		// create an object for chrome driver
		ChromeDriver driver = new ChromeDriver();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// open google page
		driver.get("https://www.google.co.in/");
		
		// get list object comprising of webelements
		List <WebElement> myElement = driver.findElementsByTagName("a");
		
		// print the count of elements
		System.out.println("Count is "+myElement.size());
		
		// run for each and select one element at a time
		for(WebElement element : myElement)
		{
			/* select fist element having following properites
				containing c in link text
				x coords greater than 50
				width greater than 20
				clikc the link
				break out of loop
			*/
			if(element.getText().contains("c")&& element.getLocation().getX() > 50 && element.getSize().width > 20)
			{
				System.out.println(element.getText());
				System.out.println(element.getSize());
				System.out.println(element.getLocation());
				element.click();
				break;
			}
		}
		
		
		//driver.findElement(By.id("lst-ib")).sendKeys("Seleniumhq");
	}

}
