package week2;
import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;
public class w3schools 
{

	public static void main(String[] args) 
	{
		// declare a string variable to store result text
		String result = "";
		
		// create an object for chrome driver
		FirefoxDriver driver = new FirefoxDriver();
		
		// open web site
		driver.get("http://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		
		// maximize web page
		driver.manage().window().maximize();
		
		// switch to frame inside the page from main page
		driver.switchTo().frame("iframeResult");
		
		// click on button present in frame
		driver.findElementByTagName("button").click();
		
		// switch control to alert box popped up
		Alert obj = driver.switchTo().alert();
		
		// obj.dismiss(); to click cancel
		obj.accept();
		
		// System.out.println(obj.getText());
		
		// after we clicked ok or cancel ctrl will be transferred to calling page, here frame
		// select text with id called demo from frame and store it to result variable
		result = driver.findElementById("demo").getText();
		
		// if(result.contains("Cancel"))
		if(result.contains("OK"))
		{
			// if result contains OK then print this
			System.out.println("Success");
		}
		// close the window
		driver.close();
	}

}
