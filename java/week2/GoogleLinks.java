package week2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.co.in");
		
		driver.manage().window().maximize();

		List <WebElement> linktext = driver.findElements(By.tagName("a"));

		System.out.println ("There are "+linktext.size()+" Links available in this page");

		for (WebElement temp : linktext) 
		{
			System.out.println(temp.getText());
			if(temp.getText().contains("c")&& temp.getLocation().getX()>50 && temp.getSize().width>20)
			{
				temp.click();
				break;
			}
			
		}
			//driver.close();	
	}
}