package week3;


import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApacheEx1 {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeDriver  cdr = new ChromeDriver();
		cdr.manage().window().maximize();
		cdr.get("http://amazon.in");		
		cdr.findElementById("twotabsearchtextbox").sendKeys("bags");
		cdr.findElementByXPath("//*[@id='nav-search-submit-text']").click();
		
	}

}
