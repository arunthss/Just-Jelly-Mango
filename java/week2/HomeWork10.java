package week2;

import org.openqa.selenium.chrome.ChromeDriver;

public class HomeWork10 
{
	public static void main(String[] args) 
	{
		// create variable to store text inside draggable
		String text = "";
		
		// set system properties
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		// create object for chrome driver
		ChromeDriver driver = new ChromeDriver();
		
		// get URL
		driver.get("http://www.jqueryui.com");
		
		// maximize window
		driver.manage().window().maximize();
		
		// click on Draggable link
		driver.findElementByLinkText("Draggable").click();
		
		// switch to demo frame
		driver.switchTo().frame(driver.findElementByClassName("demo-frame"));
		
		// get text stored inside draggable element
		text = driver.findElementById("draggable").getText();
		
		// print the text collected
		System.out.println(text);
		
		// come out of frame by switching to default content 
		driver.switchTo().defaultContent();
		
		// click on droppable link
		driver.findElementByLinkText("Droppable").click();
		
		// close window
		driver.close();
	}	

}
