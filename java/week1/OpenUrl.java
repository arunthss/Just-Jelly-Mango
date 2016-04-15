package week1;
import org.openqa.selenium.firefox.FirefoxDriver;
public class OpenUrl {

	
	public static void main(String[] args) {
		//TODO Auto-generated method stub
		String verifyText = "Welcome\nDemo Sales Manager";
			FirefoxDriver FFOpen=new FirefoxDriver();
			FFOpen.get("http://demo1.opentaps.org/"); // Open URL
			System.out.println(FFOpen.getTitle()); // print URL Title at login page
			FFOpen.findElementById("username").sendKeys("DemoSalesManager"); //Enter Username
			FFOpen.findElementById("password").sendKeys("crmsfa");// Enter Password
			FFOpen.findElementByXPath("//*[@id='login']/p[3]/input").click(); // Logging to website
			System.out.println(FFOpen.getTitle()); //print URL title at new page 
			
			System.out.println(FFOpen.findElementByXPath("//*[@id=\"form\"]/h2").getText());
			if(verifyText == FFOpen.findElementByXPath("//*[@id=\"form\"]/h2").getText())
				System.out.println("Hello Manager");
			else
				System.out.println("You are not the manager");
			/*FFOpen.findElementByXPath("//*[@id='logout']/input").click(); // Logging Out
			FFOpen.close(); // Close Browser
			*/
	}

}
